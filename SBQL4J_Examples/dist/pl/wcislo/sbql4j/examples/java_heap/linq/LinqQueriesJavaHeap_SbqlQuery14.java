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


public class LinqQueriesJavaHeap_SbqlQuery14 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers;

    public LinqQueriesJavaHeap_SbqlQuery14(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers) {
        this.customers = customers;
    }

    /**
     * original query='(customers where exists (orders where total < 500.00) join (orders where total < 500.00)).
                        (customerID as customerId, orderID as orderID, total as total)'
     *
     * query after optimization='(customers where  exists (orders where total < 500.0) join orders where total < 500.0).(customerID as customerId, orderID as orderID, total as total)'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_customers =
            customers;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _whereResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        int _whereLoopIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _whereEl1 : _ident_customers) {
            if (_whereEl1 == null) {
                continue;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_whereEl1 == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _whereEl1.orders);
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _whereResult =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>();
            int _whereLoopIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Order _whereEl : _ident_orders) {
                if (_whereEl == null) {
                    continue;
                }

                java.lang.Double _ident_total = ((_whereEl == null) ? null
                                                                    : _whereEl.total);

                Boolean _lessResult = _ident_total < 500.0;

                if (_lessResult) {
                    _whereResult.add(_whereEl);
                }

                _whereLoopIndex++;
            }

            java.lang.Boolean _existsResult = !_whereResult.isEmpty();

            if (_existsResult) {
                _whereResult1.add(_whereEl1);
            }

            _whereLoopIndex1++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _joinEl : _whereResult1) {
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders1 =
                ((_joinEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _joinEl.orders);
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _whereResult2 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>();
            int _whereLoopIndex2 = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Order _whereEl2 : _ident_orders1) {
                if (_whereEl2 == null) {
                    continue;
                }

                java.lang.Double _ident_total1 = ((_whereEl2 == null) ? null
                                                                      : _whereEl2.total);

                Boolean _lessResult1 = _ident_total1 < 500.0;

                if (_lessResult1) {
                    _whereResult2.add(_whereEl2);
                }

                _whereLoopIndex2++;
            }

            _joinResult.addAll(OperatorUtils.cartesianProductSC(_joinEl,
                    _whereResult2, "", ""));
            _joinIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl : _joinResult) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.String _ident_customerID = ((((pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl.getValue(0)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl.getValue(0)).customerID);
            java.lang.String _asResult_customerId = _ident_customerID;
            java.lang.Integer _ident_orderID = ((((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)).orderID);
            java.lang.Integer _asResult_orderID = _ident_orderID;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_customerId,
                    _asResult_orderID, "customerId", "orderID");
            java.lang.Double _ident_total2 = ((((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)).total);
            java.lang.Double _asResult_total = _ident_total2;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_commaResult,
                    _asResult_total, "", "total");
            _queryResult.add(_commaResult1);
            _dotIndex++;
        }

        return _queryResult;
    }
}
