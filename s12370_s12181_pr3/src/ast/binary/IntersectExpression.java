package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IIntersectExpression;

public class IntersectExpression extends BinaryExpression implements IIntersectExpression {
	

	public IntersectExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " INTERSECT " +
				this.getRightExpression().toString();
	}
	
}
