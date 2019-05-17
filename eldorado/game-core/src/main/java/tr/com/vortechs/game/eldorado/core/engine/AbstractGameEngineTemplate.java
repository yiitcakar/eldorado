package tr.com.vortechs.game.eldorado.core.engine;

import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

import tr.com.vortechs.game.eldorado.core.context.AbstractBeanContext;
import tr.com.vortechs.game.eldorado.core.context.AbstractGameContext;
import tr.com.vortechs.game.eldorado.core.engine.behaviour.GameEngineBehaviour;
import tr.com.vortechs.game.eldorado.core.enums.engine.GameEngineStatusEnum;
import tr.com.vortechs.game.eldorado.core.enums.engine.behaviour.GameEngineLoopStatesEnum;
import tr.com.vortechs.game.eldorado.core.object.GameObject;
import tr.com.vortechs.game.eldorado.core.player.AbstractGamePlayer;
import tr.com.vortechs.game.eldorado.core.player.action.PlayerBehaviour;
import tr.com.vortechs.game.eldorado.core.settings.AbstractGameSettings;

public abstract class AbstractGameEngineTemplate<C extends AbstractGameContext,B extends AbstractBeanContext,S extends AbstractGameSettings,P extends AbstractGamePlayer> extends GameObject{
	
	private C context;
	private P currentPlayer;
	private S settings;
	private B beans;
	private GameEngineStatusEnum gameStatus;
	private List<GameEngineBehaviour<C,B,S,P>> prevEngineBehaviours;
	private PlayerBehaviour<C,B,S,P> playerBehaviour;
	private List<GameEngineBehaviour<C,B,S,P>> postEngineBehaviours;
	
	protected AbstractGameEngineTemplate(C context,B beans,S settings) {
		this.context = context;
		this.settings = settings;
		this.beans = beans;
		this.prevEngineBehaviours = new ArrayList<>();
		this.postEngineBehaviours = new ArrayList<>();
		this.gameStatus = GameEngineStatusEnum.EMPTY;
	}
	
	protected void gameLoop()
	{
		while(this.gameStatus == GameEngineStatusEnum.RUNING)
		{
			this.currentPlayer = setActivePlayer();
			this.prevEngineBehaviours.stream().forEach(action->action.engineBehave(this.context,this.beans,this.settings,this.currentPlayer));
			if(afterPreviousEngineBehaviours() == GameEngineLoopStatesEnum.CONTINUE)
			{	
				this.playerBehaviour.playerBehave(this.context,this.beans,this.settings,this.currentPlayer);
				if(afterPlayerBehaviour() == GameEngineLoopStatesEnum.CONTINUE) 
				{
					this.postEngineBehaviours.stream().forEach(action->action.engineBehave(this.context,this.beans,this.settings,this.currentPlayer));					
					afterPostEngineBehaviours();
				}
			}
			this.gameStatus = updateGameStatus();
		}
	}
	
	public void run()
	{
		starGame();
		gameLoop();
		endGame();
	}
	
	protected abstract void starGame();
	protected abstract void endGame();
	protected abstract P setActivePlayer();
	protected abstract GameEngineLoopStatesEnum afterPreviousEngineBehaviours();
	protected abstract GameEngineLoopStatesEnum afterPlayerBehaviour();
	protected abstract GameEngineLoopStatesEnum afterPostEngineBehaviours();
	protected abstract GameEngineStatusEnum updateGameStatus();

	public PlayerBehaviour<C,B,S,P> getPlayerBehaviour() {
		return playerBehaviour;
	}

	public void setPlayerBehaviour(PlayerBehaviour<C,B,S,P> playerBehaviour) {
		this.playerBehaviour = playerBehaviour;
	}

	public C getContext() {
		return context;
	}

	public S getSettings() {
		return settings;
	}

	public List<GameEngineBehaviour<C,B,S,P>> getPrevEngineBehaviours() {
		return prevEngineBehaviours;
	}

	public List<GameEngineBehaviour<C,B,S,P>> getPostEngineBehaviours() {
		return postEngineBehaviours;
	}

	public P getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(P currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public B getBeans() {
		return beans;
	}

	protected void setGameStatus(GameEngineStatusEnum gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	

}
