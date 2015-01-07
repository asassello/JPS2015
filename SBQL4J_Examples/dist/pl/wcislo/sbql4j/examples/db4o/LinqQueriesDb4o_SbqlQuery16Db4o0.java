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


public class LinqQueriesDb4o_SbqlQuery16Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery16Db4o0() {
    }

    /**
     * query='db.(Customer as c join (c.orders as o where o.total > 2000) as j where  exists j).(c.customerID as customerID, j.o.orderID as orderID, j.o.total as total)'
    '
     **/
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_Customer =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        ClassMetadata _classMeta7 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Customer");
        long[] _ids7 = _classMeta7.getIDs(transLocal);

        for (long _id7 : _ids7) {
            LazyObjectReference _ref7 = transLocal.lazyReferenceFor((int) _id7);
            _ident_Customer.add((pl.wcislo.sbql4j.examples.model.linq.Customer) _ref7.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _asResult_c =
            _ident_Customer;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _joinEl : _asResult_c) {
            if (_joinEl != null) {
                ocb.activate(_joinEl, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c = _joinEl;

            if (_ident_c != null) {
                ocb.activate(_ident_c, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl = _ident_c;

            if (_ident_c != null) {
                ocb.activate(_ident_c, 2);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_dotEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _dotEl.orders);

            if (_ident_orders != null) {
                ocb.activate(_ident_orders, 2);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _asResult_o =
                _ident_orders;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _whereResult =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>();
            int _whereLoopIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Order _whereEl : _asResult_o) {
                if (_whereEl == null) {
                    continue;
                }

                if (_whereEl != null) {
                    ocb.activate(_whereEl, 1);
                }

                pl.wcislo.sbql4j.examples.model.linq.Order _ident_o = _whereEl;

                if (_ident_o != null) {
                    ocb.activate(_ident_o, 1);
                }

                pl.wcislo.sbql4j.examples.model.linq.Order _dotEl1 = _ident_o;

                if (_ident_o != null) {
                    ocb.activate(_ident_o, 2);
                }

                java.lang.Double _ident_total = ((_dotEl1 == null) ? null
                                                                   : _dotEl1.total);

                if (_ident_total != null) {
                    ocb.activate(_ident_total, 1);
                }

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

            if (_whereEl1 != null) {
                ocb.activate(_whereEl1, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _ident_j = (pl.wcislo.sbql4j.examples.model.linq.Order) _whereEl1.get(
                    "j");

            if (_ident_j != null) {
                ocb.activate(_ident_j, 1);
            }

            java.lang.Boolean _existsResult = _ident_j != null;

            if (_existsResult) {
                _whereResult1.add(_whereEl1);
            }

            _whereLoopIndex1++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult7 = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex7 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl7 : _whereResult1) {
            if (_dotEl7 == null) {
                continue;
            }

            if (_dotEl7 != null) {
                ocb.activate(_dotEl7, 2);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c1 = (pl.wcislo.sbql4j.examples.model.linq.Customer) _dotEl7.get(
                    "c");

            if (_ident_c1 != null) {
                ocb.activate(_ident_c1, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl2 = _ident_c1;

            if (_ident_c1 != null) {
                ocb.activate(_ident_c1, 2);
            }

            java.lang.String _ident_customerID = ((_dotEl2 == null) ? null
                                                                    : _dotEl2.customerID);

            if (_ident_customerID != null) {
                ocb.activate(_ident_customerID, 1);
            }

            java.lang.String _asResult_customerID = _ident_customerID;
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_j1 = (pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl7.get(
                    "j");

            if (_ident_j1 != null) {
                ocb.activate(_ident_j1, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl3 = _ident_j1;
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o1 = _dotEl3;

            if (_ident_o1 != null) {
                ocb.activate(_ident_o1, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl4 = _ident_o1;

            if (_ident_o1 != null) {
                ocb.activate(_ident_o1, 2);
            }

            java.lang.Integer _ident_orderID = ((_dotEl4 == null) ? null
                                                                  : _dotEl4.orderID);

            if (_ident_orderID != null) {
                ocb.activate(_ident_orderID, 1);
            }

            java.lang.Integer _asResult_orderID = _ident_orderID;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_customerID,
                    _asResult_orderID, "customerID", "orderID");
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_j2 = (pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl7.get(
                    "j");

            if (_ident_j2 != null) {
                ocb.activate(_ident_j2, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl5 = _ident_j2;
            pl.wcislo.sbql4j.examples.model.linq.Order _ident_o2 = _dotEl5;

            if (_ident_o2 != null) {
                ocb.activate(_ident_o2, 1);
            }

            pl.wcislo.sbql4j.examples.model.linq.Order _dotEl6 = _ident_o2;

            if (_ident_o2 != null) {
                ocb.activate(_ident_o2, 2);
            }

            java.lang.Double _ident_total1 = ((_dotEl6 == null) ? null
                                                                : _dotEl6.total);

            if (_ident_total1 != null) {
                ocb.activate(_ident_total1, 1);
            }

            java.lang.Double _asResult_total = _ident_total1;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_commaResult,
                    _asResult_total, "", "total");

            if (_commaResult1 != null) {
                ocb.activate(_commaResult1, 2);
            }

            _dotResult7.add(_commaResult1);
            _dotIndex7++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult7, ocb);

        return _dotResult7;
    }
}
