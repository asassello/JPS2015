package qres;

import java.util.ArrayList;
import java.util.Collection;




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
	}

	@Override
	public Collection<ISingleResult> getElements() {
		return collection;
	}
	
	public ISingleResult getElement(int value) {
		//int counter = 0;
		//while(counter < value){ 
		//	collection.iterator().next();
		//	counter++;
		//}
		ArrayList<ISingleResult> myArr= new ArrayList<ISingleResult>(collection);
		
		return myArr.get(value);
	}
	
    public void addElements(Collection<ISingleResult> elements)
    {
             
            this.collection.addAll(elements);
    }
    
    public void addElements(ISingleResult elements)
    {
             
            //this.collection.add(elements);
            

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
