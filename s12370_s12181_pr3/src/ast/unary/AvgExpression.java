package ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IAvgExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class AvgExpression extends UnaryExpression implements IAvgExpression {
	

	public AvgExpression(IExpression innerExpr){
		super(innerExpr);
	}
	
	public String toString(){
		return "Avg(" + this.getInnerExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitAvgExpression(this);
	}
}
