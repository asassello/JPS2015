package ast.auxname;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.auxname.IAsExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class AsExpression extends AuxiliaryNameExpression implements
		IAsExpression {

	public AsExpression(String name, IExpression expr) {
		super(name, expr);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitAsExpression(this);
		// TODO Auto-generated method stub

	}
}
