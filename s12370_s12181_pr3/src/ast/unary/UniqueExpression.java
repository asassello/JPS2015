package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IUniqueExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class UniqueExpression extends UnaryExpression implements IUniqueExpression {
	

	public UniqueExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return " Unique( " + this.getInnerExpression().toString() + ")";
	}
	

	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitUniqueExpression(this);
	}
	
}
