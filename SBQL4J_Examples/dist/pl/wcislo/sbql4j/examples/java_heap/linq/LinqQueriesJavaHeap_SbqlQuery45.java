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


public class LinqQueriesJavaHeap_SbqlQuery45 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products;
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers;

    public LinqQueriesJavaHeap_SbqlQuery45(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products,
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers) {
        this.products = products;
        this.customers = customers;
    }

    /**
     * original query='unique(products.productName.charAt(0))
                    minus
                    unique(customers.companyName.charAt(0))'
     *
     * query after optimization=' unique products.productName.charAt(0) minus  unique customers.companyName.charAt(0)'
    */
    public java.util.Collection<java.lang.Character> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products =
            products;
        java.util.List<java.lang.String> _dotResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl : _ident_products) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.String _ident_productName = ((_dotEl == null) ? null
                                                                    : _dotEl.productName);
            _dotResult.add(_ident_productName);
            _dotIndex++;
        }

        java.util.List<java.lang.Character> _dotResult1 = new java.util.ArrayList<java.lang.Character>();
        int _dotIndex1 = 0;

        for (java.lang.String _dotEl1 : _dotResult) {
            if (_dotEl1 == null) {
                continue;
            }

            java.lang.Character _mth_charAtResult = _dotEl1.charAt(0);
            _dotResult1.add(_mth_charAtResult);
            _dotIndex1++;
        }

        java.util.List<java.lang.Character> _uniqueResult = new java.util.ArrayList<java.lang.Character>();
        Set<java.lang.Character> _tmp10 = new LinkedHashSet<java.lang.Character>();
        _tmp10.addAll(_dotResult1);
        _uniqueResult.addAll(_tmp10);

        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_customers =
            customers;
        java.util.List<java.lang.String> _dotResult2 = new java.util.ArrayList<java.lang.String>();
        int _dotIndex2 = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl2 : _ident_customers) {
            if (_dotEl2 == null) {
                continue;
            }

            java.lang.String _ident_companyName = ((_dotEl2 == null) ? null
                                                                     : _dotEl2.companyName);
            _dotResult2.add(_ident_companyName);
            _dotIndex2++;
        }

        java.util.List<java.lang.Character> _dotResult3 = new java.util.ArrayList<java.lang.Character>();
        int _dotIndex3 = 0;

        for (java.lang.String _dotEl3 : _dotResult2) {
            if (_dotEl3 == null) {
                continue;
            }

            java.lang.Character _mth_charAtResult1 = _dotEl3.charAt(0);
            _dotResult3.add(_mth_charAtResult1);
            _dotIndex3++;
        }

        java.util.List<java.lang.Character> _uniqueResult1 = new java.util.ArrayList<java.lang.Character>();
        Set<java.lang.Character> _tmp11 = new LinkedHashSet<java.lang.Character>();
        _tmp11.addAll(_dotResult3);
        _uniqueResult1.addAll(_tmp11);

        Collection _minusLeftCol3 = new ArrayList(_uniqueResult);
        Collection _minusRightCol3 = new ArrayList(_uniqueResult1);
        java.util.Collection<java.lang.Character> _queryResult = new java.util.ArrayList<java.lang.Character>();
        _queryResult.addAll(CollectionUtils.subtract(_minusLeftCol3,
                _minusRightCol3));

        return _queryResult;
    }
}
