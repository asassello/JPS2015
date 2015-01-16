package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IBagExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class BagExpression extends UnaryExpression implements IBagExpression {
	

	public BagExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "bag(" + this.getInnerExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitBagExpression(this);
	}
	
}
