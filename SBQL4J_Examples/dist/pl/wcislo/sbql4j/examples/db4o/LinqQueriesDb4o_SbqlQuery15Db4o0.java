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


public class LinqQueriesDb4o_SbqlQuery15Db4o0 implements Db4oSBQLQuery {
    private java.util.Date d;

    public LinqQueriesDb4o_SbqlQuery15Db4o0(java.util.Date d) {
        this.d = d;
    }

    /**
     * query='db.(Customer where  exists (orders where orderDate > d) join orders where orderDate > d).(customerID as customerID, orderID as orderID, orderDate as orderDate)'
    '
     **/
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_Customer =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        ClassMetadata _classMeta6 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Customer");
        long[] _ids6 = _classMeta6.getIDs(transLocal);

        for (long _id6 : _ids6) {
            LazyObjectReference _ref6 = transLocal.lazyReferenceFor((int) _id6);
            _ident_Customer.add((pl.wcislo.sbql4j.examples.model.linq.Customer) _ref6.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _whereResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        int _whereLoopIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _whereEl1 : _ident_Customer) {
            if (_whereEl1 == null) {
                continue;
            }

            if (_whereEl1 != null) {
                ocb.activate(_whereEl1, 1);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_whereEl1 == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _whereEl1.orders);

            if (_ident_orders != null) {
                ocb.activate(_ident_orders, 2);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _whereResult =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>();
            int _whereLoopIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Order _whereEl : _ident_orders) {
                if (_whereEl == null) {
                    continue;
                }

                if (_whereEl != null) {
                    ocb.activate(_whereEl, 1);
                }

                java.util.Date _ident_orderDate = ((_whereEl == null) ? null
                                                                      : _whereEl.orderDate);

                if (_ident_orderDate != null) {
                    ocb.activate(_ident_orderDate, 1);
                }

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

            java.lang.Boolean _existsResult = !_whereResult.isEmpty();

            if (_existsResult) {
                _whereResult1.add(_whereEl1);
            }

            _whereLoopIndex1++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _joinEl : _whereResult1) {
            if (_joinEl != null) {
                ocb.activate(_joinEl, 1);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders1 =
                ((_joinEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _joinEl.orders);

            if (_ident_orders1 != null) {
                ocb.activate(_ident_orders1, 2);
            }

            _joinResult.addAll(OperatorUtils.cartesianProductSC(_joinEl,
                    _ident_orders1, "", ""));
            _joinIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _whereResult2 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _whereLoopIndex2 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _whereEl2 : _joinResult) {
            if (_whereEl2 == null) {
                continue;
            }

            if (_whereEl2 != null) {
                ocb.activate(_whereEl2, 1);
            }

            java.util.Date _ident_orderDate1 = ((((pl.wcislo.sbql4j.examples.model.linq.Order) _whereEl2.getValue(1)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Order) _whereEl2.getValue(1)).orderDate);

            if (_ident_orderDate1 != null) {
                ocb.activate(_ident_orderDate1, 1);
            }

            java.util.Date _ident_d1 = d;

            Boolean _moreResult1 = (_ident_orderDate1 == null)
                ? ((_ident_orderDate1 == null) ? false : false)
                : ((_ident_orderDate1 == null) ? true
                                               : (_ident_orderDate1.compareTo(_ident_d1) > 0));

            if (_moreResult1) {
                _whereResult2.add(_whereEl2);
            }

            _whereLoopIndex2++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl : _whereResult2) {
            if (_dotEl == null) {
                continue;
            }

            if (_dotEl != null) {
                ocb.activate(_dotEl, 2);
            }

            java.lang.String _ident_customerID = ((((pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl.getValue(0)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl.getValue(0)).customerID);

            if (_ident_customerID != null) {
                ocb.activate(_ident_customerID, 1);
            }

            java.lang.String _asResult_customerID = _ident_customerID;
            java.lang.Integer _ident_orderID = ((((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)).orderID);

            if (_ident_orderID != null) {
                ocb.activate(_ident_orderID, 1);
            }

            java.lang.Integer _asResult_orderID = _ident_orderID;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_customerID,
                    _asResult_orderID, "customerID", "orderID");
            java.util.Date _ident_orderDate2 = ((((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)).orderDate);

            if (_ident_orderDate2 != null) {
                ocb.activate(_ident_orderDate2, 1);
            }

            java.util.Date _asResult_orderDate = _ident_orderDate2;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_commaResult,
                    _asResult_orderDate, "", "orderDate");

            if (_commaResult1 != null) {
                ocb.activate(_commaResult1, 2);
            }

            _dotResult.add(_commaResult1);
            _dotIndex++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult, ocb);

        return _dotResult;
    }
}
