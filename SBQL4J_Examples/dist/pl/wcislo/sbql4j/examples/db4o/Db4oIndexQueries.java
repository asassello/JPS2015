package pl.wcislo.sbql4j.examples.db4o;

import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;
import java.util.*;
import javax.swing.JFrame;
import com.db4o.*;
import com.db4o.config.Configuration;
import com.db4o.config.ObjectClass;
import com.db4o.events.ObjectContainerEventArgs;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.ext.StoredClass;

public class Db4oIndexQueries {
    private ObjectContainer dbConn;
    
    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        new Db4oIndexQueries();
    }
    
    public Db4oIndexQueries() {
        super();
        getConnection();
        try {
            prepareData();
            test2();
        } finally {
            getConnection().close();
        }
    }
    
    private ObjectContainer getConnection() {
        if (dbConn == null) {
            dbConn = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "testIndexed.db");
        }
        return dbConn;
    }
    
    private void prepareData() {
        ExtObjectContainer con = getConnection().ext();
        Configuration config = con.configure();
        {
            ObjectClass objectClass = config.objectClass(Customer.class);
            objectClass.objectField("city").indexed(true);
        }
        {
            ObjectClass objectClass = config.objectClass(Product.class);
            objectClass.objectField("productName").indexed(true);
        }
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
    
    public void test0() {
        System.out.println("0. #{ db.(Product where productName ==\"Ikura\") }");
        ObjectContainer db = getConnection();
        String[] name = {"Ikura", "Ala", "Kot"};
        Object res = new Db4oIndexQueries_SbqlQuery0(name,db).executeQuery();
        System.out.println(res);
    }
    
    public void test1() {
        System.out.println("1. #{ db.(Product where productName ==\"Ikura\") }");
        ObjectContainer db = getConnection();
        Object res = new Db4oIndexQueries_SbqlQuery1(db).executeQuery();
        System.out.println(res);
    }
    
    public void test2() {
        System.out.println("2. #{ db.(Product where productName ==\"Ikura\" and unitsInStock > 0) }");
        ObjectContainer db = getConnection();
        Object res = new Db4oIndexQueries_SbqlQuery2(db).executeQuery();
        System.out.println(res);
    }
    
    public void test3() {
        System.out.println("3. #{ db.(Product where productName ==\"Ikura\" and unitsInStock > 0 and unitPrice < 1000) }");
        ObjectContainer db = getConnection();
        Object res = new Db4oIndexQueries_SbqlQuery3(db).executeQuery();
        System.out.println(res);
    }
}