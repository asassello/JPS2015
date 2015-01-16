package ast.terminal;

import edu.pjwstk.jps.ast.terminal.IDoubleTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class DoubleTerminal extends TerminalExpression<Double>  implements IDoubleTerminal  {
	


	public DoubleTerminal(Double t){
		
		super(t);
	}
	
	public String toString(){
		return t.toString();
	};
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitDoubleTerminal(this);
	}
}
