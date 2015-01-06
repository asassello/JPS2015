package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.ICountExpression;

public class CountExpression extends UnaryExpression implements ICountExpression {
	

	public CountExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Count(" + this.getInnerExpression().toString() + ")";
	}
	
}
