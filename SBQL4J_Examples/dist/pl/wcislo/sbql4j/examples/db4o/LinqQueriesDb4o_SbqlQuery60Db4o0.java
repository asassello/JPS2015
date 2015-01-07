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


public class LinqQueriesDb4o_SbqlQuery60Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery60Db4o0() {
    }

    /**
     * query='db.( unique Product.category as cat).(cat as category,  sum (Product where category == cat).unitsInStock as totalUnitsInStock)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta33 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids33 = _classMeta33.getIDs(transLocal);

        for (long _id33 : _ids33) {
            LazyObjectReference _ref33 = transLocal.lazyReferenceFor((int) _id33);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref33.getObject());
        }

        java.util.Collection<java.lang.String> _dotResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl : _ident_Product) {
            if (_dotEl == null) {
                continue;
            }

            if (_dotEl != null) {
                ocb.activate(_dotEl, 1);
            }

            java.lang.String _ident_category = ((_dotEl == null) ? null
                                                                 : _dotEl.category);

            if (_ident_category != null) {
                ocb.activate(_ident_category, 1);
            }

            if (_ident_category != null) {
                ocb.activate(_ident_category, 1);
            }

            _dotResult.add(_ident_category);
            _dotIndex++;
        }

        java.util.Collection<java.lang.String> _uniqueResult = new java.util.ArrayList<java.lang.String>();
        Set<java.lang.String> _tmp16 = new LinkedHashSet<java.lang.String>();
        _tmp16.addAll(_dotResult);
        _uniqueResult.addAll(_tmp16);

        java.util.Collection<java.lang.String> _asResult_cat = _uniqueResult;
        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult2 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex2 = 0;

        for (java.lang.String _dotEl2 : _asResult_cat) {
            if (_dotEl2 == null) {
                continue;
            }

            if (_dotEl2 != null) {
                ocb.activate(_dotEl2, 2);
            }

            java.lang.String _ident_cat = _dotEl2;

            if (_ident_cat != null) {
                ocb.activate(_ident_cat, 1);
            }

            java.lang.String _asResult_category = _ident_cat;
            final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
            ClassMetadata _classMeta34 = ocb.classCollection()
                                            .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
            long[] _ids34 = _classMeta34.getIDs(transLocal);

            for (long _id34 : _ids34) {
                LazyObjectReference _ref34 = transLocal.lazyReferenceFor((int) _id34);
                _ident_Product1.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref34.getObject());
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _whereResult =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
            int _whereLoopIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _whereEl : _ident_Product1) {
                if (_whereEl == null) {
                    continue;
                }

                if (_whereEl != null) {
                    ocb.activate(_whereEl, 1);
                }

                java.lang.String _ident_category1 = ((_whereEl == null) ? null
                                                                        : _whereEl.category);

                if (_ident_category1 != null) {
                    ocb.activate(_ident_category1, 1);
                }

                java.lang.String _ident_cat1 = _dotEl2;

                if (_ident_cat1 != null) {
                    ocb.activate(_ident_cat1, 1);
                }

                java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_category1,
                        _ident_cat1);

                if (_equalsResult) {
                    _whereResult.add(_whereEl);
                }

                _whereLoopIndex++;
            }

            java.util.Collection<java.lang.Integer> _dotResult1 = new java.util.ArrayList<java.lang.Integer>();
            int _dotIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl1 : _whereResult) {
                if (_dotEl1 == null) {
                    continue;
                }

                if (_dotEl1 != null) {
                    ocb.activate(_dotEl1, 1);
                }

                java.lang.Integer _ident_unitsInStock = ((_dotEl1 == null)
                    ? null : _dotEl1.unitsInStock);

                if (_ident_unitsInStock != null) {
                    ocb.activate(_ident_unitsInStock, 1);
                }

                if (_ident_unitsInStock != null) {
                    ocb.activate(_ident_unitsInStock, 1);
                }

                _dotResult1.add(_ident_unitsInStock);
                _dotIndex1++;
            }

            Number _sum2 = null;

            for (Number _sumEl2 : _dotResult1) {
                _sum2 = MathUtils.sum(_sum2, _sumEl2);
            }

            java.lang.Integer _sumResult = (java.lang.Integer) _sum2;
            java.lang.Integer _asResult_totalUnitsInStock = _sumResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_category,
                    _asResult_totalUnitsInStock, "category", "totalUnitsInStock");

            if (_commaResult != null) {
                ocb.activate(_commaResult, 2);
            }

            _dotResult2.add(_commaResult);
            _dotIndex2++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult2, ocb);

        return _dotResult2;
    }
}
