package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IExistsExpression;

public class ExistsExpression extends UnaryExpression implements IExistsExpression {
	

	public ExistsExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Exists(" + this.getInnerExpression().toString() + ")";
	}
	
}
