package pl.wcislo.sbql4j.examples.java_heap.advanced;

import java.util.List;
import java.util.Collection;
import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;

/**
 * Some advanced queries which are difficult (or even impossible) to write in LINQ.
 * Queries were orginally written by <a href="http://www.ipipan.waw.pl/~subieta/">Kazimierz Subieta</a>
 * for ODRA system. <a href="http://www.sbql.pl/various/SBQL_Examples_4_LINQ.cli.htm">link</a>
 */
public class AdvancedQueriesJavaHeap implements IAdvancedQueries {
    
    public static void main(String[] args) {
        new AdvancedQueriesJavaHeap();
    }
    
    public AdvancedQueriesJavaHeap() {
        super();
    }
    
    /**
     * Get departments together with the average salaries of their employees
     */
    @Override()
    public Collection<Struct> query1() {
        List<Department> depts = data.getDepts();
        List<Struct> deptAvgSal = new AdvancedQueriesJavaHeap_SbqlQuery0(depts).executeQuery();
        return deptAvgSal;
    }
    
    /**
     * Get name, salary and department name for employees earning less than 2222
     */
    @Override()
    public Collection<Struct> query2() {
        List<Employee> emp = data.getEmps();
        List<Struct> poorEmpData = new AdvancedQueriesJavaHeap_SbqlQuery1(emp).executeQuery();
        return poorEmpData;
    }
    
    /**
     * Get names of employees working for the department managed by Bert.
     */
    @Override()
    public Collection<String> query3() {
        List<Employee> emp = data.getEmps();
        List<String> bertSubordinates = new AdvancedQueriesJavaHeap_SbqlQuery2(emp).executeQuery();
        return bertSubordinates;
    }
    
    /**
     * Get the name of Poe's boss:
     */
    @Override()
    public String query4() {
        List<Employee> emp = data.getEmps();
        String poeBossName = new AdvancedQueriesJavaHeap_SbqlQuery3(emp).executeQuery();
        return poeBossName;
    }
    
    /**
     * Names and cities of employees working in departments managed by Bert
     */
    @Override()
    public Collection<Struct> query5() {
        List<Department> dept = data.getDepts();
        List<Struct> res = new AdvancedQueriesJavaHeap_SbqlQuery4(dept).executeQuery();
        return res;
    }
    
    /**
     * Get the minimal, average and maximal number of employees in departments
     */
    @Override()
    public Struct query6() {
        List<Department> dept = data.getDepts();
        Struct res = new AdvancedQueriesJavaHeap_SbqlQuery5(dept).executeQuery();
        return res;
    }
    
    /**
     * For each department get its name and the sum of salaries of employees being not bosses
     */
    @Override()
    public Collection<Struct> query7() {
        List<Department> dept = data.getDepts();
        List<Struct> res = new AdvancedQueriesJavaHeap_SbqlQuery6(dept).executeQuery();
        return res;
    }
    
    /**
     * Is it true that each department employs an employee earning the same as his/her boss?
     */
    @Override()
    public Boolean query8() {
        List<Department> dept = data.getDepts();
        Boolean res = new AdvancedQueriesJavaHeap_SbqlQuery7(dept).executeQuery();
        return res;
    }
    
    /**
     * For each employee get the message containing his/her name and
     * the percent of the annual budget of his/her department that is
     * consumed by his/her monthly salary
     */
    public Collection<String> query9() {
        List<Employee> emp = data.getEmps();
        List<String> res = new AdvancedQueriesJavaHeap_SbqlQuery8(emp).executeQuery();
        return res;
    }
    
    /**
     * Get cities hosting all departments
     */
    public Collection<String> query10() {
        List<Department> dept = data.getDepts();
        List<String> res = new AdvancedQueriesJavaHeap_SbqlQuery9(dept).executeQuery();
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
        List<Employee> emp = data.getEmps();
        List<String> res = new AdvancedQueriesJavaHeap_SbqlQuery10(emp).executeQuery();
        return res;
    }
    
    /**
     * For each location give the set of department names that are located at it and
     * the average salary of bosses of these departments, providing that
     * the number of clerks that are employed at such a location is lower than 100.
     */
    @Override()
    public Collection<Struct> query12() {
        List<Department> dept = data.getDepts();
        List<Employee> emp = data.getEmps();
        List<Struct> res = new AdvancedQueriesJavaHeap_SbqlQuery11(emp,dept).executeQuery();
        return res;
    }
    private AdvQueriesData data;
    
    public AdvQueriesData getData() {
        if (data == null) {
            data = new AdvQueriesData();
        }
        return data;
    }
    
    @Override()
    public void prepare() {
        getData();
    }
    
    @Override()
    public void shutDown() {
    }
}