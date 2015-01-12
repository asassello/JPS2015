package datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;

public class SBAObject implements ISBAObject {

    private String name;
    private IOID oid;
    
	public SBAObject(IOID oid, String name) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.oid = oid;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public IOID getOID() {
		return oid;
	}
	
	@Override
	public String toString() {
		return "SbaObject [name=" + name + ", o=" + oid + "]";
	}


}
