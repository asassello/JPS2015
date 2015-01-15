package qres;

import java.util.Collection;
import java.util.List;

import edu.pjwstk.jps.result.ICollectionResult;
import edu.pjwstk.jps.result.ISingleResult;

public class CollectionResult extends AbstractQueryResult implements ICollectionResult {
	
	public Collection<?> col ;
	
	
	@Override
	public String toString() {
		return "CollectionResult [col=" + col + "]";
	}
	public CollectionResult(){
		
	}
	public CollectionResult(Collection<?> col) {
		super();
		this.col = col;
	}
	
}
