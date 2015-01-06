package datastore;

import edu.pjwstk.jps.datastore.IDoubleObject;
import edu.pjwstk.jps.datastore.IOID;

public class DoubleObject extends SimpleObject<Double> implements IDoubleObject {

	 public DoubleObject(IOID oid, String name, Double value) {
         super(oid, name, value);
         // TODO Auto-generated constructor stub
	 }


}
