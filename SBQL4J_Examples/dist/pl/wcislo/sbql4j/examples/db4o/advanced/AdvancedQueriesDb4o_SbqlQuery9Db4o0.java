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


public class AdvancedQueriesDb4o_SbqlQuery9Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery9Db4o0() {
    }

    /**
     * query='db.( unique Department.getLocation() as deptcity where  all Department deptcity in getLocation())'
    '
     **/
    public java.util.Collection<java.lang.String> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        ClassMetadata _classMeta11 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
        long[] _ids11 = _classMeta11.getIDs(transLocal);

        for (long _id11 : _ids11) {
            LazyObjectReference _ref11 = transLocal.lazyReferenceFor((int) _id11);
            _ident_Department.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref11.getObject());
        }

        java.util.Collection<java.lang.String> _dotResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl : _ident_Department) {
            if (_dotEl == null) {
                continue;
            }

            if (_dotEl != null) {
                ocb.activate(_dotEl, 1);
            }

            java.util.List<java.lang.String> _mth_getLocationResult = _dotEl.getLocation();

            if (_mth_getLocationResult != null) {
                ocb.activate(_mth_getLocationResult, 2);
            }

            if (_mth_getLocationResult != null) {
                ocb.activate(_mth_getLocationResult, 2);
            }

            _dotResult.addAll(_mth_getLocationResult);
            _dotIndex++;
        }

        java.util.Collection<java.lang.String> _uniqueResult = new java.util.ArrayList<java.lang.String>();
        Set<java.lang.String> _tmp0 = new LinkedHashSet<java.lang.String>();
        _tmp0.addAll(_dotResult);
        _uniqueResult.addAll(_tmp0);

        java.util.Collection<java.lang.String> _asResult_deptcity = _uniqueResult;
        java.util.Collection<java.lang.String> _whereResult = new java.util.ArrayList<java.lang.String>();
        int _whereLoopIndex = 0;

        for (java.lang.String _whereEl : _asResult_deptcity) {
            if (_whereEl == null) {
                continue;
            }

            if (_whereEl != null) {
                ocb.activate(_whereEl, 1);
            }

            final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
            ClassMetadata _classMeta12 = ocb.classCollection()
                                            .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
            long[] _ids12 = _classMeta12.getIDs(transLocal);

            for (long _id12 : _ids12) {
                LazyObjectReference _ref12 = transLocal.lazyReferenceFor((int) _id12);
                _ident_Department1.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref12.getObject());
            }

            java.lang.Boolean _allResult = true;
            Integer _allIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _allEl : _ident_Department1) {
                if (_allEl != null) {
                    ocb.activate(_allEl, 1);
                }

                java.lang.String _ident_deptcity = _whereEl;

                if (_ident_deptcity != null) {
                    ocb.activate(_ident_deptcity, 1);
                }

                java.util.List<java.lang.String> _mth_getLocationResult1 = _allEl.getLocation();

                if (_mth_getLocationResult1 != null) {
                    ocb.activate(_mth_getLocationResult1, 2);
                }

                Collection _inLeftCol0 = new ArrayList();
                _inLeftCol0.add(_ident_deptcity);

                Collection _inRightCol0 = new ArrayList(_mth_getLocationResult1);
                java.lang.Boolean _inResult = _inRightCol0.containsAll(_inLeftCol0);

                if (!_inResult) {
                    _allResult = false;

                    break;
                }
            }

            if (_allResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_whereResult, ocb);

        return _whereResult;
    }
}
