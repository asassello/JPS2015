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


public class LinqQueriesDb4o_SbqlQuery68Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery68Db4o0() {
    }

    /**
     * query='db.( unique Product.category as cat).(cat as cat, (Product where category == cat) group as pr).(cat as category, ( max(pr.unitPrice) group as _aux0).(pr where unitPrice == _aux0) group as mostExpensiveProducts)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta41 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids41 = _classMeta41.getIDs(transLocal);

        for (long _id41 : _ids41) {
            LazyObjectReference _ref41 = transLocal.lazyReferenceFor((int) _id41);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref41.getObject());
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
        Set<java.lang.String> _tmp20 = new LinkedHashSet<java.lang.String>();
        _tmp20.addAll(_dotResult);
        _uniqueResult.addAll(_tmp20);

        java.util.Collection<java.lang.String> _asResult_cat = _uniqueResult;
        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex1 = 0;

        for (java.lang.String _dotEl1 : _asResult_cat) {
            if (_dotEl1 == null) {
                continue;
            }

            if (_dotEl1 != null) {
                ocb.activate(_dotEl1, 2);
            }

            java.lang.String _ident_cat = _dotEl1;

            if (_ident_cat != null) {
                ocb.activate(_ident_cat, 1);
            }

            java.lang.String _asResult_cat1 = _ident_cat;
            final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
            ClassMetadata _classMeta42 = ocb.classCollection()
                                            .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
            long[] _ids42 = _classMeta42.getIDs(transLocal);

            for (long _id42 : _ids42) {
                LazyObjectReference _ref42 = transLocal.lazyReferenceFor((int) _id42);
                _ident_Product1.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref42.getObject());
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

                java.lang.String _ident_cat1 = _dotEl1;

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

            java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _groupAsResultpr =
                _whereResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_cat1,
                    _groupAsResultpr, "cat", "pr");

            if (_commaResult != null) {
                ocb.activate(_commaResult, 2);
            }

            _dotResult1.add(_commaResult);
            _dotIndex1++;
        }

        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult4 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex4 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl4 : _dotResult1) {
            if (_dotEl4 == null) {
                continue;
            }

            if (_dotEl4 != null) {
                ocb.activate(_dotEl4, 2);
            }

            java.lang.String _ident_cat2 = (java.lang.String) _dotEl4.get("cat");

            if (_ident_cat2 != null) {
                ocb.activate(_ident_cat2, 1);
            }

            java.lang.String _asResult_category = _ident_cat2;
            java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_pr =
                (java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product>) _dotEl4.get(
                    "pr");

            if (_ident_pr != null) {
                ocb.activate(_ident_pr, 2);
            }

            java.util.Collection<java.lang.Double> _dotResult2 = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex2 = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl2 : _ident_pr) {
                if (_dotEl2 == null) {
                    continue;
                }

                if (_dotEl2 != null) {
                    ocb.activate(_dotEl2, 1);
                }

                java.lang.Double _ident_unitPrice = ((_dotEl2 == null) ? null
                                                                       : _dotEl2.unitPrice);

                if (_ident_unitPrice != null) {
                    ocb.activate(_ident_unitPrice, 1);
                }

                if (_ident_unitPrice != null) {
                    ocb.activate(_ident_unitPrice, 1);
                }

                _dotResult2.add(_ident_unitPrice);
                _dotIndex2++;
            }

            Number _max3 = null;

            for (Number _maxEl3 : _dotResult2) {
                _max3 = MathUtils.max(_max3, _maxEl3);
            }

            java.lang.Double _maxResult = (java.lang.Double) _max3;
            java.lang.Double _groupAsResult_aux0 = _maxResult;
            java.lang.Double _dotEl3 = _groupAsResult_aux0;
            java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_pr1 =
                (java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product>) _dotEl4.get(
                    "pr");

            if (_ident_pr1 != null) {
                ocb.activate(_ident_pr1, 2);
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _whereResult1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
            int _whereLoopIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _whereEl1 : _ident_pr1) {
                if (_whereEl1 == null) {
                    continue;
                }

                if (_whereEl1 != null) {
                    ocb.activate(_whereEl1, 1);
                }

                java.lang.Double _ident_unitPrice1 = ((_whereEl1 == null)
                    ? null : _whereEl1.unitPrice);

                if (_ident_unitPrice1 != null) {
                    ocb.activate(_ident_unitPrice1, 1);
                }

                java.lang.Double _ident__aux0 = _dotEl3;

                if (_ident__aux0 != null) {
                    ocb.activate(_ident__aux0, 1);
                }

                java.lang.Boolean _equalsResult1 = OperatorUtils.equalsSafe(_ident_unitPrice1,
                        _ident__aux0);

                if (_equalsResult1) {
                    _whereResult1.add(_whereEl1);
                }

                _whereLoopIndex1++;
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _groupAsResultmostExpensiveProducts =
                _whereResult1;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_asResult_category,
                    _groupAsResultmostExpensiveProducts, "category",
                    "mostExpensiveProducts");

            if (_commaResult1 != null) {
                ocb.activate(_commaResult1, 2);
            }

            _dotResult4.add(_commaResult1);
            _dotIndex4++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult4, ocb);

        return _dotResult4;
    }
}