package datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISimpleObject;

public class SimpleObject<T> extends SBAObject implements ISimpleObject<T> {

    private T value;

	 public SimpleObject(IOID oid, String name, T value) {
		  super(oid, name);
          this.value = value;
          // TODO Auto-generated constructor stub
	}
	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
