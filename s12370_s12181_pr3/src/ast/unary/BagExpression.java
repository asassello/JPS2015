package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IBagExpression;

public class BagExpression extends UnaryExpression implements IBagExpression {
	

	public BagExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "bag(" + this.getInnerExpression().toString() + ")";
	}
	
}
