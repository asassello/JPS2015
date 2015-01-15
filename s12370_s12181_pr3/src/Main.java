import datastore.SBAStore;
import envs.EnvsTest;

public class Main {
	
	public static void main(String[] args) throws Exception{
			
		//PR3();
		PR4();
	}
	
	public static void PR3(){
		
		SBAStore store = new SBAStore(); 
		//store.loadXML(".\\data\\dane.xml");
		//store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		store.loadXML(".\\data\\jps_envs_test.xml");
		System.out.println("\nPR3:");
		System.out.println("Wywolanie PrintStore:\n");
		store.PrintObject(store.retrieve(store.getEntryOID()));
		System.out.println("\nWywolanie PrintSBAObjects:\n");
		//System.out.println(store);
	}
	
	public static void PR4() throws Exception{

		EnvsTest tester = new EnvsTest();
		tester.PR4_q1();
		//tester.PR4_q2();		
	}

}
