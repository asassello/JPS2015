package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IJoinExpression;

public class JoinExpression extends BinaryExpression implements IJoinExpression {
	

	public JoinExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return this.getLeftExpression().toString() + " JOIN " +
				this.getRightExpression().toString();
	}
	
}
