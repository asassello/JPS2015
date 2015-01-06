package qres;

import edu.pjwstk.jps.result.IStringResult;

public class StringResult extends SimpleResult<String> implements IStringResult {

	String value;
	
	public StringResult(String value){
		super(value);
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

	public String toString(){
		return this.value.toString();
	}

}
