package tr.com.vortechs.game.eldorado.app.settings.player;

import tr.com.vortechs.game.eldorado.core.settings.AbstractGameSettings;

public class EldoradoPlayerSettings extends AbstractGameSettings{
	private int manaLimit;
	private int deckLimit;
	private int initialHealth;
	private int initialDeckSize;
	private int initialMana;
	public int getManaLimit() {
		return manaLimit;
	}
	public void setManaLimit(int manaLimit) {
		this.manaLimit = manaLimit;
	}
	public int getDeckLimit() {
		return deckLimit;
	}
	public void setDeckLimit(int deckLimit) {
		this.deckLimit = deckLimit;
	}
	public int getInitialHealth() {
		return initialHealth;
	}
	public void setInitialHealth(int initialHealth) {
		this.initialHealth = initialHealth;
	}
	public int getInitialDeckSize() {
		return initialDeckSize;
	}
	public void setInitialDeckSize(int initialDeckSize) {
		this.initialDeckSize = initialDeckSize;
	}
	public int getInitialMana() {
		return initialMana;
	}
	public void setInitialMana(int initialMana) {
		this.initialMana = initialMana;
	}
	
	
	
	
}
