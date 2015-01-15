package envs;

import java.util.Collection;

import datastore.SBAStore;
import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.IReferenceResult;
import edu.pjwstk.jps.result.ISingleResult;
import qres.*;

public class EnvsTest {

	@SuppressWarnings("unchecked")
	public static void PR4_q1() throws Exception{
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
				
				if(!(((BooleanResult)eresLeftRightRight_).getValue().equals(true) || ((BooleanResult)eresLeftRightRight_).getValue().equals(false))) throw new RuntimeException("Non Comparable");				
				BooleanResult eresLeftRight = new BooleanResult( ((BooleanResult)eresLeftRightRight_).getValue().equals(true) ); //porownaj
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
		
	public static void PR4_q2(){
		//((emp where exists address) where address.number>20).(street, city)
	}
	
}
