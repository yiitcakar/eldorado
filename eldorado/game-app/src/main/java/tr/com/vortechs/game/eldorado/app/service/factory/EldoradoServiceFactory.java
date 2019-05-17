package tr.com.vortechs.game.eldorado.app.service.factory;

import tr.com.vortechs.game.eldorado.app.service.EldoradoInputService;
import tr.com.vortechs.game.eldorado.app.service.EldoradoOutputService;
import tr.com.vortechs.game.eldorado.app.service.factory.EldoradoServiceFactory.Types.EldoradoInputServiceTypeEnum;
import tr.com.vortechs.game.eldorado.app.service.factory.EldoradoServiceFactory.Types.EldoradoOutputServiceTypeEnum;
import tr.com.vortechs.game.eldorado.app.service.impl.ConsoleBasedEldoradoInputServiceImpl;
import tr.com.vortechs.game.eldorado.app.service.impl.ConsoleBasedEldoradoOutputServiceImpl;

public class EldoradoServiceFactory {
	private static EldoradoServiceFactory serviceFactory;
	static
	{
		serviceFactory = new EldoradoServiceFactory();
	}
	
	private EldoradoServiceFactory(){}
	
	public static EldoradoServiceFactory getInstance()
	{
		return serviceFactory;
	}
	
	public EldoradoInputService getInputService(EldoradoInputServiceTypeEnum type)
	{
		EldoradoInputService bean;
		switch(type)
		{
			case CONSOLE_BASED_ELDORADO_INPUT_SERVICE:
				bean = new ConsoleBasedEldoradoInputServiceImpl();
			break;
			default:
				bean = null;
		}
		return bean;
	}
	
	public EldoradoOutputService getOutputService(EldoradoOutputServiceTypeEnum type)
	{
		EldoradoOutputService bean;
		switch(type)
		{
			case CONSOLE_BASED_ELDORADO_OUTPUT_SERVICE:
				bean = new ConsoleBasedEldoradoOutputServiceImpl();
			break;
			default:
				bean = null;
		}
		return bean;
	}
	
	public static class Types
	{
		public static enum EldoradoInputServiceTypeEnum
		{
			CONSOLE_BASED_ELDORADO_INPUT_SERVICE
		}
		
		public static enum EldoradoOutputServiceTypeEnum
		{
			CONSOLE_BASED_ELDORADO_OUTPUT_SERVICE
		}
	}
}
