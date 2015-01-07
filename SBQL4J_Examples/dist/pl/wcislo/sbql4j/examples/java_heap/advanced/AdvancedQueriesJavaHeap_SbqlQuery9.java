package pl.wcislo.sbql4j.examples.java_heap.advanced;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
import pl.wcislo.sbql4j.exception.*;
import pl.wcislo.sbql4j.java.model.compiletime.Signature.SCollectionType;
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

import java.util.*;
import java.util.Collection;
import java.util.List;


public class AdvancedQueriesJavaHeap_SbqlQuery9 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept;

    public AdvancedQueriesJavaHeap_SbqlQuery9(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept) {
        this.dept = dept;
    }

    /**
     * original query='(unique(dept.location)) as deptcity
                             where all(dept)(deptcity in location)'
     *
     * query after optimization=' unique dept.getLocation() as deptcity where  all dept deptcity in getLocation()'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept =
            dept;
        java.util.List<java.lang.String> _dotResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl : _ident_dept) {
            if (_dotEl == null) {
                continue;
            }

            java.util.List<java.lang.String> _mth_getLocationResult = _dotEl.getLocation();
            _dotResult.addAll(_mth_getLocationResult);
            _dotIndex++;
        }

        java.util.List<java.lang.String> _uniqueResult = new java.util.ArrayList<java.lang.String>();
        Set<java.lang.String> _tmp0 = new LinkedHashSet<java.lang.String>();
        _tmp0.addAll(_dotResult);
        _uniqueResult.addAll(_tmp0);

        java.util.List<java.lang.String> _asResult_deptcity = _uniqueResult;
        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        int _whereLoopIndex = 0;

        for (java.lang.String _whereEl : _asResult_deptcity) {
            if (_whereEl == null) {
                continue;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept1 =
                dept;
            java.lang.Boolean _allResult = true;
            Integer _allIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _allEl : _ident_dept1) {
                java.lang.String _ident_deptcity = _whereEl;
                java.util.List<java.lang.String> _mth_getLocationResult1 = _allEl.getLocation();
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
                _queryResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        return _queryResult;
    }
}
