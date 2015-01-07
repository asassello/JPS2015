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


public class AdvancedQueriesJavaHeap_SbqlQuery5 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept;

    public AdvancedQueriesJavaHeap_SbqlQuery5(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept) {
        this.dept = dept;
    }

    /**
     * original query='min(dept.count(employs)) as minimum,
                            avg(dept.count(employs)) as average,
                            max(dept.count(employs)) as maximum'
     *
     * query after optimization=' min(dept.( count(getEmploys()))) as minimum,  avg(dept.( count(getEmploys()))) as average,  max(dept.( count(getEmploys()))) as maximum'
    */
    public pl.wcislo.sbql4j.java.model.runtime.Struct executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept =
            dept;
        java.util.List<java.lang.Integer> _dotResult = new java.util.ArrayList<java.lang.Integer>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl : _ident_dept) {
            if (_dotEl == null) {
                continue;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                _dotEl.getEmploys();
            java.lang.Integer _countResult = _mth_getEmploysResult.size();
            _dotResult.add(_countResult);
            _dotIndex++;
        }

        Number _min0 = null;

        for (Number _minEl0 : _dotResult) {
            _min0 = MathUtils.min(_min0, _minEl0);
        }

        java.lang.Integer _minResult = (java.lang.Integer) _min0;
        java.lang.Integer _asResult_minimum = _minResult;
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept1 =
            dept;
        java.util.List<java.lang.Integer> _dotResult1 = new java.util.ArrayList<java.lang.Integer>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 : _ident_dept1) {
            if (_dotEl1 == null) {
                continue;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult1 =
                _dotEl1.getEmploys();
            java.lang.Integer _countResult1 = _mth_getEmploysResult1.size();
            _dotResult1.add(_countResult1);
            _dotIndex1++;
        }

        java.lang.Double _avgResult = 0d;

        if ((_dotResult1 != null) && !_dotResult1.isEmpty()) {
            Number _avgSum1 = null;

            for (Number _avgEl1 : _dotResult1) {
                _avgSum1 = MathUtils.sum(_avgSum1, _avgEl1);
            }

            _avgResult = _avgSum1.doubleValue() / _dotResult1.size();
        }

        java.lang.Double _asResult_average = _avgResult;
        pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_minimum,
                _asResult_average, "minimum", "average");
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept2 =
            dept;
        java.util.List<java.lang.Integer> _dotResult2 = new java.util.ArrayList<java.lang.Integer>();
        int _dotIndex2 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl2 : _ident_dept2) {
            if (_dotEl2 == null) {
                continue;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult2 =
                _dotEl2.getEmploys();
            java.lang.Integer _countResult2 = _mth_getEmploysResult2.size();
            _dotResult2.add(_countResult2);
            _dotIndex2++;
        }

        Number _max0 = null;

        for (Number _maxEl0 : _dotResult2) {
            _max0 = MathUtils.max(_max0, _maxEl0);
        }

        java.lang.Integer _maxResult = (java.lang.Integer) _max0;
        java.lang.Integer _asResult_maximum = _maxResult;
        pl.wcislo.sbql4j.java.model.runtime.Struct _queryResult = OperatorUtils.cartesianProductSS(_commaResult,
                _asResult_maximum, "", "maximum");

        return _queryResult;
    }
}
