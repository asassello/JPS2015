package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.ILessThanExpression;

public class LessThanExpression extends BinaryExpression implements ILessThanExpression {
	

	public LessThanExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " < " +
				this.getRightExpression().toString();
	}
	
}
