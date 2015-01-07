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


public class LinqQueriesDb4o_SbqlQuery71Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery71Db4o0() {
    }

    /**
     * query='db.( unique Product.category as cat).(cat as category,  avg((Product where category == cat).unitPrice) as averagePrice)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta43 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids43 = _classMeta43.getIDs(transLocal);

        for (long _id43 : _ids43) {
            LazyObjectReference _ref43 = transLocal.lazyReferenceFor((int) _id43);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref43.getObject());
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
        Set<java.lang.String> _tmp21 = new LinkedHashSet<java.lang.String>();
        _tmp21.addAll(_dotResult);
        _uniqueResult.addAll(_tmp21);

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
            ClassMetadata _classMeta44 = ocb.classCollection()
                                            .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
            long[] _ids44 = _classMeta44.getIDs(transLocal);

            for (long _id44 : _ids44) {
                LazyObjectReference _ref44 = transLocal.lazyReferenceFor((int) _id44);
                _ident_Product1.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref44.getObject());
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

            java.util.Collection<java.lang.Double> _dotResult1 = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl1 : _whereResult) {
                if (_dotEl1 == null) {
                    continue;
                }

                if (_dotEl1 != null) {
                    ocb.activate(_dotEl1, 1);
                }

                java.lang.Double _ident_unitPrice = ((_dotEl1 == null) ? null
                                                                       : _dotEl1.unitPrice);

                if (_ident_unitPrice != null) {
                    ocb.activate(_ident_unitPrice, 1);
                }

                if (_ident_unitPrice != null) {
                    ocb.activate(_ident_unitPrice, 1);
                }

                _dotResult1.add(_ident_unitPrice);
                _dotIndex1++;
            }

            java.lang.Double _avgResult = 0d;

            if ((_dotResult1 != null) && !_dotResult1.isEmpty()) {
                Number _avgSum2 = null;

                for (Number _avgEl2 : _dotResult1) {
                    _avgSum2 = MathUtils.sum(_avgSum2, _avgEl2);
                }

                _avgResult = _avgSum2.doubleValue() / _dotResult1.size();
            }

            java.lang.Double _asResult_averagePrice = _avgResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_category,
                    _asResult_averagePrice, "category", "averagePrice");

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