package envs;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.interpreter.envs.IENVSBinder;
import edu.pjwstk.jps.result.IAbstractQueryResult;

public class Binder implements IENVSBinder  {
	
	public String name;
	public IAbstractQueryResult value;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public IAbstractQueryResult getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public Binder(String name, IAbstractQueryResult value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String toString(IENVSBinder binder) {
		// TODO Auto-generated method stub
		return name + "(" + value + "), ";
	}

	
}
