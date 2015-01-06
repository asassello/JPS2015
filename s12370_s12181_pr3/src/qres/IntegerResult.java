package qres;

import edu.pjwstk.jps.result.IIntegerResult;

public class IntegerResult extends SimpleResult<Integer> implements IIntegerResult {
	
	Integer value;

	
	public IntegerResult(Integer value){
		super(value);
		this.value = value;
	}
	
	public Integer getValue(){
		return value;
	}

	
	public String toString(){
		return this.value.toString();
	}

}
