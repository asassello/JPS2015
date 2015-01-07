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


public class LinqQueriesDb4o_SbqlQuery1Db4o0 implements Db4oSBQLQuery {
    public LinqQueriesDb4o_SbqlQuery1Db4o0() {
    }

    /**
     * query='db.(Product where unitsInStock == 0)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta0 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        long[] _ids0 = _classMeta0.getIDs(transLocal);

        for (long _id0 : _ids0) {
            LazyObjectReference _ref0 = transLocal.lazyReferenceFor((int) _id0);
            _ident_Product.add((pl.wcislo.sbql4j.examples.model.linq.Product) _ref0.getObject());
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

            java.lang.Integer _ident_unitsInStock = ((_whereEl == null) ? null
                                                                        : _whereEl.unitsInStock);

            if (_ident_unitsInStock != null) {
                ocb.activate(_ident_unitsInStock, 1);
            }

            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_unitsInStock,
                    0);

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_whereResult, ocb);

        return _whereResult;
    }
}
