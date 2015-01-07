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


public class LinqQueriesJavaHeap_SbqlQuery15 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers;
    private java.util.Date d;

    public LinqQueriesJavaHeap_SbqlQuery15(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers,
        final java.util.Date d) {
        this.customers = customers;
        this.d = d;
    }

    /**
     * original query='(customers join orders where orderDate > d).
                        (customerID as customerID, orderID as orderID, orderDate as orderDate)'
     *
     * query after optimization='(customers join orders where orderDate > d).(customerID as customerID, orderID as orderID, orderDate as orderDate)'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_customers =
            customers;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _joinEl : _ident_customers) {
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_joinEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _joinEl.orders);
            _joinResult.addAll(OperatorUtils.cartesianProductSC(_joinEl,
                    _ident_orders, "", ""));
            _joinIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _whereResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _whereEl : _joinResult) {
            if (_whereEl == null) {
                continue;
            }

            java.util.Date _ident_orderDate = ((((pl.wcislo.sbql4j.examples.model.linq.Order) _whereEl.getValue(1)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Order) _whereEl.getValue(1)).orderDate);
            java.util.Date _ident_d = d;

            Boolean _moreResult = (_ident_orderDate == null)
                ? ((_ident_orderDate == null) ? false : false)
                : ((_ident_orderDate == null) ? true
                                              : (_ident_orderDate.compareTo(_ident_d) > 0));

            if (_moreResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl : _whereResult) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.String _ident_customerID = ((((pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl.getValue(0)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl.getValue(0)).customerID);
            java.lang.String _asResult_customerID = _ident_customerID;
            java.lang.Integer _ident_orderID = ((((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)).orderID);
            java.lang.Integer _asResult_orderID = _ident_orderID;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_customerID,
                    _asResult_orderID, "customerID", "orderID");
            java.util.Date _ident_orderDate1 = ((((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)).orderDate);
            java.util.Date _asResult_orderDate = _ident_orderDate1;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_commaResult,
                    _asResult_orderDate, "", "orderDate");
            _queryResult.add(_commaResult1);
            _dotIndex++;
        }

        return _queryResult;
    }
}
