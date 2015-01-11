package datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISimpleObject;

public class SimpleObject<T> extends SBAObject implements ISimpleObject<T> {

    private T value;
    private String name;
    private IOID oid;

	 public SimpleObject(IOID oid, String name, T value) {
		  super(oid, name);
          this.value = value;
          this.name = name;
          this.oid = oid;
          // TODO Auto-generated constructor stub
	}
	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
    public String getName() {
        // TODO Auto-generated method stub
        return name;
   }
    
    public IOID getOID() {
        // TODO Auto-generated method stub
        return oid;
   }

}
