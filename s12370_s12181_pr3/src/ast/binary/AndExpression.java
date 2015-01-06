package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IAndExpression;

public class AndExpression extends BinaryExpression implements IAndExpression {
	

	public AndExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " AND " +
				this.getRightExpression().toString();
	}
	
}
