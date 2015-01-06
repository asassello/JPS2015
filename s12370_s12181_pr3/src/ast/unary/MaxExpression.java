package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IMaxExpression;

public class MaxExpression extends UnaryExpression implements IMaxExpression {
	

	public MaxExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Max(" + this.getInnerExpression().toString() + ")";
	}
	
}
