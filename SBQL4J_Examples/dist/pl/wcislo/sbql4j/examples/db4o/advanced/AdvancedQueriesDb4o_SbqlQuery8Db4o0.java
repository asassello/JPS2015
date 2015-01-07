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


public class AdvancedQueriesDb4o_SbqlQuery8Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery8Db4o0() {
    }

    /**
     * query='db.Employee.("Employee " + getName() + " consumes " + getSalary() * 12 * 100/ getWorksIn().getBudget() + "% of the " + getWorksIn().getName() + " department budget.")'
    '
     **/
    public java.util.Collection<java.lang.String> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_Employee =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        ClassMetadata _classMeta10 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Employee");
        long[] _ids10 = _classMeta10.getIDs(transLocal);

        for (long _id10 : _ids10) {
            LazyObjectReference _ref10 = transLocal.lazyReferenceFor((int) _id10);
            _ident_Employee.add((pl.wcislo.sbql4j.examples.model.advanced.Employee) _ref10.getObject());
        }

        java.util.Collection<java.lang.String> _dotResult2 = new java.util.ArrayList<java.lang.String>();
        int _dotIndex2 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl2 : _ident_Employee) {
            if (_dotEl2 == null) {
                continue;
            }

            if (_dotEl2 != null) {
                ocb.activate(_dotEl2, 1);
            }

            java.lang.String _mth_getNameResult = _dotEl2.getName();

            if (_mth_getNameResult != null) {
                ocb.activate(_mth_getNameResult, 1);
            }

            java.lang.String _plusResult = "Employee " + _mth_getNameResult;
            java.lang.String _plusResult1 = _plusResult + " consumes ";
            java.lang.Double _mth_getSalaryResult = _dotEl2.getSalary();

            if (_mth_getSalaryResult != null) {
                ocb.activate(_mth_getSalaryResult, 1);
            }

            java.lang.Double _multiplyResult = _mth_getSalaryResult * 12;
            java.lang.Double _multiplyResult1 = _multiplyResult * 100;
            pl.wcislo.sbql4j.examples.model.advanced.Department _mth_getWorksInResult =
                _dotEl2.getWorksIn();

            if (_mth_getWorksInResult != null) {
                ocb.activate(_mth_getWorksInResult, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl = _mth_getWorksInResult;

            if (_mth_getWorksInResult != null) {
                ocb.activate(_mth_getWorksInResult, 2);
            }

            java.lang.Double _mth_getBudgetResult = _dotEl.getBudget();

            if (_mth_getBudgetResult != null) {
                ocb.activate(_mth_getBudgetResult, 1);
            }

            java.lang.Double _divideResult = _multiplyResult1 / _mth_getBudgetResult;
            java.lang.String _plusResult2 = _plusResult1 + _divideResult;
            java.lang.String _plusResult3 = _plusResult2 + "% of the ";
            pl.wcislo.sbql4j.examples.model.advanced.Department _mth_getWorksInResult1 =
                _dotEl2.getWorksIn();

            if (_mth_getWorksInResult1 != null) {
                ocb.activate(_mth_getWorksInResult1, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 = _mth_getWorksInResult1;

            if (_mth_getWorksInResult1 != null) {
                ocb.activate(_mth_getWorksInResult1, 2);
            }

            java.lang.String _mth_getNameResult1 = _dotEl1.getName();

            if (_mth_getNameResult1 != null) {
                ocb.activate(_mth_getNameResult1, 1);
            }

            java.lang.String _plusResult4 = _plusResult3 + _mth_getNameResult1;
            java.lang.String _plusResult5 = _plusResult4 +
                " department budget.";

            if (_plusResult5 != null) {
                ocb.activate(_plusResult5, 1);
            }

            _dotResult2.add(_plusResult5);
            _dotIndex2++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult2, ocb);

        return _dotResult2;
    }
}
