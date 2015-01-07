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


public class LinqQueriesJavaHeap_SbqlQuery60 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products;

    public LinqQueriesJavaHeap_SbqlQuery60(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products) {
        this.products = products;
    }

    /**
     * original query='(unique(products.category) as cat).
                        (cat as category, sum( (products where category == cat).unitsInStock ) as totalUnitsInStock)'
     *
     * query after optimization='( unique products.category as cat).(cat as category,  sum (products where category == cat).unitsInStock as totalUnitsInStock)'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products =
            products;
        java.util.List<java.lang.String> _dotResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl : _ident_products) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.String _ident_category = ((_dotEl == null) ? null
                                                                 : _dotEl.category);
            _dotResult.add(_ident_category);
            _dotIndex++;
        }

        java.util.List<java.lang.String> _uniqueResult = new java.util.ArrayList<java.lang.String>();
        Set<java.lang.String> _tmp16 = new LinkedHashSet<java.lang.String>();
        _tmp16.addAll(_dotResult);
        _uniqueResult.addAll(_tmp16);

        java.util.List<java.lang.String> _asResult_cat = _uniqueResult;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex2 = 0;

        for (java.lang.String _dotEl2 : _asResult_cat) {
            if (_dotEl2 == null) {
                continue;
            }

            java.lang.String _ident_cat = _dotEl2;
            java.lang.String _asResult_category = _ident_cat;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products1 =
                products;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _whereResult =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
            int _whereLoopIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _whereEl : _ident_products1) {
                if (_whereEl == null) {
                    continue;
                }

                java.lang.String _ident_category1 = ((_whereEl == null) ? null
                                                                        : _whereEl.category);
                java.lang.String _ident_cat1 = _dotEl2;
                java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_category1,
                        _ident_cat1);

                if (_equalsResult) {
                    _whereResult.add(_whereEl);
                }

                _whereLoopIndex++;
            }

            java.util.List<java.lang.Integer> _dotResult1 = new java.util.ArrayList<java.lang.Integer>();
            int _dotIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl1 : _whereResult) {
                if (_dotEl1 == null) {
                    continue;
                }

                java.lang.Integer _ident_unitsInStock = ((_dotEl1 == null)
                    ? null : _dotEl1.unitsInStock);
                _dotResult1.add(_ident_unitsInStock);
                _dotIndex1++;
            }

            Number _sum2 = null;

            for (Number _sumEl2 : _dotResult1) {
                _sum2 = MathUtils.sum(_sum2, _sumEl2);
            }

            java.lang.Integer _sumResult = (java.lang.Integer) _sum2;
            java.lang.Integer _asResult_totalUnitsInStock = _sumResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_category,
                    _asResult_totalUnitsInStock, "category", "totalUnitsInStock");
            _queryResult.add(_commaResult);
            _dotIndex2++;
        }

        return _queryResult;
    }
}