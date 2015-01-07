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


public class AdvancedQueriesDb4o_SbqlQuery1Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery1Db4o0() {
    }

    /**
     * query='db.(Employee where getSalary() < 2222).(getName(), getSalary(), getWorksIn().getName())'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_Employee =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        ClassMetadata _classMeta1 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Employee");
        long[] _ids1 = _classMeta1.getIDs(transLocal);

        for (long _id1 : _ids1) {
            LazyObjectReference _ref1 = transLocal.lazyReferenceFor((int) _id1);
            _ident_Employee.add((pl.wcislo.sbql4j.examples.model.advanced.Employee) _ref1.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _whereEl : _ident_Employee) {
            if (_whereEl == null) {
                continue;
            }

            if (_whereEl != null) {
                ocb.activate(_whereEl, 1);
            }

            java.lang.Double _mth_getSalaryResult = _whereEl.getSalary();

            if (_mth_getSalaryResult != null) {
                ocb.activate(_mth_getSalaryResult, 1);
            }

            Boolean _lessResult = _mth_getSalaryResult < 2222;

            if (_lessResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl1 : _whereResult) {
            if (_dotEl1 == null) {
                continue;
            }

            if (_dotEl1 != null) {
                ocb.activate(_dotEl1, 2);
            }

            java.lang.String _mth_getNameResult = _dotEl1.getName();

            if (_mth_getNameResult != null) {
                ocb.activate(_mth_getNameResult, 1);
            }

            java.lang.Double _mth_getSalaryResult1 = _dotEl1.getSalary();

            if (_mth_getSalaryResult1 != null) {
                ocb.activate(_mth_getSalaryResult1, 1);
            }

            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_mth_getNameResult,
                    _mth_getSalaryResult1, "", "");
            pl.wcislo.sbql4j.examples.model.advanced.Department _mth_getWorksInResult =
                _dotEl1.getWorksIn();

            if (_mth_getWorksInResult != null) {
                ocb.activate(_mth_getWorksInResult, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl = _mth_getWorksInResult;

            if (_mth_getWorksInResult != null) {
                ocb.activate(_mth_getWorksInResult, 2);
            }

            java.lang.String _mth_getNameResult1 = _dotEl.getName();

            if (_mth_getNameResult1 != null) {
                ocb.activate(_mth_getNameResult1, 1);
            }

            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_commaResult,
                    _mth_getNameResult1, "", "");

            if (_commaResult1 != null) {
                ocb.activate(_commaResult1, 2);
            }

            _dotResult1.add(_commaResult1);
            _dotIndex1++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult1, ocb);

        return _dotResult1;
    }
}
