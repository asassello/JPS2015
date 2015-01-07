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


public class AdvancedQueriesDb4o_SbqlQuery7Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery7Db4o0() {
    }

    /**
     * query='db.( all Department as d  any d.getEmploys() minus d.getBoss() as e e.getSalary() == d.getBoss().getSalary())'
    '
     **/
    public java.lang.Boolean executeQuery(final ObjectContainerBase ocb,
        final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        ClassMetadata _classMeta9 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
        long[] _ids9 = _classMeta9.getIDs(transLocal);

        for (long _id9 : _ids9) {
            LazyObjectReference _ref9 = transLocal.lazyReferenceFor((int) _id9);
            _ident_Department.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref9.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _asResult_d =
            _ident_Department;
        java.lang.Boolean _allResult = true;
        Integer _allIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _allEl : _asResult_d) {
            if (_allEl != null) {
                ocb.activate(_allEl, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d = _allEl;

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

            pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d1 = _allEl;

            if (_ident_d1 != null) {
                ocb.activate(_ident_d1, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 = _ident_d1;

            if (_ident_d1 != null) {
                ocb.activate(_ident_d1, 2);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult =
                _dotEl1.getBoss();

            if (_mth_getBossResult != null) {
                ocb.activate(_mth_getBossResult, 1);
            }

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
                if (_anyEl != null) {
                    ocb.activate(_anyEl, 1);
                }

                pl.wcislo.sbql4j.examples.model.advanced.Employee _ident_e = _anyEl;

                if (_ident_e != null) {
                    ocb.activate(_ident_e, 1);
                }

                pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl2 = _ident_e;

                if (_ident_e != null) {
                    ocb.activate(_ident_e, 2);
                }

                java.lang.Double _mth_getSalaryResult = _dotEl2.getSalary();

                if (_mth_getSalaryResult != null) {
                    ocb.activate(_mth_getSalaryResult, 1);
                }

                pl.wcislo.sbql4j.examples.model.advanced.Department _ident_d2 = _allEl;

                if (_ident_d2 != null) {
                    ocb.activate(_ident_d2, 1);
                }

                pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl3 = _ident_d2;

                if (_ident_d2 != null) {
                    ocb.activate(_ident_d2, 2);
                }

                pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult1 =
                    _dotEl3.getBoss();

                if (_mth_getBossResult1 != null) {
                    ocb.activate(_mth_getBossResult1, 1);
                }

                pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl4 = _mth_getBossResult1;

                if (_mth_getBossResult1 != null) {
                    ocb.activate(_mth_getBossResult1, 2);
                }

                java.lang.Double _mth_getSalaryResult1 = _dotEl4.getSalary();

                if (_mth_getSalaryResult1 != null) {
                    ocb.activate(_mth_getSalaryResult1, 1);
                }

                java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getSalaryResult,
                        _mth_getSalaryResult1);

                if (_equalsResult) {
                    _anyResult = true;

                    break;
                }
            }

            if (!_anyResult) {
                _allResult = false;

                break;
            }
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_allResult, ocb);

        return _allResult;
    }
}
