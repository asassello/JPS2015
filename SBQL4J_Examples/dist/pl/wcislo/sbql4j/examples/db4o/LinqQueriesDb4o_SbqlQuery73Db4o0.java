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


public class LinqQueriesDb4o_SbqlQuery73Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery73Db4o0() {
    }

    /**
     * query='db.(Customer.companyName union Product.productName)'
    '
     **/
    public java.util.Collection<java.lang.String> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_Customer =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Customer>();
        ClassMetadata _classMeta45 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Customer");
        long[] _ids45 = _classMeta45.getIDs(transLocal);

        for (long _id45 : _ids45) {
            LazyObjectReference _ref45 = transLocal.lazyReferenceFor((int) _id45);
            _ident_Customer.add((pl.wcislo.sbql4j.examples.model.linq.Customer) _ref45.getObject());
        }

        java.util.Collection<java.lang.String> _dotResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl : _ident_Customer) {
            if (_dotEl == null) {
                continue;
            }

            if (_dotEl != null) {
                ocb.activate(_dotEl, 1);
            }

            java.lang.String _ident_companyName = ((_dotEl == null) ? null
                                                                    : _dotEl.companyName);

            if (_ident_companyName != null) {
                ocb.activate(_ident_companyName, 1);
            }

            if (_ident_companyName != null) {
                ocb.activate(_ident_companyName, 1);
            }

            _dotResult.add(_ident_companyName);
            _dotIndex++;
        }

        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta46 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids46 = _classMeta46.getIDs(transLocal);

        for (long _id46 : _ids46) {
            LazyObjectReference _ref46 = transLocal.lazyReferenceFor((int) _id46);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref46.getObject());
        }

        java.util.Collection<java.lang.String> _dotResult1 = new java.util.ArrayList<java.lang.String>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Product _dotEl1 : _ident_Product) {
            if (_dotEl1 == null) {
                continue;
            }

            if (_dotEl1 != null) {
                ocb.activate(_dotEl1, 1);
            }

            java.lang.String _ident_productName = ((_dotEl1 == null) ? null
                                                                     : _dotEl1.productName);

            if (_ident_productName != null) {
                ocb.activate(_ident_productName, 1);
            }

            if (_ident_productName != null) {
                ocb.activate(_ident_productName, 1);
            }

            _dotResult1.add(_ident_productName);
            _dotIndex1++;
        }

        java.util.Collection<java.lang.String> _unionResult = new java.util.ArrayList<java.lang.String>();
        _unionResult.addAll(_dotResult);
        _unionResult.addAll(_dotResult1);
        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_unionResult, ocb);

        return _unionResult;
    }
}
