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


public class LinqQueriesDb4o_SbqlQuery22Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery22Db4o0() {
    }

    /**
     * query='db.((Customer as c where c.region == "WA" and  exists c.orders join c.orders as o)[2..*]).(c.customerID as customerID, o.orderID as orderID, o.orderDate as orderDate)'
    '
     **/
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_Customer =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        ClassMetadata _classMeta11 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Customer");
        long[] _ids11 = _classMeta11.getIDs(transLocal);

        for (long _id11 : _ids11) {
            LazyObjectReference _ref11 = transLocal.lazyReferenceFor((int) _id11);
            _ident_Customer.add((pl.wcislo.sbql4j.examples.model.linq.Customer) _ref11.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _asResult_c =
            _ident_Customer;
        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _whereEl : _asResult_c) {
            if (_whereEl == null) {
                continue;
            }

            if (_whereEl != null) {
                ocb.activate(_whereEl, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c = _whereEl;

            if (_ident_c != null) {
                ocb.activate(_ident_c, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl = _ident_c;

            if (_ident_c != null) {
                ocb.activate(_ident_c, 2);
            }

            java.lang.String _ident_region = ((_dotEl == null) ? null
                                                               : _dotEl.region);

            if (_ident_region != null) {
                ocb.activate(_ident_region, 1);
            }

            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_region,
                    "WA");
            java.lang.Boolean _andResult;

            if (!_equalsResult) {
                _andResult = false;
            } else {
                pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c1 = _whereEl;

                if (_ident_c1 != null) {
                    ocb.activate(_ident_c1, 1);
                }

                pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl1 = _ident_c1;

                if (_ident_c1 != null) {
                    ocb.activate(_ident_c1, 2);
                }

                java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                    ((_dotEl1 == null)
                    ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                    : _dotEl1.orders);

                if (_ident_orders != null) {
                    ocb.activate(_ident_orders, 2);
                }

                java.lang.Boolean _existsResult = !_ident_orders.isEmpty();
                _andResult = _existsResult;
            }

            if (_andResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _joinEl : _whereResult) {
            if (_joinEl != null) {
                ocb.activate(_joinEl, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c2 = _joinEl;

            if (_ident_c2 != null) {
                ocb.activate(_ident_c2, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl2 = _ident_c2;

            if (_ident_c2 != null) {
                ocb.activate(_ident_c2, 2);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders1 =
                ((_dotEl2 == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _dotEl2.orders);

            if (_ident_orders1 != null) {
                ocb.activate(_ident_orders1, 2);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _asResult_o =
                _ident_orders1;
            _joinResult.addAll(OperatorUtils.cartesianProductSC(_joinEl,
                    _asResult_o, "c", "o"));
            _joinIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _element_atResult;
        _element_atResult = new ArrayList();

        if (!_joinResult.isEmpty()) {
            _element_atResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();

            Integer _lowBound3 = 2;
            Integer _upBound3 = _joinResult.size() - 1;

            if (_upBound3 >= _joinResult.size()) {
                _upBound3 = _joinResult.size() - 2;
            }

            _element_atResult = _joinResult.subList(_lowBound3, _upBound3 + 1);
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult6 = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex6 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl6 : _element_atResult) {
            if (_dotEl6 == null) {
                continue;
            }

            if (_dotEl6 != null) {
                ocb.activate(_dotEl6, 2);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c3 = (pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl6.get(
                    "c");

            if (_ident_c3 != null) {
                ocb.activate(_ident_c3, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl3 = _ident_c3;

            if (_ident_c3 != null) {
                ocb.activate(_ident_c3, 2);
            }

            java.lang.String _ident_customerID = ((_dotEl3 == null) ? null
                                                                    : _dotEl3.customerID);

            if (_ident_customerID != null) {
                ocb.activate(_ident_customerID, 1);
            }

            java.lang.String _asResult_customerID = _ident_customerID;
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o = (pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl6.get(
                    "o");

            if (_ident_o != null) {
                ocb.activate(_ident_o, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl4 = _ident_o;

            if (_ident_o != null) {
                ocb.activate(_ident_o, 2);
            }

            java.lang.Integer _ident_orderID = ((_dotEl4 == null) ? null
                                                                  : _dotEl4.orderID);

            if (_ident_orderID != null) {
                ocb.activate(_ident_orderID, 1);
            }

            java.lang.Integer _asResult_orderID = _ident_orderID;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_customerID,
                    _asResult_orderID, "customerID", "orderID");
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o1 = (pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl6.get(
                    "o");

            if (_ident_o1 != null) {
                ocb.activate(_ident_o1, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl5 = _ident_o1;

            if (_ident_o1 != null) {
                ocb.activate(_ident_o1, 2);
            }

            java.util.Date _ident_orderDate = ((_dotEl5 == null) ? null
                                                                 : _dotEl5.orderDate);

            if (_ident_orderDate != null) {
                ocb.activate(_ident_orderDate, 1);
            }

            java.util.Date _asResult_orderDate = _ident_orderDate;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_commaResult,
                    _asResult_orderDate, "", "orderDate");

            if (_commaResult1 != null) {
                ocb.activate(_commaResult1, 2);
            }

            _dotResult6.add(_commaResult1);
            _dotIndex6++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult6, ocb);

        return _dotResult6;
    }
}
