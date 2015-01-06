package datastore;

import edu.pjwstk.jps.datastore.IOID;

public class OID implements IOID {

	private static final long serialVersionUID = 1L;
	private Integer value;
	    
	    public OID(Integer value) {
	        value = this.value;
	    }
	        
	        public Integer GetValue() {
	                return value;
	        }

}
