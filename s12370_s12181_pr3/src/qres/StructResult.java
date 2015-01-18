package qres;

import java.util.ArrayList;
import java.util.List;

import datastore.SimpleObject;
import edu.pjwstk.jps.datastore.ISBAStore;
import edu.pjwstk.jps.result.ISingleResult;
import edu.pjwstk.jps.result.IStructResult;

public class StructResult  extends SingleResult implements IStructResult, Comparable {
	
	List<ISingleResult> list;
	
    public StructResult(List<ISingleResult> list) {
        this.list = list;
    }
    
    public StructResult() {
        this.list = new ArrayList<ISingleResult>();
    }
	
    public void addElements(List<ISingleResult> elements)
    {
             
            this.list.addAll(elements);
    }
    
    public List<ISingleResult> getElements(){
    	return list;
    }
    
    public ISingleResult getElement(Integer i){
    	return list.get(i);
    }
    
    public void addElements(ISingleResult elements)
    {
             
            this.list.add(elements);
    }
	
	@Override
	public List<ISingleResult> elements() {
		// TODO Auto-generated method stub
		return list;
	}
	
	  public String toString() {

	    	return "struct(" + list + ")";
	    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareTo(StructResult o, ISBAStore store) {
		// TODO Auto-generated method stub
		int result = 0; //jeœli równe
		
		for(int i = 1; i <((StructResult)o).elements().size(); i++){

			result = ((SimpleObject)store.retrieve(((ReferenceResult)list.get(i)).getOIDValue())).compareTo(
					(SimpleObject)(store.retrieve(((ReferenceResult)o.list.get(i)).getOIDValue())));
			if(result != 0) //jeœli nierówne
				return result;
		}
		
		return result;
	}
	
	//order_by_structure printing (or join)
	public String print(ISBAStore store) {
	  
		String tmp = "struct(";
		for(ISingleResult el: this.getElements()){
			tmp += (store.retrieve(((ReferenceResult)el).getOIDValue())).toString() + ", ";
		}
		tmp = tmp.substring(0, tmp.length()-1);
		return tmp;
	}
}
