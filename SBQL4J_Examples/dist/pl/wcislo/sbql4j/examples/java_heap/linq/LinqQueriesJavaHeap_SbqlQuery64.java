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


public class LinqQueriesJavaHeap_SbqlQuery64 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products;

    public LinqQueriesJavaHeap_SbqlQuery64(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products) {
        this.products = products;
    }

    /**
     * original query='(unique(products.category) as cat).
                        (cat as cat, (products where category == cat) group as pr).
                        (cat as category, (pr where unitPrice == min(pr.unitPrice)) group as cheapestProducts)'
     *
     * query after optimization='( unique products.category as cat).(cat as cat, (products where category == cat) group as pr).(cat as category, ( min(pr.unitPrice) group as _aux0).(pr where unitPrice == _aux0) group as cheapestProducts)'
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
        Set<java.lang.String> _tmp18 = new LinkedHashSet<java.lang.String>();
        _tmp18.addAll(_dotResult);
        _uniqueResult.addAll(_tmp18);

        java.util.List<java.lang.String> _asResult_cat = _uniqueResult;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult1 = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex1 = 0;

        for (java.lang.String _dotEl1 : _asResult_cat) {
            if (_dotEl1 == null) {
                continue;
            }

            java.lang.String _ident_cat = _dotEl1;
            java.lang.String _asResult_cat1 = _ident_cat;
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
                java.lang.String _ident_cat1 = _dotEl1;
                java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_category1,
                        _ident_cat1);

                if (_equalsResult) {
                    _whereResult.add(_whereEl);
                }

                _whereLoopIndex++;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _groupAsResultpr =
                _whereResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_cat1,
                    _groupAsResultpr, "cat", "pr");
            _dotResult1.add(_commaResult);
            _dotIndex1++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex4 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl4 : _dotResult1) {
            if (_dotEl4 == null) {
                continue;
            }

            java.lang.String _ident_cat2 = (java.lang.String) _dotEl4.get("cat");
            java.lang.String _asResult_category = _ident_cat2;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_pr =
                (java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product>) _dotEl4.get(
                    "pr");
            java.util.List<java.lang.Double> _dotResult2 = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex2 = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl2 : _ident_pr) {
                if (_dotEl2 == null) {
                    continue;
                }

                java.lang.Double _ident_unitPrice = ((_dotEl2 == null) ? null
                                                                       : _dotEl2.unitPrice);
                _dotResult2.add(_ident_unitPrice);
                _dotIndex2++;
            }

            Number _min3 = null;

            for (Number _minEl3 : _dotResult2) {
                _min3 = MathUtils.min(_min3, _minEl3);
            }

            java.lang.Double _minResult = (java.lang.Double) _min3;
            java.lang.Double _groupAsResult_aux0 = _minResult;
            java.lang.Double _dotEl3 = _groupAsResult_aux0;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_pr1 =
                (java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product>) _dotEl4.get(
                    "pr");
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _whereResult1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
            int _whereLoopIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _whereEl1 : _ident_pr1) {
                if (_whereEl1 == null) {
                    continue;
                }

                java.lang.Double _ident_unitPrice1 = ((_whereEl1 == null)
                    ? null : _whereEl1.unitPrice);
                java.lang.Double _ident__aux0 = _dotEl3;
                java.lang.Boolean _equalsResult1 = OperatorUtils.equalsSafe(_ident_unitPrice1,
                        _ident__aux0);

                if (_equalsResult1) {
                    _whereResult1.add(_whereEl1);
                }

                _whereLoopIndex1++;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _groupAsResultcheapestProducts =
                _whereResult1;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_asResult_category,
                    _groupAsResultcheapestProducts, "category",
                    "cheapestProducts");
            _queryResult.add(_commaResult1);
            _dotIndex4++;
        }

        return _queryResult;
    }
}
