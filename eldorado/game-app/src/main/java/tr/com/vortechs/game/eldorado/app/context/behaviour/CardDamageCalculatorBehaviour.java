package tr.com.vortechs.game.eldorado.app.context.behaviour;

import tr.com.vortechs.game.eldorado.app.object.EldoradoGameCard;
import tr.com.vortechs.game.eldorado.core.behaviour.AbstractGameBehaviour;

public interface CardDamageCalculatorBehaviour extends AbstractGameBehaviour{
	int calculateCardDamge(EldoradoGameCard card);
	
	public static final CardDamageCalculatorBehaviour DEFAULT_BEHAVIOUR = new CardDamageCalculatorBehaviour() {
		@Override
		public int calculateCardDamge(EldoradoGameCard card) {
			return 1;
		}
	};
}
