package datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.IStringObject;

public class StringObject extends SimpleObject<String> implements IStringObject {

	public StringObject(IOID oid, String name, String value) {
        super(oid, name, value);
        // TODO Auto-generated constructor stub
	}
	
	

}
