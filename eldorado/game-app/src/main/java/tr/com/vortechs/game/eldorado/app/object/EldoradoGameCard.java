package tr.com.vortechs.game.eldorado.app.object;

import tr.com.vortechs.game.eldorado.app.enums.object.EldoradoGameCardType;
import tr.com.vortechs.game.eldorado.core.object.GameObject;

public class EldoradoGameCard extends GameObject{
	private String cardName;
	private int manaCost;
	private int damage;
	private EldoradoGameCardType cardType;
	
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public EldoradoGameCardType getCardType() {
		return cardType;
	}
	public void setCardType(EldoradoGameCardType cardType) {
		this.cardType = cardType;
	}
	
	
	
	
}
