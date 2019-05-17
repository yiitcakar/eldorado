package tr.com.vortechs.game.eldorado.app;

import tr.com.vortechs.game.eldorado.app.builder.engine.EldoradoGameEngineBuilder;
import tr.com.vortechs.game.eldorado.app.enums.object.EldoradoGameCardType;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGameCard;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayerInput.EldoradoGamePlayerInputType;
import tr.com.vortechs.game.eldorado.app.service.factory.EldoradoServiceFactory;
import tr.com.vortechs.game.eldorado.app.service.factory.EldoradoServiceFactory.Types.EldoradoInputServiceTypeEnum;
import tr.com.vortechs.game.eldorado.app.service.factory.EldoradoServiceFactory.Types.EldoradoOutputServiceTypeEnum;
import tr.com.vortechs.game.eldorado.app.util.RandomUtil;
import tr.com.vortechs.game.eldorado.core.enums.engine.GameEngineStatusEnum;
import tr.com.vortechs.game.eldorado.core.enums.engine.behaviour.GameEngineLoopStatesEnum;

public class EldoradoGameApp {
	public static void main(String[] args) {
		EldoradoGameEngineBuilder.newInstance()
			.settings()
				.playerSettings()
					.deckLimit(5)
					.initialDeckSize(3)
					.initialMana(0)
					.initialHealth(30)
					.manaLimit(10)
				.end()
				.numberOfPlayers(2)
			.end()
			.context()
				.deck()
					.newCard().cardName("Fake Alchemy").manaCost(0).cardType(EldoradoGameCardType.COMMON).quantity(2).end()
					.newCard().cardName("Goblin Bite").manaCost(1).cardType(EldoradoGameCardType.COMMON).quantity(2).end()
					.newCard().cardName("The Gambler").manaCost(2).cardType(EldoradoGameCardType.COMMON).quantity(3).end()
					.newCard().cardName("Hammer of Dwarf").manaCost(3).cardType(EldoradoGameCardType.RARE).quantity(4).end()
					.newCard().cardName("Eye of Medusa").manaCost(4).cardType(EldoradoGameCardType.RARE).quantity(3).end()
					.newCard().cardName("Hand of Midas").manaCost(5).cardType(EldoradoGameCardType.EPIC).quantity(2).end()
					.newCard().cardName("Rage of Minotaur").manaCost(6).cardType(EldoradoGameCardType.EPIC).quantity(2).end()
					.newCard().cardName("Touch of Titans").manaCost(7).cardType(EldoradoGameCardType.LEGENDARY).quantity(1).end()
					.newCard().cardName("Breath of The Golden Dragon").manaCost(8).cardType(EldoradoGameCardType.LEGENDARY).quantity(1).end()
					.setDamageCalculator(card->card.getManaCost())
				.end()
			.end()
			.beans()
				.injectInputService(EldoradoServiceFactory.getInstance().getInputService(EldoradoInputServiceTypeEnum.CONSOLE_BASED_ELDORADO_INPUT_SERVICE))
				.injectOutputService(EldoradoServiceFactory.getInstance().getOutputService(EldoradoOutputServiceTypeEnum.CONSOLE_BASED_ELDORADO_OUTPUT_SERVICE))
			.end()
			.behaviours()
				// how to switch user for each turn of game
				.setActivePlayer((context,beans,settings)->{
					int playerIndex = (context.getCurrentPlayerIndex() + 1 ) % settings.getNumberOfPlayers();
					context.setCurrentPlayerIndex(playerIndex);
					EldoradoGamePlayer activePlayer = context.getPlayers().get(playerIndex);
					beans.getOutputService().switchUser(activePlayer);
					return activePlayer;
				})
				.previous()
					// burn out!
					.newBehaviour((context,beans,settings,player)->{
						if(player.getDeck().isEmpty()) {
							player.setHealth(player.getHealth() -1);
							beans.getOutputService().burnOut(player);
						}
					})
					// refill mana
					.newBehaviour((context,beans,settings,player)->{
						if(player.getMana() < settings.getPlayerSettings().getManaLimit()) {
							player.setMana(player.getMana() + 1);
							beans.getOutputService().refillMana(player);
						}else {
							beans.getOutputService().fullMana(player);
						}
					})
					// draw card & overload
					.newBehaviour((context,beans,settings,player)->{
						// is player in burn out state
						if(!player.getDeck().isEmpty()) 
						{
							// is the game deck empty
							if(!context.getGameDeck().isEmpty())
							{
								// is the player deck full
								if(player.getDeck().size() < settings.getPlayerSettings().getDeckLimit())
								{
									EldoradoGameCard card = RandomUtil.getThenDropRandomItem(context.getGameDeck());
									player.getDeck().add(card);
									beans.getOutputService().drawNewCard(player, card);
								}
								else
								{
									beans.getOutputService().fullDeck(player);
								}
							}
							else
							{
								beans.getOutputService().emptyGameDeck();
							}
						}
					})
				.end()
				// check if the user in burn out state
				.afterPrev((context,beans,settings,player)->{
					if(player.getDeck().isEmpty()) {
						return GameEngineLoopStatesEnum.END_LOOP;
					}else {
						return GameEngineLoopStatesEnum.CONTINUE;
					}
				})
				// implement player actions
				.player((context,beans,settings,player)->{
					EldoradoGamePlayerInputType type= null; 
					do
					{
						beans.getOutputService().displayPlayerInfo(player);
						type = beans.getInputService().getPlayerAction(input->{
							switch(input.getType()) 
							{
								case PLAY_CARD:
									int cardIndex = Integer.parseInt(input.getValue()) -1;
									EldoradoGameCard card = player.getDeck().get(cardIndex);
									if(card.getManaCost() <= player.getMana()) {
										player.getDeck().remove(cardIndex);
										player.setMana(player.getMana() - card.getManaCost());
										for(int i = 0 ; i < context.getPlayers().size() ; i++) {
											if(i != context.getCurrentPlayerIndex()) {
												EldoradoGamePlayer enemy = context.getPlayers().get(i);
												enemy.setHealth(enemy.getHealth() - card.getDamage());
												beans.getOutputService().attackPlayer(player, enemy, card);
											}
										}
									}else {
										beans.getOutputService().notEnoughMana(card);
									}
								break;
								case END_TURN:
									beans.getOutputService().playerEndsTurn(player);
								break;
								case UNDEFINED:
									beans.getOutputService().unknownAction(input.getValue());
								break;
							}
						});
					}while(type != EldoradoGamePlayerInputType.END_TURN && !player.getDeck().isEmpty());
				})
				// if all other players is dead then exit from game loop
				.updateGameStatus((context,beans,settings,player)->{
					GameEngineStatusEnum result = GameEngineStatusEnum.RUNING;
					// check if all other players is dead
					if(context.getPlayers().stream().filter(p -> !p.getName().equals(player.getName())).allMatch(p -> p.getHealth() <= 0)) {
						result = GameEngineStatusEnum.END;
						beans.getOutputService().allEnemiesKilled(player);
					}
					return result;
				})
			.end()
		.buildInstance()
	.run();
		
	}
}
