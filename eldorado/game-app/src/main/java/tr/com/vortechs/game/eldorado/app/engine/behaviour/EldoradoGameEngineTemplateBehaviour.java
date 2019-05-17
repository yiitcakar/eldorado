package tr.com.vortechs.game.eldorado.app.engine.behaviour;

import tr.com.vortechs.game.eldorado.app.context.EldoradoBeanContext;
import tr.com.vortechs.game.eldorado.app.context.EldoradoGameContext;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.app.settings.EldoradoGameSettings;
import tr.com.vortechs.game.eldorado.core.behaviour.AbstractGameBehaviour;
import tr.com.vortechs.game.eldorado.core.enums.engine.behaviour.GameEngineLoopStatesEnum;

public interface EldoradoGameEngineTemplateBehaviour extends AbstractGameBehaviour{
	GameEngineLoopStatesEnum behave(EldoradoGameContext context,EldoradoBeanContext beans,EldoradoGameSettings settings,EldoradoGamePlayer currentPlayer);
	
	public static final EldoradoGameEngineTemplateBehaviour DEFAULT_BEHAVIOUR = new EldoradoGameEngineTemplateBehaviour() {

		@Override
		public GameEngineLoopStatesEnum behave(EldoradoGameContext context,EldoradoBeanContext beans, EldoradoGameSettings settings,EldoradoGamePlayer currentPlayer) {
			return GameEngineLoopStatesEnum.CONTINUE;
		}
		
	};
}
