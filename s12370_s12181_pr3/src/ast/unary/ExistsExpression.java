package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IExistsExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class ExistsExpression extends UnaryExpression implements IExistsExpression {
	

	public ExistsExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Exists(" + this.getInnerExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
	// TODO Auto-generated method stub
			visitor.visitExistsExpression(this);
	}
}
