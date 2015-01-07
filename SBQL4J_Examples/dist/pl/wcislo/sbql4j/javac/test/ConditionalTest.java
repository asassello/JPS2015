package pl.wcislo.sbql4j.javac.test;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ConditionalTest {
    
    public static void main(String[] args) {
        new ConditionalTest();
    }
    
    public ConditionalTest() {
        super();
        test1();
        test2();
    }
    
    public void test1() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<String> range1 = new ConditionalTest_SbqlQuery0(numbers).executeQuery();
        System.out.println(range1);
    }
    
    public void test2() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Struct> range1 = new ConditionalTest_SbqlQuery1(numbers).executeQuery();
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