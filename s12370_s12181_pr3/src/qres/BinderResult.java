package qres;

import edu.pjwstk.jps.result.IBinderResult;

public class BinderResult extends SingleResult implements IBinderResult {

	String name;
	AbstractQueryResult value;
	
	public BinderResult(String name, AbstractQueryResult value){
		super();
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String getName() {
		return name.toString();
	}

	@Override
	public AbstractQueryResult getValue() {
		return value;
	}
	
	public String toString(){
		return value + " as " + name;
	}

}
