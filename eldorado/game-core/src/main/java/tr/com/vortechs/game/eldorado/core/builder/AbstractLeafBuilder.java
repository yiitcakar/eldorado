package tr.com.vortechs.game.eldorado.core.builder;

public abstract class AbstractLeafBuilder<P extends AbstractBuilder<?>,O> extends AbstractBuilder<O>{
	
	private P parentBuilder;
	
	protected AbstractLeafBuilder(P parentBuilder,O instance) {
		super(instance);
		this.parentBuilder = parentBuilder;
	}
	
	public P end()
	{
		prebuildInstance();
		return this.parentBuilder;
	}
}
