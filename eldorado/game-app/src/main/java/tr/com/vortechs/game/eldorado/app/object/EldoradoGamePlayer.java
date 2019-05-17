package tr.com.vortechs.game.eldorado.app.object;

import java.util.ArrayList;
import java.util.List;

import tr.com.vortechs.game.eldorado.core.player.AbstractGamePlayer;

public class EldoradoGamePlayer extends AbstractGamePlayer{
	
	private String name;
	private int mana;
	private int health;
	private List<EldoradoGameCard> deck;
	
	public EldoradoGamePlayer() {
		this.deck = new ArrayList<>();
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public List<EldoradoGameCard> getDeck() {
		return deck;
	}
	public void setDeck(List<EldoradoGameCard> deck) {
		this.deck = deck;
	}
	
	
}
