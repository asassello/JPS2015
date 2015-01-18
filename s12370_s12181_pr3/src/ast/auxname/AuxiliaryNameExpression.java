package ast.auxname;

import ast.Expression;
import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.auxname.IAuxiliaryNameExpression;

public class AuxiliaryNameExpression extends Expression implements
		IAuxiliaryNameExpression {

	private String name;
	private IExpression expr;
	
	@Override
	public String getAuxiliaryName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public IExpression getInnerExpression() {
		// TODO Auto-generated method stub
		return expr;
	}

	public AuxiliaryNameExpression(String name, IExpression expr) {
		super();
		this.name = name;
		this.expr = expr;
	}

}
