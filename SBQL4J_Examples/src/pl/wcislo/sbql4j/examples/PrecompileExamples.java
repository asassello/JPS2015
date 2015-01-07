package pl.wcislo.sbql4j.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import pl.wcislo.sbql4j.java.preprocessor.PreprocessorRun;
import pl.wcislo.sbql4j.lang.codegen.CodeGeneratorFactory.CodeGenType;
import pl.wcislo.sbql4j.lang.db4o.codegen.CodeGeneratorDb4oFactory.CodeGenTypeDB4O;

public class PrecompileExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String baseDir = "E:\\Java\\workspaces\\mgr\\SBQL4JTests\\";
		String baseDir = ".\\"; 
	    File destDir = new File(baseDir + "dist"); 
	    if(destDir.isDirectory()) {
	    	try {
				FileUtils.deleteDirectory(destDir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    File[] s4jFiles = new File[] {
//	    	new File(baseDir + "currentTest\\pl\\wcislo\\sbql4j\\javac\\test\\linq_comp\\OrderByTest.s4j")
//	    	new File(baseDir + "currentTest\\pl\\wcislo\\sbql4j\\javac\\test\\linq_comp\\SimpleCodeGeneratorTest.s4j")
    		
//	    	new File(baseDir + "src\\pl\\wcislo\\sbql4j\\examples\\java_heap\\linq\\LinqQueriesJavaHeap.s4j"),
//    		new File(baseDir + "src\\pl\\wcislo\\sbql4j\\examples\\db4o\\LinqQueriesDb4o.s4j"),
    		new File(baseDir + "src\\pl\\wcislo\\sbql4j\\examples\\db4o\\Db4oEmpTest.s4j"),
//	    	new File(baseDir + "src\\pl\\wcislo\\sbql4j\\examples\\java_heap\\advanced\\AdvancedQueriesJavaHeap.s4j"),
//	    	new File(baseDir + "src\\pl\\wcislo\\sbql4j\\examples\\db4o\\advanced\\AdvancedQueriesDb4o.s4j"),
//	    	new File(baseDir + "src\\pl\\wcislo\\sbql4j\\examples\\xml\\XMLExamples.s4j")
	    };  
//	    System.out.println("!!!CLASSPATH: "+System.getProperty("java.class.path"));
//	    String classpath = baseDir + "bin;"+ baseDir + "config;"+baseDir+"lib\\sbql4j_test.jar;";
	    String classpath = System.getProperty("java.class.path");
	    CodeGenType cgt = CodeGenType.NO_STACKS;
	    boolean optimiseDeadQueries = false;
	    boolean optimiseIndependentQueries = false;
	    PreprocessorRun.run(destDir, s4jFiles, classpath, cgt, CodeGenTypeDB4O.NO_STACKS, optimiseDeadQueries, optimiseIndependentQueries);
	}
}
