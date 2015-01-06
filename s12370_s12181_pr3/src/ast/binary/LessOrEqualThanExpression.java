package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.ILessOrEqualThanExpression;

public class LessOrEqualThanExpression extends BinaryExpression implements ILessOrEqualThanExpression {
	

	public LessOrEqualThanExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " <= " +
				this.getRightExpression().toString();
	}
	
}
