package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IEqualsExpression;

public class EqualsExpression extends BinaryExpression implements IEqualsExpression {
	

	public EqualsExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " = " +
				this.getRightExpression().toString();
	}
	
}
