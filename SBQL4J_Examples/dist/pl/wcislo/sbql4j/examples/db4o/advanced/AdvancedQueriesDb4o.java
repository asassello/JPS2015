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

public class AdvancedQueriesDb4o implements IAdvancedQueries {
    private ObjectContainer db;
    private AdvQueriesData data;
    
    public static void main(String[] args) {
        new AdvancedQueriesDb4o();
    }
    
    public AdvancedQueriesDb4o() {
        super();
    }
    
    public ObjectContainer getConnection() {
        if (db == null) {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "testAdvanced.db");
        }
        return db;
    }
    
    @Override()
    public AdvQueriesData getData() {
        if (data == null) {
            data = new AdvQueriesData();
        }
        return data;
    }
    
    private void prepareData() {
        ObjectContainer con = getConnection();
        AdvQueriesData data = getData();
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
    
    @Override()
    public void prepare() {
        prepareData();
    }
    
    @Override()
    public void shutDown() {
        getConnection().close();
    }
    
    /**
     * Get departments together with the average salaries of their employees
     */
    @Override()
    public Collection<Struct> query1() {
        Collection<Struct> deptAvgSal = new AdvancedQueriesDb4o_SbqlQuery0(db).executeQuery();
        return deptAvgSal;
    }
    
    /**
     * Get name, salary and department name for employees earning less than 2222
     */
    @Override()
    public Collection<Struct> query2() {
        Collection<Struct> poorEmpData = new AdvancedQueriesDb4o_SbqlQuery1(db).executeQuery();
        return poorEmpData;
    }
    
    /**
     * Get names of employees working for the department managed by Bert.
     */
    @Override()
    public Collection<String> query3() {
        Collection<String> bertSubordinates = new AdvancedQueriesDb4o_SbqlQuery2(db).executeQuery();
        return bertSubordinates;
    }
    
    /**
     * Get the name of Poe's boss:
     */
    @Override()
    public String query4() {
        String poeBossName = new AdvancedQueriesDb4o_SbqlQuery3(db).executeQuery();
        return poeBossName;
    }
    
    /**
     * Names and cities of employees working in departments managed by Bert
     */
    @Override()
    public Collection<Struct> query5() {
        Collection<Struct> res = new AdvancedQueriesDb4o_SbqlQuery4(db).executeQuery();
        return res;
    }
    
    /**
     * Get the minimal, average and maximal number of employees in departments
     */
    @Override()
    public Struct query6() {
        Struct res = new AdvancedQueriesDb4o_SbqlQuery5(db).executeQuery();
        return res;
    }
    
    /**
     * For each department get its name and the sum of salaries of employees being not bosses
     */
    @Override()
    public Collection<Struct> query7() {
        Collection<Struct> res = new AdvancedQueriesDb4o_SbqlQuery6(db).executeQuery();
        return res;
    }
    
    /**
     * Is it true that each department employs an employee earning the same as his/her boss?
     */
    @Override()
    public Boolean query8() {
        Boolean res = new AdvancedQueriesDb4o_SbqlQuery7(db).executeQuery();
        return res;
    }
    
    /**
     * For each employee get the message containing his/her name and
     * the percent of the annual budget of his/her department that is
     * consumed by his/her monthly salary
     */
    @Override()
    public Collection<String> query9() {
        Collection<String> res = new AdvancedQueriesDb4o_SbqlQuery8(db).executeQuery();
        return res;
    }
    
    /**
     * Get cities hosting all departments
     */
    @Override()
    public Collection<String> query10() {
        Collection<String> res = new AdvancedQueriesDb4o_SbqlQuery9(db).executeQuery();
        return res;
    }
    
    /**
     * For each interval <n,n+999>, n = 0, 1000, 2000, 3000, ... get the message
     * (string) containing the number of employees having the salary within this interval
     * and the interval itself.
     * Output messages should have proper grammatical forms (suffixes -s for nouns (n) and verbs (v)).
     */
    @Override()
    public Collection<String> query11() {
        Collection<String> res = new AdvancedQueriesDb4o_SbqlQuery10(db).executeQuery();
        System.out.println("11. For each interval <n,n+999>, n = 0, 1000, 2000, 3000, ... get the message");
        System.out.println("(string) containing the number of employees having the salary within this interval");
        System.out.println("and the interval itself.");
        System.out.println("Output messages should have proper grammatical forms (suffixes -s for nouns (n) and verbs (v)).");
        for (String s : res) {
            System.out.println(s);
        }
        System.out.println();
        return res;
    }
    
    /**
     * For each location give the set of department names that are located at it and
     * the average salary of bosses of these departments, providing that
     * the number of clerks that are employed at such a location is lower than 100.
     */
    @Override()
    public Collection<Struct> query12() {
        Collection<Struct> res = new AdvancedQueriesDb4o_SbqlQuery11(db).executeQuery();
        return res;
    }
}