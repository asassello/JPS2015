package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.ICommaExpression;

public class CommaExpression extends BinaryExpression implements ICommaExpression {
	

	public CommaExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " , " +
				this.getRightExpression().toString();
	}
	
}
