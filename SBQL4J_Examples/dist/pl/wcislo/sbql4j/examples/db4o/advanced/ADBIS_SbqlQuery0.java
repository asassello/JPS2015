package pl.wcislo.sbql4j.examples.db4o.advanced;

import com.db4o.*;

import com.db4o.config.Configuration;
import com.db4o.config.ObjectClass;

import com.db4o.events.ObjectContainerEventArgs;

import com.db4o.ext.ExtObjectContainer;
import com.db4o.ext.StoredClass;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
import pl.wcislo.sbql4j.examples.model.advanced.Employee;
import pl.wcislo.sbql4j.examples.model.linq.*;
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

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.text.*;

import java.util.*;


public class ADBIS_SbqlQuery0 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> depts;
    private com.db4o.ObjectContainer db1;
    private com.db4o.ObjectContainer db2;
    private java.lang.Double minSalary;

    public ADBIS_SbqlQuery0(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> depts,
        final com.db4o.ObjectContainer db1, final com.db4o.ObjectContainer db2,
        final java.lang.Double minSalary) {
        this.depts = depts;
        this.db1 = db1;
        this.db2 = db2;
        this.minSalary = minSalary;
    }

    /**
     * original query='db1.(Employee where salary > avg(depts.budget) / 10)
                            union db2.(Employee where salary > minSalary)'
     *
     * query after optimization='(( avg(depts.getBudget())/ 10) group as _aux0).db1.(Employee where getSalary() > _aux0) union db2.(Employee where getSalary() > minSalary)'
    */
    public java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_depts =
            depts;
        java.util.List<java.lang.Double> _dotResult = new java.util.ArrayList<java.lang.Double>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl : _ident_depts) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.Double _mth_getBudgetResult = _dotEl.getBudget();
            _dotResult.add(_mth_getBudgetResult);
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

        java.lang.Double _divideResult = _avgResult / 10;
        java.lang.Double _groupAsResult_aux0 = _divideResult;
        java.lang.Double _dotEl2 = _groupAsResult_aux0;
        com.db4o.ObjectContainer _ident_db1 = db1;
        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult1 =
            _ident_db1.query(new ADBIS_SbqlQuery0Db4o0(_groupAsResult_aux0));
        com.db4o.ObjectContainer _ident_db2 = db2;
        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult3 =
            _ident_db2.query(new ADBIS_SbqlQuery0Db4o1(minSalary));
        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _queryResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        _queryResult.addAll(_dotResult1);
        _queryResult.addAll(_dotResult3);

        return _queryResult;
    }
}
