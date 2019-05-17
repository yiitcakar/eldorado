package tr.com.vortechs.game.eldorado.core.builder;

import tr.com.vortechs.game.eldorado.core.object.GameObject;

public abstract class AbstractParentBuilder<O extends GameObject> extends AbstractBuilder<O>{
	
	
	protected AbstractParentBuilder(O instance) {
		super(instance);
	}

	public O buildInstance() {
		prebuildInstance();
		return super.instance;
	}
}
