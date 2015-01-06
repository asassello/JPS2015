package datastore;

import java.util.ArrayList;
import java.util.List;

import edu.pjwstk.jps.datastore.IComplexObject;
import edu.pjwstk.jps.datastore.IOID;

public class ComplexObject extends SBAObject implements IComplexObject {
    private List<IOID> childOIDs = new ArrayList<>();
    
    public ComplexObject(IOID oid, String name, List<IOID> OIDs) {
            super(oid, name);
            childOIDs = OIDs;
            
    }
    @Override
    public List<IOID> getChildOIDs() {
            // TODO Auto-generated method stub
            return childOIDs;
    }
    
    
}