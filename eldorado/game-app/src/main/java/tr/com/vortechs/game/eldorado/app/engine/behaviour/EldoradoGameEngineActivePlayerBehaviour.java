package tr.com.vortechs.game.eldorado.app.engine.behaviour;

import tr.com.vortechs.game.eldorado.app.context.EldoradoBeanContext;
import tr.com.vortechs.game.eldorado.app.context.EldoradoGameContext;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.app.settings.EldoradoGameSettings;
import tr.com.vortechs.game.eldorado.core.behaviour.AbstractGameBehaviour;

public interface EldoradoGameEngineActivePlayerBehaviour extends AbstractGameBehaviour{
	EldoradoGamePlayer behave(EldoradoGameContext context,EldoradoBeanContext beans,EldoradoGameSettings settings);
	
	public static final EldoradoGameEngineActivePlayerBehaviour DEFAULT_BEHAVIOUR = new EldoradoGameEngineActivePlayerBehaviour() {

		@Override
		public EldoradoGamePlayer behave(EldoradoGameContext context,EldoradoBeanContext beans, EldoradoGameSettings settings) {
			return context.getPlayers().get(context.getCurrentPlayerIndex());
		}

		
		
	};
}
