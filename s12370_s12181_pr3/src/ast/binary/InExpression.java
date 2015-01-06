package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IInExpression;

public class InExpression extends BinaryExpression implements IInExpression {
	

	public InExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " IN " +
				this.getRightExpression().toString();
	}
	
}
