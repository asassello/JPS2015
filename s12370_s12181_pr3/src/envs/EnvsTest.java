package envs;

import datastore.SBAStore;
import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IReferenceResult;
import edu.pjwstk.jps.result.ISingleResult;
import qres.AbstractQueryResult;
import qres.BagResult;
import qres.QResStack;
import qres.ReferenceResult;
import qres.SingleResult;
import qres.StringResult;

public class EnvsTest {

	public static void PR4_q1(){
		//((emp where married) union (emp where lName==”Nowak")).fName
		
		QResStack qres = new QResStack();
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\jps_envs_test.xml");
		Envs stosSrod = new Envs();
		stosSrod.init(store.getEntryOID(), store);
		System.out.println("PR4:");

		BagResult eresRightLeft = (BagResult)stosSrod.bind("emp"); //prawa strona union: emp
		qres.push(eresRightLeft);
		eresRightLeft = (BagResult)qres.pop();
		
		for(ISingleResult el1: eresRightLeft.getElements()){ //dla kazdego prawego empa
			Frame tmpFr1 = (Frame)stosSrod.nested(el1, store);
			stosSrod.push(tmpFr1);
				BagResult eresRightRightLeft = (BagResult)stosSrod.bind("lName"); //lewa strona ==
				qres.push(eresRightRightLeft);
				IAbstractQueryResult eresRightRightRight = new StringResult("Nowak"); //prawa strona ==
				qres.push(eresRightRightRight);

				try{	//sprawdz czy arg to pojedyncze wartosci
					ISingleResult eresRightRightRight_ = getSingleResult(qres.pop());
					ISingleResult eresRightRightLeft_ = getSingleResult(qres.pop());
					} catch(Exception e){ e.getMessage(); }
				//sprawdz czy ktorys jest referencja
				if(true ){
				
				}
				
//				eresRightRightLeft = (BagResult)qres.pop();
//					for(ISingleResult el2: eresRightLeft.getElements()){
//						Frame tmpFr2 = (Frame)stosSrod.nested(el1, store);
//						stosSrod.push(tmpFr2);
//					}
				
				
			
			
			//eresRight.getElements().add(el);
		}
				
		System.out.println(stosSrod.toString());
		System.out.println(stosSrod.getStosEnvs().size());
		
	}
		
	public static void PR4_q2(){
		//((emp where exists address) where address.number>20).(street, city)
	}
	
}
