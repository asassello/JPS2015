package envs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    	
	public ISBAStore getStore() {
		return store;
	}

	public IQResStack getQres() {
		return qres;
	}

	public IENVS getEnvs() {
		return envs;
	}

	public Interpreter(ISBAStore store) {
		super();
		this.store = store;
		this.qres = null;
		this.envs = null;
	}
	
	
	public IAbstractQueryResult parseBool(IAbstractQueryResult param){
		
		if (param instanceof IntegerResult && ((IntegerResult) param).getValue() == 1 ) {BooleanResult param_ = new BooleanResult(true); return param_;}
		if (param instanceof IntegerResult && ((IntegerResult) param).getValue() == 0 ) {BooleanResult param_ = new BooleanResult(false); return param_;}
		return param;
	}
	
	public static Collection<ISingleResult> BagRemove (IAbstractQueryResult result)
	{
		if(result instanceof BagResult)
			return ((BagResult) result).getElements();
		else{
			ArrayList<ISingleResult> tmp = new ArrayList<ISingleResult>();
			tmp.add((ISingleResult) result);
				return tmp;
		}
	}
	
	public static IAbstractQueryResult SingleBagRemove (IAbstractQueryResult result)
	{
		if(result instanceof BagResult){
			if(((BagResult) result).getElements().size()==1)
				return ((BagResult) result).getElements().iterator().next();
			else
				return result;
		}
		else return result;	
	}
	
	public static Boolean checkIfNumber(IAbstractQueryResult result1){
		Boolean tmp = null;
		if(result1 instanceof ISimpleResult){
			if((( ISimpleResult)result1).getValue() instanceof Number ) return true;
			else throw new RuntimeException("Non NumberResults");
		}
//		else if(result1 instanceof StructResult){
//			for(ISingleResult el: (((StructResult)result1).getElements())){
//				if(((SimpleResult)el).getValue() instanceof Number) tmp = true;
//				else return false;
//			}
//			return tmp;
//		}
		else throw new RuntimeException("Non NumberResults");
		
	}
	
	
	public static ArrayList<ISingleResult> getListOfSingleResults (IAbstractQueryResult result){
		ArrayList<ISingleResult> tmp = new ArrayList<ISingleResult>();
		if(result instanceof SingleResult){
			tmp.add((ISingleResult)result);
		}
		if(result instanceof IBagResult){
			for (ISingleResult element: ((IBagResult)result).getElements()) {
				tmp.add(element);
			}
		}
		return tmp;
	}
	
	public static ArrayList<ISingleResult> checkIfIterableResult(IAbstractQueryResult result){
		ArrayList<ISingleResult> tmp = new ArrayList<ISingleResult>();
		if(result instanceof IBagResult){
			for(ISingleResult el: ((IBagResult)result).getElements() ){
				
				if(el instanceof IStructResult) //czy tak na pewno ma byæ? czy bag ze struktur¹mi ma zwróciæ pojedyncze elementy tych struktur?
					for(ISingleResult el1: ((StructResult)el).getElements())
						tmp.add(el1);
				else
				tmp.add(el);
			}
			return tmp;
		}
		else if(result instanceof IStructResult){
			for(ISingleResult el: ((IStructResult)result).elements()  ){
				tmp.add(el);
				//System.out.println(tmp);
			}
			return tmp;
		}
		else if(result instanceof ISingleResult){
			tmp.add((ISingleResult)result);
			return tmp;
		}
		else throw new RuntimeException("Non IterableResult");
		
	}

//	public static ISingleResult checkIfSingleResult(IAbstractQueryResult res){
//		if(res instanceof IStructResult){
//			if(((Integer)((IStructResult)res).elements().size()).equals(1)){
//				return ((IStructResult)res).elements().get(0);
//				//to jest Ÿle!!!
//			}
//			else throw new RuntimeException("Non SingleResult");	
//		}
//		else if(res instanceof IBagResult){
//			if(((Integer)((IBagResult)res).getElements().size()).equals(1)){
//				return ((IBagResult)res).getElements().iterator().next();
//			}
//			else throw new RuntimeException("Non SingleResult");
//		}
//		else if(res instanceof ISingleResult){
//			return (ISingleResult) res;
//		}
//		//czy konieczne jest obs³u¿enie BinderResult przy sprawdzaniu czy obiekt wskazuje na pojedyncz¹ wartoœæ? 
//		else throw new RuntimeException("Non SingleResult");		
//	}
	
	public static ISingleResult checkIfSingleResult(IAbstractQueryResult res){
		if(res instanceof ISingleResult){
				return (ISingleResult)res;
			}
		else if(res instanceof IBagResult){
			if(((Integer)((IBagResult)res).getElements().size()).equals(1)){
				return ((IBagResult)res).getElements().iterator().next();
			}
		}
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
//			else if(tmp instanceof ComplexObject){}//no bo co mielibysmy zwrocic, ktory z sub-obiektow? jesli sa roznych typow
			else throw new RuntimeException("Reference to complex object");
		}
		else if (res instanceof IBinderResult){
			return checkIfReferenceResult(((IBinderResult)res).getValue(),store);
		}
		else if (res instanceof IBagResult){
			//if(((Integer)((IBagResult)res).getElements().size()).equals(1)){
				if( ((IBagResult)res).getElements().iterator().next() instanceof ReferenceResult){
					//System.out.println("TU");
					//System.out.println(((IBagResult)res).getElements().iterator().next().getClass());
					return checkIfReferenceResult(((IBagResult)res).getElements().iterator().next(),store);
				//}
				}
		}
		return res;
	}

	@Override
	public void visitAsExpression(IAsExpression expr) {
		// TODO Auto-generated method stub
		ArrayList<ISingleResult> res  = new ArrayList<ISingleResult>();
		expr.getInnerExpression().accept(this);
		IAbstractQueryResult inner = this.qres.pop();
		Collection<ISingleResult> tmp = this.BagRemove(inner);
		
		for(ISingleResult el: tmp){	
			
				res.add(new BinderResult(expr.getAuxiliaryName(), (AbstractQueryResult) el) );		
				
		}
		qres.push(new BagResult((Collection<ISingleResult>)res));
		//System.out.println(res);
	}
	

	@Override
	public void visitGroupAsExpression(IGroupAsExpression expr) {
		// TODO Auto-generated method stub
		expr.getInnerExpression().accept(this);
		IAbstractQueryResult inner = this.qres.pop();
		
		//System.out.println(this.checkIfReferenceResult(inner, (SBAStore) store));
		
		qres.push(new BinderResult(expr.getAuxiliaryName(), (AbstractQueryResult) inner) );			
	}

	@Override
	public void visitAllExpression(IForAllExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this); //lewe podzapytanie
		IAbstractQueryResult left = this.qres.pop();
		for(IAbstractQueryResult el: this.checkIfIterableResult(left)){
			this.envs.push(this.envs.nested(el, this.store));
			expr.getRightExpression().accept(this);
			IAbstractQueryResult right = this.qres.pop();
			//System.out.println(right);
			right =  this.checkIfReferenceResult(right, (SBAStore) store); 
			//System.out.println(right);
			
			if(!(right instanceof BooleanResult)) throw new RuntimeException("Non boolean value /AllExpression"); 
			if(((BooleanResult)right).getValue().equals(false)){
				qres.push(new BooleanResult(false));
				this.envs.pop();
				return;
			}
			else qres.push(new BooleanResult(true));
			this.envs.pop();
		}		
	}

	@Override
	public void visitAndExpression(IAndExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		//try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		//} catch (Exception e) { System.out.println("AndExpression: Non single result"); }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		//System.out.println(left);
		//System.out.println(right);
				
		if (parseBool(left) instanceof IBooleanResult && parseBool(right) instanceof IBooleanResult ) //dwa bool
			qres.push ( new BooleanResult( ((BooleanResult)left).getValue() && ((BooleanResult)right).getValue()) );
		else throw new RuntimeException("AndExpression: InvalidArguments");
	}

	@Override
	public void visitAnyExpression(IForAnyExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this); //lewe podzapytanie
		IAbstractQueryResult left = this.qres.pop();
		for(IAbstractQueryResult el: this.checkIfIterableResult(left)){
			this.envs.push(this.envs.nested(el, this.store));
			expr.getRightExpression().accept(this);
			IAbstractQueryResult right = this.qres.pop();
			IAbstractQueryResult right_ = this.checkIfReferenceResult(right, (SBAStore) store);
			if(!(parseBool(right_) instanceof BooleanResult)) throw new RuntimeException("Non boolean value /ForAnyExpression"); 
			if(((BooleanResult)right_).getValue().equals(true)){
				qres.push(new BooleanResult(true));
				this.envs.pop();
				return;
			}
			else qres.push(new BooleanResult(false));
			this.envs.pop();
		}		
	}

	@Override
	public void visitCloseByExpression(ICloseByExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitCommaExpression(ICommaExpression expr) {
		// TODO Auto-generated method stub
		BagResult eres = new BagResult(); //nowy bag na wynik
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult e2res = this.qres.pop();
		IAbstractQueryResult e1res = this.qres.pop();
		
		//System.out.println("TU");
		//System.out.println(e2res);
		//System.out.println(e1res);
		
		for(IAbstractQueryResult e1: this.getListOfSingleResults(e1res)){
			for(IAbstractQueryResult e2: this.getListOfSingleResults(e2res)){
				StructResult structEl = new StructResult();
				//System.out.println(e1);
				//System.out.println(e2);
				structEl.addElements(this.checkIfIterableResult(e1));
				structEl.addElements(this.checkIfIterableResult(e2));
//				structEl.addElements(this.checkIfIterableResult(e1));
//				structEl.addElements(this.checkIfIterableResult(e2));
				//System.out.println(structEl);
				eres.addElements(structEl);
			}
		}		
		qres.push(SingleBagRemove(eres));
	}

	@Override
	public void visitDivideExpression(IDivideExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("DivideExpression: Non single result");  }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new DoubleResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() / ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ){ //dwa int
			if( (((Number)((ISimpleResult)left).getValue()).doubleValue() / ((Number)((ISimpleResult)right).getValue()).doubleValue()) % 1 == 0  ) //dwa int dziel¹ce siê bez reszty
				qres.push ( new IntegerResult( ((IntegerResult)left).getValue() / ((IntegerResult)right).getValue()) );
			else //reszta
				qres.push( new DoubleResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() / ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		}
		else throw new RuntimeException("DivideExpression: InvalidArguments");
	}

	@Override
	public void visitDotExpression(IDotExpression expr) {
		// TODO Auto-generated method stub
		
		BagResult eres = new BagResult(); //nowy bag na wynik
		expr.getLeftExpression().accept(this); //lewe podzapytanie
		IAbstractQueryResult left = this.qres.pop();	
		
		
		for(IAbstractQueryResult el: this.getListOfSingleResults(left)){
			//System.out.println(el);
			this.envs.push(this.envs.nested(el, this.store));
			expr.getRightExpression().accept(this);
			IAbstractQueryResult right = this.qres.pop();
			//System.out.println(right);
			eres.addElements(SingleBagRemove(right)); //funkcja przeci¹¿ona
			this.envs.pop();
		}		
		qres.push(SingleBagRemove(eres));
	}
	
	@Override
	public void visitWhereExpression(IWhereExpression expr){
		// TODO Auto-generated method stub
		BagResult wheres = new BagResult(); //nowy bag na wynik
		expr.getLeftExpression().accept(this); //lewe podzapytanie
		IAbstractQueryResult left = this.qres.pop();
		
//		System.out.println(left);
		for(IAbstractQueryResult el: this.checkIfIterableResult(left)){
			this.envs.push(this.envs.nested(el, this.store));
			expr.getRightExpression().accept(this);
			IAbstractQueryResult right = this.qres.pop();
			right =  this.checkIfReferenceResult(right, (SBAStore) store);
			//System.out.println(right);
			if(!(right instanceof BooleanResult)) throw new RuntimeException("Non boolean value"); 
			if(((BooleanResult)right).getValue().equals(true)){
//				System.out.println(el);
//				System.out.println(wheres);
				wheres.addElements(el); //funkcja przeci¹¿ona
//				System.out.println("TEST");
//				System.out.println(wheres);
			}
			this.envs.pop();
		}	
//		System.out.println(wheres);
		qres.push(SingleBagRemove(wheres));
		
	}

	@Override
	public void visitEqualsExpression(IEqualsExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		
		//System.out.println(left.getClass());
		
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("EqualsExpression: Non single result"); }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		//System.out.println(left.getClass());
		
		if(left instanceof IStringResult || right instanceof IStringResult ) //jeden string
			{
			if(parseBool(left) instanceof IBooleanResult || parseBool(right) instanceof IBooleanResult ) qres.push( new BooleanResult(true) ); 
			else
			qres.push( new BooleanResult( ((ISimpleResult)left).getValue().toString().equals(((ISimpleResult)right).getValue().toString()) ) );
		}
		else if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new BooleanResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() == ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ) //dwa int
			qres.push ( new BooleanResult( ((IntegerResult)left).getValue() == ((IntegerResult)right).getValue()) );
		else if (parseBool(left) instanceof IBooleanResult && parseBool(right) instanceof IBooleanResult ) //dwa bool
			qres.push ( new BooleanResult( ((BooleanResult)parseBool(left)).getValue() == ((BooleanResult)parseBool(right)).getValue()) );
		else throw new RuntimeException("EqualsExpression: InvalidArguments");
	}

	@Override
	public void visitGreaterThanExpression(IGreaterThanExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("GreaterThanExpression: Non single result");  }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new BooleanResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() > ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ) //dwa int
			qres.push ( new BooleanResult( ((IntegerResult)left).getValue() > ((IntegerResult)right).getValue()) );
		else throw new RuntimeException("GreaterThanExpression: InvalidArguments");
	}

	@Override
	public void visitGreaterOrEqualThanExpression(
			IGreaterOrEqualThanExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("GreaterOrEqualThanExpression: Non single result");  }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new BooleanResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() >= ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ) //dwa int
			qres.push ( new BooleanResult( ((IntegerResult)left).getValue() >= ((IntegerResult)right).getValue()) );
		else throw new RuntimeException("GreaterOrEqualThanExpression: InvalidArguments");
	}

	@Override
	public void visitInExpression(IInExpression expr) {
		// TODO Auto-generated method stub
		BagResult eres = new BagResult();
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
			
		ArrayList<ISingleResult> eres2= (this.checkIfIterableResult(this.qres.pop()));
		ArrayList<ISingleResult> eres1 = (this.checkIfIterableResult(this.qres.pop()));
		
			if((eres2.containsAll(eres1))){
				qres.push(new BooleanResult(true));
			}
			else qres.push(new BooleanResult(false));
	}

	@Override
	public void visitIntersectExpression(IIntersectExpression expr) {
		// TODO Auto-generated method stub
		BagResult eres = new BagResult();
		BagResult eres1 = new BagResult(); //nowy bag na wynik
		BagResult eres2 = new BagResult(); //nowy bag na wynik
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
			
		ArrayList<ISingleResult> right = (this.getListOfSingleResults(this.qres.pop()));
		ArrayList<ISingleResult> left = (this.getListOfSingleResults(this.qres.pop()));
		
//		System.out.println(eres);
//		System.out.println(right);
//		System.out.println(left);
				
		for(ISingleResult eres1El: left){
			for(ISingleResult eres2El: right){
				Boolean fla = false;
				if(eres1El instanceof ISimpleResult && eres2El instanceof ISimpleResult ){
					if(((ISimpleResult)eres1El).getValue().equals(((ISimpleResult)eres2El).getValue()))
					{
						fla = true;
					}
				}
				else if(eres1El instanceof IStructResult && eres2El instanceof IStructResult && 
						(((IStructResult)eres1El).elements().size()==((IStructResult)eres2El).elements().size()) ){
						Boolean fla2 = true;
						for(int i=0;i<((IStructResult)eres1El).elements().size();i++)
							if ( !(((ISimpleResult)((IStructResult)eres1El).elements().get(i)).getValue().equals(((ISimpleResult)((IStructResult)eres2El).elements().get(i)).getValue())) )
							{
								fla2 = false;
							}
						fla=fla2;
				}					
				if(fla) eres.addElements(eres1El);
				//System.out.println(eres);
			}
		}
		qres.push((eres));
	}

	@Override
	public void visitJoinExpression(IJoinExpression expr) {
		// TODO Auto-generated method stub
		
		BagResult eres = new BagResult(); //nowy bag na wynik
		expr.getLeftExpression().accept(this); //lewe podzapytanie
		IAbstractQueryResult left = this.qres.pop();		
		for(IAbstractQueryResult el: this.checkIfIterableResult(left)){
			ISingleResult el_ = this.checkIfSingleResult(el);
			this.envs.push(this.envs.nested(el, this.store));
			expr.getRightExpression().accept(this);
			for(IAbstractQueryResult e2: this.checkIfIterableResult(this.qres.pop())){
				StructResult structEl = new StructResult();
				structEl.addElements(this.checkIfIterableResult(el_));
				structEl.addElements(this.checkIfIterableResult(e2));
				eres.addElements(structEl);
			}
			this.envs.pop();
		}		
		qres.push(SingleBagRemove(eres));
	}

	@Override
	public void visitLessOrEqualThanExpression(ILessOrEqualThanExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("LessOrEqualThanExpression: Non single result");  }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new BooleanResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() <= ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ) //dwa int
			qres.push ( new BooleanResult( ((IntegerResult)left).getValue() <= ((IntegerResult)right).getValue()) );
		else throw new RuntimeException("LessOrEqualThanExpression: InvalidArguments");
	}

	@Override
	public void visitLessThanExpression(ILessThanExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("LessThanExpression: Non single result");  }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new BooleanResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() < ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ) //dwa int
			qres.push ( new BooleanResult( ((IntegerResult)left).getValue() < ((IntegerResult)right).getValue()) );
		else throw new RuntimeException("LessThanExpression: InvalidArguments");
	}

	@Override
	public void visitMinusExpression(IMinusExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("MinusExpression: Non single result"); }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new DoubleResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() - ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ) //dwa int
			qres.push ( new IntegerResult( ((IntegerResult)left).getValue() - ((IntegerResult)right).getValue()) );
		else throw new RuntimeException("MinusExpression: InvalidArguments");
	}

	@Override
	public void visitMinusSetExpression(IMinusSetExpression expr) {
		// TODO Auto-generated method stub
		BagResult eres = new BagResult();
		BagResult eres1 = new BagResult(); //nowy bag na wynik
		BagResult eres2 = new BagResult(); //nowy bag na wynik
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
			
//		eres2.addElements(this.checkIfIterableResult(this.qres.pop()));
//		eres1.addElements(this.checkIfIterableResult(this.qres.pop()));
		
		eres2.addElements(this.getListOfSingleResults(this.qres.pop()));
		eres1.addElements(this.getListOfSingleResults(this.qres.pop()));
		
		for(ISingleResult eres1El: this.getListOfSingleResults(eres1)){
			if(!(eres2.getElements().contains(eres1El))){
				eres.addElements(eres1El);
			}
		}
		qres.push(SingleBagRemove(eres));
	}

	@Override
	public void visitModuloExpression(IModuloExpression expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitMultiplyExpression(IMultiplyExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("MultiplyExpression: Non single result");  }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new DoubleResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() * ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ) //dwa int
			qres.push ( new IntegerResult( ((IntegerResult)left).getValue() * ((IntegerResult)right).getValue()) );
		else throw new RuntimeException("MultiplyExpression: InvalidArguments");
	}

	@Override
	public void visitNotEqualsExpression(INotEqualsExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("NotEqualsExpression: Non single result"); }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if(left instanceof IStringResult || right instanceof IStringResult ) //jeden string
			qres.push( new BooleanResult( !(((ISimpleResult)left).getValue().toString().equals(((ISimpleResult)right).getValue().toString())) ) );
		else if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new BooleanResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() != ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ) //dwa int
			qres.push ( new BooleanResult( ((IntegerResult)left).getValue() != ((IntegerResult)right).getValue()) );
		else if (parseBool(left) instanceof IBooleanResult && parseBool(right) instanceof IBooleanResult ) //dwa bool
			qres.push ( new BooleanResult( ((BooleanResult)left).getValue() != ((BooleanResult)right).getValue()) );
		else throw new RuntimeException("NotEqualsExpression: InvalidArguments");
	}

	@Override
	public void visitOrderByExpression(IOrderByExpression expr) {
		// TODO Auto-generated method stub
		//join
		BagResult eres_join = new BagResult(); //nowy bag na wynik
		expr.getLeftExpression().accept(this); //lewe podzapytanie
		IAbstractQueryResult left = this.qres.pop();		
		for(IAbstractQueryResult el: this.checkIfIterableResult(left)){
			ISingleResult el_ = this.checkIfSingleResult(el);
			this.envs.push(this.envs.nested(el, this.store));
			expr.getRightExpression().accept(this);
			for(IAbstractQueryResult e2: this.checkIfIterableResult(this.qres.pop())){
				StructResult structEl = new StructResult();
				structEl.addElements(this.checkIfIterableResult(el_));
				structEl.addElements(this.checkIfIterableResult(e2));
				eres_join.addElements(structEl);
			}
			this.envs.pop();
		}		
		qres.push(eres_join);
		//System.out.println(eres_join);
		ArrayList<StructResult> arrayOfStructsForSort = new ArrayList( this.checkIfIterableResult(qres.pop()) );
		
		Collections.sort(arrayOfStructsForSort, new Comparator<StructResult>() {
			@Override
			public int compare(StructResult o1, StructResult o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2,store); //StructResult dziedziczy po Comparable
			}
	    });
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//		for (StructResult element: structForSort) {
//			System.out.println( element.print(store));
//		}
		BagResult eres_order_by = new BagResult();
		for (StructResult element: arrayOfStructsForSort) {
			eres_order_by.addElements(element.getElement(0));
		}
		qres.push(SingleBagRemove(eres_order_by)); 
	}

	@Override
	public void visitOrExpression(IOrExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("OrExpression: Non single result"); }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if (parseBool(left) instanceof IBooleanResult && parseBool(right) instanceof IBooleanResult ) //dwa bool
			qres.push ( new BooleanResult( ((BooleanResult)left).getValue() || ((BooleanResult)right).getValue()) );
		else throw new RuntimeException("OrExpression: InvalidArguments");
	}

	@Override
	public void visitPlusExpression(IPlusExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("PlusExpression: Non single result");  }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if(left instanceof IStringResult || right instanceof IStringResult ) //jeden string
			qres.push( new StringResult( ((ISimpleResult)left).getValue().toString() + ((ISimpleResult)right).getValue().toString() ) );
		else if (left instanceof IDoubleResult || right instanceof IDoubleResult ) //przynajmniej jeden double
			qres.push( new DoubleResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() + ((Number)((ISimpleResult)right).getValue()).doubleValue() ) );
		else if (left instanceof IIntegerResult && right instanceof IIntegerResult ) //dwa int
			qres.push ( new IntegerResult( ((IntegerResult)left).getValue() + ((IntegerResult)right).getValue()) );
		else throw new RuntimeException("PlusExpression: InvalidArguments");
		
	}

	@Override
	public void visitUnionExpression(IUnionExpression expr) {
		// TODO Auto-generated method stub
		BagResult eres = new BagResult(); //nowy bag na wynik
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
			
		eres.addElements(this.getListOfSingleResults(this.qres.pop()));
		eres.addElements(this.getListOfSingleResults(this.qres.pop()));

		qres.push(SingleBagRemove(eres));
	}

	@Override
	public void visitXORExpression(IXORExpression expr) {
		// TODO Auto-generated method stub
		expr.getLeftExpression().accept(this);
		expr.getRightExpression().accept(this);
		IAbstractQueryResult right = this.qres.pop();
		IAbstractQueryResult left = this.qres.pop();
		try { 
			right = this.checkIfSingleResult(right);
			left = this.checkIfSingleResult(left);
		} catch (Exception e) { System.out.println("XORExpression: Non single result"); }
		right = this.checkIfReferenceResult(right, (SBAStore) store);
		left = this.checkIfReferenceResult(left, (SBAStore) store);
		
		if (parseBool(left) instanceof IBooleanResult && parseBool(right) instanceof IBooleanResult ) //dwa bool
			qres.push ( new BooleanResult( (! ((BooleanResult)left).getValue() == ((BooleanResult)right).getValue() )) );
		else throw new RuntimeException("XORExpression: InvalidArguments");
	}

	@Override
	public void visitBooleanTerminal(IBooleanTerminal expr) {
		// TODO Auto-generated method stub
		  Boolean value = expr.getValue();
          qres.push(new BooleanResult(value));
	}

	@Override
	public void visitDoubleTerminal(IDoubleTerminal expr) {
		// TODO Auto-generated method stub
		 Double value = expr.getValue();
         qres.push(new DoubleResult(value));
	}

	@Override
	public void visitIntegerTerminal(IIntegerTerminal expr) {
		// TODO Auto-generated method stub
		  Integer value = expr.getValue();
          qres.push(new IntegerResult(value));
	}

	@Override
	public void visitNameTerminal(INameTerminal expr) {
		// TODO Auto-generated method stub
		qres.push(this.envs.bind(expr.getName()));
	}

	@Override
	public void visitStringTerminal(IStringTerminal expr) {
		// TODO Auto-generated method stub
		 String value = expr.getValue();
         qres.push(new StringResult(value));
	}

	@Override
	public void visitBagExpression(IBagExpression expr) {
		// TODO Auto-generated method stub
		BagResult eres = new BagResult(); //nowy bag na wynik
		expr.getInnerExpression().accept(this);
		IAbstractQueryResult inner = this.qres.pop();
		//System.out.println(inner);
		
		for(ISingleResult el: this.checkIfIterableResult(inner)){
			eres.addElements(el);
		}
		//System.out.println(eres);
		//eres = (BagResult) convertBagOfSingle(eres);
		qres.push(eres);
	}

	@Override
	public void visitCountExpression(ICountExpression expr) {
		// TODO Auto-generated method stub
		expr.getInnerExpression().accept(this);
		qres.push( new IntegerResult (this.getListOfSingleResults(this.qres.pop()).size() ));
	}

	@Override
	public void visitExistsExpression(IExistsExpression expr) {
		// TODO Auto-generated method stub
		expr.getInnerExpression().accept(this);
		if(this.checkIfIterableResult(this.qres.pop()).size() > 0 ){
			qres.push(new BooleanResult(true));
		}
		else qres.push(new BooleanResult(false));
	}

	@Override
	public void visitMaxExpression(IMaxExpression expr) {
		// TODO Auto-generated method stub
		expr.getInnerExpression().accept(this);
		IAbstractQueryResult inner = this.qres.pop();
		
		double maxValue = Double.MIN_VALUE;
		for(IAbstractQueryResult eresEl: this.checkIfIterableResult(inner)){			
			IAbstractQueryResult eresEl_ = this.checkIfReferenceResult(eresEl, (SBAStore) store);
			if(this.checkIfNumber(eresEl_)){
				if( ((Number)((ISimpleResult)eresEl_).getValue()).doubleValue() > maxValue )
					maxValue = ((Number)((ISimpleResult)eresEl_).getValue()).doubleValue();
			}
		}
		if( maxValue  % 1 == 0   )
			qres.push(new IntegerResult( (int)maxValue));
		else qres.push(new DoubleResult( maxValue));
	}

	@Override
	public void visitMinExpression(IMinExpression expr) {
		// TODO Auto-generated method stub
		expr.getInnerExpression().accept(this);
		IAbstractQueryResult inner = this.qres.pop();
		
		double minValue = Double.MAX_VALUE;
		for(IAbstractQueryResult eresEl: this.checkIfIterableResult(inner)){			
			IAbstractQueryResult eresEl_ = this.checkIfReferenceResult(eresEl, (SBAStore) store);
			if(this.checkIfNumber(eresEl_)){
				if( ((Number)((ISimpleResult)eresEl_).getValue()).doubleValue() < minValue )
					minValue = ((Number)((ISimpleResult)eresEl_).getValue()).doubleValue();
			}
		}
		if( minValue  % 1 == 0   )
			qres.push(new IntegerResult( (int)minValue));
		else qres.push(new DoubleResult( minValue));
	}

	@Override
	public void visitNotExpression(INotExpression expr) {
		// TODO Auto-generated method stub
				expr.getInnerExpression().accept(this);
				IAbstractQueryResult inner = this.qres.pop();
				try { 
					inner = this.checkIfSingleResult(inner);
				} catch (Exception e) { System.out.println("NotExpression: Non single result");  }
				inner = this.checkIfReferenceResult(inner, (SBAStore) store);
			
				if(parseBool(inner) instanceof IBooleanResult) 
					qres.push( new BooleanResult( !(((IBooleanResult)inner).getValue()) ) );
				else throw new RuntimeException("NotExpression: InvalidArguments");
	}

	@Override
	public void visitStructExpression(IStructExpression expr) {
		// TODO Auto-generated method stub
		BagResult eres = new BagResult(); //nowy bag na wynik
		expr.getInnerExpression().accept(this);
		IAbstractQueryResult inner = this.qres.pop();
		//System.out.println(inner);
		for(IAbstractQueryResult el: this.checkIfIterableResult(inner)){
			eres.addElements(el);
		}		
		qres.push(SingleBagRemove(eres));
	}

	@Override
	public void visitSumExpression(ISumExpression expr) {
		// TODO Auto-generated method stub
		double res = 0.0;
		expr.getInnerExpression().accept(this);
		IAbstractQueryResult inner = this.qres.pop();
		
		System.out.println(inner);
		for(IAbstractQueryResult eresEl: this.checkIfIterableResult(inner)){
			//System.out.println(eresEl);
			IAbstractQueryResult eresEl_ = this.checkIfReferenceResult(eresEl, (SBAStore) store);
			//System.out.println(eresEl.getClass());
			if(this.checkIfNumber(eresEl_)){
				if(eresEl_ instanceof DoubleResult)	
					res += ((DoubleResult)eresEl_).getValue();
				else if(eresEl_ instanceof IntegerResult)
					res += ((IntegerResult)eresEl_).getValue();
			}
		}
		if( res  % 1 == 0 )
			qres.push(new IntegerResult( (int) (res) ));
		else qres.push(new DoubleResult(res));
	}

	@Override
	public void visitUniqueExpression(IUniqueExpression expr) {
		// TODO Auto-generated method stub
		BagResult eres = new BagResult(); //nowy bag na wynik
		expr.getInnerExpression().accept(this);
		IAbstractQueryResult inner = this.qres.pop();
		
		ArrayList<ISingleResult> inner_ = this.getListOfSingleResults(inner);
		ArrayList<ISingleResult> resList = new ArrayList<ISingleResult>();
				
		for (ISingleResult el : inner_) {
			Boolean flag = true;
			for(int i=0;i<resList.size();i++){
				if(((ISingleResult)(resList.get(i))).equals(el)) flag = false;
			}
			if(flag)resList.add(el);
		}
		eres.addElements(resList);
		qres.push(eres);
	}

	@Override
	public void visitAvgExpression(IAvgExpression expr) {
		// TODO Auto-generated method stub
		double avg = 0.0;
		int i = 0;
		expr.getInnerExpression().accept(this);
		IAbstractQueryResult inner = this.qres.pop();

		for(IAbstractQueryResult eresEl: this.checkIfIterableResult(inner)){
			IAbstractQueryResult eresEl_ = this.checkIfReferenceResult(eresEl, (SBAStore) store);
			if(this.checkIfNumber(eresEl_)){
				avg += (((Number)((ISimpleResult)eresEl_).getValue()).doubleValue());
				i++;
			}
			else throw new RuntimeException("AvgExpression: InvalidArguments");
		}
		if( (avg/i)  % 1 == 0 )
			qres.push(new IntegerResult( (int) (avg/i) ));
		else qres.push(new DoubleResult(avg/i));
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
