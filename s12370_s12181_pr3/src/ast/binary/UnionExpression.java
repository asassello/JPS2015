package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IUnionExpression;

public class UnionExpression extends BinaryExpression implements IUnionExpression {
	

	public UnionExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " UNION " +
				this.getRightExpression().toString();
	}
	
}
