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
//
//	public int compareTo(SimpleResult simpleResult) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	@Override
	public boolean equals(Object o){
		
		if(o == this)
		{
			return true;
		}else if(o instanceof SimpleResult<?>  )
		{
			return this.t.equals(((SimpleResult<?>)o).getValue());
		}
		return false;
		
	}
	
}
