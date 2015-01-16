package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IIntersectExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class IntersectExpression extends BinaryExpression implements IIntersectExpression {
	

	public IntersectExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " INTERSECT " +
				this.getRightExpression().toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitIntersectExpression(this);
	}
}
