package tr.com.vortechs.game.eldorado.app.context;

import java.util.ArrayList;
import java.util.List;

import tr.com.vortechs.game.eldorado.app.object.EldoradoGameCard;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.core.context.AbstractGameContext;

public class EldoradoGameContext extends AbstractGameContext{
	private List<EldoradoGamePlayer> players;
	private List<EldoradoGameCard> gameDeck;
	private int currentPlayerIndex;
	
	public EldoradoGameContext() {
		this.players = new ArrayList<>();
		this.gameDeck = new ArrayList<>();
	}

	public List<EldoradoGamePlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<EldoradoGamePlayer> players) {
		this.players = players;
	}

	public List<EldoradoGameCard> getGameDeck() {
		return gameDeck;
	}

	public void setGameDeck(List<EldoradoGameCard> gameDeck) {
		this.gameDeck = gameDeck;
	}

	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}
	
	
	
	
}
