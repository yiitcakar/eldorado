package tr.com.vortechs.game.eldorado.app.engine.behaviour;

import tr.com.vortechs.game.eldorado.app.context.EldoradoBeanContext;
import tr.com.vortechs.game.eldorado.app.context.EldoradoGameContext;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.app.settings.EldoradoGameSettings;
import tr.com.vortechs.game.eldorado.core.behaviour.AbstractGameBehaviour;
import tr.com.vortechs.game.eldorado.core.enums.engine.GameEngineStatusEnum;

public interface EldoradoGameEngineGameStatusBehaviour extends AbstractGameBehaviour{
	GameEngineStatusEnum behave(EldoradoGameContext context,EldoradoBeanContext beans ,EldoradoGameSettings settings,EldoradoGamePlayer currentPlayer);
	
	public static final EldoradoGameEngineGameStatusBehaviour DEFAULT_BEHAVIOUR = new EldoradoGameEngineGameStatusBehaviour() {

		@Override
		public GameEngineStatusEnum behave(EldoradoGameContext context,EldoradoBeanContext beans,  EldoradoGameSettings settings,
				EldoradoGamePlayer currentPlayer) {
			return GameEngineStatusEnum.RUNING;
		}

		
		
	};
}
