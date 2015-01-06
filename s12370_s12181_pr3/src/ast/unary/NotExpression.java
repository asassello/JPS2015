package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.INotExpression;

public class NotExpression extends UnaryExpression implements INotExpression {
	

	public NotExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Not(" + this.getInnerExpression().toString() + ")";
	}
	
}
