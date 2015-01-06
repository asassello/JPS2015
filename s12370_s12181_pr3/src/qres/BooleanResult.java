package qres;

import edu.pjwstk.jps.result.IBooleanResult;

public class BooleanResult extends SimpleResult<Boolean> implements IBooleanResult {

	Boolean value;
	
	public BooleanResult(Boolean value){
		super(value);
		this.value = value;
	}
	
	public Boolean getValue(){
		return value;
	}

	
	public String toString(){
		return this.value.toString();
	}

}
