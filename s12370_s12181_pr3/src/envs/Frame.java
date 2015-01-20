package envs;

import java.util.ArrayList;
import java.util.Collection;

import qres.BagResult;
import qres.ReferenceResult;
import qres.SingleResult;
import edu.pjwstk.jps.interpreter.envs.IENVSBinder;
import edu.pjwstk.jps.interpreter.envs.IENVSFrame;
import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.ISingleResult;

public class Frame implements IENVSFrame {

	public Collection<IENVSBinder> frameElements;
	
	@Override
	public Collection<IENVSBinder> getElements() {
		// TODO Auto-generated method stub
		return frameElements;
	}

	public Frame(Collection<IENVSBinder> aFrameElements) {
		super();
		frameElements = new ArrayList<IENVSBinder>();
		this.frameElements = aFrameElements;
	}
	
	public Frame(IENVSBinder aFrameElement) {
		super();
		frameElements = new ArrayList<IENVSBinder>();
		frameElements.add(aFrameElement);
	}

	public Frame() {
		super();
		this.frameElements = new ArrayList<IENVSBinder>();
	}
	
	public Boolean checkFrameForBinder(String pattern){
		
		Boolean flag = false;
		for(IENVSBinder singleBinder: this.frameElements){
			if((Boolean)(singleBinder.getName().equals(pattern))){
				flag = true;
				break;
			}
			else flag = false;
		}
		return flag;
	}
	
	

	public IBagResult returnBagOfBindersFromFrame(String pattern){
		
		BagResult tmp = new BagResult();
		for(IENVSBinder singleBinder: this.frameElements){
			if(singleBinder.getName().equals(pattern)){
				//System.out.println("TU");
				tmp.getElements().add( (ISingleResult) singleBinder.getValue() );
			}
		}
		return tmp;
	}

	public String toString(IENVSFrame frame, int i) {
		// TODO Auto-generated method stub
		String drukujFrame = new String();
		
		drukujFrame += "------Ramka: " + i + "-------\n";
		for(IENVSBinder binder: ((Frame)frame).frameElements){
			drukujFrame += ((Binder) binder).toString(binder);
		}
		drukujFrame = drukujFrame.substring(0, drukujFrame.length()-2);
		//drukuj += "\n---Ramka: " + i + " koniec---\n";
		
		return drukujFrame;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		String drukujFrame = new String();
		
		drukujFrame += "-------Ramka-------\n";
		for(IENVSBinder binder: this.frameElements){
			drukujFrame += ((Binder) binder).toString(binder);
		}
		drukujFrame = drukujFrame.substring(0, drukujFrame.length()-2);
		//drukuj += "\n---Ramka: " + i + " koniec---\n";
		
		return drukujFrame;
	}
	
	
}
