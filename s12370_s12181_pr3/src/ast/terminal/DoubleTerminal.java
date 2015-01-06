package ast.terminal;

import edu.pjwstk.jps.ast.terminal.IDoubleTerminal;

public class DoubleTerminal extends TerminalExpression<Double>  implements IDoubleTerminal  {
	


	public DoubleTerminal(Double t){
		this.t = t;
	}
	
	public String toString(){
		return t.toString();
	};
}
