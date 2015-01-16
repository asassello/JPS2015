package ast.terminal;

import edu.pjwstk.jps.ast.terminal.IIntegerTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class IntegerTerminal extends TerminalExpression<Integer>  implements IIntegerTerminal  {
	


	public IntegerTerminal(Integer t){
		super(t);
	}
	
	public String toString(){
		return t.toString();
	};
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitIntegerTerminal(this);
	}
}
