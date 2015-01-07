package pl.wcislo.sbql4j.javac.test.db4o;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import com.db4o.*;

public class Db4oOperatorTest {
    private ObjectContainer dbConn;
    
    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        new Db4oOperatorTest();
    }
    
    public Db4oOperatorTest() {
        super();
        getConnection();
        prepareData();
    }
    
    public ObjectContainer getConnection() {
        if (dbConn == null) {
            dbConn = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "testOperators.db");
        }
        return dbConn;
    }
    
    private void prepareData() {
        ObjectContainer con = getConnection();
        List<Emp> empList = new ArrayList<Emp>();
        List<Emp.Book> b1List = new ArrayList<Emp.Book>();
        b1List.add(new Emp.Book("Juliusz S\u0142owacki", "Kordian"));
        empList.add(new Emp("s0000", "Anna", "Kowalska", new Emp.Address("al. Jerozolimskie", 50, "00-111", "Warszawa"), true, b1List));
        List<Emp.Book> b2List = new ArrayList<Emp.Book>();
        b2List.add(new Emp.Book("Adam Mickiewicz", "Pan Tadeusz"));
        b2List.add(new Emp.Book("Aleksander Dumas (syn)", "Dama kameliowa"));
        empList.add(new Emp("s0001", "Maciej", "Nowak", new Emp.Address("Koszykowa", 86, "00-222", "Warszawa"), true, b2List));
        LinqExampleData data = new LinqExampleData();
        ObjectSet<Emp> emp = con.query(Emp.class);
        if (emp.isEmpty()) {
            for (Emp e : empList) {
                con.store(e);
            }
        }
    }
    
    public Boolean testAll1() {
        ObjectContainer db = getConnection();
        Boolean res = new Db4oOperatorTest_SbqlQuery0(db).executeQuery();
        return res;
    }
    
    public Boolean testAll2() {
        ObjectContainer db = getConnection();
        Boolean res = new Db4oOperatorTest_SbqlQuery1(db).executeQuery();
        return res;
    }
    
    public Boolean testAnd1() {
        ObjectContainer db = getConnection();
        Boolean res = new Db4oOperatorTest_SbqlQuery2(db).executeQuery();
        return res;
    }
    
    public Boolean testAny1() {
        ObjectContainer db = getConnection();
        Boolean res = new Db4oOperatorTest_SbqlQuery3(db).executeQuery();
        return res;
    }
    
    public Boolean testAny2() {
        ObjectContainer db = getConnection();
        Boolean res = new Db4oOperatorTest_SbqlQuery4(db).executeQuery();
        return res;
    }
    
    public Collection<Integer> testBag1() {
        ObjectContainer db = getConnection();
        Collection<Integer> res = new Db4oOperatorTest_SbqlQuery5(db).executeQuery();
        return res;
    }
    
    public Collection<Integer> testBag2() {
        ObjectContainer db = getConnection();
        Collection<Integer> res = new Db4oOperatorTest_SbqlQuery6(db).executeQuery();
        return res;
    }
    
    public Collection<Integer> testBag3() {
        ObjectContainer db = getConnection();
        Collection<Integer> res = new Db4oOperatorTest_SbqlQuery7(db).executeQuery();
        return res;
    }
    
    public Collection<Integer> testBag4() {
        ObjectContainer db = getConnection();
        Collection<Integer> res = new Db4oOperatorTest_SbqlQuery8(db).executeQuery();
        return res;
    }
    
    public Struct testComma1() {
        ObjectContainer db = getConnection();
        Struct res = new Db4oOperatorTest_SbqlQuery9(db).executeQuery();
        return res;
    }
    
    public Collection<Struct> testComma2() {
        ObjectContainer db = getConnection();
        Collection<Struct> res = new Db4oOperatorTest_SbqlQuery10(db).executeQuery();
        return res;
    }
    
    public Collection<Struct> testComma3() {
        ObjectContainer db = getConnection();
        Collection<Struct> res = new Db4oOperatorTest_SbqlQuery11(db).executeQuery();
        return res;
    }
    
    public Integer testDivide1() {
        ObjectContainer db = getConnection();
        Integer res = new Db4oOperatorTest_SbqlQuery12(db).executeQuery();
        return res;
    }
    
    public Double testDivide2() {
        ObjectContainer db = getConnection();
        Double res = new Db4oOperatorTest_SbqlQuery13(db).executeQuery();
        return res;
    }
    
    public Double testDivide3() {
        ObjectContainer db = getConnection();
        Double res = new Db4oOperatorTest_SbqlQuery14(db).executeQuery();
        return res;
    }
    
    public Double testDivide4() {
        ObjectContainer db = getConnection();
        Double res = new Db4oOperatorTest_SbqlQuery15(db).executeQuery();
        return res;
    }
    
    public Collection<String> testDot1() {
        ObjectContainer db = getConnection();
        Collection<String> res = new Db4oOperatorTest_SbqlQuery16(db).executeQuery();
        return res;
    }
    
    public Collection<String> testDot2() {
        ObjectContainer db = getConnection();
        Collection<String> res = new Db4oOperatorTest_SbqlQuery17(db).executeQuery();
        return res;
    }
    
    public String testDot3() {
        ObjectContainer db = getConnection();
        String res = new Db4oOperatorTest_SbqlQuery18(db).executeQuery();
        return res;
    }
    
    public Collection<String> testDot4() {
        Collection<String> res = new Db4oOperatorTest_SbqlQuery19().executeQuery();
        return res;
    }
    
    public Collection<String> testDot5() {
        Collection<String> res = new Db4oOperatorTest_SbqlQuery20().executeQuery();
        return res;
    }
}