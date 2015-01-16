package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IMaxExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class MaxExpression extends UnaryExpression implements IMaxExpression {
	

	public MaxExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Max(" + this.getInnerExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitMaxExpression(this);
	}
	
}
