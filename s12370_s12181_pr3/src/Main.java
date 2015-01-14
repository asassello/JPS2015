


import java.util.LinkedList;

import qres.QResStack;
import datastore.SBAStore;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.interpreter.envs.IENVSFrame;
import envs.*;
import ast.*;
import qres.*;

public class Main {
	
	public static void main(String[] args){
			
		SBAStore store = new SBAStore(); 
		//store.loadXML(".\\data\\dane.xml");
		store.loadXML(".\\data\\jps_envs_test.xml");
		//store.loadXML(".\\data\\dane_do_zap_testowych.xml");
		
		// PR3
		//PR3(store);
		
		//PR4
		PR4(store);
	}
	
	public static void PR3(SBAStore sklep){
		
		System.out.println("\nPR3:");
		System.out.println("Wywolanie PrintStore:\n");
		sklep.PrintObject(sklep.retrieve(sklep.getEntryOID()));
		System.out.println("\nWywolanie PrintSBAObjects:\n");
		//System.out.println(sklep);
	}
	
	public static void PR4(SBAStore sklep){
		
		Envs stosSrod = new Envs();
		System.out.println("PR4:");
		stosSrod.init(sklep.getEntryOID(), sklep);
		System.out.println("Wywolanie PrintStosEnvs:\n");
		System.out.println(stosSrod.toString());
		
		PR4_q1(stosSrod, sklep);
		//PR4_q2(stosSrod, sklep);
		
	}
	
	public static void PR4_q1(Envs stosSrod, SBAStore sklep){
		//((emp where married) union (emp where lName=”Nowak)).fName
		QResStack qres = new QResStack();
		qres.push(new );
		
	}
	
	public static void PR4_q2(Envs stosSrod, SBAStore sklep){
		//((emp where exists address) where address.number>20).(street, city)
	}

}
