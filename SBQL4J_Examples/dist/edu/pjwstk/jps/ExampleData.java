package edu.pjwstk.jps;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import edu.pjwstk.jps.model.Address;
import edu.pjwstk.jps.model.Car;
import edu.pjwstk.jps.model.Firm;
import edu.pjwstk.jps.model.Person;

public class ExampleData {
    private List<Car> cars;
    private List<Firm> firms;
    private List<Person> persons;
    
    public ExampleData() {
        super();
        initData();
    }
    
    public List<Car> getCars() {
        return cars;
    }
    
    public List<Firm> getFirms() {
        return firms;
    }
    
    public List<Person> getPersons() {
        return persons;
    }
    
    private void initData() {
        List<String> colors = new ArrayList<String>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Black");
        colors.add("White");
        List<Date> sampleDates = new ArrayList<Date>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sampleDates.add(df.parse("1995-03-01"));
            sampleDates.add(df.parse("1995-09-22"));
            sampleDates.add(df.parse("1996-01-06"));
            sampleDates.add(df.parse("1997-07-11"));
            sampleDates.add(df.parse("1998-04-30"));
            sampleDates.add(df.parse("1998-06-15"));
            sampleDates.add(df.parse("1999-09-30"));
            sampleDates.add(df.parse("2000-12-20"));
            sampleDates.add(df.parse("2001-01-01"));
            sampleDates.add(df.parse("2002-06-14"));
        } catch (ParseException e) {
            System.err.println(e);
        }
        List<String> cities = new ArrayList<String>();
        cities.add("\u0141\u00f3d\u017a");
        cities.add("Warszawa");
        cities.add("Pozna\u0144");
        cities.add("Wroc\u0142aw");
        cities.add("Krak\u00f3w");
        cities.add("Gda\u0144sk");
        cities.add("Szczecin");
        cities.add("Rzesz\u00f3w");
        cities.add("Katowice");
        List<String> streets = new ArrayList<String>();
        streets.add("5\'th avenue");
        streets.add("S. La Salle St.");
        streets.add("South Cass Avenue");
        streets.add("Park Avenue");
        streets.add("West Avenue");
        streets.add("North Avenue");
        List<String> femaleLNames = new ArrayList<String>();
        femaleLNames.add("NOWAK");
        femaleLNames.add("KOWALSKA");
        femaleLNames.add("WI\u0139\u0161NIEWSKA");
        femaleLNames.add("W\u00d3JCIK");
        femaleLNames.add("KOWALCZYK");
        femaleLNames.add("KAMI\u0143SKA");
        femaleLNames.add("LEWANDOWSKA");
        femaleLNames.add("ZIELI\u0143SKA");
        femaleLNames.add("SZYMA\u0143SKA");
        femaleLNames.add("WO\u0139\u00bbNIAK");
        femaleLNames.add("D\u0104BROWSKA");
        femaleLNames.add("KOZ\u0143OWSKA");
        femaleLNames.add("JANKOWSKA");
        femaleLNames.add("MAZUR");
        femaleLNames.add("WOJCIECHOWSKA");
        femaleLNames.add("KWIATKOWSKA");
        femaleLNames.add("KRAWCZYK");
        femaleLNames.add("PIOTROWSKA");
        femaleLNames.add("KACZMAREK");
        femaleLNames.add("GRABOWSKA");
        femaleLNames.add("PAW\u0143OWSKA");
        femaleLNames.add("MICHALSKA");
        femaleLNames.add("ZAJ\u0104C");
        femaleLNames.add("KR\u00d3L");
        femaleLNames.add("JAB\u0143O\u0143SKA");
        femaleLNames.add("WIECZOREK");
        femaleLNames.add("NOWAKOWSKA");
        femaleLNames.add("WR\u00d3BEL");
        femaleLNames.add("MAJEWSKA");
        femaleLNames.add("OLSZEWSKA");
        femaleLNames.add("ST\u0118PIE\u0143");
        femaleLNames.add("JAWORSKA");
        femaleLNames.add("MALINOWSKA");
        femaleLNames.add("ADAMCZYK");
        femaleLNames.add("NOWICKA");
        femaleLNames.add("G\u00d3RSKA");
        femaleLNames.add("DUDEK");
        femaleLNames.add("PAWLAK");
        femaleLNames.add("WITKOWSKA");
        femaleLNames.add("WALCZAK");
        femaleLNames.add("RUTKOWSKA");
        femaleLNames.add("SIKORA");
        femaleLNames.add("BARAN");
        femaleLNames.add("MICHALAK");
        femaleLNames.add("SZEWCZYK");
        femaleLNames.add("OSTROWSKA");
        femaleLNames.add("TOMASZEWSKA");
        femaleLNames.add("PIETRZAK");
        femaleLNames.add("JASI\u0143SKA");
        femaleLNames.add("WR\u00d3BLEWSKA");
        List<String> femaleFNames = new ArrayList<String>();
        femaleFNames.add("ANNA");
        femaleFNames.add("MARIA");
        femaleFNames.add("KATARZYNA");
        femaleFNames.add("MA\u0143GORZATA");
        femaleFNames.add("AGNIESZKA");
        femaleFNames.add("KRYSTYNA");
        femaleFNames.add("BARBARA");
        femaleFNames.add("EWA");
        femaleFNames.add("EL\u0139\u00bbBIETA");
        femaleFNames.add("ZOFIA");
        femaleFNames.add("JANINA");
        femaleFNames.add("TERESA");
        femaleFNames.add("JOANNA");
        femaleFNames.add("MAGDALENA");
        femaleFNames.add("MONIKA");
        femaleFNames.add("JADWIGA");
        femaleFNames.add("DANUTA");
        femaleFNames.add("IRENA");
        femaleFNames.add("HALINA");
        femaleFNames.add("HELENA");
        femaleFNames.add("BEATA");
        femaleFNames.add("ALEKSANDRA");
        femaleFNames.add("MARTA");
        femaleFNames.add("DOROTA");
        femaleFNames.add("MARIANNA");
        femaleFNames.add("GRA\u0139\u00bbYNA");
        femaleFNames.add("JOLANTA");
        femaleFNames.add("STANIS\u0143AWA");
        femaleFNames.add("IWONA");
        femaleFNames.add("KAROLINA");
        femaleFNames.add("BO\u0139\u00bbENA");
        femaleFNames.add("URSZULA");
        femaleFNames.add("JUSTYNA");
        femaleFNames.add("RENATA");
        femaleFNames.add("ALICJA");
        femaleFNames.add("PAULINA");
        femaleFNames.add("SYLWIA");
        femaleFNames.add("NATALIA");
        femaleFNames.add("WANDA");
        femaleFNames.add("AGATA");
        femaleFNames.add("ANETA");
        femaleFNames.add("IZABELA");
        femaleFNames.add("EWELINA");
        femaleFNames.add("MARZENA");
        femaleFNames.add("WIES\u0143AWA");
        femaleFNames.add("GENOWEFA");
        femaleFNames.add("PATRYCJA");
        femaleFNames.add("KAZIMIERA");
        femaleFNames.add("EDYTA");
        femaleFNames.add("STEFANIA");
        List<String> maleLNames = new ArrayList<String>();
        maleLNames.add("NOWAK");
        maleLNames.add("KOWALSKI");
        maleLNames.add("WI\u0139\u0161NIEWSKI");
        maleLNames.add("W\u00d3JCIK");
        maleLNames.add("KOWALCZYK");
        maleLNames.add("KAMI\u0143SKI");
        maleLNames.add("LEWANDOWSKI");
        maleLNames.add("ZIELI\u0143SKI");
        maleLNames.add("WO\u0139\u00bbNIAK");
        maleLNames.add("SZYMA\u0143SKI");
        maleLNames.add("D\u0104BROWSKI");
        maleLNames.add("KOZ\u0143OWSKI");
        maleLNames.add("JANKOWSKI");
        maleLNames.add("MAZUR");
        maleLNames.add("WOJCIECHOWSKI");
        maleLNames.add("KWIATKOWSKI");
        maleLNames.add("KRAWCZYK");
        maleLNames.add("KACZMAREK");
        maleLNames.add("PIOTROWSKI");
        maleLNames.add("GRABOWSKI");
        maleLNames.add("ZAJ\u0104C");
        maleLNames.add("PAW\u0143OWSKI");
        maleLNames.add("KR\u00d3L");
        maleLNames.add("MICHALSKI");
        maleLNames.add("WR\u00d3BEL");
        maleLNames.add("WIECZOREK");
        maleLNames.add("JAB\u0143O\u0143SKI");
        maleLNames.add("NOWAKOWSKI");
        maleLNames.add("MAJEWSKI");
        maleLNames.add("ST\u0118PIE\u0143");
        maleLNames.add("OLSZEWSKI");
        maleLNames.add("JAWORSKI");
        maleLNames.add("MALINOWSKI");
        maleLNames.add("DUDEK");
        maleLNames.add("ADAMCZYK");
        maleLNames.add("PAWLAK");
        maleLNames.add("G\u00d3RSKI");
        maleLNames.add("NOWICKI");
        maleLNames.add("SIKORA");
        maleLNames.add("WALCZAK");
        maleLNames.add("WITKOWSKI");
        maleLNames.add("BARAN");
        maleLNames.add("RUTKOWSKI");
        maleLNames.add("MICHALAK");
        maleLNames.add("SZEWCZYK");
        maleLNames.add("OSTROWSKI");
        maleLNames.add("TOMASZEWSKI");
        maleLNames.add("PIETRZAK");
        maleLNames.add("ZALEWSKI");
        maleLNames.add("WR\u00d3BLEWSKI");
        List<String> maleFNames = new ArrayList<String>();
        maleFNames.add("JAN");
        maleFNames.add("ANDRZEJ");
        maleFNames.add("PIOTR");
        maleFNames.add("KRZYSZTOF");
        maleFNames.add("STANIS\u0143AW");
        maleFNames.add("TOMASZ");
        maleFNames.add("PAWE\u0141");
        maleFNames.add("J\u00d3ZEF");
        maleFNames.add("MARCIN");
        maleFNames.add("MAREK");
        maleFNames.add("MICHA\u0143");
        maleFNames.add("GRZEGORZ");
        maleFNames.add("JERZY");
        maleFNames.add("TADEUSZ");
        maleFNames.add("ADAM");
        maleFNames.add("\u0143UKASZ");
        maleFNames.add("ZBIGNIEW");
        maleFNames.add("RYSZARD");
        maleFNames.add("DARIUSZ");
        maleFNames.add("HENRYK");
        maleFNames.add("MARIUSZ");
        maleFNames.add("KAZIMIERZ");
        maleFNames.add("WOJCIECH");
        maleFNames.add("ROBERT");
        maleFNames.add("MATEUSZ");
        maleFNames.add("MARIAN");
        maleFNames.add("RAFA\u0143");
        maleFNames.add("JACEK");
        maleFNames.add("JANUSZ");
        maleFNames.add("MIROS\u0143AW");
        maleFNames.add("MACIEJ");
        maleFNames.add("S\u0143AWOMIR");
        maleFNames.add("JAROS\u0143AW");
        maleFNames.add("KAMIL");
        maleFNames.add("WIES\u0143AW");
        maleFNames.add("ROMAN");
        maleFNames.add("W\u0143ADYS\u0143AW");
        maleFNames.add("JAKUB");
        maleFNames.add("ARTUR");
        maleFNames.add("ZDZIS\u0143AW");
        maleFNames.add("EDWARD");
        maleFNames.add("MIECZYS\u0143AW");
        maleFNames.add("DAMIAN");
        maleFNames.add("DAWID");
        maleFNames.add("PRZEMYS\u0141AW");
        maleFNames.add("SEBASTIAN");
        maleFNames.add("CZES\u0143AW");
        maleFNames.add("LESZEK");
        maleFNames.add("DANIEL");
        maleFNames.add("WALDEMAR");
        firms = new ArrayList<Firm>();
        persons = new ArrayList<Person>();
        cars = new ArrayList<Car>();
        for (String c : cities) {
            for (int i = 0; i < 2; i++) {
                firms.add(new Firm("firm" + i, new Address(c, random(streets), randomZip())));
            }
            for (int i = 0; i < 20; i++) {
                persons.add(new Person(random(maleFNames), random(maleLNames), randomInt(25, 35), randomBoolean(), new Address(c, random(streets), randomZip())));
                persons.add(new Person(random(femaleFNames), random(femaleLNames), randomInt(25, 35), randomBoolean(), new Address(c, random(streets), randomZip())));
            }
            for (int i = 0; i < 30; i++) {
                cars.add(new Car("model" + i, random(colors), randomInt(150, 350), random(sampleDates)));
            }
        }
        for (String c : cities) {
            Collection<Person> pCity = new ExampleData_SbqlQuery0(persons,c).executeQuery();
            for (Person p : pCity) {
                List<Firm> fCity = new ExampleData_SbqlQuery1(firms,c).executeQuery();
                p.setWorksIn(random(fCity));
            }
        }
    }
    
    private <T>T random(List<T> col) {
        int randomIndex = (int)(Math.random() * col.size());
        return col.get(randomIndex);
    }
    
    private String randomZip() {
        int r = (int)(Math.random() * 100000);
        DecimalFormat df = new DecimalFormat("00000");
        StringBuilder sb = new StringBuilder(df.format(r));
        sb.insert(2, "-");
        return sb.toString();
    }
    
    private int randomInt(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    
    private boolean randomBoolean() {
        int r = (int)(Math.random() * 2);
        return r > 0 ? true : false;
    }
}