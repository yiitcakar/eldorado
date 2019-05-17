package tr.com.vortechs.game.eldorado.app.builder.engine.behaviours.template;

import java.util.List;

import tr.com.vortechs.game.eldorado.app.builder.engine.behaviours.EldoradoGameEngineBehavioursBuilder;
import tr.com.vortechs.game.eldorado.app.context.EldoradoBeanContext;
import tr.com.vortechs.game.eldorado.app.context.EldoradoGameContext;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.app.settings.EldoradoGameSettings;
import tr.com.vortechs.game.eldorado.core.builder.AbstractLeafBuilder;
import tr.com.vortechs.game.eldorado.core.engine.behaviour.GameEngineBehaviour;

public class EldoradoGameEngineTemplateBehaviourBuilder extends AbstractLeafBuilder<EldoradoGameEngineBehavioursBuilder, List<GameEngineBehaviour<EldoradoGameContext,EldoradoBeanContext, EldoradoGameSettings, EldoradoGamePlayer>>>{

	protected EldoradoGameEngineTemplateBehaviourBuilder(EldoradoGameEngineBehavioursBuilder parentBuilder,List<GameEngineBehaviour<EldoradoGameContext,EldoradoBeanContext, EldoradoGameSettings, EldoradoGamePlayer>> instance) {
		super(parentBuilder, instance);
	}
	
	public static EldoradoGameEngineTemplateBehaviourBuilder newInstance(EldoradoGameEngineBehavioursBuilder parentBuilder,List<GameEngineBehaviour<EldoradoGameContext,EldoradoBeanContext, EldoradoGameSettings, EldoradoGamePlayer>> instance)
	{
		return new EldoradoGameEngineTemplateBehaviourBuilder(parentBuilder, instance);
	}
	
	public EldoradoGameEngineTemplateBehaviourBuilder newBehaviour(GameEngineBehaviour<EldoradoGameContext,EldoradoBeanContext, EldoradoGameSettings, EldoradoGamePlayer> gameEngineBehaviour) {
		super.instance.add(gameEngineBehaviour);
		return this;
	}
	

	@Override
	protected void prebuildInstance() {
		// TODO Auto-generated method stub
		
	}

}
