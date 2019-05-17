package tr.com.vortechs.game.eldorado.app.builder.context.deck;

import java.util.List;

import tr.com.vortechs.game.eldorado.app.builder.context.EldoradoGameContextBuilder;
import tr.com.vortechs.game.eldorado.app.builder.context.deck.card.EldoradoGameCardBuilder;
import tr.com.vortechs.game.eldorado.app.context.behaviour.CardDamageCalculatorBehaviour;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGameCard;
import tr.com.vortechs.game.eldorado.core.builder.AbstractLeafBuilder;

public class EldoradoGameDeckBuilder extends AbstractLeafBuilder<EldoradoGameContextBuilder, List<EldoradoGameCard>>{

	private CardDamageCalculatorBehaviour behaviour;
	
	protected EldoradoGameDeckBuilder(EldoradoGameContextBuilder parentBuilder,List<EldoradoGameCard> instance) {
		super(parentBuilder, instance);
		this.behaviour = CardDamageCalculatorBehaviour.DEFAULT_BEHAVIOUR;
	}
	
	public static EldoradoGameDeckBuilder newInstance(EldoradoGameContextBuilder parentBuilder,List<EldoradoGameCard> instance) {
		return new EldoradoGameDeckBuilder(parentBuilder, instance);
	}
	
	
	public EldoradoGameDeckBuilder setDamageCalculator(CardDamageCalculatorBehaviour behaviour) {
		this.behaviour = behaviour;
		return this;
	}
	
	public EldoradoGameCardBuilder newCard()
	{
		return EldoradoGameCardBuilder.newInstance(this, super.instance);
	}
	

	@Override
	protected void prebuildInstance() {
		super.instance.stream().forEach(card -> card.setDamage(behaviour.calculateCardDamge(card)));
	}


}
