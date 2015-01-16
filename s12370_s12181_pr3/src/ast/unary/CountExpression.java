package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.ICountExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class CountExpression extends UnaryExpression implements ICountExpression {
	

	public CountExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Count(" + this.getInnerExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitCountExpression(this);
	}
}
