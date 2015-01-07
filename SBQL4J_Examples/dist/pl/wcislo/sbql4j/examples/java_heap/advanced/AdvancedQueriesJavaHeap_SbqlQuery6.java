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


public class AdvancedQueriesJavaHeap_SbqlQuery6 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept;

    public AdvancedQueriesJavaHeap_SbqlQuery6(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept) {
        this.dept = dept;
    }

    /**
     * original query='((dept as d) join ((sum(d.employs.salary) - (d.boss.salary)) as s)).(d.name, s)'
     *
     * query after optimization='(dept as d join ( sum d.getEmploys().getSalary() - d.getBoss().getSalary()) as s).(d.getName(), s)'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept =
            dept;
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _asResult_d =
            _ident_dept;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _joinEl : _asResult_d) {
            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d = _joinEl;
            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl = _ident_d;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                _dotEl.getEmploys();
            java.util.List<java.lang.Double> _dotResult1 = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl1 : _mth_getEmploysResult) {
                if (_dotEl1 == null) {
                    continue;
                }

                java.lang.Double _mth_getSalaryResult = _dotEl1.getSalary();
                _dotResult1.add(_mth_getSalaryResult);
                _dotIndex1++;
            }

            Number _sum0 = null;

            for (Number _sumEl0 : _dotResult1) {
                _sum0 = MathUtils.sum(_sum0, _sumEl0);
            }

            java.lang.Double _sumResult = (java.lang.Double) _sum0;
            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d1 = _joinEl;
            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl2 = _ident_d1;
            pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult =
                _dotEl2.getBoss();
            pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl3 = _mth_getBossResult;
            java.lang.Double _mth_getSalaryResult1 = _dotEl3.getSalary();
            java.lang.Double _minusResult = _sumResult - _mth_getSalaryResult1;
            java.lang.Double _asResult_s = _minusResult;
            _joinResult.add(OperatorUtils.cartesianProductSS(_joinEl,
                    _asResult_s, "d", "s"));
            _joinIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex5 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl5 : _joinResult) {
            if (_dotEl5 == null) {
                continue;
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d2 = (pl.wcislo.sbql4j.examples.model.advanced.Department) _dotEl5.get(
                    "d");
            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl4 = _ident_d2;
            java.lang.String _mth_getNameResult = _dotEl4.getName();
            java.lang.Double _ident_s = (java.lang.Double) _dotEl5.get("s");
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_mth_getNameResult,
                    _ident_s, "", "");
            _queryResult.add(_commaResult);
            _dotIndex5++;
        }

        return _queryResult;
    }
}
