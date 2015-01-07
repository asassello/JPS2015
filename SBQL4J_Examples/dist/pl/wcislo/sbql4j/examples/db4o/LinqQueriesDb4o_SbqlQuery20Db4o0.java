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


public class LinqQueriesDb4o_SbqlQuery20Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery20Db4o0() {
    }

    /**
     * query='db.((Customer where region == "WA" join orders)[0..2]).(customerID as customerID, orderID as orderID, orderDate as orderDate)'
    '
     **/
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_Customer =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        ClassMetadata _classMeta10 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Customer");
        long[] _ids10 = _classMeta10.getIDs(transLocal);

        for (long _id10 : _ids10) {
            LazyObjectReference _ref10 = transLocal.lazyReferenceFor((int) _id10);
            _ident_Customer.add((pl.wcislo.sbql4j.examples.model.linq.Customer) _ref10.getObject());
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

            java.lang.String _ident_region = ((_whereEl == null) ? null
                                                                 : _whereEl.region);

            if (_ident_region != null) {
                ocb.activate(_ident_region, 1);
            }

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
            if (_joinEl != null) {
                ocb.activate(_joinEl, 1);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_joinEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _joinEl.orders);

            if (_ident_orders != null) {
                ocb.activate(_ident_orders, 2);
            }

            _joinResult.addAll(OperatorUtils.cartesianProductSC(_joinEl,
                    _ident_orders, "", ""));
            _joinIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _element_atResult;
        _element_atResult = new ArrayList();

        if (!_joinResult.isEmpty()) {
            _element_atResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();

            Integer _lowBound1 = 0;
            Integer _upBound1 = 2;

            if (_upBound1 >= _joinResult.size()) {
                _upBound1 = _joinResult.size() - 2;
            }

            _element_atResult = _joinResult.subList(_lowBound1, _upBound1 + 1);
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl : _element_atResult) {
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
            java.util.Date _ident_orderDate = ((((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)) == null)
                ? null
                : ((pl.wcislo.sbql4j.examples.model.linq.Order) _dotEl.getValue(1)).orderDate);

            if (_ident_orderDate != null) {
                ocb.activate(_ident_orderDate, 1);
            }

            java.util.Date _asResult_orderDate = _ident_orderDate;
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
