package datastore;

import edu.pjwstk.jps.datastore.IOID;

public class OID implements IOID {

	//private static final long serialVersionUID = 1L;
	private Integer value;
	    
	    public OID(Integer param) {
	        value = param;
	    }
	        
	        public Integer GetValue() {
	                return value;
	        }
	        
	        //experimental
	        @Override
	        public String toString(){
	        	return String.valueOf(value);
	        }
	        
	        public int compareTo(OID other){
	            return value.compareTo(other.value);
	          }
}
