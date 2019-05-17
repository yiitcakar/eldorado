package tr.com.vortechs.game.eldorado.app.settings;

import tr.com.vortechs.game.eldorado.app.settings.player.EldoradoPlayerSettings;
import tr.com.vortechs.game.eldorado.core.settings.AbstractGameSettings;

public class EldoradoGameSettings extends AbstractGameSettings{
	
	private EldoradoPlayerSettings playerSettings;
	private int numberOfPlayers;
	
	public EldoradoGameSettings() {
		this.playerSettings = new EldoradoPlayerSettings();
	}

	public EldoradoPlayerSettings getPlayerSettings() {
		return playerSettings;
	}

	

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public void setPlayerSettings(EldoradoPlayerSettings playerSettings) {
		this.playerSettings = playerSettings;
	}
	
}
