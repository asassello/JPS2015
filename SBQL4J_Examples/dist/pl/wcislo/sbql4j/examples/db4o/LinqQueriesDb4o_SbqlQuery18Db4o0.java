package pl.wcislo.sbql4j.examples.db4o;

import com.db4o.*;

import com.db4o.foundation.*;

import com.db4o.internal.*;
import com.db4o.internal.btree.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.db4o.*;
import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.exception.*;
import pl.wcislo.sbql4j.java.model.runtime.*;
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

import java.text.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;


public class LinqQueriesDb4o_SbqlQuery18Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery18Db4o0() {
    }

    /**
     * query='db.((Customer where  exists orders) as c).($index as custIndex, c.orders as o).("Customer #" + custIndex + 1 + " has an order with OrderID " + o.orderID)'
    '
     **/
    public java.util.Collection<java.lang.String> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_Customer =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        ClassMetadata _classMeta9 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Customer");
        long[] _ids9 = _classMeta9.getIDs(transLocal);

        for (long _id9 : _ids9) {
            LazyObjectReference _ref9 = transLocal.lazyReferenceFor((int) _id9);
            _ident_Customer.add((pl.wcislo.sbql4j.examples.model.linq.Customer) _ref9.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _whereEl : _ident_Customer) {
            if (_whereEl == null) {
                continue;
            }

            if (_whereEl != null) {
                ocb.activate(_whereEl, 1);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_whereEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _whereEl.orders);

            if (_ident_orders != null) {
                ocb.activate(_ident_orders, 2);
            }

            java.lang.Boolean _existsResult = !_ident_orders.isEmpty();

            if (_existsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _asResult_c =
            _whereResult;
        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl1 : _asResult_c) {
            if (_dotEl1 == null) {
                continue;
            }

            if (_dotEl1 != null) {
                ocb.activate(_dotEl1, 2);
            }

            java.lang.Integer _ident_$index = _dotIndex1;
            java.lang.Integer _asResult_custIndex = _ident_$index;
            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c = _dotEl1;

            if (_ident_c != null) {
                ocb.activate(_ident_c, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl = _ident_c;

            if (_ident_c != null) {
                ocb.activate(_ident_c, 2);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders1 =
                ((_dotEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _dotEl.orders);

            if (_ident_orders1 != null) {
                ocb.activate(_ident_orders1, 2);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _asResult_o =
                _ident_orders1;
            java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _commaResult =
                OperatorUtils.cartesianProductSC(_asResult_custIndex,
                    _asResult_o, "custIndex", "o");

            if (_commaResult != null) {
                ocb.activate(_commaResult, 3);
            }

            _dotResult1.addAll(_commaResult);
            _dotIndex1++;
        }

        java.util.Collection<java.lang.String> _dotResult3 = new java.util.ArrayList<java.lang.String>();
        int _dotIndex3 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl3 : _dotResult1) {
            if (_dotEl3 == null) {
                continue;
            }

            if (_dotEl3 != null) {
                ocb.activate(_dotEl3, 1);
            }

            java.lang.Integer _ident_custIndex = (java.lang.Integer) _dotEl3.get(
                    "custIndex");
            java.lang.Integer _plusResult = _ident_custIndex + 1;
            java.lang.String _plusResult1 = "Customer #" + _plusResult;
            java.lang.String _plusResult2 = _plusResult1 +
                " has an order with OrderID ";
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o = (pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl3.get(
                    "o");

            if (_ident_o != null) {
                ocb.activate(_ident_o, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl2 = _ident_o;

            if (_ident_o != null) {
                ocb.activate(_ident_o, 2);
            }

            java.lang.Integer _ident_orderID = ((_dotEl2 == null) ? null
                                                                  : _dotEl2.orderID);

            if (_ident_orderID != null) {
                ocb.activate(_ident_orderID, 1);
            }

            java.lang.String _plusResult3 = _plusResult2 + _ident_orderID;

            if (_plusResult3 != null) {
                ocb.activate(_plusResult3, 1);
            }

            _dotResult3.add(_plusResult3);
            _dotIndex3++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult3, ocb);

        return _dotResult3;
    }
}
