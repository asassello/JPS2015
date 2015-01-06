package ast.terminal;

import edu.pjwstk.jps.ast.terminal.INameTerminal;

public class NameTerminal extends TerminalExpression<String>  implements INameTerminal  {
	


	public NameTerminal(String t){
		this.t = t;
	};
	
	public String getName(){
		return t;
	};
	
	public String toString(){
		return t.toString();
	};
}
