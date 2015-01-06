package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IGreaterThanExpression;

public class GreaterThanExpression extends BinaryExpression implements IGreaterThanExpression {
	

	public GreaterThanExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " > " +
				this.getRightExpression().toString();
	}
	
}
