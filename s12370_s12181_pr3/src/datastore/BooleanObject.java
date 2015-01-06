package datastore;

import edu.pjwstk.jps.datastore.IBooleanObject;
import edu.pjwstk.jps.datastore.IOID;

public class BooleanObject extends SimpleObject<Boolean> implements IBooleanObject {

	  public BooleanObject(IOID oid, String name, Boolean value) {
          super(oid, name, value);
          // TODO Auto-generated constructor stub
	}
	

}
