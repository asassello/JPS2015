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


public class LinqQueriesDb4o_SbqlQuery43Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery43Db4o0() {
    }

    /**
     * query='db.( unique Product.productName.charAt(0) intersect Customer.companyName.charAt(0))'
    '
     **/
    public java.util.Collection<java.lang.Character> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta21 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids21 = _classMeta21.getIDs(transLocal);

        for (long _id21 : _ids21) {
            LazyObjectReference _ref21 = transLocal.lazyReferenceFor((int) _id21);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref21.getObject());
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

            java.lang.String _ident_productName = ((_dotEl == null) ? null
                                                                    : _dotEl.productName);

            if (_ident_productName != null) {
                ocb.activate(_ident_productName, 1);
            }

            if (_ident_productName != null) {
                ocb.activate(_ident_productName, 1);
            }

            _dotResult.add(_ident_productName);
            _dotIndex++;
        }

        java.util.Collection<java.lang.Character> _dotResult1 = new java.util.ArrayList<java.lang.Character>();
        int _dotIndex1 = 0;

        for (java.lang.String _dotEl1 : _dotResult) {
            if (_dotEl1 == null) {
                continue;
            }

            if (_dotEl1 != null) {
                ocb.activate(_dotEl1, 1);
            }

            java.lang.Character _mth_charAtResult = _dotEl1.charAt(0);

            if (_mth_charAtResult != null) {
                ocb.activate(_mth_charAtResult, 1);
            }

            if (_mth_charAtResult != null) {
                ocb.activate(_mth_charAtResult, 1);
            }

            _dotResult1.add(_mth_charAtResult);
            _dotIndex1++;
        }

        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_Customer =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        ClassMetadata _classMeta22 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Customer");
        long[] _ids22 = _classMeta22.getIDs(transLocal);

        for (long _id22 : _ids22) {
            LazyObjectReference _ref22 = transLocal.lazyReferenceFor((int) _id22);
            _ident_Customer.add((pl.wcislo.sbql4j.examples.model.linq.Customer) _ref22.getObject());
        }

        java.util.Collection<java.lang.String> _dotResult2 = new java.util.ArrayList<java.lang.String>();
        int _dotIndex2 = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl2 : _ident_Customer) {
            if (_dotEl2 == null) {
                continue;
            }

            if (_dotEl2 != null) {
                ocb.activate(_dotEl2, 1);
            }

            java.lang.String _ident_companyName = ((_dotEl2 == null) ? null
                                                                     : _dotEl2.companyName);

            if (_ident_companyName != null) {
                ocb.activate(_ident_companyName, 1);
            }

            if (_ident_companyName != null) {
                ocb.activate(_ident_companyName, 1);
            }

            _dotResult2.add(_ident_companyName);
            _dotIndex2++;
        }

        java.util.Collection<java.lang.Character> _dotResult3 = new java.util.ArrayList<java.lang.Character>();
        int _dotIndex3 = 0;

        for (java.lang.String _dotEl3 : _dotResult2) {
            if (_dotEl3 == null) {
                continue;
            }

            if (_dotEl3 != null) {
                ocb.activate(_dotEl3, 1);
            }

            java.lang.Character _mth_charAtResult1 = _dotEl3.charAt(0);

            if (_mth_charAtResult1 != null) {
                ocb.activate(_mth_charAtResult1, 1);
            }

            if (_mth_charAtResult1 != null) {
                ocb.activate(_mth_charAtResult1, 1);
            }

            _dotResult3.add(_mth_charAtResult1);
            _dotIndex3++;
        }

        Collection _minusLeftCol1 = new ArrayList(_dotResult1);
        Collection _minusRightCol1 = new ArrayList(_dotResult3);
        java.util.Collection<java.lang.Character> _intersectResult = new java.util.ArrayList<java.lang.Character>();
        _intersectResult.addAll(CollectionUtils.intersection(_minusLeftCol1,
                _minusRightCol1));

        java.util.Collection<java.lang.Character> _uniqueResult = new java.util.ArrayList<java.lang.Character>();
        Set<java.lang.Character> _tmp9 = new LinkedHashSet<java.lang.Character>();
        _tmp9.addAll(_intersectResult);
        _uniqueResult.addAll(_tmp9);
        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_uniqueResult, ocb);

        return _uniqueResult;
    }
}
