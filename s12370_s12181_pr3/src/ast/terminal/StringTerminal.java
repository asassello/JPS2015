package ast.terminal;

import edu.pjwstk.jps.ast.terminal.IStringTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class StringTerminal extends TerminalExpression<String>  implements IStringTerminal  {
	


	public StringTerminal(String t){
		super(t);
	}
	
	public String toString(){
		return "\"" + t.toString() + "\"";
	};
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitStringTerminal(this);
	}
}
