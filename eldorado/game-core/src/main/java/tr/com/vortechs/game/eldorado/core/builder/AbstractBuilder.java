package tr.com.vortechs.game.eldorado.core.builder;

public abstract class AbstractBuilder<O>{

	protected O instance;
	
	protected AbstractBuilder(O instance) {
		this.instance = instance;
	}
	
	protected abstract void prebuildInstance();
}
