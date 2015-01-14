package envs;

import java.util.ArrayList;
import java.util.Collection;

import qres.BagResult;
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
		this.frameElements = aFrameElements;
	}

	public Frame() {
		super();
		this.frameElements = new ArrayList<IENVSBinder>();
	}
	
	public Boolean checkFrameForBinder(String pattern){
		for(IENVSBinder singleBinder: frameElements){
			return singleBinder.getName().contains(pattern);
		}
		return false;
	}

	public IBagResult returnBagOfBindersFromFrame(String pattern){
		
		BagResult tmp = new BagResult(); 
		for(IENVSBinder singleBinder: frameElements){
			if(singleBinder.getName().contains(pattern)){
				tmp.addElements((Collection<ISingleResult>) singleBinder);
			}
		}
		return tmp;
	}

	public String toString(IENVSFrame frame, int i) {
		// TODO Auto-generated method stub
		String drukuj = new String();
		
		drukuj += "------Ramka: " + i + "-------\n";
		for(IENVSBinder binder: this.frameElements){
			drukuj += ((Binder) binder).toString(binder);
		}
		drukuj = drukuj.substring(0, drukuj.length()-2);
		//drukuj += "\n---Ramka: " + i + " koniec---\n";
		
		return drukuj;
	}
	
	
}
