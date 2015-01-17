package qres;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.pjwstk.jps.result.ISequenceResult;
import edu.pjwstk.jps.result.ISingleResult;

public class SequenceResult extends CollectionResult implements ISequenceResult {
	

	public List<ISingleResult> getElements() {
		// TODO Auto-generated method stub
		List<ISingleResult> tab = new ArrayList<ISingleResult>();
		for (int i = 0; i < col.size(); i++) {
			tab.add((ISingleResult) ((List<ISingleResult>) col).get(0));
		}
		return tab;
	}
	
	public SequenceResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SequenceResult(Collection<?> col) {
		super(col);
		// TODO Auto-generated constructor stub
	}
	
	public SequenceResult(List<?> col) {
		super(col);
		// TODO Auto-generated constructor stub
	}
	
	

}
