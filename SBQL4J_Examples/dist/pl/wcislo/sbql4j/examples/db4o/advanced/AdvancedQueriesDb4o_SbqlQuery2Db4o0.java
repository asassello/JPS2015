package pl.wcislo.sbql4j.examples.db4o.advanced;

import com.db4o.*;

import com.db4o.foundation.*;

import com.db4o.internal.*;
import com.db4o.internal.btree.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.db4o.*;
import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
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

import java.text.*;

import java.util.*;


public class AdvancedQueriesDb4o_SbqlQuery2Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery2Db4o0() {
    }

    /**
     * query='db.(Employee where getWorksIn().getBoss().getName() == "Bert").getName()'
    '
     **/
    public java.util.Collection<java.lang.String> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_Employee =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        ClassMetadata _classMeta2 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Employee");
        long[] _ids2 = _classMeta2.getIDs(transLocal);

        for (long _id2 : _ids2) {
            LazyObjectReference _ref2 = transLocal.lazyReferenceFor((int) _id2);
            _ident_Employee.add((pl.wcislo.sbql4j.examples.model.advanced.Employee) _ref2.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _whereEl : _ident_Employee) {
            if (_whereEl == null) {
                continue;
            }

            if (_whereEl != null) {
                ocb.activate(_whereEl, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _mth_getWorksInResult =
                _whereEl.getWorksIn();

            if (_mth_getWorksInResult != null) {
                ocb.activate(_mth_getWorksInResult, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl = _mth_getWorksInResult;

            if (_mth_getWorksInResult != null) {
                ocb.activate(_mth_getWorksInResult, 2);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult =
                _dotEl.getBoss();

            if (_mth_getBossResult != null) {
                ocb.activate(_mth_getBossResult, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl1 = _mth_getBossResult;

            if (_mth_getBossResult != null) {
                ocb.activate(_mth_getBossResult, 2);
            }

            java.lang.String _mth_getNameResult = _dotEl1.getName();

            if (_mth_getNameResult != null) {
                ocb.activate(_mth_getNameResult, 1);
            }

            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getNameResult,
                    "Bert");

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.Collection<java.lang.String> _dotResult2 = new java.util.ArrayList<java.lang.String>();
        int _dotIndex2 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl2 : _whereResult) {
            if (_dotEl2 == null) {
                continue;
            }

            if (_dotEl2 != null) {
                ocb.activate(_dotEl2, 1);
            }

            java.lang.String _mth_getNameResult1 = _dotEl2.getName();

            if (_mth_getNameResult1 != null) {
                ocb.activate(_mth_getNameResult1, 1);
            }

            if (_mth_getNameResult1 != null) {
                ocb.activate(_mth_getNameResult1, 1);
            }

            _dotResult2.add(_mth_getNameResult1);
            _dotIndex2++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult2, ocb);

        return _dotResult2;
    }
}
