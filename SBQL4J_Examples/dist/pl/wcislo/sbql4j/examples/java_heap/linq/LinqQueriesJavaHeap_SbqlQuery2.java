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


public class LinqQueriesJavaHeap_SbqlQuery2 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products;

    public LinqQueriesJavaHeap_SbqlQuery2(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products) {
        this.products = products;
    }

    /**
     * original query='products
                        where unitsInStock > 0 and unitPrice > 3.00'
     *
     * query after optimization='products where unitsInStock > 0 and unitPrice > 3.0'
    */
    public java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products =
            products;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _queryResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Product _whereEl : _ident_products) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.Integer _ident_unitsInStock = ((_whereEl == null) ? null
                                                                        : _whereEl.unitsInStock);

            Boolean _moreResult = _ident_unitsInStock > 0;
            java.lang.Boolean _andResult;

            if (!_moreResult) {
                _andResult = false;
            } else {
                java.lang.Double _ident_unitPrice = ((_whereEl == null) ? null
                                                                        : _whereEl.unitPrice);

                Boolean _moreResult1 = _ident_unitPrice > 3.0;
                _andResult = _moreResult1;
            }

            if (_andResult) {
                _queryResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        return _queryResult;
    }
}
