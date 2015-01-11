package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IOrderByExpression;

public class OrderByExpression extends BinaryExpression implements IOrderByExpression {
	

	public OrderByExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " ORDER BY " +
				this.getRightExpression().toString();
	}
	
}
