package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.ISumExpression;

public class SumExpression extends UnaryExpression implements ISumExpression {
	

	public SumExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return " Sum( " + this.getInnerExpression().toString() + ")";
	}
	
}
