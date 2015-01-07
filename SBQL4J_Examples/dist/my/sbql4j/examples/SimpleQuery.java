package my.sbql4j.examples;

import java.util.*;

public class SimpleQuery {
    
    public SimpleQuery() {
        super();
    }
    
    public void query01() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<String> range1 = new SimpleQuery_SbqlQuery0(numbers).executeQuery();
        System.out.println(range1);
    }
}