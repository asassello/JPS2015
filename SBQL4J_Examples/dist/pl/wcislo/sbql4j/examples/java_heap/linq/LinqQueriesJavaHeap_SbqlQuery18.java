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


public class LinqQueriesJavaHeap_SbqlQuery18 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers;

    public LinqQueriesJavaHeap_SbqlQuery18(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers) {
        this.customers = customers;
    }

    /**
     * original query='((customers where exists orders) as c).
                        ($index as custIndex, c.orders as o).
                        ("Customer #"+(custIndex + 1)+" has an order with OrderID "+o.orderID)'
     *
     * query after optimization='((customers where  exists orders) as c).($index as custIndex, c.orders as o).("Customer #" + custIndex + 1 + " has an order with OrderID " + o.orderID)'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_customers =
            customers;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _whereEl : _ident_customers) {
            if (_whereEl == null) {
                continue;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_whereEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _whereEl.orders);
            java.lang.Boolean _existsResult = !_ident_orders.isEmpty();

            if (_existsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _asResult_c =
            _whereResult;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult1 = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl1 : _asResult_c) {
            if (_dotEl1 == null) {
                continue;
            }

            java.lang.Integer _ident_$index = _dotIndex1;
            java.lang.Integer _asResult_custIndex = _ident_$index;
            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c = _dotEl1;
            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl = _ident_c;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders1 =
                ((_dotEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _dotEl.orders);
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _asResult_o =
                _ident_orders1;
            java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _commaResult =
                OperatorUtils.cartesianProductSC(_asResult_custIndex,
                    _asResult_o, "custIndex", "o");
            _dotResult1.addAll(_commaResult);
            _dotIndex1++;
        }

        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex3 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl3 : _dotResult1) {
            if (_dotEl3 == null) {
                continue;
            }

            java.lang.Integer _ident_custIndex = (java.lang.Integer) _dotEl3.get(
                    "custIndex");
            java.lang.Integer _plusResult = _ident_custIndex + 1;
            java.lang.String _plusResult1 = "Customer #" + _plusResult;
            java.lang.String _plusResult2 = _plusResult1 +
                " has an order with OrderID ";
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o = (pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl3.get(
                    "o");
            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl2 = _ident_o;
            java.lang.Integer _ident_orderID = ((_dotEl2 == null) ? null
                                                                  : _dotEl2.orderID);
            java.lang.String _plusResult3 = _plusResult2 + _ident_orderID;
            _queryResult.add(_plusResult3);
            _dotIndex3++;
        }

        return _queryResult;
    }
}
