package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.ICloseByExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class CloseByExpression extends BinaryExpression implements ICloseByExpression {
	

	public CloseByExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " CLOSE BY " +
				this.getRightExpression().toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitCloseByExpression(this);
	}
}