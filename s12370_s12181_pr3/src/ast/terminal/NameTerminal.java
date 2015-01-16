package ast.terminal;

import ast.Expression;
import edu.pjwstk.jps.ast.terminal.INameTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class NameTerminal extends Expression  implements INameTerminal  {
	
	private String name;

	public NameTerminal(String t){
		super();
		this.name = t;
	};
	
	public String getName(){
		return name;
	};
	
	public String toString(){
		return name;
	};
	
	@Override
	public void accept(ASTVisitor visitor) {
		// TODO Auto-generated method stub
			visitor.visitNameTerminal(this);
	}
}
