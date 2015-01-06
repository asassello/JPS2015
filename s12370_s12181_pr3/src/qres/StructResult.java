package qres;

import java.util.List;

import edu.pjwstk.jps.result.ISingleResult;
import edu.pjwstk.jps.result.IStructResult;

public class StructResult  extends SingleResult implements IStructResult {
	
List<ISingleResult> list;
	
    public StructResult(List<ISingleResult> list) {
        this.list = list;
}
	
    public void addElements(List<ISingleResult> elements)
    {
             
            this.list.addAll(elements);
    }
    
    public List<ISingleResult> getElements(){
    	return list;
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

}
