package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IForAllExpression;

public class ForAllExpression extends BinaryExpression implements IForAllExpression {
	

	public ForAllExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return " ForAll( " + this.getLeftExpression().toString() + " , " +
				this.getRightExpression().toString() + ")";
	}
	
}
