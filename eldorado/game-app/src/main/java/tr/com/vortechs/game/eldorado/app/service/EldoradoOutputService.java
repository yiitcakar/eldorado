package tr.com.vortechs.game.eldorado.app.service;

import tr.com.vortechs.game.eldorado.app.object.EldoradoGameCard;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.core.service.AbstractBaseService;

public interface EldoradoOutputService extends AbstractBaseService{
	void switchUser(EldoradoGamePlayer player);
	void burnOut(EldoradoGamePlayer player);
	void refillMana(EldoradoGamePlayer player);
	void fullMana(EldoradoGamePlayer player);
	void drawNewCard(EldoradoGamePlayer player,EldoradoGameCard card);
	void fullDeck(EldoradoGamePlayer player);
	void emptyGameDeck();
	void allEnemiesKilled(EldoradoGamePlayer player);
	void displayPlayerInfo(EldoradoGamePlayer player);
	void attackPlayer(EldoradoGamePlayer player,EldoradoGamePlayer target,EldoradoGameCard card);
	void notEnoughMana(EldoradoGameCard card);
	void playerEndsTurn(EldoradoGamePlayer player);
	void unknownAction(String action);
	void startGame();
	void endGame();
}
