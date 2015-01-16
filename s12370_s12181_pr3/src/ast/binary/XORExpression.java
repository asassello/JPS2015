package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IXORExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class XORExpression extends BinaryExpression implements IXORExpression {
	

	public XORExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " XOR " +
				this.getRightExpression().toString();
	}
	

	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitXORExpression(this);
	}
}
