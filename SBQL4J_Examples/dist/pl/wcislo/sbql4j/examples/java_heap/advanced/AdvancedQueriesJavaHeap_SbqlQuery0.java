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


public class AdvancedQueriesJavaHeap_SbqlQuery0 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> depts;

    public AdvancedQueriesJavaHeap_SbqlQuery0(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> depts) {
        this.depts = depts;
    }

    /**
     * original query='depts join avg(employs.salary)'
     *
     * query after optimization='depts join  avg(getEmploys().getSalary())'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_depts =
            depts;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _joinEl : _ident_depts) {
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                _joinEl.getEmploys();
            java.util.List<java.lang.Double> _dotResult = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl : _mth_getEmploysResult) {
                if (_dotEl == null) {
                    continue;
                }

                java.lang.Double _mth_getSalaryResult = _dotEl.getSalary();
                _dotResult.add(_mth_getSalaryResult);
                _dotIndex++;
            }

            java.lang.Double _avgResult = 0d;

            if ((_dotResult != null) && !_dotResult.isEmpty()) {
                Number _avgSum0 = null;

                for (Number _avgEl0 : _dotResult) {
                    _avgSum0 = MathUtils.sum(_avgSum0, _avgEl0);
                }

                _avgResult = _avgSum0.doubleValue() / _dotResult.size();
            }

            _queryResult.add(OperatorUtils.cartesianProductSS(_joinEl,
                    _avgResult, "", ""));
            _joinIndex++;
        }

        return _queryResult;
    }
}
