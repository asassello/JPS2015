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


public class LinqQueriesJavaHeap_SbqlQuery16 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers;

    public LinqQueriesJavaHeap_SbqlQuery16(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers) {
        this.customers = customers;
    }

    /**
     * original query='(customers as c join (c.orders as o where o.total > 2000) as j where exists (j)).
                        (c.customerID as customerID, j.o.orderID as orderID, j.o.total as total)'
     *
     * query after optimization='(customers as c join (c.orders as o where o.total > 2000) as j where  exists j).(c.customerID as customerID, j.o.orderID as orderID, j.o.total as total)'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_customers =
            customers;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _asResult_c =
            _ident_customers;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _joinEl : _asResult_c) {
            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c = _joinEl;
            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl = _ident_c;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_dotEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _dotEl.orders);
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _asResult_o =
                _ident_orders;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _whereResult =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>();
            int _whereLoopIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Order _whereEl : _asResult_o) {
                if (_whereEl == null) {
                    continue;
                }

                pl.wcislo.sbql4j.examples.model.linq.Order _ident_o = _whereEl;
                pl.wcislo.sbql4j.examples.model.linq.Order _dotEl1 = _ident_o;
                java.lang.Double _ident_total = ((_dotEl1 == null) ? null
                                                                   : _dotEl1.total);

                Boolean _moreResult = _ident_total > 2000;

                if (_moreResult) {
                    _whereResult.add(_whereEl);
                }

                _whereLoopIndex++;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _asResult_j =
                _whereResult;
            _joinResult.addAll(OperatorUtils.cartesianProductSC(_joinEl,
                    _asResult_j, "c", "j"));
            _joinIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _whereResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _whereLoopIndex1 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _whereEl1 : _joinResult) {
            if (_whereEl1 == null) {
                continue;
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _ident_j = (pl.wcislo.sbql4j.examples.model.linq.Order) _whereEl1.get(
                    "j");
            java.lang.Boolean _existsResult = _ident_j != null;

            if (_existsResult) {
                _whereResult1.add(_whereEl1);
            }

            _whereLoopIndex1++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex7 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl7 : _whereResult1) {
            if (_dotEl7 == null) {
                continue;
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c1 = (pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl7.get(
                    "c");
            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl2 = _ident_c1;
            java.lang.String _ident_customerID = ((_dotEl2 == null) ? null
                                                                    : _dotEl2.customerID);
            java.lang.String _asResult_customerID = _ident_customerID;
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_j1 = (pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl7.get(
                    "j");
            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl3 = _ident_j1;
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o1 = _dotEl3;
            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl4 = _ident_o1;
            java.lang.Integer _ident_orderID = ((_dotEl4 == null) ? null
                                                                  : _dotEl4.orderID);
            java.lang.Integer _asResult_orderID = _ident_orderID;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_customerID,
                    _asResult_orderID, "customerID", "orderID");
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_j2 = (pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl7.get(
                    "j");
            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl5 = _ident_j2;
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o2 = _dotEl5;
            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl6 = _ident_o2;
            java.lang.Double _ident_total1 = ((_dotEl6 == null) ? null
                                                                : _dotEl6.total);
            java.lang.Double _asResult_total = _ident_total1;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_commaResult,
                    _asResult_total, "", "total");
            _queryResult.add(_commaResult1);
            _dotIndex7++;
        }

        return _queryResult;
    }
}
