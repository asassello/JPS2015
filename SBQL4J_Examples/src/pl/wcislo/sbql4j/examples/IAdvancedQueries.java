package pl.wcislo.sbql4j.examples;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
import pl.wcislo.sbql4j.java.model.runtime.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.text.*;

import com.db4o.*;

public interface IAdvancedQueries {

	/**
	 * Get departments together with the average salaries of their employees
	 */
	public abstract Collection<Struct> query1();

	/**
	 * Get name, salary and department name for employees earning less than 2222
	 */
	public abstract Collection<Struct> query2();

	/**
	 * Get names of employees working for the department managed by Bert.
	 */
	public abstract Collection<String> query3();

	/**
	 * Get the name of Poe's boss:
	 */
	public abstract String query4();

	/**
	 * Names and cities of employees working in departments managed by Bert
	 */
	public abstract Collection<Struct> query5();

	/**
	 * Get the minimal, average and maximal number of employees in departments
	 */
	public abstract Struct query6();

	/**
	 * For each department get its name and the sum of salaries of employees being not bosses
	 */
	public abstract Collection<Struct> query7();

	/**
	 * Is it true that each department employs an employee earning the same as his/her boss?
	 */
	public abstract Boolean query8();

	/**
	 * For each employee get the message containing his/her name and
	 * the percent of the annual budget of his/her department that is
	 * consumed by his/her monthly salary
	 */
	public abstract Collection<String> query9();

	/**
	 * Get cities hosting all departments
	 */
	public abstract Collection<String> query10();

	/**
	 * For each interval <n,n+999>, n = 0, 1000, 2000, 3000, ... get the message
	 * (string) containing the number of employees having the salary within this interval
	 * and the interval itself.
	 * Output messages should have proper grammatical forms (suffixes -s for nouns (n) and verbs (v)).
	 */
	public abstract Collection<String> query11();

	/**
	 * For each location give the set of department names that are located at it and
	 * the average salary of bosses of these departments, providing that
	 * the number of clerks that are employed at such a location is lower than 100.
	 */
	public abstract Collection<Struct> query12();

	public abstract AdvQueriesData getData();

	public abstract void prepare();

	public abstract void shutDown();

}