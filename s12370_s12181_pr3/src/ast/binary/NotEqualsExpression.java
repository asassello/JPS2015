package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.INotEqualsExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class NotEqualsExpression extends BinaryExpression implements INotEqualsExpression {
	

	public NotEqualsExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " != " +
				this.getRightExpression().toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitNotEqualsExpression(this);
	}
}
