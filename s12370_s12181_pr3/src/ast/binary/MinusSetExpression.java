package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IMinusSetExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class MinusSetExpression extends BinaryExpression implements IMinusSetExpression {
	

	public MinusSetExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " MINUS " +
				this.getRightExpression().toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitMinusSetExpression(this);
	}
}
