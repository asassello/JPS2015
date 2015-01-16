package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IJoinExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class JoinExpression extends BinaryExpression implements IJoinExpression {
	

	public JoinExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " JOIN " +
				this.getRightExpression().toString();
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitJoinExpression(this);
	}
}
