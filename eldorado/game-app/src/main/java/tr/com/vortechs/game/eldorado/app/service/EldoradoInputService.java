package tr.com.vortechs.game.eldorado.app.service;

import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayerInput.EldoradoGamePlayerInputType;
import tr.com.vortechs.game.eldorado.app.service.listener.PlayerInputListener;
import tr.com.vortechs.game.eldorado.core.service.AbstractBaseService;

public interface EldoradoInputService extends AbstractBaseService{
	EldoradoGamePlayerInputType getPlayerAction(PlayerInputListener playerInputListener);
}
