package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IForAnyExpression;

public class ForAnyExpression extends BinaryExpression implements IForAnyExpression {
	

	public ForAnyExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return " ForAny( " + this.getLeftExpression().toString() + " , " +
				this.getRightExpression().toString() + ")";
	}
	
}
