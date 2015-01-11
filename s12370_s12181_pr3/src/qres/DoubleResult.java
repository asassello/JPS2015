package qres;

import edu.pjwstk.jps.result.IDoubleResult;

public class DoubleResult extends SimpleResult<Double> implements IDoubleResult {

	Double value;
	
	public DoubleResult(Double value){
		super(value);
		this.value = value;
	}
	
	public Double getValue(){
		return value;
	}

	
	public String toString(){
		return this.value.toString();
	}


}
