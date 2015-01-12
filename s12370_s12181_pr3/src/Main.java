


import datastore.SBAStore;




public class Main {
	
	public static void main(String[] args){
			
		SBAStore store = new SBAStore(); 
		
		store.loadXML(".\\data\\dane.xml");
		System.out.println("\nWywolanie PrintObjects:\n");
		//store.PrintObjects();
		
		
		
	}

}
