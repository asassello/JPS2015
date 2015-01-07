package pl.wcislo.sbql4j.examples.java_heap.linq;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.exception.*;
import pl.wcislo.sbql4j.java.model.compiletime.Signature.SCollectionType;
import pl.wcislo.sbql4j.java.model.runtime.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import pl.wcislo.sbql4j.java.model.runtime.factory.*;
import pl.wcislo.sbql4j.java.utils.ArrayUtils;
import pl.wcislo.sbql4j.java.utils.OperatorUtils;
import pl.wcislo.sbql4j.java.utils.Pair;
import pl.wcislo.sbql4j.lang.codegen.nostacks.*;
import pl.wcislo.sbql4j.lang.codegen.simple.*;
import pl.wcislo.sbql4j.lang.db4o.*;
import pl.wcislo.sbql4j.lang.db4o.codegen.*;
import pl.wcislo.sbql4j.lang.db4o.codegen.interpreter.*;
import pl.wcislo.sbql4j.lang.db4o.codegen.nostacks.*;
import pl.wcislo.sbql4j.lang.parser.expression.*;
import pl.wcislo.sbql4j.lang.parser.expression.OrderByParamExpression.SortType;
import pl.wcislo.sbql4j.lang.parser.terminals.*;
import pl.wcislo.sbql4j.lang.parser.terminals.operators.*;
import pl.wcislo.sbql4j.lang.types.*;
import pl.wcislo.sbql4j.lang.xml.*;
import pl.wcislo.sbql4j.model.*;
import pl.wcislo.sbql4j.model.collections.*;
import pl.wcislo.sbql4j.util.*;
import pl.wcislo.sbql4j.util.Utils;
import pl.wcislo.sbql4j.xml.model.*;
import pl.wcislo.sbql4j.xml.parser.store.*;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.*;


public class LinqQueriesJavaHeap_SbqlQuery73 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers;
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products;

    public LinqQueriesJavaHeap_SbqlQuery73(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers,
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products) {
        this.customers = customers;
        this.products = products;
    }

    /**
     * original query='customers.companyName
                        union
                        products.productName'
     *
     * query after optimization='customers.companyName union products.productName'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_customers =
            customers;
        java.util.List<java.lang.String> _dotResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl : _ident_customers) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.String _ident_companyName = ((_dotEl == null) ? null
                                                                    : _dotEl.companyName);
            _dotResult.add(_ident_companyName);
            _dotIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products =
            products;
        java.util.List<java.lang.String> _dotResult1 = new java.util.ArrayList<java.lang.String>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl1 : _ident_products) {
            if (_dotEl1 == null) {
                continue;
            }

            java.lang.String _ident_productName = ((_dotEl1 == null) ? null
                                                                     : _dotEl1.productName);
            _dotResult1.add(_ident_productName);
            _dotIndex1++;
        }

        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        _queryResult.addAll(_dotResult);
        _queryResult.addAll(_dotResult1);

        return _queryResult;
    }
}
