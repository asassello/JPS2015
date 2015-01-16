package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IStructExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class StructExpression extends UnaryExpression implements IStructExpression {
	

	public StructExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "<" + this.getInnerExpression().toString() + ">";
	}
	

	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitStructExpression(this);
	}
}
