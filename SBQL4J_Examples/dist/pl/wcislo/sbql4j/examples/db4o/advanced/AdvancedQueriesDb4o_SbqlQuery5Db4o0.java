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


public class AdvancedQueriesDb4o_SbqlQuery5Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery5Db4o0() {
    }

    /**
     * query='db.( min(Department.( count(getEmploys()))) as minimum,  avg(Department.( count(getEmploys()))) as average,  max(Department.( count(getEmploys()))) as maximum)'
    '
     **/
    public pl.wcislo.sbql4j.java.model.runtime.Struct executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        ClassMetadata _classMeta5 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
        long[] _ids5 = _classMeta5.getIDs(transLocal);

        for (long _id5 : _ids5) {
            LazyObjectReference _ref5 = transLocal.lazyReferenceFor((int) _id5);
            _ident_Department.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref5.getObject());
        }

        java.util.Collection<java.lang.Integer> _dotResult = new java.util.ArrayList<java.lang.Integer>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl : _ident_Department) {
            if (_dotEl == null) {
                continue;
            }

            if (_dotEl != null) {
                ocb.activate(_dotEl, 1);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                _dotEl.getEmploys();

            if (_mth_getEmploysResult != null) {
                ocb.activate(_mth_getEmploysResult, 2);
            }

            java.lang.Integer _countResult = _mth_getEmploysResult.size();

            if (_countResult != null) {
                ocb.activate(_countResult, 1);
            }

            _dotResult.add(_countResult);
            _dotIndex++;
        }

        Number _min0 = null;

        for (Number _minEl0 : _dotResult) {
            _min0 = MathUtils.min(_min0, _minEl0);
        }

        java.lang.Integer _minResult = (java.lang.Integer) _min0;
        java.lang.Integer _asResult_minimum = _minResult;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        ClassMetadata _classMeta6 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
        long[] _ids6 = _classMeta6.getIDs(transLocal);

        for (long _id6 : _ids6) {
            LazyObjectReference _ref6 = transLocal.lazyReferenceFor((int) _id6);
            _ident_Department1.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref6.getObject());
        }

        java.util.Collection<java.lang.Integer> _dotResult1 = new java.util.ArrayList<java.lang.Integer>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 : _ident_Department1) {
            if (_dotEl1 == null) {
                continue;
            }

            if (_dotEl1 != null) {
                ocb.activate(_dotEl1, 1);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult1 =
                _dotEl1.getEmploys();

            if (_mth_getEmploysResult1 != null) {
                ocb.activate(_mth_getEmploysResult1, 2);
            }

            java.lang.Integer _countResult1 = _mth_getEmploysResult1.size();

            if (_countResult1 != null) {
                ocb.activate(_countResult1, 1);
            }

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
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department2 =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        ClassMetadata _classMeta7 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
        long[] _ids7 = _classMeta7.getIDs(transLocal);

        for (long _id7 : _ids7) {
            LazyObjectReference _ref7 = transLocal.lazyReferenceFor((int) _id7);
            _ident_Department2.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref7.getObject());
        }

        java.util.Collection<java.lang.Integer> _dotResult2 = new java.util.ArrayList<java.lang.Integer>();
        int _dotIndex2 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl2 : _ident_Department2) {
            if (_dotEl2 == null) {
                continue;
            }

            if (_dotEl2 != null) {
                ocb.activate(_dotEl2, 1);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult2 =
                _dotEl2.getEmploys();

            if (_mth_getEmploysResult2 != null) {
                ocb.activate(_mth_getEmploysResult2, 2);
            }

            java.lang.Integer _countResult2 = _mth_getEmploysResult2.size();

            if (_countResult2 != null) {
                ocb.activate(_countResult2, 1);
            }

            _dotResult2.add(_countResult2);
            _dotIndex2++;
        }

        Number _max0 = null;

        for (Number _maxEl0 : _dotResult2) {
            _max0 = MathUtils.max(_max0, _maxEl0);
        }

        java.lang.Integer _maxResult = (java.lang.Integer) _max0;
        java.lang.Integer _asResult_maximum = _maxResult;
        pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_commaResult,
                _asResult_maximum, "", "maximum");
        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_commaResult1, ocb);

        return _commaResult1;
    }
}
