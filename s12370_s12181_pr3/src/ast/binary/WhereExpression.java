package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IWhereExpression;

public class WhereExpression extends BinaryExpression implements IWhereExpression {
	

	public WhereExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		String leftStr  = getLeftExpression().toString();
		String rightStr  = getRightExpression().toString();
		//String leftStr  = getLeftExpression() instanceof  BinaryExpression ? getLeftExpression().toString(): "(" + getLeftExpression().toString()  + ")";
		//String rightStr  = getRightExpression() instanceof  BinaryExpression ? getRightExpression().toString(): "(" + getRightExpression().toString()  + ")";
		return leftStr.toString() + " WHERE " +
		rightStr.toString();
	}
	
}
