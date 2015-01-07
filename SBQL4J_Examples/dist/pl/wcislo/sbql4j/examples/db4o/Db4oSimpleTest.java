package pl.wcislo.sbql4j.examples.db4o;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import pl.wcislo.sbql4j.examples.model.Emp;
import java.util.*;
import com.db4o.*;

public class Db4oSimpleTest {
    private ObjectContainer dbConn;
    
    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        new Db4oSimpleTest();
    }
    
    public Db4oSimpleTest() {
        super();
        getConnection();
        try {
            prepareData();
            test1();
            test2();
        } finally {
            getConnection().close();
        }
    }
    
    private ObjectContainer getConnection() {
        if (dbConn == null) {
            dbConn = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "test.db");
        }
        return dbConn;
    }
    
    private void prepareData() {
        ObjectContainer con = getConnection();
        LinqExampleData data = new LinqExampleData();
        ObjectSet<Customer> cust = con.query(Customer.class);
        if (cust.isEmpty()) {
            for (Customer c : data.getCustomerList()) {
                con.store(c);
            }
        }
        ObjectSet<Product> prd = con.query(Product.class);
        if (prd.isEmpty()) {
            for (Product p : data.getProductList()) {
                con.store(p);
            }
        }
        con.commit();
    }
    
    public void test1() {
        System.out.println("1. #{ db.(Product) }");
        ObjectContainer db = getConnection();
        Object res = new Db4oSimpleTest_SbqlQuery0(db).executeQuery();
        System.out.println(res);
    }
    
    public void test2() {
        System.out.println("2. #{ db.(Product.productName) }");
        ObjectContainer db = getConnection();
        Object res = new Db4oSimpleTest_SbqlQuery1(db).executeQuery();
        System.out.println(res);
    }
}