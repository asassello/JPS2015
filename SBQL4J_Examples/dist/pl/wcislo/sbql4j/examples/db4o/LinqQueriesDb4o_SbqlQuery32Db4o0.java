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


public class LinqQueriesDb4o_SbqlQuery32Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery32Db4o0() {
    }

    /**
     * query='db.(Product order by (category, unitPrice DESC ))'
    '
     **/
    public java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta14 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids14 = _classMeta14.getIDs(transLocal);

        for (long _id14 : _ids14) {
            LazyObjectReference _ref14 = transLocal.lazyReferenceFor((int) _id14);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref14.getObject());
        }

        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _orderByResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();

        if (_ident_Product != null) {
            ocb.activate(_ident_Product, 2);
        }

        _orderByResult.addAll(_ident_Product);

        Comparator<pl.wcislo.sbql4j.examples.model.linq.Product> _comparator9 = new Comparator<pl.wcislo.sbql4j.examples.model.linq.Product>() {
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
                        java.lang.String _ident_category = ((_leftObj == null)
                            ? null : _leftObj.category);

                        if (_ident_category != null) {
                            ocb.activate(_ident_category, 1);
                        }

                        _leftParam0 = _ident_category;
                    }

                    java.lang.String _rightParam0;

                    {
                        java.lang.String _ident_category = ((_rightObj == null)
                            ? null : _rightObj.category);

                        if (_ident_category != null) {
                            ocb.activate(_ident_category, 1);
                        }

                        _rightParam0 = _ident_category;
                    }

                    if (_leftParam0 != null) {
                        res = _leftParam0.compareTo(_rightParam0);
                    } else {
                        return -1;
                    }

                    if (res != 0) {
                        return res;
                    }

                    java.lang.Double _leftParam1;

                    {
                        java.lang.Double _ident_unitPrice = ((_leftObj == null)
                            ? null : _leftObj.unitPrice);

                        if (_ident_unitPrice != null) {
                            ocb.activate(_ident_unitPrice, 1);
                        }

                        _leftParam1 = _ident_unitPrice;
                    }

                    java.lang.Double _rightParam1;

                    {
                        java.lang.Double _ident_unitPrice = ((_rightObj == null)
                            ? null : _rightObj.unitPrice);

                        if (_ident_unitPrice != null) {
                            ocb.activate(_ident_unitPrice, 1);
                        }

                        _rightParam1 = _ident_unitPrice;
                    }

                    if (_leftParam1 != null) {
                        res = _leftParam1.compareTo(_rightParam1);
                    } else {
                        return 1;
                    }

                    return -res;
                }
            };

        Collections.sort(_orderByResult, _comparator9);
        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_orderByResult,
            ocb);

        return _orderByResult;
    }
}
