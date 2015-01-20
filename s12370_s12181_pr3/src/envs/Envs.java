package envs;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import qres.BagResult;
import qres.ReferenceResult;
import qres.SimpleResult;
import datastore.ComplexObject;
import datastore.OID;
import edu.pjwstk.jps.datastore.IComplexObject;
import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;
import edu.pjwstk.jps.datastore.ISimpleObject;
import edu.pjwstk.jps.interpreter.envs.IENVS;
import edu.pjwstk.jps.interpreter.envs.IENVSFrame;
import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.IBinderResult;
import edu.pjwstk.jps.result.IReferenceResult;
import edu.pjwstk.jps.result.ISimpleResult;
import edu.pjwstk.jps.result.ISingleResult;
import edu.pjwstk.jps.result.IStructResult;

public class Envs implements IENVS{
	
	LinkedList<IENVSFrame> stosEnvs;
	
	public LinkedList<IENVSFrame> getStosEnvs() {
		return stosEnvs;
	}

	@Override
	public void init(IOID rootOID, ISBAStore store) {
		// TODO Auto-generated method stub
		ComplexObject rootOb = (ComplexObject)store.retrieve(rootOID);
		this.push(nested(new ReferenceResult((OID)(store.getEntryOID())),store));
	}
	
	public Envs(LinkedList<IENVSFrame> stosEnvs) {
		super();
		this.stosEnvs = stosEnvs;
	}
	
	public Envs() {
		super();
		this.stosEnvs = new LinkedList<IENVSFrame>();
	}	

	@Override
	public IENVSFrame pop() {
		// TODO Auto-generated method stub
		return stosEnvs.pop();
	}

	@Override
	public void push(IENVSFrame frame) {
		// TODO Auto-generated method stub
		stosEnvs.push(frame);
	}

	@Override
	public IBagResult bind(String name) {
		// TODO Auto-generated method stub
		Iterator<IENVSFrame> envsIter = stosEnvs.descendingIterator();
		BagResult bagOfBinders = new BagResult();
		//przegladajac kolejno ramki na stosie envs, szukamy takiej ktora ma element z etykieta jak ta ktora probujemy zbindowac 
		//i zwracamy bag wszystkich binderow z poszukiwanym name
		while( envsIter.hasNext() ){
			Frame tmp = (Frame)envsIter.next();
			if(tmp.checkFrameForBinder(name)) {
				//System.out.println("TU");
				bagOfBinders = (BagResult)tmp.returnBagOfBindersFromFrame(name);
				//System.out.println(bagOfBinders);
			}
		}
		return bagOfBinders;
	}

	@Override
	public IENVSFrame nested(IAbstractQueryResult result, ISBAStore store) {
		// TODO Auto-generated method stub
		IENVSFrame newNestedFrame = new Frame();

		//3 podstawowe przypadki: referncje(obiekt zlozony) / binder / struct
		if(result instanceof IReferenceResult){
			//System.out.println("test referenced");
			ISBAObject obFromStore = store.retrieve(((IReferenceResult) result).getOIDValue());
			//jesli zlozony: complex - wez wszystkie elementy zbinduj: i odeslij w ramce
			if(obFromStore instanceof IComplexObject){
				//System.out.println("test complex");
				for(IOID childOid: (((IComplexObject)obFromStore).getChildOIDs())){
					ISBAObject child = store.retrieve(childOid);
					((Frame)newNestedFrame).frameElements.add(new Binder(child.getName(),new ReferenceResult((OID) childOid)));
				}
			}
			else if(obFromStore instanceof ISimpleObject){
				//System.out.println("test simple");
				//jesli mamy obiekt prosty: zbinduj i odeslij w ramce
				((Frame)newNestedFrame).frameElements.add(new Binder(obFromStore.getName(),new SimpleResult(obFromStore.getOID())));
			}
		}
		else if(result instanceof IBinderResult){
			//System.out.println("test binder");
			//jesli mamy binder odeslij taki sam binder
			((Frame)newNestedFrame).frameElements.add(new Binder(((IBinderResult)result).getName(),((IBinderResult)result).getValue()));
			//TU JEST CHYBA ZLE
		}
//		else if(result instanceof IBinderResult){
//			//System.out.println("test binder");
//			//jesli mamy binder odeslij taki sam binder
//			((Frame)newNestedFrame).frameElements.add(new Binder(((Binder)result).name,((Binder)result).value));
//		}
		
		else if(result instanceof IStructResult){
			//System.out.println("test struct");
			//dla struktury nested na kazdym elemencie, a nastepnie bindery ze zwroconej ramki dodajemy do docelowej ramki
			for(ISingleResult structEl: ((IStructResult)result).elements()){
				IENVSFrame newFrameForStructEl = nested(structEl,store);
				((Frame)newNestedFrame).frameElements.addAll(newFrameForStructEl.getElements());
			}
		}
		//System.out.println(newNestedFrame);
		return newNestedFrame;
	}
	
	public String toString(){
		String drukujENVS = new String();
		int i = 0;
		
		drukujENVS += "\nStos ENVS:\n\n";
		for(IENVSFrame frame: stosEnvs){
			drukujENVS += ((Frame)frame).toString(frame,i) +"\n";
			i++;
		}
		drukujENVS += "\nKoniec stosu ENVS\n";
		return drukujENVS;
	}
	
	

}
