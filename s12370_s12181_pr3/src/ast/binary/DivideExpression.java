package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IDivideExpression;

public class DivideExpression extends BinaryExpression implements IDivideExpression {
	

	public DivideExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " / " +
				this.getRightExpression().toString();
	}
	
}
