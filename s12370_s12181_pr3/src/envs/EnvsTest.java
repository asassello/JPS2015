package envs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IBagExpression;
import datastore.SBAStore;
import ast.terminal.*;
import ast.unary.*;
import ast.binary.*;
import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.IReferenceResult;
import edu.pjwstk.jps.result.ISimpleResult;
import edu.pjwstk.jps.result.ISingleResult;
import qres.*;

public class EnvsTest {

	@SuppressWarnings("unchecked")
	public void PR4_q1() throws Exception{
		//((emp where married) union (emp where lName==”Nowak")).fName
		
		QResStack qres = new QResStack();
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\jps_envs_test.xml");
		Envs stosSrod = new Envs();
		stosSrod.init(store.getEntryOID(), store);
		System.out.println("PR4:");
		
		BagResult eres = new BagResult();//sumaryczny wynik union 
		
		BagResult eresLeft = new BagResult(); 
		BagResult eresLeftLeft = (BagResult) stosSrod.bind("emp"); //lewa strona union: emp
		qres.push(eresLeftLeft);

		
		for(ISingleResult el1: ((IBagResult) qres.pop()).getElements()){ //dla kazdego prawego empa (prawa strona union)
			Frame tmpFr1 = (Frame)stosSrod.nested(el1, store);
			stosSrod.push(tmpFr1);
			
				BagResult eresLeftRightRight = (BagResult)stosSrod.bind("married"); // prawa strona where
				qres.push(eresLeftRightRight);
				
				//sprawdz czy single object
				IAbstractQueryResult eresLeftRightRight_ = Interpreter.checkIfSingleResult(qres.pop());
				//ReferenceResult otrzymujemy
				
				//sprawdz czy ktorys jest referencja
				eresLeftRightRight_ = Interpreter.checkIfReferenceResult(eresLeftRightRight_, store);

				//castujemy na wlasciwy wynik zeby moc pobrac wartosc do poronwania
				if(!(((BooleanResult)eresLeftRightRight_).getValue().equals(true) || ((BooleanResult)eresLeftRightRight_).getValue().equals(false))) throw new RuntimeException("Non Comparable");				
				BooleanResult eresLeftRight = new BooleanResult( ((BooleanResult)eresLeftRightRight_).getValue().equals(true) ); //porownaj wartosc z obiektem true
				qres.push(eresLeftRight);
				IAbstractQueryResult eresLeftRight_ = qres.pop();
				if(!(eresLeftRight_ instanceof BooleanResult)) throw new RuntimeException("Non logical value"); //czy wynik porownania bool
				if(((BooleanResult)eresLeftRight_).getValue().equals(true)) {
					eresLeft.addElements(el1); //jesli true dodaj emp do bag (wynik prawego zapytania)
				}
			stosSrod.pop();
		}
		System.out.println("\nWynik lewego podzapytania:");
		System.out.println(eresLeft + "\n");
		qres.push(eresLeft);
		
		
		//prawa strona union
		BagResult eresRight = new BagResult(); 
		BagResult eresRightLeft = (BagResult) stosSrod.bind("emp"); //prawa strona union: emp
		qres.push(eresRightLeft);
		
		for(ISingleResult el2: ((IBagResult)(qres.pop())).getElements()){ //dla kazdego prawego empa (prawa strona union)
			Frame tmpFr2 = (Frame)stosSrod.nested(el2, store);
			stosSrod.push(tmpFr2);
			
				BagResult eresRightRightLeft = (BagResult)stosSrod.bind("lName"); //lewa strona ==
				qres.push(eresRightRightLeft);
				
				IAbstractQueryResult eresRightRightRight = new StringResult("Nowak"); //prawa strona ==
				qres.push(eresRightRightRight);

				//sprawdz czy single object
				IAbstractQueryResult eresRightRightRight_ = Interpreter.checkIfSingleResult(qres.pop());
				IAbstractQueryResult eresRightRightLeft_ = Interpreter.checkIfSingleResult(qres.pop());
				
				//sprawdz czy ktorys jest referencja
				eresRightRightRight_ = Interpreter.checkIfReferenceResult(eresRightRightRight_, store);
				eresRightRightLeft_ = Interpreter.checkIfReferenceResult(eresRightRightLeft_, store);
				
				
				//sprawdz czy mozna porownywac	
				if(eresRightRightRight_.getClass() != eresRightRightLeft_.getClass()) throw new RuntimeException("Non Comparable");
				BooleanResult eresRightRight = new BooleanResult( (eresRightRightRight_.toString().equals(eresRightRightLeft_.toString())) ); //porownaj
				qres.push(eresRightRight);
				IAbstractQueryResult eresRightRight_ = qres.pop();
				if(!(eresRightRight_ instanceof BooleanResult)) throw new RuntimeException("Non logical value"); //czy wynik porownania bool
				if(((BooleanResult)eresRightRight_).getValue().equals(true)) {
					eresRight.addElements(el2); //jesli true dodaj emp do baga wynika prawego zapytania
				}
				stosSrod.pop();
		}
		System.out.println("\nWynik prawego podzapytania:");
		System.out.println(eresRight + "\n");
		qres.push(eresRight); 
		
		IAbstractQueryResult right = qres.pop();
		IAbstractQueryResult left = qres.pop();
		
		//dodajemy do ostatecznego wyniku
		eres.addElements((IBagResult)right);
		eres.addElements((IBagResult)left);
		
		qres.push(eres);
		
		System.out.println("\nWynik zapytania:");
		System.out.println(qres.pop()+ "\n");
		
		System.out.println(store.retrieve(((ReferenceResult)eres.getElement(0)).getOIDValue()));
		System.out.println(store.retrieve(((ReferenceResult)eres.getElement(1)).getOIDValue()));
		
//		System.out.println(stosSrod.toString());
//		System.out.println(stosSrod.getStosEnvs().size());
		
	}
		
	public void PR4_q2(){
		//((emp where exists address) where address.number>20).(street, city)
	}
	
	public void PR_test(){
		
//		IntegerResult left = new IntegerResult(1);
//		DoubleResult right = new DoubleResult(2.5);
//		SimpleResult res = new DoubleResult( ((Number)((ISimpleResult)left).getValue()).doubleValue() + ((Number)((ISimpleResult)right).getValue()).doubleValue() );
//		System.out.println(res);
		
//		StringResult left = new StringResult("test");
//		StringResult right = new StringResult("test");
//		BooleanResult res = new BooleanResult( ((ISimpleResult)left).getValue().toString().equals(((ISimpleResult)right).getValue().toString()) );
//		System.out.println(res);
		
//		BooleanResult left = new BooleanResult(false);
//		BooleanResult right = new BooleanResult(true);
//		BooleanResult res = new BooleanResult( ((BooleanResult)left).getValue() == ((BooleanResult)right).getValue()) ;
//		System.out.println(res);
	}
	
	public void test_string(){
		
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new ExistsExpression(
						new StringTerminal("a"))
				);
		System.out.println(res);
	}
	
	public void testOrderByExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		CommaExpression comma = new CommaExpression(new NameTerminal("fName"),
				new NameTerminal("lName"));
		IAbstractQueryResult res = interpreter.eval(
				new OrderByExpression(
						new NameTerminal("emp"), comma)
				);
		System.out.println(res);
	}
	
	public void testExistsExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new ExistsExpression(
						new StringTerminal("a"))
				);
		System.out.println(res);
	}
	
	public void testDotExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new DotExpression(
						new StringTerminal("emp"), new StringTerminal("fName"))
				);
//		System.out.println(res);
//		System.out.println(((BagResult)res).getElement(0).getClass());
		
		IAbstractQueryResult res2 = interpreter.eval(
				new DotExpression(
						new NameTerminal("emp"), new NameTerminal("fName"))
				);
		System.out.println(res2);
	}
	
	public void testEqualsExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new EqualsExpression(
						new IntegerTerminal(10), new DoubleTerminal(10.0))
				);
		System.out.println(res);
		
		IAbstractQueryResult res2 = interpreter.eval(
				new EqualsExpression(new IntegerTerminal(10),
						new BagExpression(new IntegerTerminal(10)))
				);
		System.out.println(res2);
		
		IAbstractQueryResult res3 = interpreter.eval(
				new EqualsExpression(new IntegerTerminal(
						10), new BagExpression(new CommaExpression(
						new IntegerTerminal(10), new IntegerTerminal(10))))
				);
		System.out.println(res3);
	}
	
	public void testWhereExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IBagExpression bag = new BagExpression(
								new IntegerTerminal(4));
		IAbstractQueryResult res = interpreter.eval(
				new WhereExpression(bag,
						new EqualsExpression(new IntegerTerminal(1),
								new IntegerTerminal(1)))
				);
		System.out.println(res);
	}
	
	public void testSumExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new SumExpression(new CommaExpression(
						new DoubleTerminal(1.0), new CommaExpression(
								new IntegerTerminal(2), new CommaExpression(
										new DoubleTerminal(-3.0),
										new IntegerTerminal(4)))))
				);
		System.out.println(res);
	}
	
	public void testMinExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new MinExpression(new CommaExpression(
						new DoubleTerminal(1.0), new CommaExpression(
								new IntegerTerminal(2), new CommaExpression(
										new DoubleTerminal(-3.0),
										new IntegerTerminal(4)))))
				);
		System.out.println(res);
	}
	
	public void testMaxExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new MaxExpression(new CommaExpression(
						new DoubleTerminal(1.0), new CommaExpression(
								new IntegerTerminal(2), new CommaExpression(
										new DoubleTerminal(-3.0),
										new IntegerTerminal(6)))))
				);
		System.out.println(res);
	}
	
	public void testNotExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new NotExpression(new BooleanTerminal(false))
				);
		System.out.println(res);
	}
	
	public void testUniqueExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new UniqueExpression(new BagExpression(new CommaExpression(
						new IntegerTerminal(2),
						new CommaExpression(new StructExpression(new CommaExpression(
								new IntegerTerminal(1), new IntegerTerminal(1))),

						new CommaExpression(new StructExpression(new CommaExpression(
								new IntegerTerminal(221), new IntegerTerminal(1221))),
								new IntegerTerminal(1))))))
				);
		System.out.println(res);
	}
	
	public void testCountExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new CountExpression(new BagExpression(new CommaExpression(
						new IntegerTerminal(1),
						new CommaExpression(new IntegerTerminal(2),
								new CommaExpression(new IntegerTerminal(3),
										new IntegerTerminal(4))))))
				);
		System.out.println(res);
	}
	
	public void testJoinExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new JoinExpression(new BagExpression(new CommaExpression(
						new IntegerTerminal(1), new IntegerTerminal(2))),
						new BagExpression(new CommaExpression(
								new StringTerminal("a"), new StringTerminal("b"))))
				);
		System.out.println(res);
	}
	
	public void testSelectExpression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
		IAbstractQueryResult res = interpreter.eval(
				new DotExpression(new UnionExpression(new WhereExpression(new NameTerminal("emp"),
						new NameTerminal("married")), new WhereExpression(new NameTerminal("emp"),
								new EqualsExpression(new NameTerminal("lName"),
										new StringTerminal("Nowak")))), new NameTerminal(
						"fName"))
				);
//		System.out.println(res);
		System.out.println(((BagResult)res).printBagOfReferenced(store));

	}
	
	public void testWhere2Expression() {
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		//System.out.println(store);
		Interpreter interpreter = new Interpreter(store);
//		IAbstractQueryResult res = interpreter.eval(
//				new WhereExpression(new NameTerminal("emp"),
//						new EqualsExpression(new NameTerminal("lName"),
//								new StringTerminal("Nowak")))
//				);
		IAbstractQueryResult res = interpreter.eval(
				new WhereExpression(new NameTerminal("emp"),
						new NameTerminal("married"))
				);
		System.out.println(res);
	}
}