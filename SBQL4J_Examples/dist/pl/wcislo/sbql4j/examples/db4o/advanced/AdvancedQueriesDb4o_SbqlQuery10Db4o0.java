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


public class AdvancedQueriesDb4o_SbqlQuery10Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery10Db4o0() {
    }

    /**
     * query='db.((0 as i close by (i + 1000 where i <=  max(Employee.getSalary())) as i join  count((Employee where getSalary() >= i and getSalary() < i + 1000)) as c join c == 1 ? "" as n, "s" as v : "s" as n, "" as v).(c + " employee" + n + " earn" + v + " between " + i + " and " + i + 999) as message)'
    '
     **/
    public java.util.List<java.lang.String> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        java.lang.Integer _asResult_i = 0;
        java.util.List<java.lang.Integer> _closeByResult = new ArrayList<java.lang.Integer>();
        _closeByResult.add(_asResult_i);

        int _i0 = 0;

        while (_i0 < _closeByResult.size()) {
            java.lang.Integer _closeByEl = _closeByResult.get(_i0);

            if (_closeByEl != null) {
                ocb.activate(_closeByEl, 1);
            }

            java.lang.Integer _ident_i = _closeByEl;

            if (_ident_i != null) {
                ocb.activate(_ident_i, 1);
            }

            java.lang.Integer _plusResult = _ident_i + 1000;

            if (_plusResult != null) {
                ocb.activate(_plusResult, 2);
            }

            java.lang.Integer _whereEl = _plusResult;
            java.lang.Integer _ident_i1 = _closeByEl;

            if (_ident_i1 != null) {
                ocb.activate(_ident_i1, 1);
            }

            final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_Employee =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            ClassMetadata _classMeta13 = ocb.classCollection()
                                            .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Employee");
            long[] _ids13 = _classMeta13.getIDs(transLocal);

            for (long _id13 : _ids13) {
                LazyObjectReference _ref13 = transLocal.lazyReferenceFor((int) _id13);
                _ident_Employee.add((pl.wcislo.sbql4j.examples.model.advanced.Employee) _ref13.getObject());
            }

            java.util.Collection<java.lang.Double> _dotResult = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl : _ident_Employee) {
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

            Number _max1 = null;

            for (Number _maxEl1 : _dotResult) {
                _max1 = MathUtils.max(_max1, _maxEl1);
            }

            java.lang.Double _maxResult = (java.lang.Double) _max1;

            Boolean _less_or_equalResult = _ident_i1 <= _maxResult;
            java.lang.Integer _whereResult = null;

            if (_less_or_equalResult) {
                _whereResult = _plusResult;
            }

            java.lang.Integer _asResult_i1 = _whereResult;

            if (_asResult_i1 != null) {
                _closeByResult.add(_asResult_i1);
            }

            _i0++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex = 0;

        for (java.lang.Integer _joinEl : _closeByResult) {
            if (_joinEl != null) {
                ocb.activate(_joinEl, 1);
            }

            final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_Employee1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            ClassMetadata _classMeta14 = ocb.classCollection()
                                            .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Employee");
            long[] _ids14 = _classMeta14.getIDs(transLocal);

            for (long _id14 : _ids14) {
                LazyObjectReference _ref14 = transLocal.lazyReferenceFor((int) _id14);
                _ident_Employee1.add((pl.wcislo.sbql4j.examples.model.advanced.Employee) _ref14.getObject());
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _whereResult1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            int _whereLoopIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _whereEl1 : _ident_Employee1) {
                if (_whereEl1 == null) {
                    continue;
                }

                if (_whereEl1 != null) {
                    ocb.activate(_whereEl1, 1);
                }

                java.lang.Double _mth_getSalaryResult1 = _whereEl1.getSalary();

                if (_mth_getSalaryResult1 != null) {
                    ocb.activate(_mth_getSalaryResult1, 1);
                }

                java.lang.Integer _ident_i2 = _joinEl;

                if (_ident_i2 != null) {
                    ocb.activate(_ident_i2, 1);
                }

                Boolean _more_or_equalResult = _mth_getSalaryResult1 >= _ident_i2;
                java.lang.Boolean _andResult;

                if (!_more_or_equalResult) {
                    _andResult = false;
                } else {
                    java.lang.Double _mth_getSalaryResult2 = _whereEl1.getSalary();

                    if (_mth_getSalaryResult2 != null) {
                        ocb.activate(_mth_getSalaryResult2, 1);
                    }

                    java.lang.Integer _ident_i3 = _joinEl;

                    if (_ident_i3 != null) {
                        ocb.activate(_ident_i3, 1);
                    }

                    java.lang.Integer _plusResult1 = _ident_i3 + 1000;

                    Boolean _lessResult = _mth_getSalaryResult2 < _plusResult1;
                    _andResult = _lessResult;
                }

                if (_andResult) {
                    _whereResult1.add(_whereEl1);
                }

                _whereLoopIndex1++;
            }

            java.lang.Integer _countResult = _whereResult1.size();
            java.lang.Integer _asResult_c = _countResult;
            _joinResult.add(OperatorUtils.cartesianProductSS(_joinEl,
                    _asResult_c, "i", "c"));
            _joinIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult1 = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _joinIndex1 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _joinEl1 : _joinResult) {
            if (_joinEl1 != null) {
                ocb.activate(_joinEl1, 1);
            }

            java.lang.Integer _ident_c = (java.lang.Integer) _joinEl1.get("c");

            if (_ident_c != null) {
                ocb.activate(_ident_c, 1);
            }

            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_c,
                    1);
            Boolean _b1 = _equalsResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _conditionalResult;

            if (_b1) {
                java.lang.String _asResult_n = "";
                java.lang.String _asResult_v = "s";
                pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_n,
                        _asResult_v, "n", "v");
                _conditionalResult = _commaResult;
            } else {
                java.lang.String _asResult_n1 = "s";
                java.lang.String _asResult_v1 = "";
                pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_asResult_n1,
                        _asResult_v1, "n", "v");
                _conditionalResult = _commaResult1;
            }

            _joinResult1.add(OperatorUtils.cartesianProductSS(_joinEl1,
                    _conditionalResult, "", ""));
            _joinIndex1++;
        }

        java.util.List<java.lang.String> _dotResult1 = new java.util.ArrayList<java.lang.String>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl1 : _joinResult1) {
            if (_dotEl1 == null) {
                continue;
            }

            if (_dotEl1 != null) {
                ocb.activate(_dotEl1, 1);
            }

            java.lang.Integer _ident_c1 = (java.lang.Integer) _dotEl1.get("c");

            if (_ident_c1 != null) {
                ocb.activate(_ident_c1, 1);
            }

            java.lang.String _plusResult2 = _ident_c1 + " employee";
            java.lang.String _ident_n = (java.lang.String) _dotEl1.get("n");
            java.lang.String _plusResult3 = _plusResult2 + _ident_n;
            java.lang.String _plusResult4 = _plusResult3 + " earn";
            java.lang.String _ident_v = (java.lang.String) _dotEl1.get("v");
            java.lang.String _plusResult5 = _plusResult4 + _ident_v;
            java.lang.String _plusResult6 = _plusResult5 + " between ";
            java.lang.Integer _ident_i4 = (java.lang.Integer) _dotEl1.get("i");

            if (_ident_i4 != null) {
                ocb.activate(_ident_i4, 1);
            }

            java.lang.String _plusResult7 = _plusResult6 + _ident_i4;
            java.lang.String _plusResult8 = _plusResult7 + " and ";
            java.lang.Integer _ident_i5 = (java.lang.Integer) _dotEl1.get("i");

            if (_ident_i5 != null) {
                ocb.activate(_ident_i5, 1);
            }

            java.lang.Integer _plusResult9 = _ident_i5 + 999;
            java.lang.String _plusResult10 = _plusResult8 + _plusResult9;

            if (_plusResult10 != null) {
                ocb.activate(_plusResult10, 1);
            }

            _dotResult1.add(_plusResult10);
            _dotIndex1++;
        }

        java.util.List<java.lang.String> _asResult_message = _dotResult1;
        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_asResult_message,
            ocb);

        return _asResult_message;
    }
}
