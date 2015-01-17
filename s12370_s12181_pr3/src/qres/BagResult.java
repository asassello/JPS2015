package qres;

import java.util.ArrayList;
import java.util.Collection;







import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.ICollectionResult;
import edu.pjwstk.jps.result.IReferenceResult;
import edu.pjwstk.jps.result.ISingleResult;

public class BagResult extends CollectionResult implements IBagResult {

	Collection<ISingleResult> collection;
	private ArrayList<ISingleResult> arrayList;
	
    public BagResult(Collection<ISingleResult> collection) {
        this.collection = collection;
}
	
	public BagResult() {
		// TODO Auto-generated constructor stub
		super();
		collection = new ArrayList<ISingleResult>();
	}

	@Override
	public Collection<ISingleResult> getElements() {
		return collection;
	}
	
	public ISingleResult getElement(int value) {

		ArrayList<ISingleResult> myArr = new ArrayList<ISingleResult>(collection);
		return myArr.get(value);
	}
	
    public void addElements(Collection<ISingleResult> elements)
    {    
            this.collection.addAll(elements);
    }
    
    public void addElements(IBagResult elements)
    {    

    	for(ISingleResult single: elements.getElements())
            this.collection.add(single);
    }
    
    public void addElements(ISingleResult element)
    {

        if(element instanceof ISingleResult) {
                this.collection.add((ISingleResult) element);
        }
        else if(element instanceof IBagResult) {

        this.arrayList.addAll(((IBagResult) element).getElements());
        this.collection = arrayList;
        }
    }
    
    public void addElements(IReferenceResult element)
    {        	
    	if(element instanceof IReferenceResult) {
            this.collection.add(element);
    	}
    }
    	
    public void addElements(IAbstractQueryResult element){	
    	
    	if(element instanceof IReferenceResult) {
            this.collection.add((ISingleResult) element);
    	}
    	if(element instanceof ISingleResult) {
            this.collection.add((ISingleResult) element);
	    }
	    else if(element instanceof IBagResult) {
	
	    this.arrayList.addAll(((IBagResult) element).getElements());
	    this.collection = arrayList;
	    }
	    else if(element instanceof ICollectionResult) {
	    	this.collection.addAll((Collection<? extends ISingleResult>) element);
	    }
	    else throw new RuntimeException("Unable to add element to result!");
    	
    }
	
    public String toString() {
    	return "bag(" + collection + ")";
    }

}
