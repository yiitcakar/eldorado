package tr.com.vortechs.game.eldorado.app.context;

import tr.com.vortechs.game.eldorado.app.service.EldoradoInputService;
import tr.com.vortechs.game.eldorado.app.service.EldoradoOutputService;
import tr.com.vortechs.game.eldorado.core.context.AbstractBeanContext;

public class EldoradoBeanContext extends AbstractBeanContext{
	
	private EldoradoInputService inputService;
	private EldoradoOutputService outputService;
	
	public EldoradoInputService getInputService() {
		return inputService;
	}
	public void setInputService(EldoradoInputService inputService) {
		this.inputService = inputService;
	}
	public EldoradoOutputService getOutputService() {
		return outputService;
	}
	public void setOutputService(EldoradoOutputService outputService) {
		this.outputService = outputService;
	}
	
	
}
