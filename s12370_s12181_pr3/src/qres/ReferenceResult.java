package qres;

import datastore.OID;
import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IReferenceResult;

public class ReferenceResult extends SingleResult implements IReferenceResult {

	
	private OID refSBAObjectId;
	private String name;
	
	@Override
	public IOID getOIDValue() {
		// TODO Auto-generated method stub
		return refSBAObjectId;
	}
	
	public ReferenceResult(OID refSBAObjectId) {
		super();
		this.refSBAObjectId = refSBAObjectId;
	}

}
