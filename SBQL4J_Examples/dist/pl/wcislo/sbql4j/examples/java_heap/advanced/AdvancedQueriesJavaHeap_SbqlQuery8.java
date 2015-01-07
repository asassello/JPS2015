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


public class AdvancedQueriesJavaHeap_SbqlQuery8 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> emp;

    public AdvancedQueriesJavaHeap_SbqlQuery8(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> emp) {
        this.emp = emp;
    }

    /**
     * original query='emp.("Employee " + name + " consumes " + (salary * 12 * 100 / (worksIn.budget)) +
                                            "% of the " + worksIn.name + " department budget.")'
     *
     * query after optimization='emp.("Employee " + getName() + " consumes " + getSalary() * 12 * 100/ getWorksIn().getBudget() + "% of the " + getWorksIn().getName() + " department budget.")'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_emp =
            emp;
        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex2 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl2 : _ident_emp) {
            if (_dotEl2 == null) {
                continue;
            }

            java.lang.String _mth_getNameResult = _dotEl2.getName();
            java.lang.String _plusResult = "Employee " + _mth_getNameResult;
            java.lang.String _plusResult1 = _plusResult + " consumes ";
            java.lang.Double _mth_getSalaryResult = _dotEl2.getSalary();
            java.lang.Double _multiplyResult = _mth_getSalaryResult * 12;
            java.lang.Double _multiplyResult1 = _multiplyResult * 100;
            pl.wcislo.sbql4j.examples.model.advanced.Department _mth_getWorksInResult =
                _dotEl2.getWorksIn();
            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl = _mth_getWorksInResult;
            java.lang.Double _mth_getBudgetResult = _dotEl.getBudget();
            java.lang.Double _divideResult = _multiplyResult1 / _mth_getBudgetResult;
            java.lang.String _plusResult2 = _plusResult1 + _divideResult;
            java.lang.String _plusResult3 = _plusResult2 + "% of the ";
            pl.wcislo.sbql4j.examples.model.advanced.Department _mth_getWorksInResult1 =
                _dotEl2.getWorksIn();
            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 = _mth_getWorksInResult1;
            java.lang.String _mth_getNameResult1 = _dotEl1.getName();
            java.lang.String _plusResult4 = _plusResult3 + _mth_getNameResult1;
            java.lang.String _plusResult5 = _plusResult4 +
                " department budget.";
            _queryResult.add(_plusResult5);
            _dotIndex2++;
        }

        return _queryResult;
    }
}
