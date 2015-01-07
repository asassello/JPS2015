package pl.wcislo.sbql4j.examples.db4o;

import pl.wcislo.sbql4j.examples.model.Emp;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import com.db4o.*;

public class Db4oEmpTest {
    private ObjectContainer dbConn;
    
    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        new Db4oSimpleTest();
    }
    
    public Db4oEmpTest() {
        super();
        getConnection();
        try {
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
}