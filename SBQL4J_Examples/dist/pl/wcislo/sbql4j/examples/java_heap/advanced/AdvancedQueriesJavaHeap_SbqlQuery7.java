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


public class AdvancedQueriesJavaHeap_SbqlQuery7 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept;

    public AdvancedQueriesJavaHeap_SbqlQuery7(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept) {
        this.dept = dept;
    }

    /**
     * original query='all (dept as d)
                            any ((d.employs minus d.boss) as e)
                            (e.salary == d.boss.salary)'
     *
     * query after optimization=' all dept as d  any d.getEmploys() minus d.getBoss() as e e.getSalary() == d.getBoss().getSalary()'
    */
    public java.lang.Boolean executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept =
            dept;
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _asResult_d =
            _ident_dept;
        java.lang.Boolean _queryResult = true;
        Integer _allIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _allEl : _asResult_d) {
            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d = _allEl;
            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl = _ident_d;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                _dotEl.getEmploys();
            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d1 = _allEl;
            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 = _ident_d1;
            pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult =
                _dotEl1.getBoss();
            Collection _minusLeftCol0 = new ArrayList(_mth_getEmploysResult);
            Collection _minusRightCol0 = new ArrayList();
            _minusRightCol0.add(_mth_getBossResult);

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _exceptResult =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            _exceptResult.addAll(CollectionUtils.subtract(_minusLeftCol0,
                    _minusRightCol0));

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _asResult_e =
                _exceptResult;
            java.lang.Boolean _anyResult = false;
            Integer _anyIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _anyEl : _asResult_e) {
                pl.wcislo.sbql4j.examples.model.advanced.Employee _ident_e = _anyEl;
                pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl2 = _ident_e;
                java.lang.Double _mth_getSalaryResult = _dotEl2.getSalary();
                pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d2 = _allEl;
                pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl3 = _ident_d2;
                pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult1 =
                    _dotEl3.getBoss();
                pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl4 = _mth_getBossResult1;
                java.lang.Double _mth_getSalaryResult1 = _dotEl4.getSalary();
                java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getSalaryResult,
                        _mth_getSalaryResult1);

                if (_equalsResult) {
                    _anyResult = true;

                    break;
                }
            }

            if (!_anyResult) {
                _queryResult = false;

                break;
            }
        }

        return _queryResult;
    }
}
