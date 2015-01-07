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


public class LinqQueriesJavaHeap_SbqlQuery25 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products;

    public LinqQueriesJavaHeap_SbqlQuery25(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products) {
        this.products = products;
    }

    /**
     * original query='products as p
                        order by p.productName'
     *
     * query after optimization='products as p order by (p.productName)'
    */
    public java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products =
            products;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _asResult_p =
            _ident_products;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _queryResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        _queryResult.addAll(_asResult_p);

        Comparator<pl.wcislo.sbql4j.examples.model.linq.Product> _comparator2 = new Comparator<pl.wcislo.sbql4j.examples.model.linq.Product>() {
                public int compare(
                    pl.wcislo.sbql4j.examples.model.linq.Product _leftObj,
                    pl.wcislo.sbql4j.examples.model.linq.Product _rightObj) {
                    if (_leftObj == null) {
                        return -1;
                    }

                    int res = 0;
                    java.lang.String _leftParam0;

                    {
                        pl.wcislo.sbql4j.examples.model.linq.Product _ident_p = _leftObj;
                        pl.wcislo.sbql4j.examples.model.linq.Product _dotEl = _ident_p;
                        java.lang.String _ident_productName = ((_dotEl == null)
                            ? null : _dotEl.productName);
                        _leftParam0 = _ident_productName;
                    }

                    java.lang.String _rightParam0;

                    {
                        pl.wcislo.sbql4j.examples.model.linq.Product _ident_p = _rightObj;
                        pl.wcislo.sbql4j.examples.model.linq.Product _dotEl = _ident_p;
                        java.lang.String _ident_productName = ((_dotEl == null)
                            ? null : _dotEl.productName);
                        _rightParam0 = _ident_productName;
                    }

                    if (_leftParam0 != null) {
                        res = _leftParam0.compareTo(_rightParam0);
                    } else {
                        return -1;
                    }

                    return res;
                }
            };

        Collections.sort(_queryResult, _comparator2);

        return _queryResult;
    }
}
