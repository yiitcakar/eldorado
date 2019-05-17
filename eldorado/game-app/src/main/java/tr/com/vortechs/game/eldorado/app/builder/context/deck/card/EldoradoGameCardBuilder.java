package tr.com.vortechs.game.eldorado.app.builder.context.deck.card;

import java.util.List;

import tr.com.vortechs.game.eldorado.app.builder.context.deck.EldoradoGameDeckBuilder;
import tr.com.vortechs.game.eldorado.app.enums.object.EldoradoGameCardType;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGameCard;
import tr.com.vortechs.game.eldorado.core.builder.AbstractLeafBuilder;

public class EldoradoGameCardBuilder extends AbstractLeafBuilder<EldoradoGameDeckBuilder, List<EldoradoGameCard>>{

	private int quantity;
	private String cardName;
	private int manaCost;
	private EldoradoGameCardType cardType;
	
	protected EldoradoGameCardBuilder(EldoradoGameDeckBuilder parentBuilder, List<EldoradoGameCard> instance) {
		super(parentBuilder, instance);
		this.quantity = 1;
	}
	
	public static EldoradoGameCardBuilder newInstance(EldoradoGameDeckBuilder parentBuilder, List<EldoradoGameCard> instance) {
		return new EldoradoGameCardBuilder(parentBuilder, instance);
	}

	public EldoradoGameCardBuilder quantity(int quantity) {
		if(quantity > 0) {			
			this.quantity = quantity;
		}
		return this;
	}
	
	public EldoradoGameCardBuilder cardName(String cardName) {
		this.cardName = cardName;
		return this;
	}
	
	public EldoradoGameCardBuilder manaCost(int manaCost) {
		this.manaCost = manaCost;
		return this;
	}
	
	public EldoradoGameCardBuilder cardType(EldoradoGameCardType cardType) {
		this.cardType = cardType;
		return this;
	}

	@Override
	protected void prebuildInstance() {
		EldoradoGameCard card;
		for(int i = 0 ; i < quantity ; i++) {
			card = new EldoradoGameCard();
			card.setCardName(this.cardName);
			card.setManaCost(this.manaCost);
			card.setCardType(this.cardType);
			super.instance.add(card);
		}
	}

}
