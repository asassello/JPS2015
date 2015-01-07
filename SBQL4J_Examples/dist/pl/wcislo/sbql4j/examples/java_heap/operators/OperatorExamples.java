package pl.wcislo.sbql4j.examples.java_heap.operators;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.java.model.runtime.*;
import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;
import java.util.*;

public class OperatorExamples {
    
    public OperatorExamples() {
        super();
    }
    
    public Boolean testAll1() {
        Boolean result = new OperatorExamples_SbqlQuery0().executeQuery();
        return result;
    }
    
    public void testAll2() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Struct> range1 = new OperatorExamples_SbqlQuery1(numbers).executeQuery();
        System.out.println(range1);
    }
    private LinqExampleData data = new LinqExampleData();
    
    private List<Product> getProductList() {
        return data.getProductList();
    }
    
    private List<Customer> getCustomerList() {
        return data.getCustomerList();
    }
}