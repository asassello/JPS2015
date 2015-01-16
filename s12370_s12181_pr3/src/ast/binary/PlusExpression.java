package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IPlusExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class PlusExpression extends BinaryExpression implements IPlusExpression {
	

	public PlusExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " + " +
				this.getRightExpression().toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitPlusExpression(this);
	}
}
