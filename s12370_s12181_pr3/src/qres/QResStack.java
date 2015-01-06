package qres;

import edu.pjwstk.jps.interpreter.qres.IQResStack;
import edu.pjwstk.jps.result.IAbstractQueryResult;
import java.util.Stack;

public class QResStack implements IQResStack {
	
	Stack<IAbstractQueryResult> qres = new Stack<IAbstractQueryResult>();

	@Override
	public IAbstractQueryResult pop() {
		return qres.pop();
	}

	@Override
	public void push(IAbstractQueryResult value) {
		qres.push(value);
	}
	
	public String toString(IAbstractQueryResult value){
		return "qres";
	}

}
