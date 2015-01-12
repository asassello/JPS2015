package datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISimpleObject;

public class SimpleObject<T> extends SBAObject implements ISimpleObject<T> {

    private T value;

	@Override
	public String toString() {
		return "<"+getOID()+", name=" + getName() + ", value=" + getValue() +">"+"\n";
	}

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
