package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IMinusSetExpression;

public class MinusSetExpression extends BinaryExpression implements IMinusSetExpression {
	

	public MinusSetExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " MINUS " +
				this.getRightExpression().toString();
	}
	
}
