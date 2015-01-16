package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IMinExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class MinExpression extends UnaryExpression implements IMinExpression {
	

	public MinExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Min(" + this.getInnerExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitMinExpression(this);
	}
}
