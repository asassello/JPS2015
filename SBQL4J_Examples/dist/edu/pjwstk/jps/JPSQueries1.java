package edu.pjwstk.jps;

import java.util.List;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import edu.pjwstk.jps.model.*;

public class JPSQueries1 {
    
    public static void main(String[] args) {
        new JPSQueries1();
    }
    private ExampleData data = new ExampleData();
    
    public JPSQueries1() {
        super();
        query1();
        query2();
        query3();
        query4();
        query5();
        query6();
        query7();
        query8();
        query9();
        query10();
        query11();
        query12();
        query13();
        query14();
        query15();
    }
    
    /**
     * Policz 1 + 2 * 3 + 4
     */
    private void query1() {
        System.out.println("Query 1");
    }
    
    /**
     * Policz ile wynosi reszta z dzielenia 435 przez 3
     */
    private void query2() {
        System.out.println("Query 2");
    }
    
    /**
     * Sprawd\u017a czy 6549 dzieli si\u0119 przez 4
     */
    private void query3() {
        System.out.println("Query 3");
    }
    
    /**
     * Wypisz nazwiska wszystkich pracowników. Posortuj t\u0105 list\u0119.
     */
    private void query4() {
        System.out.println("Query 4");
        List<Person> emp = data.getPersons();
    }
    
    /**
     * Wypisz wszystkie samochody czerwone o mocy wi\u0119kszej od 200
     */
    private void query5() {
        System.out.println("Query 5");
        List<Car> car = data.getCars();
    }
    
    /**
     * Wypisz na ekran przywitanie wszystkich pracowników po imieniu np. \u201eHello John!\u201d;
     */
    private void query6() {
        System.out.println("Query 6");
        List<Person> emp = data.getPersons();
    }
    
    /**
     * Wypisz dla ka\u017cdego pracownika nazwisko i ulic\u0119 na której pracuje.
     */
    private void query7() {
        System.out.println("Query 7");
        List<Person> emp = data.getPersons();
    }
    
    /**
     * Sprawd\u017a, czy wszyscy pracownicy s\u0105 zam\u0119\u017cni/\u017conaci (u\u017cyj forall)
     */
    private void query8() {
        System.out.println("Query 8");
        List<Person> emp = data.getPersons();
    }
    
    /**
     * Policz \u015bredni\u0105 wieku mieszkaj\u0105cych w Katowicach
     */
    private void query9() {
        System.out.println("Query 9");
        List<Person> emp = data.getPersons();
    }
    
    /**
     * Wypisz wszystkich pracuj\u0105cych w Warszawie (potrzeba u\u017cy\u0107 operatora any)
     */
    private void query10() {
        System.out.println("Query 10");
        List<Person> emp = data.getPersons();
    }
    
    /**
     * Policz ile jest w bazie danych firm (u\u017cyj count)
     */
    private void query11() {
        System.out.println("Query 11");
        List<Firm> firm = data.getFirms();
    }
    
    /**
     * Dla ka\u017cdej firmy wypisz jej nazw\u0119 i liczb\u0119 osób w niej pracuj\u0105cych (u\u017cyj \u201efirm as f\u201d)
     */
    private void query12() {
        System.out.println("Query 12");
        List<Firm> firm = data.getFirms();
        List<Person> emp = data.getPersons();
    }
    
    /**
     * Wypisz wszystkie miasta w których mieszkaj\u0105 pracownicy (u\u017cyj unique)
     */
    private void query13() {
        System.out.println("Query 13");
        List<Person> emp = data.getPersons();
    }
    
    /**
     * Dla ka\u017cdego miasta wypisz \u015bredni\u0105 wieku jej mieszka\u0144ców.
     */
    private void query14() {
        System.out.println("Query 14");
        List<Person> emp = data.getPersons();
    }
    
    /**
     * Wypisz pracowników na zasadzie \u201ewolny/wolna\u201dKowalski \u201ezam\u0119\u017cna/\u017conaty\u201dNowak.
     */
    private void query15() {
        System.out.println("Query 15");
        List<Person> emp = data.getPersons();
    }
}