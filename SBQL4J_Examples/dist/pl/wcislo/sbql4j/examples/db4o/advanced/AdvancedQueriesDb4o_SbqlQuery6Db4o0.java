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


public class AdvancedQueriesDb4o_SbqlQuery6Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery6Db4o0() {
    }

    /**
     * query='db.(Department as d join ( sum d.getEmploys().getSalary() - d.getBoss().getSalary()) as s).(d.getName(), s)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        ClassMetadata _classMeta8 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
        long[] _ids8 = _classMeta8.getIDs(transLocal);

        for (long _id8 : _ids8) {
            LazyObjectReference _ref8 = transLocal.lazyReferenceFor((int) _id8);
            _ident_Department.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref8.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _asResult_d =
            _ident_Department;
        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _joinEl : _asResult_d) {
            if (_joinEl != null) {
                ocb.activate(_joinEl, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d = _joinEl;

            if (_ident_d != null) {
                ocb.activate(_ident_d, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl = _ident_d;

            if (_ident_d != null) {
                ocb.activate(_ident_d, 2);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                _dotEl.getEmploys();

            if (_mth_getEmploysResult != null) {
                ocb.activate(_mth_getEmploysResult, 2);
            }

            java.util.List<java.lang.Double> _dotResult1 = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl1 : _mth_getEmploysResult) {
                if (_dotEl1 == null) {
                    continue;
                }

                if (_dotEl1 != null) {
                    ocb.activate(_dotEl1, 1);
                }

                java.lang.Double _mth_getSalaryResult = _dotEl1.getSalary();

                if (_mth_getSalaryResult != null) {
                    ocb.activate(_mth_getSalaryResult, 1);
                }

                if (_mth_getSalaryResult != null) {
                    ocb.activate(_mth_getSalaryResult, 1);
                }

                _dotResult1.add(_mth_getSalaryResult);
                _dotIndex1++;
            }

            Number _sum0 = null;

            for (Number _sumEl0 : _dotResult1) {
                _sum0 = MathUtils.sum(_sum0, _sumEl0);
            }

            java.lang.Double _sumResult = (java.lang.Double) _sum0;
            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d1 = _joinEl;

            if (_ident_d1 != null) {
                ocb.activate(_ident_d1, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl2 = _ident_d1;

            if (_ident_d1 != null) {
                ocb.activate(_ident_d1, 2);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult =
                _dotEl2.getBoss();

            if (_mth_getBossResult != null) {
                ocb.activate(_mth_getBossResult, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl3 = _mth_getBossResult;

            if (_mth_getBossResult != null) {
                ocb.activate(_mth_getBossResult, 2);
            }

            java.lang.Double _mth_getSalaryResult1 = _dotEl3.getSalary();

            if (_mth_getSalaryResult1 != null) {
                ocb.activate(_mth_getSalaryResult1, 1);
            }

            java.lang.Double _minusResult = _sumResult - _mth_getSalaryResult1;
            java.lang.Double _asResult_s = _minusResult;
            _joinResult.add(OperatorUtils.cartesianProductSS(_joinEl,
                    _asResult_s, "d", "s"));
            _joinIndex++;
        }

        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult5 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex5 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl5 : _joinResult) {
            if (_dotEl5 == null) {
                continue;
            }

            if (_dotEl5 != null) {
                ocb.activate(_dotEl5, 2);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d2 = (pl.wcislo.sbql4j.examples.model.advanced.Department) _dotEl5.get(
                    "d");

            if (_ident_d2 != null) {
                ocb.activate(_ident_d2, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl4 = _ident_d2;

            if (_ident_d2 != null) {
                ocb.activate(_ident_d2, 2);
            }

            java.lang.String _mth_getNameResult = _dotEl4.getName();

            if (_mth_getNameResult != null) {
                ocb.activate(_mth_getNameResult, 1);
            }

            java.lang.Double _ident_s = (java.lang.Double) _dotEl5.get("s");

            if (_ident_s != null) {
                ocb.activate(_ident_s, 1);
            }

            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_mth_getNameResult,
                    _ident_s, "", "");

            if (_commaResult != null) {
                ocb.activate(_commaResult, 2);
            }

            _dotResult5.add(_commaResult);
            _dotIndex5++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult5, ocb);

        return _dotResult5;
    }
}
