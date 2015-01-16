package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IForAllExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class ForAllExpression extends BinaryExpression implements IForAllExpression {
	

	public ForAllExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return " ForAll( " + this.getLeftExpression().toString() + " , " +
				this.getRightExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitAllExpression(this);
	}
}
