package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IGreaterThanExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class GreaterThanExpression extends BinaryExpression implements IGreaterThanExpression {
	

	public GreaterThanExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " > " +
				this.getRightExpression().toString();
	}
	
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitGreaterThanExpression(this);
	}
}
