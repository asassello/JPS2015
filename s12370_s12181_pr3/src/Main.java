import datastore.SBAStore;
import envs.EnvsTest;

public class Main {
	
	public static void main(String[] args) throws Exception{
			
		//PR3();
		//PR4();
		FULL();
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
//		tester.PR4_q1();
//		tester.PR4_q2();
//		tester.PR_test();
//		tester.test_string();
//		tester.testOrderByExpression();
//		tester.testExistsExpression();
//		tester.testDotExpression();
//		tester.testEqualsExpression();
//		tester.testWhereExpression();
//		tester.testSumExpression();
//		testertestMinExpression();
//		tester.testMaxExpression();
//		tester.testNotExpression();
//		tester.testUniqueExpression();
//		tester.testCountExpression();
//		tester.testJoinExpression();
		tester.testSelectExpression();
//		tester.testWhere2Expression();
//		tester.testAnyExpression();
//		tester.testAnyExpression();
//		tester.testDivideExpression();
//		tester.testMultiplyExpression();
//		tester.testModuloExpression(); //nie ma
//		tester.testGraterOrEqualThanExpression();
//		tester.testGraterThanExpression();
//		tester.testNotEqualExpression();
//		tester.testOrExpression();
//		tester.testXORExpression();
//		tester.testAndExpression();
//		tester.testAsExpression();
//		tester.testGroupAsExpression();
	}

	public static void FULL() throws Exception{
		
	}
}
