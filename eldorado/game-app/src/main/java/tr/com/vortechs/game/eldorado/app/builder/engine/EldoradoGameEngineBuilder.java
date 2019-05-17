package tr.com.vortechs.game.eldorado.app.builder.engine;

import tr.com.vortechs.game.eldorado.app.builder.context.EldoradoBeanContextBuilder;
import tr.com.vortechs.game.eldorado.app.builder.context.EldoradoGameContextBuilder;
import tr.com.vortechs.game.eldorado.app.builder.engine.behaviours.EldoradoGameEngineBehavioursBuilder;
import tr.com.vortechs.game.eldorado.app.builder.settings.EldoradoGameSettingsBuilder;
import tr.com.vortechs.game.eldorado.app.context.EldoradoGameContext;
import tr.com.vortechs.game.eldorado.app.engine.EldoradoGameEngine;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayer;
import tr.com.vortechs.game.eldorado.app.settings.EldoradoGameSettings;
import tr.com.vortechs.game.eldorado.app.util.RandomUtil;
import tr.com.vortechs.game.eldorado.core.builder.AbstractParentBuilder;

public class EldoradoGameEngineBuilder extends AbstractParentBuilder<EldoradoGameEngine>{
	
	
	protected EldoradoGameEngineBuilder(EldoradoGameEngine instance) {
		super(instance);
		
	}
	
	public static EldoradoGameEngineBuilder newInstance()
	{
		return new EldoradoGameEngineBuilder(new EldoradoGameEngine());
	}

	public EldoradoGameSettingsBuilder settings()
	{
		return EldoradoGameSettingsBuilder.newInstance(this,super.instance.getSettings());
	}
	
	public EldoradoGameContextBuilder context()
	{
		return EldoradoGameContextBuilder.newInstance(this, super.instance.getContext());
	}
	
	public EldoradoBeanContextBuilder beans()
	{
		return EldoradoBeanContextBuilder.newInstance(this, super.instance.getBeans());
	}
	
	public EldoradoGameEngineBehavioursBuilder behaviours()
	{
		return EldoradoGameEngineBehavioursBuilder.newInstance(this, super.instance);
	}
	
	@Override
	protected void prebuildInstance() {
		EldoradoGameSettings settings = super.instance.getSettings();
		EldoradoGameContext context = super.instance.getContext();
		// create players
		EldoradoGamePlayer player;
		for(int i = 0 ; i < settings.getNumberOfPlayers() ; i++) {
			player = new EldoradoGamePlayer();
			player.setHealth(settings.getPlayerSettings().getInitialHealth());
			player.setMana(settings.getPlayerSettings().getInitialMana());
			player.setName("Player " + (i+1));
			// init player deck
			for(int j = 0 ; j < settings.getPlayerSettings().getInitialDeckSize() ; j++) {
				player.getDeck().add(RandomUtil.getThenDropRandomItem(context.getGameDeck()));
			}
			// add player to context
			context.getPlayers().add(player);
		}
		// set current player
		int index = RandomUtil.getRandomIntInRange(settings.getNumberOfPlayers());
		context.setCurrentPlayerIndex(index);
		super.instance.setCurrentPlayer(context.getPlayers().get(index));
	}

}
