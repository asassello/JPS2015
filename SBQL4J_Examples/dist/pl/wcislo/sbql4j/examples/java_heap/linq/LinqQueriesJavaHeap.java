package pl.wcislo.sbql4j.examples.java_heap.linq;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Some examples from LINQ <a href="http://msdn.microsoft.com/en-us/vcsharp/aa336746.aspx">examples page</a>
 */
public class LinqQueriesJavaHeap implements ILinqQueries {
    private LinqExampleData data;
    
    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
    }
    
    public LinqQueriesJavaHeap() {
        super();
    }
    
    public LinqExampleData getData() {
        if (this.data == null) {
            this.data = new LinqExampleData();
        }
        return this.data;
    }
    
    public void prepare() {
        getData();
    }
    
    public void shutDown() {
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
        List<Integer> lowNums = new LinqQueriesJavaHeap_SbqlQuery0(numbers).executeQuery();
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
        List<Product> products = getProductList();
        List<Product> soldOutProducts = new LinqQueriesJavaHeap_SbqlQuery1(products).executeQuery();
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
        List<Product> products = getProductList();
        List<Product> expensiveInStockProducts = new LinqQueriesJavaHeap_SbqlQuery2(products).executeQuery();
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
        List<Customer> customers = getCustomerList();
        List<Customer> waCustomers = new LinqQueriesJavaHeap_SbqlQuery3(customers).executeQuery();
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
        List<String> shortDigits = new LinqQueriesJavaHeap_SbqlQuery4(digits).executeQuery();
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
        List<Integer> numsPlusOne = new LinqQueriesJavaHeap_SbqlQuery5(numbers).executeQuery();
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
        List<Product> products = getProductList();
        List<String> productNames = new LinqQueriesJavaHeap_SbqlQuery6(products).executeQuery();
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
        List<String> textNums = new LinqQueriesJavaHeap_SbqlQuery7(numbers,strings).executeQuery();
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
        List<Struct> upperLowerWords = new LinqQueriesJavaHeap_SbqlQuery8(words).executeQuery();
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
        List<Struct> digitOddEvens = new LinqQueriesJavaHeap_SbqlQuery9(numbers,strings).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> productInfos = new LinqQueriesJavaHeap_SbqlQuery10(products).executeQuery();
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
        List<Struct> numsInPlace = new LinqQueriesJavaHeap_SbqlQuery11(numbers).executeQuery();
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
        List<String> lowNums = new LinqQueriesJavaHeap_SbqlQuery12(numbers,digits).executeQuery();
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
        List<Struct> pairs = new LinqQueriesJavaHeap_SbqlQuery13(numbersA,numbersB).executeQuery();
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
        List<Customer> customers = getCustomerList();
        List<Struct> orders = new LinqQueriesJavaHeap_SbqlQuery14(customers).executeQuery();
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
        List<Customer> customers = getCustomerList();
        Calendar c = Calendar.getInstance();
        c.set(1998, Calendar.JANUARY, 1);
        Date d = c.getTime();
        List<Struct> orders = new LinqQueriesJavaHeap_SbqlQuery15(customers,d).executeQuery();
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
        List<Customer> customers = getCustomerList();
        List<Struct> orders = new LinqQueriesJavaHeap_SbqlQuery16(customers).executeQuery();
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
        List<Customer> customers = getCustomerList();
        Calendar c = Calendar.getInstance();
        c.set(1997, 0, 1);
        Date cutoffDate = c.getTime();
        List<Struct> orders = new LinqQueriesJavaHeap_SbqlQuery17(customers,cutoffDate).executeQuery();
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
        List<Customer> customers = getCustomerList();
        List<String> customerOrders = new LinqQueriesJavaHeap_SbqlQuery18(customers).executeQuery();
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
        List<Integer> first3Numbers = new LinqQueriesJavaHeap_SbqlQuery19(numbers).executeQuery();
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
        List<Customer> customers = getCustomerList();
        List<Struct> first3WAOrders = new LinqQueriesJavaHeap_SbqlQuery20(customers).executeQuery();
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
        List<Integer> allButFirst4Numbers = new LinqQueriesJavaHeap_SbqlQuery21(numbers).executeQuery();
        System.out.println("All but first 4 numbers:");
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
        List<Customer> customers = getCustomerList();
        List<Struct> waOrders = new LinqQueriesJavaHeap_SbqlQuery22(customers).executeQuery();
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
        List<String> sortedWords = new LinqQueriesJavaHeap_SbqlQuery23(words).executeQuery();
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
        List<String> sortedWords = new LinqQueriesJavaHeap_SbqlQuery24(words).executeQuery();
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
        List<Product> products = getProductList();
        List<Product> sortedProducts = new LinqQueriesJavaHeap_SbqlQuery25(products).executeQuery();
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
        List<String> sortedWords = new LinqQueriesJavaHeap_SbqlQuery26(words,comp).executeQuery();
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
        List<Double> sortedDoubles = new LinqQueriesJavaHeap_SbqlQuery27(doubles).executeQuery();
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
        List<Product> products = getProductList();
        List<Product> sortedProducts = new LinqQueriesJavaHeap_SbqlQuery28(products).executeQuery();
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
        List<String> sortedWords = new LinqQueriesJavaHeap_SbqlQuery29(words).executeQuery();
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
        List<String> sortedDigits = new LinqQueriesJavaHeap_SbqlQuery30(digits).executeQuery();
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
        List<String> sortedWords = new LinqQueriesJavaHeap_SbqlQuery31(words,comp).executeQuery();
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
        List<Product> products = getProductList();
        List<Product> sortedProducts = new LinqQueriesJavaHeap_SbqlQuery32(products).executeQuery();
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
        List<String> sortedWords = new LinqQueriesJavaHeap_SbqlQuery33(words,comp).executeQuery();
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
        List<Struct> numberGroups = new LinqQueriesJavaHeap_SbqlQuery34(numbers).executeQuery();
        System.out.println(numberGroups);
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
        List<Struct> wordGroups = new LinqQueriesJavaHeap_SbqlQuery35(words).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> orderGroups = new LinqQueriesJavaHeap_SbqlQuery36(products).executeQuery();
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
        List<Customer> customers = getCustomerList();
        List<Struct> customerOrderGroups = new LinqQueriesJavaHeap_SbqlQuery37(customers).executeQuery();
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
        List<Integer> uniqueFactors = new LinqQueriesJavaHeap_SbqlQuery38(factorsOf300).executeQuery();
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
        List<Product> products = getProductList();
        List<String> categoryNames = new LinqQueriesJavaHeap_SbqlQuery39(products).executeQuery();
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
        Collection<Integer> uniqueNumbers = new LinqQueriesJavaHeap_SbqlQuery40(numbersA,numbersB).executeQuery();
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
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        Collection<Character> uniqueFirstChars = new LinqQueriesJavaHeap_SbqlQuery41(products,customers).executeQuery();
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
        Collection<Integer> commonNumbers = new LinqQueriesJavaHeap_SbqlQuery42(numbersA,numbersB).executeQuery();
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
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        Collection<Character> commonFirstChars = new LinqQueriesJavaHeap_SbqlQuery43(products,customers).executeQuery();
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
        Collection<Integer> aOnlyNumbers = new LinqQueriesJavaHeap_SbqlQuery44(numbersA,numbersB).executeQuery();
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
        List<Product> products = getProductList();
        List<Customer> customers = getCustomerList();
        Collection<Character> productOnlyFirstChars = new LinqQueriesJavaHeap_SbqlQuery45(products,customers).executeQuery();
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
        List<Object> doubles = new LinqQueriesJavaHeap_SbqlQuery46(numbers).executeQuery();
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
        List<Product> products = getProductList();
        Product product12 = new LinqQueriesJavaHeap_SbqlQuery47(products).executeQuery();
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
        String startsWithO = new LinqQueriesJavaHeap_SbqlQuery48(strings).executeQuery();
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
        int fourthLowNum = new LinqQueriesJavaHeap_SbqlQuery49(numbers).executeQuery();
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
        Boolean iAfterE = new LinqQueriesJavaHeap_SbqlQuery50(words).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> productGroups = new LinqQueriesJavaHeap_SbqlQuery51(products).executeQuery();
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
        Boolean onlyOdd = new LinqQueriesJavaHeap_SbqlQuery52(numbers).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> productGroups = new LinqQueriesJavaHeap_SbqlQuery53(products).executeQuery();
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
        int uniqueFactors = new LinqQueriesJavaHeap_SbqlQuery54(factorsOf300).executeQuery();
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
        int oddNumbers = new LinqQueriesJavaHeap_SbqlQuery55(numbers).executeQuery();
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
        List<Customer> customers = getCustomerList();
        List<Struct> orderCounts = new LinqQueriesJavaHeap_SbqlQuery56(customers).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> categoryCounts = new LinqQueriesJavaHeap_SbqlQuery57(products).executeQuery();
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
        int numSum = new LinqQueriesJavaHeap_SbqlQuery58(numbers).executeQuery();
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
        int totalChars = new LinqQueriesJavaHeap_SbqlQuery59(words).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> categories = new LinqQueriesJavaHeap_SbqlQuery60(products).executeQuery();
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
        int minNum = new LinqQueriesJavaHeap_SbqlQuery61(numbers).executeQuery();
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
        int shortestWord = new LinqQueriesJavaHeap_SbqlQuery62(words).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> categories = new LinqQueriesJavaHeap_SbqlQuery63(products).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> categories = new LinqQueriesJavaHeap_SbqlQuery64(products).executeQuery();
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
        int maxNum = new LinqQueriesJavaHeap_SbqlQuery65(numbers).executeQuery();
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
        int longestLength = new LinqQueriesJavaHeap_SbqlQuery66(words).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> categories = new LinqQueriesJavaHeap_SbqlQuery67(products).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> categories = new LinqQueriesJavaHeap_SbqlQuery68(products).executeQuery();
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
        double averageNum = new LinqQueriesJavaHeap_SbqlQuery69(numbers).executeQuery();
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
        double averageLength = new LinqQueriesJavaHeap_SbqlQuery70(words).executeQuery();
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
        List<Product> products = getProductList();
        List<Struct> categories = new LinqQueriesJavaHeap_SbqlQuery71(products).executeQuery();
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
        List<Integer> allNumbers = new LinqQueriesJavaHeap_SbqlQuery72(numbersA,numbersB).executeQuery();
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
        List<Customer> customers = getCustomerList();
        List<Product> products = getProductList();
        List<String> allNames = new LinqQueriesJavaHeap_SbqlQuery73(customers,products).executeQuery();
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
        Boolean match = new LinqQueriesJavaHeap_SbqlQuery74(wordsA,wordsB).executeQuery();
        return match;
    }
    
    private List<Product> getProductList() {
        return data.getProductList();
    }
    
    private List<Customer> getCustomerList() {
        return data.getCustomerList();
    }
}