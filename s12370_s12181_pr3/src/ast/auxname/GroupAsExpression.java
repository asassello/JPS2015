package ast.auxname;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.auxname.IGroupAsExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class GroupAsExpression extends AuxiliaryNameExpression implements
		IGroupAsExpression {

	public GroupAsExpression(String name, IExpression expr) {
		super(name, expr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGroupAsExpression(this);

	}
}
