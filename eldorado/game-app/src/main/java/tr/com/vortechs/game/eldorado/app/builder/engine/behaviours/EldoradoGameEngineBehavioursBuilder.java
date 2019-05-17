package tr.com.vortechs.game.eldorado.app.builder.engine.behaviours;

import tr.com.vortechs.game.eldorado.app.builder.engine.EldoradoGameEngineBuilder;
import tr.com.vortechs.game.eldorado.app.builder.engine.behaviours.template.EldoradoGameEngineTemplateBehaviourBuilder;
import tr.com.vortechs.game.eldorado.app.context.EldoradoBeanContext;
import tr.com.vortechs.game.eldorado.app.context.EldoradoGameContext;
import tr.com.vortechs.game.eldorado.app.engine.EldoradoGameEngine;
import tr.com.vortechs.game.eldorado.app.engine.behaviour.EldoradoGameEngineActivePlayerBehaviour;
import tr.com.vortechs.game.eldorado.app.engine.behaviour.EldoradoGameEngineGameStatusBehaviour;
import tr.com.vortechs.game.eldorado.app.engine.behaviour.EldoradoGameEngineTemplateBehaviour;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.app.settings.EldoradoGameSettings;
import tr.com.vortechs.game.eldorado.core.builder.AbstractLeafBuilder;
import tr.com.vortechs.game.eldorado.core.player.action.PlayerBehaviour;

public class EldoradoGameEngineBehavioursBuilder extends AbstractLeafBuilder<EldoradoGameEngineBuilder, EldoradoGameEngine>{

	protected EldoradoGameEngineBehavioursBuilder(EldoradoGameEngineBuilder parentBuilder,EldoradoGameEngine instance) {
		super(parentBuilder, instance);
	}
	
	public static EldoradoGameEngineBehavioursBuilder newInstance(EldoradoGameEngineBuilder parentBuilder,EldoradoGameEngine instance)
	{
		return new EldoradoGameEngineBehavioursBuilder(parentBuilder, instance);
	}
	
	public EldoradoGameEngineTemplateBehaviourBuilder previous()
	{
		return EldoradoGameEngineTemplateBehaviourBuilder.newInstance(this, instance.getPrevEngineBehaviours());
	}
	
	public EldoradoGameEngineTemplateBehaviourBuilder post()
	{
		return EldoradoGameEngineTemplateBehaviourBuilder.newInstance(this, instance.getPostEngineBehaviours());
	}
	
	public EldoradoGameEngineBehavioursBuilder player(PlayerBehaviour<EldoradoGameContext,EldoradoBeanContext, EldoradoGameSettings, EldoradoGamePlayer> behaviour)
	{
		super.instance.setPlayerBehaviour(behaviour);
		return this;
	}
	
	public EldoradoGameEngineBehavioursBuilder afterPrev(EldoradoGameEngineTemplateBehaviour behaviour)
	{
		super.instance.setAfterPreviousEngineBehaviours(behaviour);
		return this;
	}
	
	public EldoradoGameEngineBehavioursBuilder afterPlayer(EldoradoGameEngineTemplateBehaviour behaviour)
	{
		super.instance.setAfterPlayerBehaviour(behaviour);
		return this;
	}
	
	public EldoradoGameEngineBehavioursBuilder afterPost(EldoradoGameEngineTemplateBehaviour behaviour)
	{
		super.instance.setAfterPostEngineBehaviours(behaviour);
		return this;
	}
	
	public EldoradoGameEngineBehavioursBuilder setActivePlayer(EldoradoGameEngineActivePlayerBehaviour behaviour)
	{
		super.instance.setSetActivePlayer(behaviour);
		return this;
	}
	
	public EldoradoGameEngineBehavioursBuilder updateGameStatus(EldoradoGameEngineGameStatusBehaviour behaviour)
	{
		super.instance.setUpdateGameStatus(behaviour);
		return this;
	}

	@Override
	protected void prebuildInstance() {
		// TODO Auto-generated method stub
		
	}

}
