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

	public int compareTo(SimpleObject simpleObject) {
		// TODO Auto-generated method stub
		if (simpleObject.value instanceof String)
			return ((String)value).compareTo((String)simpleObject.value);
		if (simpleObject.value instanceof Integer)
			return ((Integer)value).compareTo((Integer)simpleObject.value);
		if (simpleObject.value instanceof Double)
			return ((Double)value).compareTo((Double)simpleObject.value);
		if (simpleObject.value instanceof Boolean)
			return ((Boolean)value).compareTo((Boolean)simpleObject.value);
		else return 0;
	}
	

}
