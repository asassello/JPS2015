package pl.wcislo.sbql4j.javac.test.db4o;

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
import pl.wcislo.sbql4j.java.model.runtime.Struct;
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
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.*;


public class Db4oOperatorTest_SbqlQuery4Db4o0 implements Db4oSBQLQuery {
    public Db4oOperatorTest_SbqlQuery4Db4o0() {
    }

    /**
     * query='db.( any Emp isMarried())'
    '
     **/
    public java.lang.Boolean executeQuery(final ObjectContainerBase ocb,
        final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.Emp> _ident_Emp =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.Emp>();
        ClassMetadata _classMeta1 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.Emp");
        long[] _ids1 = _classMeta1.getIDs(transLocal);

        for (long _id1 : _ids1) {
            LazyObjectReference _ref1 = transLocal.lazyReferenceFor((int) _id1);
            _ident_Emp.add((pl.wcislo.sbql4j.examples.model.Emp) _ref1.getObject());
        }

        java.lang.Boolean _anyResult = false;
        Integer _anyIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.Emp _anyEl : _ident_Emp) {
            if (_anyEl != null) {
                ocb.activate(_anyEl, 1);
            }

            java.lang.Boolean _mth_isMarriedResult = _anyEl.isMarried();

            if (_mth_isMarriedResult != null) {
                ocb.activate(_mth_isMarriedResult, 1);
            }

            if (_mth_isMarriedResult) {
                _anyResult = true;

                break;
            }
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_anyResult, ocb);

        return _anyResult;
    }
}
