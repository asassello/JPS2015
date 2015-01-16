package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IForAnyExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class ForAnyExpression extends BinaryExpression implements IForAnyExpression {
	

	public ForAnyExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return " ForAny( " + this.getLeftExpression().toString() + " , " +
				this.getRightExpression().toString() + ")";
	}
	
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitAnyExpression(this);
	}
	
}
