package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IAvgExpression;

public class AvgExpression extends UnaryExpression implements IAvgExpression {
	

	public AvgExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Avg(" + this.getInnerExpression().toString() + ")";
	}
	
}
