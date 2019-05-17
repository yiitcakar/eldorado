package tr.com.vortechs.game.eldorado.app.engine;

import tr.com.vortechs.game.eldorado.app.context.EldoradoBeanContext;
import tr.com.vortechs.game.eldorado.app.context.EldoradoGameContext;
import tr.com.vortechs.game.eldorado.app.engine.behaviour.EldoradoGameEngineActivePlayerBehaviour;
import tr.com.vortechs.game.eldorado.app.engine.behaviour.EldoradoGameEngineGameStatusBehaviour;
import tr.com.vortechs.game.eldorado.app.engine.behaviour.EldoradoGameEngineTemplateBehaviour;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.app.settings.EldoradoGameSettings;
import tr.com.vortechs.game.eldorado.core.engine.AbstractGameEngineTemplate;
import tr.com.vortechs.game.eldorado.core.enums.engine.GameEngineStatusEnum;
import tr.com.vortechs.game.eldorado.core.enums.engine.behaviour.GameEngineLoopStatesEnum;

public class EldoradoGameEngine extends AbstractGameEngineTemplate<EldoradoGameContext,EldoradoBeanContext, EldoradoGameSettings, EldoradoGamePlayer>{

	
	private EldoradoGameEngineActivePlayerBehaviour setActivePlayer;
	private EldoradoGameEngineTemplateBehaviour afterPreviousEngineBehaviours;
	private EldoradoGameEngineTemplateBehaviour afterPlayerBehaviour;
	private EldoradoGameEngineTemplateBehaviour afterPostEngineBehaviours;
	private EldoradoGameEngineGameStatusBehaviour updateGameStatus;
	
	
	public EldoradoGameEngine() {
		super(new EldoradoGameContext(), new EldoradoBeanContext(),new EldoradoGameSettings());
		this.setActivePlayer = EldoradoGameEngineActivePlayerBehaviour.DEFAULT_BEHAVIOUR;
		this.afterPreviousEngineBehaviours = EldoradoGameEngineTemplateBehaviour.DEFAULT_BEHAVIOUR;
		this.afterPlayerBehaviour = EldoradoGameEngineTemplateBehaviour.DEFAULT_BEHAVIOUR;
		this.afterPostEngineBehaviours = EldoradoGameEngineTemplateBehaviour.DEFAULT_BEHAVIOUR;
		this.updateGameStatus = EldoradoGameEngineGameStatusBehaviour.DEFAULT_BEHAVIOUR;
		super.setPlayerBehaviour((context,beans,settings,player)->{});
	}

	@Override
	protected EldoradoGamePlayer setActivePlayer() {
		return this.setActivePlayer.behave(getContext(),getBeans(), getSettings());
	}

	@Override
	protected GameEngineLoopStatesEnum afterPreviousEngineBehaviours() {
		return this.afterPreviousEngineBehaviours.behave(getContext(),getBeans(), getSettings(), getCurrentPlayer());
	}

	@Override
	protected GameEngineLoopStatesEnum afterPlayerBehaviour() {
		return this.afterPlayerBehaviour.behave(getContext(),getBeans(), getSettings(), getCurrentPlayer());
	}

	@Override
	protected GameEngineLoopStatesEnum afterPostEngineBehaviours() {
		return this.afterPostEngineBehaviours.behave(getContext(),getBeans(), getSettings(), getCurrentPlayer());
	}

	@Override
	protected GameEngineStatusEnum updateGameStatus() {
		return this.updateGameStatus.behave(getContext(),getBeans(), getSettings(), getCurrentPlayer());
	}

	public void setSetActivePlayer(EldoradoGameEngineActivePlayerBehaviour setActivePlayer) {
		this.setActivePlayer = setActivePlayer;
	}

	public void setAfterPreviousEngineBehaviours(EldoradoGameEngineTemplateBehaviour afterPreviousEngineBehaviours) {
		this.afterPreviousEngineBehaviours = afterPreviousEngineBehaviours;
	}

	public void setAfterPlayerBehaviour(EldoradoGameEngineTemplateBehaviour afterPlayerBehaviour) {
		this.afterPlayerBehaviour = afterPlayerBehaviour;
	}

	public void setAfterPostEngineBehaviours(EldoradoGameEngineTemplateBehaviour afterPostEngineBehaviours) {
		this.afterPostEngineBehaviours = afterPostEngineBehaviours;
	}

	public void setUpdateGameStatus(EldoradoGameEngineGameStatusBehaviour updateGameStatus) {
		this.updateGameStatus = updateGameStatus;
	}

	@Override
	protected void starGame() {
		getBeans().getOutputService().startGame();
		super.setGameStatus(GameEngineStatusEnum.RUNING);
		
	}

	@Override
	protected void endGame() {
		getBeans().getOutputService().endGame();
	}
	
	
}
