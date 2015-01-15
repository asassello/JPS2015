package qres;

import java.util.ArrayList;
import java.util.Collection;





import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IBagResult;
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
    
    public void addElements(ISingleResult elements)
    {
        if(elements instanceof ISingleResult) {
                this.arrayList.add((ISingleResult) elements);
                this.collection = arrayList;
        } else if(elements instanceof IBagResult) {
                this.arrayList.addAll(((IBagResult) elements).getElements());
                this.collection = arrayList;
        }
    }
	
    public String toString() {
    	return "bag(" + collection + ")";
    }

}
