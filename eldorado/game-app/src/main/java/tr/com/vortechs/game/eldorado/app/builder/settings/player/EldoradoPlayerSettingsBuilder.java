package tr.com.vortechs.game.eldorado.app.builder.settings.player;

import tr.com.vortechs.game.eldorado.app.builder.settings.EldoradoGameSettingsBuilder;
import tr.com.vortechs.game.eldorado.app.settings.player.EldoradoPlayerSettings;
import tr.com.vortechs.game.eldorado.core.builder.AbstractLeafBuilder;

public class EldoradoPlayerSettingsBuilder extends AbstractLeafBuilder<EldoradoGameSettingsBuilder, EldoradoPlayerSettings>{

	protected EldoradoPlayerSettingsBuilder(EldoradoGameSettingsBuilder parentBuilder,EldoradoPlayerSettings instance) {
		super(parentBuilder, instance);
	}
	
	public static EldoradoPlayerSettingsBuilder newInstance(EldoradoGameSettingsBuilder parentBuilder,EldoradoPlayerSettings instance) {
		return new EldoradoPlayerSettingsBuilder(parentBuilder, instance);
	}
	
	public EldoradoPlayerSettingsBuilder manaLimit(int manaLimit) {
		super.instance.setManaLimit(manaLimit);
		return this;
	}
	
	public EldoradoPlayerSettingsBuilder deckLimit(int deckLimit) {
		super.instance.setDeckLimit(deckLimit);
		return this;
	}
	
	public EldoradoPlayerSettingsBuilder initialHealth(int initialHealth) {
		super.instance.setInitialHealth(initialHealth);
		return this;
	}
	
	public EldoradoPlayerSettingsBuilder initialDeckSize(int initialDeckSize) {
		super.instance.setInitialDeckSize(initialDeckSize);
		return this;
	}
	
	public EldoradoPlayerSettingsBuilder initialMana(int initialMana) {
		super.instance.setInitialMana(initialMana);
		return this;
	}

	@Override
	protected void prebuildInstance() {
		// TODO Auto-generated method stub
		
	}

}
