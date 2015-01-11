package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IOrExpression;

public class OrExpression extends BinaryExpression implements IOrExpression {
	

	public OrExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " OR " +
				this.getRightExpression().toString();
	}
	
}
