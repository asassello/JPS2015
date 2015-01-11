package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IUniqueExpression;

public class UniqueExpression extends UnaryExpression implements IUniqueExpression {
	

	public UniqueExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return " Unique( " + this.getInnerExpression().toString() + ")";
	}
	
}
