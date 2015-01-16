package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IAndExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class AndExpression extends BinaryExpression implements IAndExpression {
	

	public AndExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " AND " +
				this.getRightExpression().toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitAndExpression(this);
	}
}
