package pl.wcislo.sbql4j.examples.db4o.advanced;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
import pl.wcislo.sbql4j.java.model.runtime.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.text.*;
import com.db4o.*;
import com.db4o.config.Configuration;
import com.db4o.config.ObjectClass;
import com.db4o.events.ObjectContainerEventArgs;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.ext.StoredClass;

public class ADBIS {
    private ObjectContainer db;
    private AdvQueriesData data;
    
    public static void main(String[] args) {
        new ADBIS();
    }
    
    public ADBIS() {
        super();
        getConnection();
        prepareData();
    }
    
    public ObjectContainer getConnection() {
        if (db == null) {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "testAdvanced.db");
        }
        return db;
    }
    
    public ObjectContainer getDB4OConnection() {
        if (db == null) {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "testAdvanced.db");
        }
        return db;
    }
    
    public ObjectContainer getAnotherDB4OConnection() {
        if (db == null) {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "testAdvanced.db");
        }
        return db;
    }
    
    public AdvQueriesData getData() {
        if (data == null) {
            data = new AdvQueriesData();
        }
        return data;
    }
    
    private void prepareData() {
        AdvQueriesData data = getData();
        ExtObjectContainer con = getConnection().ext();
        Configuration config = con.configure();
        {
            ObjectClass objectClass = config.objectClass(Employee.class);
            objectClass.objectField("salary").indexed(true);
        }
        ObjectSet<Employee> emp = con.query(Employee.class);
        if (emp.isEmpty()) {
            for (Employee e : data.getEmps()) {
                con.store(e);
            }
        }
        ObjectSet<Department> depts = con.query(Department.class);
        if (depts.isEmpty()) {
            for (Department d : data.getDepts()) {
                con.store(d);
            }
        }
        con.commit();
    }
    
    public void prepare() {
        prepareData();
    }
    
    public void shutDown() {
        getConnection().close();
    }
    
    public Collection<Employee> query1() {
        ObjectContainer db1 = getDB4OConnection();
        ObjectContainer db2 = getAnotherDB4OConnection();
        List<Department> depts = data.getDepts();
        Double minSalary = 3000.0;
        Collection<Employee> res = new ADBIS_SbqlQuery0(depts,db1,db2,minSalary).executeQuery();
        return res;
    }
    
    public Collection<Employee> query2() {
        ObjectContainer db1 = getDB4OConnection();
        ObjectContainer db2 = getAnotherDB4OConnection();
        Double minSalary = 3000.0;
        String reqJob = "Clerk";
        Collection<Employee> res = new ADBIS_SbqlQuery1(db1,minSalary,db2,reqJob).executeQuery();
        return res;
    }
}