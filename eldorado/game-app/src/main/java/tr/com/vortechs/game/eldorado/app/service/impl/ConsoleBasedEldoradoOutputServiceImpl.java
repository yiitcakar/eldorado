package tr.com.vortechs.game.eldorado.app.service.impl;

import tr.com.vortechs.game.eldorado.app.object.EldoradoGameCard;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.app.service.EldoradoOutputService;
import tr.com.vortechs.game.eldorado.core.service.impl.AbstractBaseServiceImpl;

public class ConsoleBasedEldoradoOutputServiceImpl extends AbstractBaseServiceImpl implements EldoradoOutputService{

	@Override
	public void switchUser(EldoradoGamePlayer player) {
		System.out.println("New Turn Begins! Active Player: " + player.getName());
	}

	@Override
	public void burnOut(EldoradoGamePlayer player) {
		System.out.println(player.getName() + " your deck is empty so you are burning out! health: " + player.getHealth());
	}

	@Override
	public void refillMana(EldoradoGamePlayer player) {
		System.out.println(player.getName() + ": refilled 1 point mana!");
	}

	@Override
	public void fullMana(EldoradoGamePlayer player) {
		System.out.println(player.getName() + " your mana is full!");
	}

	@Override
	public void drawNewCard(EldoradoGamePlayer player, EldoradoGameCard card) {
		System.out.println(player.getName() + " draw new card : " + card.getCardName() + "!");
	}

	@Override
	public void fullDeck(EldoradoGamePlayer player) {
		System.out.println(player.getName() + " your deck is full!");
	}

	@Override
	public void emptyGameDeck() {
		System.out.println("Game deck is empty!");
		
	}

	@Override
	public void allEnemiesKilled(EldoradoGamePlayer player) {
		System.out.println("All enemies has been killed!");
		System.out.println(player.getName() + " wins!");
		
	}

	@Override
	public void displayPlayerInfo(EldoradoGamePlayer player) {
		System.out.println(player.getName() + " health: " + player.getHealth() + " mana: " + player.getMana());
		System.out.println("Your Deck: " + (player.getDeck().isEmpty() ? " is Empty" : " "));
		for(EldoradoGameCard card : player.getDeck())
		{
			System.out.println(card.getCardName() + " mana cost: " + card.getManaCost() + " damage: " + card.getDamage());
		}
		
	}

	@Override
	public void attackPlayer(EldoradoGamePlayer player, EldoradoGamePlayer target, EldoradoGameCard card) {
		System.out.println(player.getName() + " attacked to " + target.getName() + "!");
		System.out.println(card.getCardName() + " takes " + card.getDamage() + " damages");
		System.out.println(target.getName() + " health: " + target.getHealth());
		
	}

	@Override
	public void notEnoughMana(EldoradoGameCard card) {
		System.out.println("Not enough mana to play " + card.getCardName() + " !");
		
	}

	@Override
	public void playerEndsTurn(EldoradoGamePlayer player) {
		System.out.println(player.getName() + " ends his turn.");
		
	}

	@Override
	public void unknownAction(String action) {
		System.out.println("Unknown action: '" + action + "'. Enter card index for play card (1,2,3,4,5) or enter 'END' to end your turn.");
		
	}

	@Override
	public void startGame() {
		System.out.println("---El-Dorado Simple Card Game---");
		System.out.println("1) wait for your turn");
		System.out.println("2) play cards in your deck if you have enough mana");
		System.out.println("3) you have to enter card number to play ex 1,2,3,4,5");
		System.out.println("4) if you do not have any movment, end your turn wait for refill mana");
		System.out.println("5) you have to enter 'END' command to kill your turn");
		System.out.println();
	}

	@Override
	public void endGame() {
		System.out.println("end...");
		
	}

}
