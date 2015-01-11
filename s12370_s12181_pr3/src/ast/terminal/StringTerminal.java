package ast.terminal;

import edu.pjwstk.jps.ast.terminal.IStringTerminal;

public class StringTerminal extends TerminalExpression<String>  implements IStringTerminal  {
	


	public StringTerminal(String t){
		this.t = t;
	}
	
	public String toString(){
		return "\"" + t.toString() + "\"";
	};
}
