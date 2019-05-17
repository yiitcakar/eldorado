package tr.com.vortechs.game.eldorado.app.builder.context;

import tr.com.vortechs.game.eldorado.app.builder.engine.EldoradoGameEngineBuilder;
import tr.com.vortechs.game.eldorado.app.context.EldoradoBeanContext;
import tr.com.vortechs.game.eldorado.app.service.EldoradoInputService;
import tr.com.vortechs.game.eldorado.app.service.EldoradoOutputService;
import tr.com.vortechs.game.eldorado.core.builder.AbstractLeafBuilder;

public class EldoradoBeanContextBuilder extends AbstractLeafBuilder<EldoradoGameEngineBuilder, EldoradoBeanContext> {

	protected EldoradoBeanContextBuilder(EldoradoGameEngineBuilder parentBuilder, EldoradoBeanContext instance) {
		super(parentBuilder, instance);
	}
	
	public static EldoradoBeanContextBuilder newInstance(EldoradoGameEngineBuilder parentBuilder, EldoradoBeanContext instance) {
		return new EldoradoBeanContextBuilder(parentBuilder, instance);
	}
	
	public EldoradoBeanContextBuilder injectInputService(EldoradoInputService inputService) {
		super.instance.setInputService(inputService);
		return this;
	}
	
	public EldoradoBeanContextBuilder injectOutputService(EldoradoOutputService outputService) {
		super.instance.setOutputService(outputService);
		return this;
	}

	@Override
	protected void prebuildInstance() {
		// TODO Auto-generated method stub
	}

}
