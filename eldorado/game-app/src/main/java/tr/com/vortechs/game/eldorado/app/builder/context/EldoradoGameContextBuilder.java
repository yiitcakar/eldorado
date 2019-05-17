package tr.com.vortechs.game.eldorado.app.builder.context;

import tr.com.vortechs.game.eldorado.app.builder.context.deck.EldoradoGameDeckBuilder;
import tr.com.vortechs.game.eldorado.app.builder.engine.EldoradoGameEngineBuilder;
import tr.com.vortechs.game.eldorado.app.context.EldoradoGameContext;
import tr.com.vortechs.game.eldorado.core.builder.AbstractLeafBuilder;

public class EldoradoGameContextBuilder extends AbstractLeafBuilder<EldoradoGameEngineBuilder, EldoradoGameContext>{

	protected EldoradoGameContextBuilder(EldoradoGameEngineBuilder parentBuilder, EldoradoGameContext instance) {
		super(parentBuilder, instance);
	}
	
	public static EldoradoGameContextBuilder newInstance(EldoradoGameEngineBuilder parentBuilder, EldoradoGameContext instance) {
		return new EldoradoGameContextBuilder(parentBuilder, instance);
	}
	
	public EldoradoGameDeckBuilder deck() {
		return EldoradoGameDeckBuilder.newInstance(this, super.instance.getGameDeck());
	}

	@Override
	protected void prebuildInstance() {
		// TODO Auto-generated method stub
		
	}

}
