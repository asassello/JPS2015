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


public class LinqQueriesDb4o_SbqlQuery47Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery47Db4o0() {
    }

    /**
     * query='db.((Product where productID == 12)[0])'
    '
     **/
    public pl.wcislo.sbql4j.examples.model.linq.Product executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta25 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids25 = _classMeta25.getIDs(transLocal);

        for (long _id25 : _ids25) {
            LazyObjectReference _ref25 = transLocal.lazyReferenceFor((int) _id25);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref25.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Product _whereEl : _ident_Product) {
            if (_whereEl == null) {
                continue;
            }

            if (_whereEl != null) {
                ocb.activate(_whereEl, 1);
            }

            java.lang.Integer _ident_productID = ((_whereEl == null) ? null
                                                                     : _whereEl.productID);

            if (_ident_productID != null) {
                ocb.activate(_ident_productID, 1);
            }

            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_productID,
                    12);

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        pl.wcislo.sbql4j.examples.model.linq.Product _element_atResult;
        _element_atResult = null;

        if (!_whereResult.isEmpty()) {
            Iterator<pl.wcislo.sbql4j.examples.model.linq.Product> _elementAtIteraotr0 =
                _whereResult.iterator();

            for (int _j0 = 0; _j0 < (0 + 1); _j0++) {
                _element_atResult = _elementAtIteraotr0.next();
            }
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_element_atResult,
            ocb);

        return _element_atResult;
    }
}
