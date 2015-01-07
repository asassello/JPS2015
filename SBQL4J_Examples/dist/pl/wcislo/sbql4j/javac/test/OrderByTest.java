package pl.wcislo.sbql4j.javac.test;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.java.model.runtime.*;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.text.*;

public class OrderByTest {
    
    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        new OrderByTest();
    }
    
    public OrderByTest() {
        super();
        test1();
    }
    
    public void test1() {
        List<Product> products = getProductList();
        Comparator<Double> dComp = null;
        Collator plCollator = Collator.getInstance(new Locale("pl"));
        List<Product> orderedProducts = new OrderByTest_SbqlQuery0(products,plCollator).executeQuery();
        for (Product p : orderedProducts) {
            System.out.println(p);
        }
    }
    private LinqExampleData data = new LinqExampleData();
    
    private List<Product> getProductList() {
        return data.getProductList();
    }
    
    private List<Customer> getCustomerList() {
        return data.getCustomerList();
    }
}