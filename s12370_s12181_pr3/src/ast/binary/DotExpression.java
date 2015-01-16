package ast.binary;

import ast.terminal.TerminalExpression;
import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IDotExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class DotExpression extends BinaryExpression implements IDotExpression {
	

	public DotExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		String leftStr  = getLeftExpression() instanceof  TerminalExpression<?> ? getLeftExpression().toString(): "(" + getLeftExpression().toString()  + ")";
		String rightStr  = getRightExpression() instanceof  TerminalExpression<?> ? getRightExpression().toString(): "(" + getRightExpression().toString()  + ")";
		return leftStr.toString() + "." + rightStr.toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitDotExpression(this);
	}
}
