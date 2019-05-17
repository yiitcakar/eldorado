package tr.com.vortechs.game.eldorado.app.object;

import tr.com.vortechs.game.eldorado.core.object.GameObject;

public class EldoradoGamePlayerInput extends GameObject
{
	private EldoradoGamePlayerInputType type;
	private String value;
	
	
	
	public EldoradoGamePlayerInputType getType() {
		return type;
	}



	public void setType(EldoradoGamePlayerInputType type) {
		this.type = type;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public static enum EldoradoGamePlayerInputType{
		UNDEFINED,
		PLAY_CARD,
		END_TURN;
	}
}
