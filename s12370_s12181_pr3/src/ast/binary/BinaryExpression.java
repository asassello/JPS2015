package ast.binary;

import ast.Expression;
import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IBinaryExpression;

public abstract class BinaryExpression extends Expression implements IBinaryExpression {
	IExpression leftExpr;
	IExpression rightExpr;
	
	public BinaryExpression(IExpression leftExpr, IExpression rightExpr){
		this.leftExpr = leftExpr;
		this.rightExpr = rightExpr;
	};
	
	public IExpression getLeftExpression(){
		return leftExpr;
	};
	public IExpression getRightExpression(){
		return rightExpr;
	};
	
}
