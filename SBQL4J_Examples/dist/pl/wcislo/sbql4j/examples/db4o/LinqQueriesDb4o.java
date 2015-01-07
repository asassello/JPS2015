package pl.wcislo.sbql4j.examples.db4o;

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
import com.db4o.*;

public class LinqQueriesDb4o implements ILinqQueries {
    private ObjectContainer db;
    private LinqExampleData data;
    
    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        new LinqQueriesDb4o();
    }
    
    public LinqQueriesDb4o() {
        super();
    }
    
    public ObjectContainer getConnection() {
        if (db == null) {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "testLinq.db");
        }
        return db;
    }
    
    private void prepareData() {
        ObjectContainer con = getConnection();
        LinqExampleData data = getData();
        ObjectSet<Customer> cust = con.query(Customer.class);
        if (cust.isEmpty()) {
            for (Customer c : data.getCustomerList()) {
                con.store(c);
            }
        }
        ObjectSet<Product> prd = con.query(Product.class);
        if (prd.isEmpty()) {
            for (Product p : data.getProductList()) {
                con.store(p);
            }
        }
        con.commit();
    }
    
    @Override()
    public LinqExampleData getData() {
        if (this.data == null) {
            this.data = new LinqExampleData();
        }
        return this.data;
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
     * This sample uses where to find all elements of an array less than 5.
     * 
     * Orginal LINQ query:
     * from n in numbers
     * where n < 5
     * select n; 
     */
    public List<Integer> linq1() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> lowNums = new LinqQueriesDb4o_SbqlQuery0(numbers,db).executeQuery();
        return lowNums;
    }
    
    /**
     * This sample uses where to find all products that are out of stock.
     * 
     * Orginal LINQ query:
     * from p in products
     * where p.UnitsInStock == 0
     * select p;
     */
    public Collection<Product> linq2() {
        Collection<Product> soldOutProducts = new LinqQueriesDb4o_SbqlQuery1(db).executeQuery();
        for (Product product : soldOutProducts) {
        }
        return soldOutProducts;
    }
    
    /**
     * This sample uses where to find all products that are in stock and cost more than 3.00 per unit.
     * 
     * Orginal LINQ query:
     * from p in products
     *      where p.UnitsInStock > 0 && p.UnitPrice > 3.00M
     *      select p;
     */
    public Collection<Product> linq3() {
        ObjectContainer db = getConnection();
        int minUnitsInStock = 0;
        int minUnitPrice = 3;
        Collection<Product> expensiveInStockProducts = new LinqQueriesDb4o_SbqlQuery2(db,minUnitsInStock,minUnitPrice).executeQuery();
        return expensiveInStockProducts;
    }
    
    /**
     * This sample uses where to find all customers in Washington and then 
     * uses the resulting sequence to drill down into their orders.
     * 
     * Orginal LINQ query:
     * from c in customers
     *         where c.Region == "WA"
     *          select c;
     */
    public Collection<Customer> linq4() {
        Collection<Customer> waCustomers = new LinqQueriesDb4o_SbqlQuery3(db).executeQuery();
        return waCustomers;
    }
    
    /**
     * This sample demonstrates an indexed Where clause that 
     * returns digits whose name is shorter than their value.
     * 
     * Orginal LINQ query:
     * digits.Where((digit, index) => digit.Length < index);
     */
    public List<String> linq5() {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<String> shortDigits = new LinqQueriesDb4o_SbqlQuery4(digits,db).executeQuery();
        return shortDigits;
    }
    
    /**
     * This sample uses select to produce a sequence of 
     * ints one higher than those in an existing array of ints.
     * 
     * Orginal LINQ query:
     * from n in numbers
     * select n + 1;
     */
    public List<Integer> linq6() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> numsPlusOne = new LinqQueriesDb4o_SbqlQuery5(numbers,db).executeQuery();
        return numsPlusOne;
    }
    
    /**
     * This sample uses select to return a sequence of just the names of a list of products.
     * 
     * Orginal LINQ query:
     * from p in products
     * select p.ProductName;
     */
    public Collection<String> linq7() {
        Collection<String> productNames = new LinqQueriesDb4o_SbqlQuery6(db).executeQuery();
        return productNames;
    }
    
    /**
     * This sample uses select to produce a sequence of strings representing 
     * the text version of a sequence of ints.
     * 
     * Orginal LINQ query:
     * from n in numbers
     * select strings[n];
     */
    public List<String> linq8() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<String> textNums = new LinqQueriesDb4o_SbqlQuery7(numbers,strings,db).executeQuery();
        return textNums;
    }
    
    /**
     * This sample uses select to produce a sequence of the uppercase
     * and lowercase versions of each word in the original array.
     * 
     * Orginal LINQ query:
     * from w in words
     * select new {Upper = w.ToUpper(), Lower = w.ToLower()};
     */
    public List<Struct> linq9() {
        String[] words = {"aPPLE", "BlUeBeRrY", "cHeRry"};
        List<Struct> upperLowerWords = new LinqQueriesDb4o_SbqlQuery8(words,db).executeQuery();
        return upperLowerWords;
    }
    
    /**
     * This sample uses select to produce a sequence containing text
     * representations of digits and whether their length is even or odd.
     * 
     * Orginal LINQ query:
     * from n in numbers
     * select new {Digit = strings[n], Even = (n % 2 == 0)};
     */
    public List<Struct> linq10() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<Struct> digitOddEvens = new LinqQueriesDb4o_SbqlQuery9(numbers,strings).executeQuery();
        return digitOddEvens;
    }
    
    /**
     * This sample uses select to produce a sequence containing some properties
     * of Products, including UnitPrice which is renamed to Price
     * in the resulting type.
     * 
     * Orginal LINQ query:
     * from p in products
     * select new {p.ProductName, p.Category, Price = p.UnitPrice};
     */
    public Collection<Struct> linq11() {
        Collection<Struct> productInfos = new LinqQueriesDb4o_SbqlQuery10(db).executeQuery();
        return productInfos;
    }
    
    /**
     * This sample uses an loop index to determine if the value of ints
     * in an array match their position in the array.
     * 
     * Orginal LINQ query:
     * numbers.Select((num, index) => new {Num = num, InPlace = (num == index)});
     */
    public List<Struct> linq12() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Struct> numsInPlace = new LinqQueriesDb4o_SbqlQuery11(numbers,db).executeQuery();
        return numsInPlace;
    }
    
    /**
     * This sample combines select and where to make a simple query that returns
     * the text form of each digit less than 5.
     * 
     * Orginal LINQ query:
     * from n in numbers
     *      where n < 5
     *      select digits[n];
     */
    public List<String> linq13() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<String> lowNums = new LinqQueriesDb4o_SbqlQuery12(numbers,digits).executeQuery();
        return lowNums;
    }
    
    /**
     *	This sample uses a compound from clause to make a query that returns all pairs
     *	of numbers from both arrays such that the number from numbersA is less than the number
     *  from numbersB.
     *  
     *  Orginal LINQ query:
     *  from a in numbersA
     *      from b in numbersB
     *      where a < b
     *      select new { a, b };
     */
    public List<Struct> linq14() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        List<Struct> pairs = new LinqQueriesDb4o_SbqlQuery13(numbersA,numbersB,db).executeQuery();
        return pairs;
    }
    
    /**
     * This sample uses a compound from clause to select all orders where the
     * order total is less than 500.00.
     *
     * Orginal LINQ query:
     * from c in customers
     *      from o in c.Orders
     *      where o.Total < 500.00M
     *      select new {c.CustomerID, o.OrderID, o.Total};
     */
    public Collection<Struct> linq15() {
        Collection<Struct> orders = new LinqQueriesDb4o_SbqlQuery14(db).executeQuery();
        return orders;
    }
    
    /**
     * This sample uses a compound from clause to select all orders 
     * where the order was made in 1998 or later.
     * 
     * Orginal LINQ query:
     * 
     * from c in customers
     * from o in c.Orders
     * where o.OrderDate >= new DateTime(1998, 1, 1)
     * select new { c.CustomerID, o.OrderID, o.OrderDate };
     */
    public Collection<Struct> linq16() {
        Calendar c = Calendar.getInstance();
        c.set(1998, Calendar.JANUARY, 1);
        Date d = c.getTime();
        Collection<Struct> orders = new LinqQueriesDb4o_SbqlQuery15(db,d).executeQuery();
        return orders;
    }
    
    /**
     * This sample uses a compound from clause to select all orders where the order total 
     * is greater than 2000.00 and uses from assignment to avoid requesting the total twice.
     * 
     * Orginal LINQ query:
     * from c in customers
     *      from o in c.Orders
     *      where o.Total >= 2000.0M
     *      select new { c.CustomerID, o.OrderID, o.Total };
     */
    public List<Struct> linq17() {
        List<Struct> orders = new LinqQueriesDb4o_SbqlQuery16(db).executeQuery();
        return orders;
    }
    
    /**
     * This sample uses multiple from clauses so that filtering on customers can be done 
     * before selecting their orders. This makes the query more efficient by not selecting 
     * and then discarding orders for customers outside of Washington.
     * 
     * Orginal LINQ query:
     * from c in customers
     * where c.Region == "WA"
     * from o in c.Orders
     * where o.OrderDate >= cutoffDate
     * select new { c.CustomerID, o.OrderID };
     */
    public List<Struct> linq18() {
        Calendar c = Calendar.getInstance();
        c.set(1997, 0, 1);
        Date cutoffDate = c.getTime();
        List<Struct> orders = new LinqQueriesDb4o_SbqlQuery17(db,cutoffDate).executeQuery();
        return orders;
    }
    
    /**
     * This sample selects all orders, 
     * while referring to customers by the order in which they are returned from the query.
     * 
     * Orginal LINQ query:
     * customers.SelectMany(
     *          (cust, custIndex) =>
     *          cust.Orders.Select(o => "Customer #" + (custIndex + 1) +
     *                                  " has an order with OrderID " + o.OrderID));
     */
    public Collection<String> linq19() {
        Collection<String> customerOrders = new LinqQueriesDb4o_SbqlQuery18(db).executeQuery();
        return customerOrders;
    }
    
    /**
     * This sample uses an range operator to get only the first 3 elements of the array.
     * 
     * Orginal LINQ query:
     * numbers.Take(3);
     */
    public List<Integer> linq20() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> first3Numbers = new LinqQueriesDb4o_SbqlQuery19(numbers,db).executeQuery();
        return first3Numbers;
    }
    
    /**
     * This sample uses an range operator to get the first 3 orders from customers in Washington.
     * 
     * Orginal LINQ query:
     * from c in customers
     * from o in c.Orders
     * where c.Region == "WA"
     * select new { c.CustomerID, o.OrderID, o.OrderDate })
     * .Take(3);
     */
    public List<Struct> linq21() {
        List<Struct> first3WAOrders = new LinqQueriesDb4o_SbqlQuery20(db).executeQuery();
        return first3WAOrders;
    }
    
    /**
     * This sample uses an range operator to get all but the first 4 elements of the array.
     * 
     * Orginal LINQ query:
     * numbers.Skip(4);
     */
    public List<Integer> linq22() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Integer> allButFirst4Numbers = new LinqQueriesDb4o_SbqlQuery21(numbers,db).executeQuery();
        return allButFirst4Numbers;
    }
    
    /**
     * This sample uses an range operator to get all but the first 2 orders from customers in Washington.
     * 
     * Orginal LINQ query:
     * from c in customers
     * from o in c.Orders
     * where c.Region == "WA"
     * select new { c.CustomerID, o.OrderID, o.OrderDate };
     */
    public List<Struct> linq23() {
        List<Struct> waOrders = new LinqQueriesDb4o_SbqlQuery22(db).executeQuery();
        return waOrders;
    }
    
    /**
     * This sample uses orderby to sort a list of words alphabetically.
     * 
     * Orginal LINQ query:
     * from w in words
     * orderby w
     * select w;
     */
    public List<String> linq28() {
        String[] words = {"cherry", "apple", "blueberry"};
        List<String> sortedWords = new LinqQueriesDb4o_SbqlQuery23(db,words).executeQuery();
        return sortedWords;
    }
    
    /**
     * This sample uses orderby to sort a list of words by length.
     * 
     * Orginal LINQ query:
     * 
     * from w in words
     * orderby w.Length
     * select w;
     */
    public List<String> linq29() {
        String[] words = {"cherry", "apple", "blueberry"};
        List<String> sortedWords = new LinqQueriesDb4o_SbqlQuery24(db,words).executeQuery();
        return sortedWords;
    }
    
    /**
     * This sample uses an order by operator to sort a list of products by name.
     * 
     * Orginal LINQ query:
     * from p in products
     * orderby p.ProductName
     * select p;
     */
    public List<Product> linq30() {
        List<Product> sortedProducts = new LinqQueriesDb4o_SbqlQuery25(db).executeQuery();
        return sortedProducts;
    }
    
    /**
     * This sample uses an order by operator clause with a custom comparer to do 
     * a case-insensitive sort of the words in an array.
     * 
     * Orginal LINQ query:
     * words.OrderBy(a => a, new CaseInsensitiveComparer());
     */
    public List<String> linq31() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        Comparator<String> comp = new Comparator<String>(){
            
            
            @Override()
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        };
        List<String> sortedWords = new LinqQueriesDb4o_SbqlQuery26(db,words,comp).executeQuery();
        return sortedWords;
    }
    
    /**
     * This sample uses an order by operator and descending to 
     * sort a list of doubles from highest to lowest.
     * 
     * Orginal LINQ query:
     * from d in doubles
     * orderby d descending
     * select d;
     */
    public List<Double> linq32() {
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        List<Double> sortedDoubles = new LinqQueriesDb4o_SbqlQuery27(db,doubles).executeQuery();
        return sortedDoubles;
    }
    
    /**
     * This sample uses an order by operator to sort a list 
     * of products by units in stock from highest to lowest.
     * 
     * Orginal LINQ query:
     * from p in products
     *     orderby p.UnitsInStock descending
     *     select p;
     */
    public List<Product> linq33() {
        List<Product> sortedProducts = new LinqQueriesDb4o_SbqlQuery28(db).executeQuery();
        return sortedProducts;
    }
    
    /**
     * This sample uses an order by operator with a custom comparer to do a case-insensitive 
     * descending sort of the words in an array.
     * 
     * Orginal LINQ query:
     * words.OrderByDescending(a => a, new CaseInsensitiveComparer());
     */
    public List<String> linq34() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = new LinqQueriesDb4o_SbqlQuery29(db,words).executeQuery();
        return sortedWords;
    }
    
    /**
     * This sample uses an order by operator to sort a list of digits, 
     * first by length of their name, and then alphabetically by the name itself.
     * 
     * Orginal LINQ query:
     * from d in digits
     * orderby d.Length, d
     * select d;
     */
    public List<String> linq35() {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<String> sortedDigits = new LinqQueriesDb4o_SbqlQuery30(db,digits).executeQuery();
        return sortedDigits;
    }
    
    /**
     * This sample uses an order by operator with a custom comparer to sort first
     * by word length and then by a case-insensitive sort of the words in an array.
     * 
     * Orginal LINQ query:
     * words.OrderBy(a => a.Length)
     * .ThenBy(a => a, new CaseInsensitiveComparer());
     */
    public List<String> linq36() {
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        Comparator<String> comp = new Comparator<String>(){
            
            
            @Override()
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        };
        List<String> sortedWords = new LinqQueriesDb4o_SbqlQuery31(db,words,comp).executeQuery();
        return sortedWords;
    }
    
    /**
     * This sample uses an order by operator to sort a list of products,
     * first by category, and then by unit price, from highest to lowest.
     * 
     * Orginal LINQ query:
     * from p in products
     * orderby p.Category, p.UnitPrice descending
     * select p;
     */
    public List<Product> linq37() {
        List<Product> sortedProducts = new LinqQueriesDb4o_SbqlQuery32(db).executeQuery();
        return sortedProducts;
    }
    
    /**
     * This sample uses an order by operator with a custom comparer to sort 
     * first by word length and then by a case-insensitive descending sort of the words in an array.
     * 
     * Orginal LINQ query:
     * words.OrderBy(a => a.Length)
     * .ThenByDescending(a => a, new CaseInsensitiveComparer());
     */
    public List<String> linq38() {
        Comparator<String> comp = new Comparator<String>(){
            
            
            @Override()
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        };
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        List<String> sortedWords = new LinqQueriesDb4o_SbqlQuery33(db,words,comp).executeQuery();
        return sortedWords;
    }
    
    /**
     * This sample partition a list of numbers by their remainder when divided by 5.
     * 
     * Orginal LINQ query:
     * from n in numbers
     * group n by n % 5 into g
     * select new { Remainder = g.Key, Numbers = g };
     */
    public List<Struct> linq40() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        List<Struct> numberGroups = new LinqQueriesDb4o_SbqlQuery34(numbers,db).executeQuery();
        return numberGroups;
    }
    
    /**
     * This sample partition a list of words by their first letter.
     * 
     * Orginal LINQ query:
     * from w in words
     * group w by w[0] into g
     * select new { FirstLetter = g.Key, Words = g };
     */
    public List<Struct> linq41() {
        String[] words = {"blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese"};
        List<Struct> wordGroups = new LinqQueriesDb4o_SbqlQuery35(words,db).executeQuery();
        return wordGroups;
    }
    
    /**
     * This sample partition a list of products by category.
     * 
     * Orginal LINQ query:
     * from p in products
     * group p by p.Category into g
     * select new { Category = g.Key, Products = g };
     */
    public Collection<Struct> linq42() {
        Collection<Struct> orderGroups = new LinqQueriesDb4o_SbqlQuery36(db).executeQuery();
        return orderGroups;
    }
    
    /**
     * This sample partition a list of each 
     * customer's orders, first by year, and then by month.
     * 
     * Orginal LINQ query:
     * from c in customers
     *  select
     *      new
     *      {
     *          c.CompanyName,
     *          YearGroups =
     *              from o in c.Orders
     *              group o by o.OrderDate.Year into yg
     *              select
     *                  new
     *                  {
     *                      Year = yg.Key,
     *                      MonthGroups =
     *                          from o in yg
     *                          group o by o.OrderDate.Month into mg
     *                          select new { Month = mg.Key, Orders = mg }
     *                  }
     *      };
     */
    public Collection<Struct> linq43() {
        Collection<Struct> customerOrderGroups = new LinqQueriesDb4o_SbqlQuery37(db).executeQuery();
        return customerOrderGroups;
    }
    
    /**
     * This sample uses unique operator to remove duplicate 
     * elements in a sequence of factors of 300.
     * 
     * Orginal LINQ query:
     * factorsOf300.Distinct();
     */
    public List<Integer> linq46() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        List<Integer> uniqueFactors = new LinqQueriesDb4o_SbqlQuery38(factorsOf300,db).executeQuery();
        return uniqueFactors;
    }
    
    /**
     * This sample uses unique operator to find the unique Category names.
     * 
     * Orginal LINQ query:
     * from p in products
     *      select p.Category)
     *      .Distinct();
     */
    public Collection<String> linq47() {
        Collection<String> categoryNames = new LinqQueriesDb4o_SbqlQuery39(db).executeQuery();
        return categoryNames;
    }
    
    /**
     * This sample uses union operator to create one sequence 
     * that contains the unique values from both arrays.
     * 
     * Orginal LINQ query:
     * numbersA.Union(numbersB);
     */
    public Collection<Integer> linq48() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        Collection<Integer> uniqueNumbers = new LinqQueriesDb4o_SbqlQuery40(numbersA,numbersB,db).executeQuery();
        return uniqueNumbers;
    }
    
    /**
     * This sample uses union operator to create one sequence that 
     * contains the unique first letter from both product and customer names.
     * 
     * Orginal LINQ queries:
     * var productFirstChars =
     *      from p in products
     *      select p.ProductName[0];
     *  var customerFirstChars =
     *      from c in customers
     *      select c.CompanyName[0];
     *
     *  var uniqueFirstChars = productFirstChars.Union(customerFirstChars);
     */
    public Collection<Character> linq49() {
        Collection<Character> uniqueFirstChars = new LinqQueriesDb4o_SbqlQuery41(db).executeQuery();
        return uniqueFirstChars;
    }
    
    /**
     * This sample uses intersect operator to create one sequence that 
     * contains the common values shared by both arrays.
     * 
     * Orginal LINQ query:
     * numbersA.Intersect(numbersB);
     */
    public Collection<Integer> linq50() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        Collection<Integer> commonNumbers = new LinqQueriesDb4o_SbqlQuery42(numbersA,numbersB,db).executeQuery();
        return commonNumbers;
    }
    
    /**
     * This sample uses intersect operator to create one sequence that 
     * contains the common first letter from both product and customer names.
     * 
     * Orginal LINQ query:
     * var productFirstChars =
     *      from p in products
     *      select p.ProductName[0];
     *  var customerFirstChars =
     *      from c in customers
     *      select c.CompanyName[0];
     *  var commonFirstChars = productFirstChars.Intersect(customerFirstChars);
     */
    public Collection<Character> linq51() {
        Collection<Character> commonFirstChars = new LinqQueriesDb4o_SbqlQuery43(db).executeQuery();
        return commonFirstChars;
    }
    
    /**
     * This sample uses minus operator to create a sequence that 
     * contains the values from numbersAthat are not also in numbersB.
     * 
     * Orginal LINQ query:
     * numbersA.Except(numbersB);
     */
    public Collection<Integer> linq52() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        Collection<Integer> aOnlyNumbers = new LinqQueriesDb4o_SbqlQuery44(numbersA,numbersB,db).executeQuery();
        return aOnlyNumbers;
    }
    
    /**
     * This sample uses minus operator to create one sequence that contains
     * the first letters of product names that are not also 
     * first letters of customer names.
     *  
     * Orginal LINQ queries:
     * var productFirstChars =
     *      from p in products
     *      select p.ProductName[0];
     * var customerFirstChars =
     *      from c in customers
     *      select c.CompanyName[0];
     *
     * var productOnlyFirstChars = productFirstChars.Except(customerFirstChars);
     */
    public Collection<Character> linq53() {
        Collection<Character> productOnlyFirstChars = new LinqQueriesDb4o_SbqlQuery45(db).executeQuery();
        return productOnlyFirstChars;
    }
    
    /**
     * This sample uses instanceof operator to return only 
     * the elements of the array that are of type double.
     * 
     * Orginal LINQ query:
     * numbers.OfType<double>();
     */
    public List<Object> linq57() {
        Object[] numbers = {null, 1.0, "two", 3, "four", 5, "six", 7.0};
        List<Object> doubles = new LinqQueriesDb4o_SbqlQuery46(numbers).executeQuery();
        return doubles;
    }
    
    /**
     * This sample uses range operator to return the first matching element as a Product, 
     * instead of as a sequence containing a Product.
     * 
     * Orginal LINQ query:
     * (
     *      from p in products
     *      where p.ProductID == 12
     *      select p)
     *      .First();
     */
    public Product linq58() {
        Product product12 = new LinqQueriesDb4o_SbqlQuery47(db).executeQuery();
        return product12;
    }
    
    /**
     * This sample uses range operator to find the first element in the array that starts with 'o'.
     * 
     * Orginal LINQ query:
     * strings.First(s => s[0] == 'o');
     */
    public String linq59() {
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String startsWithO = new LinqQueriesDb4o_SbqlQuery48(strings,db).executeQuery();
        return startsWithO;
    }
    
    /**
     * This sample uses range operator to retrieve the second number greater than 5 from an array.
     * 
     * Orginal LINQ query:
     * (from n in numbers
     *  where n > 5
     *  select n)
     * .ElementAt(1)
     */
    public int linq64() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int fourthLowNum = new LinqQueriesDb4o_SbqlQuery49(numbers,db).executeQuery();
        return fourthLowNum;
    }
    
    /**
     * This sample uses any operator to determine if any of the words
     * in the array contain the substring 'ei'.
     * 
     * Orginal LINQ query:
     * words.Any(w => w.Contains("ei"));
     */
    public Boolean linq67() {
        String[] words = {"believe", "relief", "receipt", "field"};
        Boolean iAfterE = new LinqQueriesDb4o_SbqlQuery50(words,db).executeQuery();
        return iAfterE;
    }
    
    /**
     * This sample uses any operator to return a grouped a list of products only for 
     * categories that have at least one product that is out of stock.
     * 
     * Orginal LINQ query:
     * from p in products
     *            group p by p.Category into g
     *            where g.Any(p => p.UnitsInStock == 0)
     *            select new { Category = g.Key, Products = g };
     */
    public Collection<Struct> linq69() {
        Collection<Struct> productGroups = new LinqQueriesDb4o_SbqlQuery51(db).executeQuery();
        return productGroups;
    }
    
    /**
     * This sample uses all operator to determine whether an array contains only odd numbers.
     * 
     * Orginal LINQ query:
     * numbers.All(n => n % 2 == 1);
     */
    public Boolean linq70() {
        int[] numbers = {1, 11, 3, 19, 41, 65, 19};
        Boolean onlyOdd = new LinqQueriesDb4o_SbqlQuery52(numbers,db).executeQuery();
        return onlyOdd;
    }
    
    /**
     * This sample uses all operator to return a grouped a list of products only for 
     * categories that have all of their products in stock.
     * 
     * Orginal LINQ query:
     * from p in products
     *            group p by p.Category into g
     *            where g.All(p => p.UnitsInStock > 0)
     *            select new { Category = g.Key, Products = g };
     */
    public Collection<Struct> linq72() {
        Collection<Struct> productGroups = new LinqQueriesDb4o_SbqlQuery53(db).executeQuery();
        return productGroups;
    }
    
    /**
     * This sample uses count operator to get the number of unique factors of 300.
     * 
     * Orginal LINQ query:
     * factorsOf300.Distinct().Count();
     */
    public int linq73() {
        int[] factorsOf300 = {2, 2, 3, 5, 5};
        int uniqueFactors = new LinqQueriesDb4o_SbqlQuery54(factorsOf300,db).executeQuery();
        return uniqueFactors;
    }
    
    /**
     * This sample uses count operator to get the number of odd ints in the array.
     * 
     * Orginal LINQ query:
     * numbers.Count(n => n % 2 == 1);
     */
    public int linq74() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int oddNumbers = new LinqQueriesDb4o_SbqlQuery55(numbers,db).executeQuery();
        return oddNumbers;
    }
    
    /**
     * This sample uses count operator to return a list 
     * of customers and how many orders each has.
     * 
     * Orginal LINQ query:
     * from c in customers
     * select new { c.CustomerID, OrderCount = c.Orders.Count() };
     */
    public Collection<Struct> linq76() {
        Collection<Struct> orderCounts = new LinqQueriesDb4o_SbqlQuery56(db).executeQuery();
        return orderCounts;
    }
    
    /**
     * This sample uses count operator to return a list 
     * of categories and how many products each has.
     * 
     * Orginal LINQ query:
     * from p in products
     * group p by p.Category into g
     * select new { Category = g.Key, ProductCount = g.Count() };
     */
    public Collection<Struct> linq77() {
        Collection<Struct> categoryCounts = new LinqQueriesDb4o_SbqlQuery57(db).executeQuery();
        return categoryCounts;
    }
    
    /**
     * This sample uses sum operator to get the total of the numbers in an array.
     * 
     * Orginal LINQ query:
     * numbers.Sum();
     */
    public int linq78() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int numSum = new LinqQueriesDb4o_SbqlQuery58(numbers,db).executeQuery();
        return numSum;
    }
    
    /**
     * This sample uses sum operator to get the total 
     * number of characters of all words in the array.
     * 
     * Orginal LINQ query:
     * words.Sum(w => w.Length);
     */
    public int linq79() {
        String[] words = {"cherry", "apple", "blueberry"};
        int totalChars = new LinqQueriesDb4o_SbqlQuery59(words,db).executeQuery();
        return totalChars;
    }
    
    /**
     * This sample uses sum operator to get the total units in stock for each product category.
     * 
     * Orginal LINQ query:
     * from p in products
     * group p by p.Category into g
     * select new { Category = g.Key, TotalUnitsInStock = g.Sum(p => p.UnitsInStock) };
     */
    public Collection<Struct> linq80() {
        Collection<Struct> categories = new LinqQueriesDb4o_SbqlQuery60(db).executeQuery();
        return categories;
    }
    
    /**
     * This sample uses min operator to get the lowest number in an array.
     * 
     * Orginal LINQ query:
     * numbers.Min();
     */
    public int linq81() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int minNum = new LinqQueriesDb4o_SbqlQuery61(numbers,db).executeQuery();
        return minNum;
    }
    
    /**
     * This sample uses min operator to get the 
     * length of the shortest word in an array.
     * 
     * Orginal LINQ query:
     * words.Min(w => w.Length);
     */
    public int linq82() {
        String[] words = {"cherry", "apple", "blueberry"};
        int shortestWord = new LinqQueriesDb4o_SbqlQuery62(words,db).executeQuery();
        return shortestWord;
    }
    
    /**
     * This sample uses min operator to get the cheapest 
     * price among each category's products.
     * 
     * Orginal LINQ query:
     * from p in products
     * group p by p.Category into g
     * select new { Category = g.Key, CheapestPrice = g.Min(p => p.UnitPrice) };
     */
    public Collection<Struct> linq83() {
        Collection<Struct> categories = new LinqQueriesDb4o_SbqlQuery63(db).executeQuery();
        return categories;
    }
    
    /**
     * This sample uses min operator to get the products with the cheapest price in each category.
     * 
     * Orginal LINQ query:
     * from p in products
     * group p by p.Category into g
     * let minPrice = g.Min(p => p.UnitPrice)
     * select new { Category = g.Key, CheapestProducts = g.Where(p => p.UnitPrice == minPrice) };
     */
    public Collection<Struct> linq84() {
        Collection<Struct> categories = new LinqQueriesDb4o_SbqlQuery64(db).executeQuery();
        return categories;
    }
    
    /**
     * This sample uses max operator to get the highest number in an array.
     * 
     * Orginal LINQ query:
     * numbers.Max();
     */
    public int linq85() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        int maxNum = new LinqQueriesDb4o_SbqlQuery65(numbers,db).executeQuery();
        return maxNum;
    }
    
    /**
     * This sample uses max operator to get the 
     * length of the longest word in an array.
     * 
     * Orginal LINQ query:
     * words.Max(w => w.Length);
     */
    public int linq86() {
        String[] words = {"cherry", "apple", "blueberry"};
        int longestLength = new LinqQueriesDb4o_SbqlQuery66(words,db).executeQuery();
        return longestLength;
    }
    
    /**
     * This sample uses max operator to get the most expensive 
     * price among each category's products.
     * 
     * Orginal LINQ query:
     * from p in products
     *       group p by p.Category into g
     *       select new { Category = g.Key, MostExpensivePrice = g.Max(p => p.UnitPrice) };
     */
    public Collection<Struct> linq87() {
        Collection<Struct> categories = new LinqQueriesDb4o_SbqlQuery67(db).executeQuery();
        return categories;
    }
    
    /**
     * This sample uses max operator to get the products with the most expensive price in each category.
     * 
     * Orginal LINQ query:
     * from p in products
     * group p by p.Category into g
     * let maxPrice = g.Max(p => p.UnitPrice)
     * select new { Category = g.Key, MostExpensiveProducts = g.Where(p => p.UnitPrice == maxPrice) };
     */
    public Collection<Struct> linq88() {
        Collection<Struct> categories = new LinqQueriesDb4o_SbqlQuery68(db).executeQuery();
        return categories;
    }
    
    /**
     * This sample uses avg operator to get the average of all numbers in an array.
     * 
     * Orginal LINQ query:
     * numbers.Average();
     */
    public double linq89() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        double averageNum = new LinqQueriesDb4o_SbqlQuery69(numbers,db).executeQuery();
        return averageNum;
    }
    
    /**
     * This sample uses avg operator to get the average length of the words in the array.
     * 
     * Orginal LINQ query:
     * words.Average(w => w.Length);
     */
    public double linq90() {
        String[] words = {"cherry", "apple", "blueberry"};
        double averageLength = new LinqQueriesDb4o_SbqlQuery70(words,db).executeQuery();
        return averageLength;
    }
    
    /**
     * This sample uses avg operator to get the average price of each category's products.
     * 
     * Orginal LINQ query:
     * from p in products
     * group p by p.Category into g
     * select new { Category = g.Key, AveragePrice = g.Average(p => p.UnitPrice) };
     */
    public Collection<Struct> linq91() {
        Collection<Struct> categories = new LinqQueriesDb4o_SbqlQuery71(db).executeQuery();
        return categories;
    }
    
    /**
     * This sample uses union operator to create one sequence that 
     * contains each array's values, one after the other.
     * 
     * Orginal LINQ query:
     * numbersA.Concat(numbersB);
     */
    public List<Integer> linq94() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        List<Integer> allNumbers = new LinqQueriesDb4o_SbqlQuery72(numbersA,numbersB,db).executeQuery();
        return allNumbers;
    }
    
    /**
     * This sample uses union operator to create one sequence that contains the 
     * names of all customers and products, including any duplicates.
     * 
     * Orginal LINQ queries:
     *  var customerNames =
     *      from c in customers
     *      select c.CompanyName;
     *  var productNames =
     *      from p in products
     *      select p.ProductName;
     *  var allNames = customerNames.Concat(productNames);
     */
    public Collection<String> linq95() {
        Collection<String> allNames = new LinqQueriesDb4o_SbqlQuery73(db).executeQuery();
        return allNames;
    }
    
    /**
     * This sample check if two sequences match on all elements in the same order.
     * 
     * Orginal LINQ query:
     * wordsA.SequenceEqual(wordsB);
     */
    public Boolean linq96() {
        String[] wordsA = new String[]{"cherry", "apple", "blueberry"};
        String[] wordsB = new String[]{"cherry", "apple", "blueberry"};
        Boolean match = new LinqQueriesDb4o_SbqlQuery74(wordsA,wordsB,db).executeQuery();
        return match;
    }
}