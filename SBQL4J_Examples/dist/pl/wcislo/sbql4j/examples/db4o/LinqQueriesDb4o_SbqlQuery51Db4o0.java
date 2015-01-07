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


public class LinqQueriesDb4o_SbqlQuery51Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery51Db4o0() {
    }

    /**
     * query='db.(( unique Product.category as cat).(cat as category, (Product where category == cat) group as products) where  any products unitsInStock == 0)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta26 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids26 = _classMeta26.getIDs(transLocal);

        for (long _id26 : _ids26) {
            LazyObjectReference _ref26 = transLocal.lazyReferenceFor((int) _id26);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref26.getObject());
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
        Set<java.lang.String> _tmp12 = new LinkedHashSet<java.lang.String>();
        _tmp12.addAll(_dotResult);
        _uniqueResult.addAll(_tmp12);

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

            java.lang.String _asResult_category = _ident_cat;
            final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
            ClassMetadata _classMeta27 = ocb.classCollection()
                                            .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
            long[] _ids27 = _classMeta27.getIDs(transLocal);

            for (long _id27 : _ids27) {
                LazyObjectReference _ref27 = transLocal.lazyReferenceFor((int) _id27);
                _ident_Product1.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref27.getObject());
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

            java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _groupAsResultproducts =
                _whereResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_category,
                    _groupAsResultproducts, "category", "products");

            if (_commaResult != null) {
                ocb.activate(_commaResult, 2);
            }

            _dotResult1.add(_commaResult);
            _dotIndex1++;
        }

        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _whereResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _whereLoopIndex1 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _whereEl1 : _dotResult1) {
            if (_whereEl1 == null) {
                continue;
            }

            if (_whereEl1 != null) {
                ocb.activate(_whereEl1, 1);
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products =
                (java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product>) _whereEl1.get(
                    "products");

            if (_ident_products != null) {
                ocb.activate(_ident_products, 2);
            }

            java.lang.Boolean _anyResult = false;
            Integer _anyIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Product _anyEl : _ident_products) {
                if (_anyEl != null) {
                    ocb.activate(_anyEl, 1);
                }

                java.lang.Integer _ident_unitsInStock = ((_anyEl == null)
                    ? null : _anyEl.unitsInStock);

                if (_ident_unitsInStock != null) {
                    ocb.activate(_ident_unitsInStock, 1);
                }

                java.lang.Boolean _equalsResult1 = OperatorUtils.equalsSafe(_ident_unitsInStock,
                        0);

                if (_equalsResult1) {
                    _anyResult = true;

                    break;
                }
            }

            if (_anyResult) {
                _whereResult1.add(_whereEl1);
            }

            _whereLoopIndex1++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_whereResult1, ocb);

        return _whereResult1;
    }
}
