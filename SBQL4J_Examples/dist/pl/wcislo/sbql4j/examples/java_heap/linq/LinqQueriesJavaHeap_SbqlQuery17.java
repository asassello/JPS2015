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


public class LinqQueriesJavaHeap_SbqlQuery17 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers;
    private java.util.Date cutoffDate;

    public LinqQueriesJavaHeap_SbqlQuery17(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers,
        final java.util.Date cutoffDate) {
        this.customers = customers;
        this.cutoffDate = cutoffDate;
    }

    /**
     * original query='(customers as c where c.region == "WA" join c.orders as o where o.orderDate >= cutoffDate).
                        (c.customerID as customerID, o.orderID as orderID)'
     *
     * query after optimization='(customers as c where c.region == "WA" join c.orders as o where o.orderDate >= cutoffDate).(c.customerID as customerID, o.orderID as orderID)'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_customers =
            customers;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _asResult_c =
            _ident_customers;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _whereEl : _asResult_c) {
            if (_whereEl == null) {
                continue;
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c = _whereEl;
            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl = _ident_c;
            java.lang.String _ident_region = ((_dotEl == null) ? null
                                                               : _dotEl.region);
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_region,
                    "WA");

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _joinEl : _whereResult) {
            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c1 = _joinEl;
            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl1 = _ident_c1;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_dotEl1 == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _dotEl1.orders);
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _asResult_o =
                _ident_orders;
            _joinResult.addAll(OperatorUtils.cartesianProductSC(_joinEl,
                    _asResult_o, "c", "o"));
            _joinIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _whereResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _whereLoopIndex1 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _whereEl1 : _joinResult) {
            if (_whereEl1 == null) {
                continue;
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o = (pl.wcislo.sbql4j.examples.model.linq.Order) _whereEl1.get(
                    "o");
            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl2 = _ident_o;
            java.util.Date _ident_orderDate = ((_dotEl2 == null) ? null
                                                                 : _dotEl2.orderDate);
            java.util.Date _ident_cutoffDate = cutoffDate;

            Boolean _more_or_equalResult = _ident_orderDate.compareTo(_ident_cutoffDate) >= 0;

            if (_more_or_equalResult) {
                _whereResult1.add(_whereEl1);
            }

            _whereLoopIndex1++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex5 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl5 : _whereResult1) {
            if (_dotEl5 == null) {
                continue;
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c2 = (pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl5.get(
                    "c");
            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl3 = _ident_c2;
            java.lang.String _ident_customerID = ((_dotEl3 == null) ? null
                                                                    : _dotEl3.customerID);
            java.lang.String _asResult_customerID = _ident_customerID;
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o1 = (pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl5.get(
                    "o");
            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl4 = _ident_o1;
            java.lang.Integer _ident_orderID = ((_dotEl4 == null) ? null
                                                                  : _dotEl4.orderID);
            java.lang.Integer _asResult_orderID = _ident_orderID;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_customerID,
                    _asResult_orderID, "customerID", "orderID");
            _queryResult.add(_commaResult);
            _dotIndex5++;
        }

        return _queryResult;
    }
}
