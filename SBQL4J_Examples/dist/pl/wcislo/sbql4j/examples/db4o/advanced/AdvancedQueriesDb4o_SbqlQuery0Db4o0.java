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


public class AdvancedQueriesDb4o_SbqlQuery0Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery0Db4o0() {
    }

    /**
     * query='db.(Department join  avg(getEmploys().getSalary()))'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        ClassMetadata _classMeta0 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
        long[] _ids0 = _classMeta0.getIDs(transLocal);

        for (long _id0 : _ids0) {
            LazyObjectReference _ref0 = transLocal.lazyReferenceFor((int) _id0);
            _ident_Department.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref0.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _joinEl : _ident_Department) {
            if (_joinEl != null) {
                ocb.activate(_joinEl, 1);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                _joinEl.getEmploys();

            if (_mth_getEmploysResult != null) {
                ocb.activate(_mth_getEmploysResult, 2);
            }

            java.util.List<java.lang.Double> _dotResult = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl : _mth_getEmploysResult) {
                if (_dotEl == null) {
                    continue;
                }

                if (_dotEl != null) {
                    ocb.activate(_dotEl, 1);
                }

                java.lang.Double _mth_getSalaryResult = _dotEl.getSalary();

                if (_mth_getSalaryResult != null) {
                    ocb.activate(_mth_getSalaryResult, 1);
                }

                if (_mth_getSalaryResult != null) {
                    ocb.activate(_mth_getSalaryResult, 1);
                }

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

            _joinResult.add(OperatorUtils.cartesianProductSS(_joinEl,
                    _avgResult, "", ""));
            _joinIndex++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_joinResult, ocb);

        return _joinResult;
    }
}
