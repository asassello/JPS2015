package qres;

import java.util.ArrayList;
import java.util.List;

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

	public int compareTo(StructResult o) {
		// TODO Auto-generated method stub
		int result = 0; //jeœli równe
		for(int i = 1; i<((List<ISingleResult>) o).size(); i++)
		{
			result = ((StructResult) list.get(i)).compareTo(o.list.get(i));
			if(result != 0) //jeœli nierówne
				return result;
		}
		return result;
	}

}
