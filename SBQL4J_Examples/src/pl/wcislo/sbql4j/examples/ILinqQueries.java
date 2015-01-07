package pl.wcislo.sbql4j.examples;

import java.util.Collection;
import java.util.List;

import pl.wcislo.sbql4j.examples.model.linq.Customer;
import pl.wcislo.sbql4j.examples.model.linq.LinqExampleData;
import pl.wcislo.sbql4j.examples.model.linq.Product;
import pl.wcislo.sbql4j.java.model.runtime.Struct;

public interface ILinqQueries {

	/**
	 * This sample uses where to find all elements of an array less than 5.
	 * 
	 * Orginal LINQ query:
	 * from n in numbers
	 * where n < 5
	 * select n; 
	 */
	public abstract List<Integer> linq1();

	/**
	 * This sample uses where to find all products that are out of stock.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * where p.UnitsInStock == 0
	 * select p;
	 */
	public abstract Collection<Product> linq2();

	/**
	 * This sample uses where to find all products that are in stock and cost more than 3.00 per unit.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 *      where p.UnitsInStock > 0 && p.UnitPrice > 3.00M
	 *      select p;
	 */
	public abstract Collection<Product> linq3();

	/**
	 * This sample uses where to find all customers in Washington and then 
	 * uses the resulting sequence to drill down into their orders.
	 * 
	 * Orginal LINQ query:
	 * from c in customers
	 *         where c.Region == "WA"
	 *          select c;
	 */
	public abstract Collection<Customer> linq4();

	/**
	 * This sample demonstrates an indexed Where clause that 
	 * returns digits whose name is shorter than their value.
	 * 
	 * Orginal LINQ query:
	 * digits.Where((digit, index) => digit.Length < index);
	 */
	public abstract List<String> linq5();

	/**
	 * This sample uses select to produce a sequence of 
	 * ints one higher than those in an existing array of ints.
	 * 
	 * Orginal LINQ query:
	 * from n in numbers
	 * select n + 1;
	 */
	public abstract List<Integer> linq6();

	/**
	 * This sample uses select to return a sequence of just the names of a list of products.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * select p.ProductName;
	 */
	public abstract Collection<String> linq7();

	/**
	 * This sample uses select to produce a sequence of strings representing 
	 * the text version of a sequence of ints.
	 * 
	 * Orginal LINQ query:
	 * from n in numbers
	 * select strings[n];
	 */
	public abstract List<String> linq8();

	/**
	 * This sample uses select to produce a sequence of the uppercase
	 * and lowercase versions of each word in the original array.
	 * 
	 * Orginal LINQ query:
	 * from w in words
	 * select new {Upper = w.ToUpper(), Lower = w.ToLower()};
	 */
	public abstract List<Struct> linq9();

	/**
	 * This sample uses select to produce a sequence containing text
	 * representations of digits and whether their length is even or odd.
	 * 
	 * Orginal LINQ query:
	 * from n in numbers
	 * select new {Digit = strings[n], Even = (n % 2 == 0)};
	 */
	public abstract List<Struct> linq10();

	/**
	 * This sample uses select to produce a sequence containing some properties
	 * of Products, including UnitPrice which is renamed to Price
	 * in the resulting type.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * select new {p.ProductName, p.Category, Price = p.UnitPrice};
	 */
	public abstract Collection<Struct> linq11();

	/**
	 * This sample uses an loop index to determine if the value of ints
	 * in an array match their position in the array.
	 * 
	 * Orginal LINQ query:
	 * numbers.Select((num, index) => new {Num = num, InPlace = (num == index)});
	 */
	public abstract List<Struct> linq12();

	/**
	 * This sample combines select and where to make a simple query that returns
	 * the text form of each digit less than 5.
	 * 
	 * Orginal LINQ query:
	 * from n in numbers
	 *      where n < 5
	 *      select digits[n];
	 */
	public abstract List<String> linq13();

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
	public abstract List<Struct> linq14();

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
	public abstract Collection<Struct> linq15();

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
	public abstract Collection<Struct> linq16();

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
	public abstract List<Struct> linq17();

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
	public abstract List<Struct> linq18();

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
	public abstract Collection<String> linq19();

	/**
	 * This sample uses an range operator to get only the first 3 elements of the array.
	 * 
	 * Orginal LINQ query:
	 * numbers.Take(3);
	 */
	public abstract List<Integer> linq20();

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
	public abstract List<Struct> linq21();

	/**
	 * This sample uses an range operator to get all but the first 4 elements of the array.
	 * 
	 * Orginal LINQ query:
	 * numbers.Skip(4);
	 */
	public abstract List<Integer> linq22();

	/**
	 * This sample uses an range operator to get all but the first 2 orders from customers in Washington.
	 * 
	 * Orginal LINQ query:
	 * from c in customers
	 * from o in c.Orders
	 * where c.Region == "WA"
	 * select new { c.CustomerID, o.OrderID, o.OrderDate };
	 */
	public abstract List<Struct> linq23();

	/**
	 * This sample uses orderby to sort a list of words alphabetically.
	 * 
	 * Orginal LINQ query:
	 * from w in words
	 * orderby w
	 * select w;
	 */
	public abstract List<String> linq28();

	/**
	 * This sample uses orderby to sort a list of words by length.
	 * 
	 * Orginal LINQ query:
	 * 
	 * from w in words
	 * orderby w.Length
	 * select w;
	 */
	public abstract List<String> linq29();

	/**
	 * This sample uses an order by operator to sort a list of products by name.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * orderby p.ProductName
	 * select p;
	 */
	public abstract List<Product> linq30();

	/**
	 * This sample uses an order by operator clause with a custom comparer to do 
	 * a case-insensitive sort of the words in an array.
	 * 
	 * Orginal LINQ query:
	 * words.OrderBy(a => a, new CaseInsensitiveComparer());
	 */
	public abstract List<String> linq31();

	/**
	 * This sample uses an order by operator and descending to 
	 * sort a list of doubles from highest to lowest.
	 * 
	 * Orginal LINQ query:
	 * from d in doubles
	 * orderby d descending
	 * select d;
	 */
	public abstract List<Double> linq32();

	/**
	 * This sample uses an order by operator to sort a list 
	 * of products by units in stock from highest to lowest.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 *     orderby p.UnitsInStock descending
	 *     select p;
	 */
	public abstract List<Product> linq33();

	/**
	 * This sample uses an order by operator with a custom comparer to do a case-insensitive 
	 * descending sort of the words in an array.
	 * 
	 * Orginal LINQ query:
	 * words.OrderByDescending(a => a, new CaseInsensitiveComparer());
	 */
	public abstract List<String> linq34();

	/**
	 * This sample uses an order by operator to sort a list of digits, 
	 * first by length of their name, and then alphabetically by the name itself.
	 * 
	 * Orginal LINQ query:
	 * from d in digits
	 * orderby d.Length, d
	 * select d;
	 */
	public abstract List<String> linq35();

	/**
	 * This sample uses an order by operator with a custom comparer to sort first
	 * by word length and then by a case-insensitive sort of the words in an array.
	 * 
	 * Orginal LINQ query:
	 * words.OrderBy(a => a.Length)
	 * .ThenBy(a => a, new CaseInsensitiveComparer());
	 */
	public abstract List<String> linq36();

	/**
	 * This sample uses an order by operator to sort a list of products,
	 * first by category, and then by unit price, from highest to lowest.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * orderby p.Category, p.UnitPrice descending
	 * select p;
	 */
	public abstract List<Product> linq37();

	/**
	 * This sample uses an order by operator with a custom comparer to sort 
	 * first by word length and then by a case-insensitive descending sort of the words in an array.
	 * 
	 * Orginal LINQ query:
	 * words.OrderBy(a => a.Length)
	 * .ThenByDescending(a => a, new CaseInsensitiveComparer());
	 */
	public abstract List<String> linq38();

	/**
	 * This sample partition a list of numbers by their remainder when divided by 5.
	 * 
	 * Orginal LINQ query:
	 * from n in numbers
	 * group n by n % 5 into g
	 * select new { Remainder = g.Key, Numbers = g };
	 */
	public abstract List<Struct> linq40();

	/**
	 * This sample partition a list of words by their first letter.
	 * 
	 * Orginal LINQ query:
	 * from w in words
	 * group w by w[0] into g
	 * select new { FirstLetter = g.Key, Words = g };
	 */
	public abstract List<Struct> linq41();

	/**
	 * This sample partition a list of products by category.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * group p by p.Category into g
	 * select new { Category = g.Key, Products = g };
	 */
	public abstract Collection<Struct> linq42();

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
	public abstract Collection<Struct> linq43();

	/**
	 * This sample uses unique operator to remove duplicate 
	 * elements in a sequence of factors of 300.
	 * 
	 * Orginal LINQ query:
	 * factorsOf300.Distinct();
	 */
	public abstract List<Integer> linq46();

	/**
	 * This sample uses unique operator to find the unique Category names.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 *      select p.Category)
	 *      .Distinct();
	 */
	public abstract Collection<String> linq47();

	/**
	 * This sample uses union operator to create one sequence 
	 * that contains the unique values from both arrays.
	 * 
	 * Orginal LINQ query:
	 * numbersA.Union(numbersB);
	 */
	public abstract Collection<Integer> linq48();

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
	public abstract Collection<Character> linq49();

	/**
	 * This sample uses intersect operator to create one sequence that 
	 * contains the common values shared by both arrays.
	 * 
	 * Orginal LINQ query:
	 * numbersA.Intersect(numbersB);
	 */
	public abstract Collection<Integer> linq50();

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
	public abstract Collection<Character> linq51();

	/**
	 * This sample uses minus operator to create a sequence that 
	 * contains the values from numbersAthat are not also in numbersB.
	 * 
	 * Orginal LINQ query:
	 * numbersA.Except(numbersB);
	 */
	public abstract Collection<Integer> linq52();

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
	public abstract Collection<Character> linq53();

	/**
	 * This sample uses instanceof operator to return only 
	 * the elements of the array that are of type double.
	 * 
	 * Orginal LINQ query:
	 * numbers.OfType<double>();
	 */
	public abstract List<Object> linq57();

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
	public abstract Product linq58();

	/**
	 * This sample uses range operator to find the first element in the array that starts with 'o'.
	 * 
	 * Orginal LINQ query:
	 * strings.First(s => s[0] == 'o');
	 */
	public abstract String linq59();

	/**
	 * This sample uses range operator to retrieve the second number greater than 5 from an array.
	 * 
	 * Orginal LINQ query:
	 * (from n in numbers
	 *  where n > 5
	 *  select n)
	 * .ElementAt(1)
	 */
	public abstract int linq64();

	/**
	 * This sample uses any operator to determine if any of the words
	 * in the array contain the substring 'ei'.
	 * 
	 * Orginal LINQ query:
	 * words.Any(w => w.Contains("ei"));
	 */
	public abstract Boolean linq67();

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
	public abstract Collection<Struct> linq69();

	/**
	 * This sample uses all operator to determine whether an array contains only odd numbers.
	 * 
	 * Orginal LINQ query:
	 * numbers.All(n => n % 2 == 1);
	 */
	public abstract Boolean linq70();

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
	public abstract Collection<Struct> linq72();

	/**
	 * This sample uses count operator to get the number of unique factors of 300.
	 * 
	 * Orginal LINQ query:
	 * factorsOf300.Distinct().Count();
	 */
	public abstract int linq73();

	/**
	 * This sample uses count operator to get the number of odd ints in the array.
	 * 
	 * Orginal LINQ query:
	 * numbers.Count(n => n % 2 == 1);
	 */
	public abstract int linq74();

	/**
	 * This sample uses count operator to return a list 
	 * of customers and how many orders each has.
	 * 
	 * Orginal LINQ query:
	 * from c in customers
	 * select new { c.CustomerID, OrderCount = c.Orders.Count() };
	 */
	public abstract Collection<Struct> linq76();

	/**
	 * This sample uses count operator to return a list 
	 * of categories and how many products each has.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * group p by p.Category into g
	 * select new { Category = g.Key, ProductCount = g.Count() };
	 */
	public abstract Collection<Struct> linq77();

	/**
	 * This sample uses sum operator to get the total of the numbers in an array.
	 * 
	 * Orginal LINQ query:
	 * numbers.Sum();
	 */
	public abstract int linq78();

	/**
	 * This sample uses sum operator to get the total 
	 * number of characters of all words in the array.
	 * 
	 * Orginal LINQ query:
	 * words.Sum(w => w.Length);
	 */
	public abstract int linq79();

	/**
	 * This sample uses sum operator to get the total units in stock for each product category.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * group p by p.Category into g
	 * select new { Category = g.Key, TotalUnitsInStock = g.Sum(p => p.UnitsInStock) };
	 */
	public abstract Collection<Struct> linq80();

	/**
	 * This sample uses min operator to get the lowest number in an array.
	 * 
	 * Orginal LINQ query:
	 * numbers.Min();
	 */
	public abstract int linq81();

	/**
	 * This sample uses min operator to get the 
	 * length of the shortest word in an array.
	 * 
	 * Orginal LINQ query:
	 * words.Min(w => w.Length);
	 */
	public abstract int linq82();

	/**
	 * This sample uses min operator to get the cheapest 
	 * price among each category's products.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * group p by p.Category into g
	 * select new { Category = g.Key, CheapestPrice = g.Min(p => p.UnitPrice) };
	 */
	public abstract Collection<Struct> linq83();

	/**
	 * This sample uses min operator to get the products with the cheapest price in each category.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * group p by p.Category into g
	 * let minPrice = g.Min(p => p.UnitPrice)
	 * select new { Category = g.Key, CheapestProducts = g.Where(p => p.UnitPrice == minPrice) };
	 */
	public abstract Collection<Struct> linq84();

	/**
	 * This sample uses max operator to get the highest number in an array.
	 * 
	 * Orginal LINQ query:
	 * numbers.Max();
	 */
	public abstract int linq85();

	/**
	 * This sample uses max operator to get the 
	 * length of the longest word in an array.
	 * 
	 * Orginal LINQ query:
	 * words.Max(w => w.Length);
	 */
	public abstract int linq86();

	/**
	 * This sample uses max operator to get the most expensive 
	 * price among each category's products.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 *       group p by p.Category into g
	 *       select new { Category = g.Key, MostExpensivePrice = g.Max(p => p.UnitPrice) };
	 */
	public abstract Collection<Struct> linq87();

	/**
	 * This sample uses max operator to get the products with the most expensive price in each category.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * group p by p.Category into g
	 * let maxPrice = g.Max(p => p.UnitPrice)
	 * select new { Category = g.Key, MostExpensiveProducts = g.Where(p => p.UnitPrice == maxPrice) };
	 */
	public abstract Collection<Struct> linq88();

	/**
	 * This sample uses avg operator to get the average of all numbers in an array.
	 * 
	 * Orginal LINQ query:
	 * numbers.Average();
	 */
	public abstract double linq89();

	/**
	 * This sample uses avg operator to get the average length of the words in the array.
	 * 
	 * Orginal LINQ query:
	 * words.Average(w => w.Length);
	 */
	public abstract double linq90();

	/**
	 * This sample uses avg operator to get the average price of each category's products.
	 * 
	 * Orginal LINQ query:
	 * from p in products
	 * group p by p.Category into g
	 * select new { Category = g.Key, AveragePrice = g.Average(p => p.UnitPrice) };
	 */
	public abstract Collection<Struct> linq91();

	/**
	 * This sample uses union operator to create one sequence that 
	 * contains each array's values, one after the other.
	 * 
	 * Orginal LINQ query:
	 * numbersA.Concat(numbersB);
	 */
	public abstract List<Integer> linq94();

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
	public abstract Collection<String> linq95();

	/**
	 * This sample check if two sequences match on all elements in the same order.
	 * 
	 * Orginal LINQ query:
	 * wordsA.SequenceEqual(wordsB);
	 */
	public abstract Boolean linq96();

	public abstract LinqExampleData getData();
	
	public abstract void prepare();
	public abstract void shutDown();

//	public abstract ObjectContainer getConnection();

}