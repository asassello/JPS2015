package ast.terminal;

import edu.pjwstk.jps.ast.terminal.IIntegerTerminal;

public class IntegerTerminal extends TerminalExpression<Integer>  implements IIntegerTerminal  {
	


	public IntegerTerminal(Integer t){
		this.t = t;
	}
	
	public String toString(){
		return t.toString();
	};
}
