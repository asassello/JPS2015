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


public class LinqQueriesDb4o_SbqlQuery25Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery25Db4o0() {
    }

    /**
     * query='db.(Product as p order by (p.productName))'
    '
     **/
    public java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta12 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids12 = _classMeta12.getIDs(transLocal);

        for (long _id12 : _ids12) {
            LazyObjectReference _ref12 = transLocal.lazyReferenceFor((int) _id12);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref12.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _asResult_p =
            _ident_Product;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _orderByResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();

        if (_asResult_p != null) {
            ocb.activate(_asResult_p, 2);
        }

        _orderByResult.addAll(_asResult_p);

        Comparator<pl.wcislo.sbql4j.examples.model.linq.Product> _comparator2 = new Comparator<pl.wcislo.sbql4j.examples.model.linq.Product>() {
                public int compare(
                    pl.wcislo.sbql4j.examples.model.linq.Product _leftObj,
                    pl.wcislo.sbql4j.examples.model.linq.Product _rightObj) {
                    if (_leftObj == null) {
                        return -1;
                    }

                    if (_leftObj != null) {
                        ocb.activate(_leftObj, 1);
                    }

                    if (_rightObj != null) {
                        ocb.activate(_rightObj, 1);
                    }

                    int res = 0;
                    java.lang.String _leftParam0;

                    {
                        pl.wcislo.sbql4j.examples.model.linq.Product _ident_p = _leftObj;

                        if (_ident_p != null) {
                            ocb.activate(_ident_p, 1);
                        }

                        pl.wcislo.sbql4j.examples.model.linq.Product _dotEl = _ident_p;

                        if (_ident_p != null) {
                            ocb.activate(_ident_p, 2);
                        }

                        java.lang.String _ident_productName = ((_dotEl == null)
                            ? null : _dotEl.productName);

                        if (_ident_productName != null) {
                            ocb.activate(_ident_productName, 1);
                        }

                        _leftParam0 = _ident_productName;
                    }

                    java.lang.String _rightParam0;

                    {
                        pl.wcislo.sbql4j.examples.model.linq.Product _ident_p = _rightObj;

                        if (_ident_p != null) {
                            ocb.activate(_ident_p, 1);
                        }

                        pl.wcislo.sbql4j.examples.model.linq.Product _dotEl = _ident_p;

                        if (_ident_p != null) {
                            ocb.activate(_ident_p, 2);
                        }

                        java.lang.String _ident_productName = ((_dotEl == null)
                            ? null : _dotEl.productName);

                        if (_ident_productName != null) {
                            ocb.activate(_ident_productName, 1);
                        }

                        _rightParam0 = _ident_productName;
                    }

                    if (_leftParam0 != null) {
                        res = _leftParam0.compareTo(_rightParam0);
                    } else {
                        return -1;
                    }

                    return res;
                }
            };

        Collections.sort(_orderByResult, _comparator2);
        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_orderByResult,
            ocb);

        return _orderByResult;
    }
}
