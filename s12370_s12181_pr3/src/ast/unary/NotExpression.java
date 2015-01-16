package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.INotExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class NotExpression extends UnaryExpression implements INotExpression {
	

	public NotExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Not(" + this.getInnerExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitNotExpression(this);
	}

}
