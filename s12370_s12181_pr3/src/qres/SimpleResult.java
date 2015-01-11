package qres;

import edu.pjwstk.jps.result.ISimpleResult;

public class SimpleResult<T>  extends SingleResult implements ISimpleResult<T> {

	T t;
	
	public SimpleResult(T t){
		this.t = t;
	}
	
	public void set(T value){
		this.t = value;
	}

	@Override
	public T getValue() {
		return t;
	}
	
	public String toString(){
		return t.toString();
	}
}
