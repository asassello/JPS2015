package ast.unary;

import ast.Expression;
import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IUnaryExpression;

public abstract class UnaryExpression extends Expression implements IUnaryExpression {
	IExpression innerExpr;
	
	public UnaryExpression(IExpression innerExpr){
		this.innerExpr = innerExpr;
	};
	
	public IExpression getInnerExpression(){
		return innerExpr;
	};
}
