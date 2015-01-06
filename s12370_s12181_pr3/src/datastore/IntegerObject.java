package datastore;

import edu.pjwstk.jps.datastore.IIntegerObject;
import edu.pjwstk.jps.datastore.IOID;

public class IntegerObject extends SimpleObject<Integer> implements IIntegerObject {

	public IntegerObject(IOID oid, String name, Integer value) {
        super(oid, name, value);
        // TODO Auto-generated constructor stub
	}
	
	

}
