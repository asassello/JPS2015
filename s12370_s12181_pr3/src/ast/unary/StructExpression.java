package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IStructExpression;

public class StructExpression extends UnaryExpression implements IStructExpression {
	

	public StructExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "<" + this.getInnerExpression().toString() + ">";
	}
	
}
