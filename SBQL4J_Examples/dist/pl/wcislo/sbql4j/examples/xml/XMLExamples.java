package pl.wcislo.sbql4j.examples.xml;

import java.io.File;
import java.util.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import pl.wcislo.sbql4j.lang.xml.XMLDataSource;
import pl.wcislo.sbql4j.lang.xml.XMLMetadata;
import pl.wcislo.sbql4j.lang.xml.XMLMetadata.SourceType;

public class XMLExamples {
    
    public XMLExamples() {
        super();
    }
    @XMLMetadata(type = SourceType.XML_SCHEMA_FILE, value = "data/books.xsd", validateXML = true)
    public final XMLDataSource xmlSource = new XMLDataSource(new File("data/books.xml"));
    
    public static void main(String[] args) {
        XMLExamples e = new XMLExamples();
        e.findCatalogue();
        e.findAllBooks();
        e.findAllBooksPrices();
        e.findAllBooksPricesRetail();
        e.findSumBooksPricesRetail();
        e.findAvgBooksPricesRetail();
    }
    
    public Struct findCatalogue() {
        Struct res = new XMLExamples_SbqlQuery0(xmlSource).executeQuery();
        System.out.println("XMLExamples.findCatalogue() res=" + res);
        return res;
    }
    
    public List<Struct> findAllBooks() {
        List<Struct> res = new XMLExamples_SbqlQuery1(xmlSource).executeQuery();
        System.out.println("XMLExamples.findAllBooks() res=" + res);
        return res;
    }
    
    public Object findAllBooksPrices() {
        Object res = new XMLExamples_SbqlQuery2(xmlSource).executeQuery();
        System.out.println("XMLExamples.findAllBooksPrices() res=" + res);
        return res;
    }
    
    public Object findAllBooksPricesRetail() {
        Object res = new XMLExamples_SbqlQuery3(xmlSource).executeQuery();
        System.out.println("XMLExamples.findAllBooksPricesRetail() res=" + res);
        return res;
    }
    
    public Object findSumBooksPricesRetail() {
        Object res = new XMLExamples_SbqlQuery4(xmlSource).executeQuery();
        System.out.println("XMLExamples.findSumBooksPricesRetail() res=" + res);
        return res;
    }
    
    public Object findAvgBooksPricesRetail() {
        Object res = new XMLExamples_SbqlQuery5(xmlSource).executeQuery();
        System.out.println("XMLExamples.findAvgBooksPricesRetail() res=" + res);
        return res;
    }
}