package ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IModuloExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class ModuloExpression extends BinaryExpression implements IModuloExpression {
	

	public ModuloExpression(IExpression leftExpr, IExpression rightExpr){
		super(leftExpr, rightExpr);
	}
	
	public String toString(){
		return " MOD( " + this.getLeftExpression().toString() + " , " +
				this.getRightExpression().toString() + ")";
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitModuloExpression(this);
	}
}
