package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IMinusExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class MinusExpression extends BinaryExpression implements IMinusExpression {
	

	public MinusExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " - " +
				this.getRightExpression().toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitMinusExpression(this);
	}
}
