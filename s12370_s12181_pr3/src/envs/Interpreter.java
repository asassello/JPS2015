package envs;

import qres.*;
import datastore.*;
import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.auxname.IAsExpression;
import edu.pjwstk.jps.ast.auxname.IGroupAsExpression;
import edu.pjwstk.jps.ast.binary.IAndExpression;
import edu.pjwstk.jps.ast.binary.ICloseByExpression;
import edu.pjwstk.jps.ast.binary.ICommaExpression;
import edu.pjwstk.jps.ast.binary.IDivideExpression;
import edu.pjwstk.jps.ast.binary.IDotExpression;
import edu.pjwstk.jps.ast.binary.IEqualsExpression;
import edu.pjwstk.jps.ast.binary.IForAllExpression;
import edu.pjwstk.jps.ast.binary.IForAnyExpression;
import edu.pjwstk.jps.ast.binary.IGreaterOrEqualThanExpression;
import edu.pjwstk.jps.ast.binary.IGreaterThanExpression;
import edu.pjwstk.jps.ast.binary.IInExpression;
import edu.pjwstk.jps.ast.binary.IIntersectExpression;
import edu.pjwstk.jps.ast.binary.IJoinExpression;
import edu.pjwstk.jps.ast.binary.ILessOrEqualThanExpression;
import edu.pjwstk.jps.ast.binary.ILessThanExpression;
import edu.pjwstk.jps.ast.binary.IMinusExpression;
import edu.pjwstk.jps.ast.binary.IMinusSetExpression;
import edu.pjwstk.jps.ast.binary.IModuloExpression;
import edu.pjwstk.jps.ast.binary.IMultiplyExpression;
import edu.pjwstk.jps.ast.binary.INotEqualsExpression;
import edu.pjwstk.jps.ast.binary.IOrExpression;
import edu.pjwstk.jps.ast.binary.IOrderByExpression;
import edu.pjwstk.jps.ast.binary.IPlusExpression;
import edu.pjwstk.jps.ast.binary.IUnionExpression;
import edu.pjwstk.jps.ast.binary.IWhereExpression;
import edu.pjwstk.jps.ast.binary.IXORExpression;
import edu.pjwstk.jps.ast.terminal.IBooleanTerminal;
import edu.pjwstk.jps.ast.terminal.IDoubleTerminal;
import edu.pjwstk.jps.ast.terminal.IIntegerTerminal;
import edu.pjwstk.jps.ast.terminal.INameTerminal;
import edu.pjwstk.jps.ast.terminal.IStringTerminal;
import edu.pjwstk.jps.ast.unary.IAvgExpression;
import edu.pjwstk.jps.ast.unary.IBagExpression;
import edu.pjwstk.jps.ast.unary.ICountExpression;
import edu.pjwstk.jps.ast.unary.IExistsExpression;
import edu.pjwstk.jps.ast.unary.IMaxExpression;
import edu.pjwstk.jps.ast.unary.IMinExpression;
import edu.pjwstk.jps.ast.unary.INotExpression;
import edu.pjwstk.jps.ast.unary.IStructExpression;
import edu.pjwstk.jps.ast.unary.ISumExpression;
import edu.pjwstk.jps.ast.unary.IUniqueExpression;
import edu.pjwstk.jps.datastore.*;
import edu.pjwstk.jps.interpreter.envs.IENVS;
import edu.pjwstk.jps.interpreter.envs.IInterpreter;
import edu.pjwstk.jps.interpreter.qres.IQResStack;
import edu.pjwstk.jps.result.*;

public class Interpreter implements IInterpreter {
	
    private ISBAStore store;
    private IQResStack qres;
    private IENVS envs;
    
    
	
	public Interpreter(ISBAStore store) {
		super();
		this.store = store;
		this.qres = null;
		this.envs = null;
	}

	//czy aby na pewno warto�� zwracana ISingleResult ?
	public static ISingleResult checkIfSingleResult(IAbstractQueryResult res) throws Exception{
		
		if(res instanceof IStructResult){
			if(((Integer)((IStructResult)res).elements().size()).equals(1)){
				return ((IStructResult)res).elements().get(0);
			}
		}
		else if(res instanceof IBagResult){
			if(((Integer)((IBagResult)res).getElements().size()).equals(1)){
				return ((IBagResult)res).getElements().iterator().next();
			}
		}
		else if(res instanceof ISingleResult){
			return (ISingleResult) res;
		}
		//czy konieczne jest obs�u�enie BinderResult przy sprawdzaniu czy obiekt wskazuje na pojedyncz� warto��? 
		throw new RuntimeException("Non SingleResult");		
	}
	
	public static IAbstractQueryResult checkIfReferenceResult(IAbstractQueryResult res, SBAStore store){

		//System.out.println(res.getClass());
		
		if(res instanceof IReferenceResult){
			ISBAObject tmp = store.retrieve(((IReferenceResult)res).getOIDValue());
			
			//System.out.println(tmp.getClass());
			
			if(tmp instanceof BooleanObject){
				return new BooleanResult(((BooleanObject)tmp).getValue());				
			}
			else if(tmp instanceof IntegerObject){
				return new IntegerResult(((IntegerObject)tmp).getValue());
			}
			else if(tmp instanceof DoubleObject){
				return new DoubleResult(((DoubleObject)tmp).getValue());
			}
			else if(tmp instanceof StringObject){
				return new StringResult(((StringObject)tmp).getValue());
			}
			else if(tmp instanceof ComplexObject){
				//return new CollectionResult(((ComplexObject)tmp).getChildOIDs());
				//no bo co mielibysmy zwrocic, ktory z sub-obiektow? jesli sa roznych typow
			}
		}
		else if (res instanceof IBinderResult){
			return ((IBinderResult)res).getValue();
		}
		return res;
	}
	
	

	@Override
	public void visitAsExpression(IAsExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitGroupAsExpression(IGroupAsExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitAllExpression(IForAllExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitAndExpression(IAndExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitAnyExpression(IForAnyExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitCloseByExpression(ICloseByExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitCommaExpression(ICommaExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitDivideExpression(IDivideExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitDotExpression(IDotExpression expr) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void visitEqualsExpression(IEqualsExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitGreaterThanExpression(IGreaterThanExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitGreaterOrEqualThanExpression(
			IGreaterOrEqualThanExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitInExpression(IInExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitIntersectExpression(IIntersectExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitJoinExpression(IJoinExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLessOrEqualThanExpression(ILessOrEqualThanExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLessThanExpression(ILessThanExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitMinusExpression(IMinusExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitMinusSetExpression(IMinusSetExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitModuloExpression(IModuloExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitMultiplyExpression(IMultiplyExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitNotEqualsExpression(INotEqualsExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitOrderByExpression(IOrderByExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitOrExpression(IOrExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitPlusExpression(IPlusExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitUnionExpression(IUnionExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitWhereExpression(IWhereExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitXORExpression(IXORExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitBooleanTerminal(IBooleanTerminal expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitDoubleTerminal(IDoubleTerminal expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitIntegerTerminal(IIntegerTerminal expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitNameTerminal(INameTerminal expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitStringTerminal(IStringTerminal expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitBagExpression(IBagExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitCountExpression(ICountExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitExistsExpression(IExistsExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitMaxExpression(IMaxExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitMinExpression(IMinExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitNotExpression(INotExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitStructExpression(IStructExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitSumExpression(ISumExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitUniqueExpression(IUniqueExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitAvgExpression(IAvgExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IAbstractQueryResult eval(IExpression queryTreeRoot) {
		// TODO Auto-generated method stub
				
		this.qres = new QResStack();
		this.envs = new Envs();
		this.envs.init(this.store.getEntryOID(), this.store);
		queryTreeRoot.accept(this);
        return qres.pop();
	}

}
