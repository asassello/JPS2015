package ast.terminal;

import edu.pjwstk.jps.ast.terminal.ITerminalExpression;
import ast.Expression;

public class TerminalExpression<Typ> extends Expression implements ITerminalExpression<Typ> {
	
	Typ t;
	
	public void set(Typ t){
		this.t = t;
	}
	
	public Typ getValue(){
		return t;
	};

}

