package datastore;

import java.util.ArrayList;
import java.util.List;

import edu.pjwstk.jps.datastore.IComplexObject;
import edu.pjwstk.jps.datastore.IOID;

public class ComplexObject extends SBAObject implements IComplexObject {
    
	//private List<IOID> childOIDs = new ArrayList<IOID>();
	private List<IOID> childOIDs = new ArrayList<IOID>();
    
    public ComplexObject(IOID oid, String name, List<IOID> OIDs) {
            super(oid, name);
            childOIDs = OIDs;
           
    }
    @Override
    public List<IOID> getChildOIDs() {
            // TODO Auto-generated method stub
            return childOIDs;
    }
    
    //experimentall
	@Override
//	public String toString() {
//		return "ComplexObject [name=" + super.getName() + ", o=" + super.getOID().toString() + "]";
//	}
	
	public String toString() {
		return "ComplexObject [name=" + super.getName() + ", o=" + super.getOID().toString() + ", childOIDs=" + childOIDs + "]\n";
	}
    
}