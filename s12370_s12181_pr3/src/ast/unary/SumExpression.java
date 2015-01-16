package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.ISumExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class SumExpression extends UnaryExpression implements ISumExpression {
	

	public SumExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return " Sum( " + this.getInnerExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitSumExpression(this);
	}
}
