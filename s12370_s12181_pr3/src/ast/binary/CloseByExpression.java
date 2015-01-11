package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.ICloseByExpression;

public class CloseByExpression extends BinaryExpression implements ICloseByExpression {
	

	public CloseByExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " CLOSE BY " +
				this.getRightExpression().toString();
	}
	
}