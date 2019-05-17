package tr.com.vortechs.game.eldorado.core.player.action;

import tr.com.vortechs.game.eldorado.core.behaviour.AbstractGameBehaviour;
import tr.com.vortechs.game.eldorado.core.context.AbstractBeanContext;
import tr.com.vortechs.game.eldorado.core.context.AbstractGameContext;
import tr.com.vortechs.game.eldorado.core.player.AbstractGamePlayer;
import tr.com.vortechs.game.eldorado.core.settings.AbstractGameSettings;

public interface PlayerBehaviour<C extends AbstractGameContext,B extends AbstractBeanContext,S extends AbstractGameSettings,P extends AbstractGamePlayer>  extends AbstractGameBehaviour{
	void playerBehave(C context,B beans,S settings,P currentPlayer);
	
	
}
