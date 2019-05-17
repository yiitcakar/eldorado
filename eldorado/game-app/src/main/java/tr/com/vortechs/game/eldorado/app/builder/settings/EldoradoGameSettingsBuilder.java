package tr.com.vortechs.game.eldorado.app.builder.settings;

import tr.com.vortechs.game.eldorado.app.builder.engine.EldoradoGameEngineBuilder;
import tr.com.vortechs.game.eldorado.app.builder.settings.player.EldoradoPlayerSettingsBuilder;
import tr.com.vortechs.game.eldorado.app.settings.EldoradoGameSettings;
import tr.com.vortechs.game.eldorado.core.builder.AbstractLeafBuilder;

public class EldoradoGameSettingsBuilder extends AbstractLeafBuilder<EldoradoGameEngineBuilder,EldoradoGameSettings>{

	protected EldoradoGameSettingsBuilder(EldoradoGameEngineBuilder parentBuilder, EldoradoGameSettings instance) {
		super(parentBuilder, instance);
	}
	
	public static EldoradoGameSettingsBuilder newInstance(EldoradoGameEngineBuilder parentBuilder, EldoradoGameSettings instance)
	{
		return new EldoradoGameSettingsBuilder(parentBuilder,instance);
	}
	
	public EldoradoPlayerSettingsBuilder playerSettings()
	{
		return EldoradoPlayerSettingsBuilder.newInstance(this, super.instance.getPlayerSettings());
	}
	
	public EldoradoGameSettingsBuilder numberOfPlayers(int numberOfPlayers) {
		super.instance.setNumberOfPlayers(numberOfPlayers);
		return this;
	}

	@Override
	protected void prebuildInstance() {
		// TODO Auto-generated method stub
		
	}


}
