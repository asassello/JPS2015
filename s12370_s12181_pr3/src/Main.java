


import datastore.SBAStore;
import edu.pjwstk.jps.datastore.ISBAObject;




public class Main {
	
	public static void main(String[] args){
			
		SBAStore store = new SBAStore(); 
		store.loadXML(".\\data\\dane.xml");
		System.out.println("\nWywolanie PrintObject:\n");
		store.PrintObject(store.retrieve(store.getEntryOID()));
		System.out.println("\nWywolanie PrintSBAObjects:\n");
		System.out.println(store);
		
	}

}
