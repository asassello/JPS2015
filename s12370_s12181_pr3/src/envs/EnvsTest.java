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
		BagResult eresLeftLeft = (BagResult)stosSrod.bind("emp"); //lewa strona union: emp
		qres.push(eresLeftLeft);
		eresLeftLeft = (BagResult)qres.pop();
		
		for(ISingleResult el1: eresLeftLeft.getElements()){ //dla kazdego prawego empa (prawa strona union)
			Frame tmpFr1 = (Frame)stosSrod.nested(el1, store);
			stosSrod.push(tmpFr1);
			
				BagResult eresLeftRightRight = (BagResult)stosSrod.bind("married"); // prawa strona where
				qres.push(eresLeftRightRight);
				
				//sprawdz czy single object
				IAbstractQueryResult eresLeftRightRight_ = Interpreter.checkIfSingleResult(qres.pop());
				//ReferenceResult otrzymujemy
				
				//sprawdz czy ktorys jest referencja
				eresLeftRightRight_ = Interpreter.checkIfReferenceResult(eresLeftRightRight_, store);
				// !!! nie wiem czemu z referenced object robi String (a nie Boolean)
				
				//sprawdz czy mozna porownywac (porownujemy ze Stringiem w takim razie)
				if(!(((StringResult)eresLeftRightRight_).getValue().equals("true") || ((StringResult)eresLeftRightRight_).getValue().equals("false"))) throw new RuntimeException("Non Comparable");
				BooleanResult eresLeftRight = new BooleanResult( (eresLeftRightRight_.toString().equals((new BooleanResult(true)).getClass().toString())) ); //porownaj
				qres.push(eresLeftRight);
				IAbstractQueryResult eresLeftRight_ = qres.pop();
				if(!(eresLeftRight_ instanceof BooleanResult)) throw new RuntimeException("Non logical value"); //czy wynik porownania bool
				if(eresLeftRight_.equals(true)) eresLeft.addElements(el1); //jesli true dodaj emp do baga wynika prawego zapytania
			stosSrod.pop();
		}
		qres.push(eresLeft);
		
		
		//prawa strona union
		BagResult eresRight = new BagResult(); 
		BagResult eresRightLeft = (BagResult)stosSrod.bind("emp"); //prawa strona union: emp
		qres.push(eresRightLeft);
		eresRightLeft = (BagResult)qres.pop();
		
		for(ISingleResult el1: eresRightLeft.getElements()){ //dla kazdego prawego empa (prawa strona union)
			Frame tmpFr2 = (Frame)stosSrod.nested(el1, store);
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
				if(eresRightRight_.equals(true)) eresRight.addElements(el1); //jesli true dodaj emp do baga wynika prawego zapytania
				stosSrod.pop();
		}
		qres.push(eresRight); 
		
		IAbstractQueryResult right = qres.pop();
		IAbstractQueryResult left = qres.pop();
		
		//dodajemy do ostatecznego wyniku
		eres.addElements((IBagResult)right);
		eres.addElements((IBagResult)left);
		//eres.getElements().add((ISingleResult) left);
		
		qres.push(eres);
		
		System.out.println(stosSrod.toString());
		System.out.println(stosSrod.getStosEnvs().size());
		
	}
		
	public static void PR4_q2(){
		//((emp where exists address) where address.number>20).(street, city)
	}
	
}
