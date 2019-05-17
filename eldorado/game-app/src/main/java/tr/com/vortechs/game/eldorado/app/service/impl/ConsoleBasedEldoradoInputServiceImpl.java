package tr.com.vortechs.game.eldorado.app.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayerInput;
import tr.com.vortechs.game.eldorado.app.object.EldoradoGamePlayerInput.EldoradoGamePlayerInputType;
import tr.com.vortechs.game.eldorado.app.service.EldoradoInputService;
import tr.com.vortechs.game.eldorado.app.service.listener.PlayerInputListener;
import tr.com.vortechs.game.eldorado.core.service.impl.AbstractBaseServiceImpl;

public class ConsoleBasedEldoradoInputServiceImpl extends AbstractBaseServiceImpl implements EldoradoInputService{

	private Scanner scanner;
	private static final List<String> DECK_COMMANDS = Arrays.asList("1","2","3","4","5");
	private static final List<String> TURN_COMMANDS = Arrays.asList("END");
	
	public ConsoleBasedEldoradoInputServiceImpl()
	{
		scanner = new Scanner(System.in);
	}
	
	@Override
	public EldoradoGamePlayerInputType getPlayerAction(PlayerInputListener playerInputListener) {
		String value = scanner.nextLine();
		EldoradoGamePlayerInput input = new EldoradoGamePlayerInput();
		input.setValue(value);
		if(DECK_COMMANDS.stream().anyMatch(command -> command.equals(value))) {
			input.setType(EldoradoGamePlayerInputType.PLAY_CARD);
		}else if(TURN_COMMANDS.stream().anyMatch(command -> command.equals(value))){
			input.setType(EldoradoGamePlayerInputType.END_TURN);
		}else {
			input.setType(EldoradoGamePlayerInputType.UNDEFINED);
		}
		playerInputListener.onPlayerInput(input);
		return input.getType();
	}

	

}
