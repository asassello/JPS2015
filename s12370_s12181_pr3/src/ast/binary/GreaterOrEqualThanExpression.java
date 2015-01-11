package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IGreaterOrEqualThanExpression;

public class GreaterOrEqualThanExpression extends BinaryExpression implements IGreaterOrEqualThanExpression {
	

	public GreaterOrEqualThanExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " => " +
				this.getRightExpression().toString();
	}
	
}
