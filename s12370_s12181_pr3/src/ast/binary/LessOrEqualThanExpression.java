package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.ILessOrEqualThanExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class LessOrEqualThanExpression extends BinaryExpression implements ILessOrEqualThanExpression {
	

	public LessOrEqualThanExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " <= " +
				this.getRightExpression().toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitLessOrEqualThanExpression(this);
	}
}
