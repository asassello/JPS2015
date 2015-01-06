package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IMinExpression;

public class MinExpression extends UnaryExpression implements IMinExpression {
	

	public MinExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Min(" + this.getInnerExpression().toString() + ")";
	}
	
}
