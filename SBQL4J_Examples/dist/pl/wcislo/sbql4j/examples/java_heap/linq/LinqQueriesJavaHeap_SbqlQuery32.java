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


public class LinqQueriesJavaHeap_SbqlQuery32 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products;

    public LinqQueriesJavaHeap_SbqlQuery32(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products) {
        this.products = products;
    }

    /**
     * original query='products
                    order by category; unitPrice desc'
     *
     * query after optimization='products order by (category, unitPrice DESC )'
    */
    public java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products =
            products;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _queryResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        _queryResult.addAll(_ident_products);

        Comparator<pl.wcislo.sbql4j.examples.model.linq.Product> _comparator9 = new Comparator<pl.wcislo.sbql4j.examples.model.linq.Product>() {
                public int compare(
                    pl.wcislo.sbql4j.examples.model.linq.Product _leftObj,
                    pl.wcislo.sbql4j.examples.model.linq.Product _rightObj) {
                    if (_leftObj == null) {
                        return -1;
                    }

                    int res = 0;
                    java.lang.String _leftParam0;

                    {
                        java.lang.String _ident_category = ((_leftObj == null)
                            ? null : _leftObj.category);
                        _leftParam0 = _ident_category;
                    }

                    java.lang.String _rightParam0;

                    {
                        java.lang.String _ident_category = ((_rightObj == null)
                            ? null : _rightObj.category);
                        _rightParam0 = _ident_category;
                    }

                    if (_leftParam0 != null) {
                        res = _leftParam0.compareTo(_rightParam0);
                    } else {
                        return -1;
                    }

                    if (res != 0) {
                        return res;
                    }

                    java.lang.Double _leftParam1;

                    {
                        java.lang.Double _ident_unitPrice = ((_leftObj == null)
                            ? null : _leftObj.unitPrice);
                        _leftParam1 = _ident_unitPrice;
                    }

                    java.lang.Double _rightParam1;

                    {
                        java.lang.Double _ident_unitPrice = ((_rightObj == null)
                            ? null : _rightObj.unitPrice);
                        _rightParam1 = _ident_unitPrice;
                    }

                    if (_leftParam1 != null) {
                        res = _leftParam1.compareTo(_rightParam1);
                    } else {
                        return 1;
                    }

                    return -res;
                }
            };

        Collections.sort(_queryResult, _comparator9);

        return _queryResult;
    }
}
