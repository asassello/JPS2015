package ast.terminal;

import ast.Expression;
import edu.pjwstk.jps.ast.terminal.INameTerminal;
import ast.terminal.TerminalExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class NameTerminal extends TerminalExpression<String>  implements INameTerminal  {

	public NameTerminal(String t){
		super(t);
	};
	
	public String getName(){
		return super.getValue();
	};
	
	public String toString(){
		return super.getValue();
	};
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitNameTerminal(this);
	}
}
