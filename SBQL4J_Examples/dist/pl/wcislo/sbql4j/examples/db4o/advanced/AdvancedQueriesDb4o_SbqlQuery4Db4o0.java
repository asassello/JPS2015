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


public class AdvancedQueriesDb4o_SbqlQuery4Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery4Db4o0() {
    }

    /**
     * query='db.(Department where getBoss().getName() == "Bert").getEmploys().(getName(), ( exists getAddress() ? getAddress().getCity() : "No address"))'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        ClassMetadata _classMeta4 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
        long[] _ids4 = _classMeta4.getIDs(transLocal);

        for (long _id4 : _ids4) {
            LazyObjectReference _ref4 = transLocal.lazyReferenceFor((int) _id4);
            _ident_Department.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref4.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _whereEl : _ident_Department) {
            if (_whereEl == null) {
                continue;
            }

            if (_whereEl != null) {
                ocb.activate(_whereEl, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult =
                _whereEl.getBoss();

            if (_mth_getBossResult != null) {
                ocb.activate(_mth_getBossResult, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl = _mth_getBossResult;

            if (_mth_getBossResult != null) {
                ocb.activate(_mth_getBossResult, 2);
            }

            java.lang.String _mth_getNameResult = _dotEl.getName();

            if (_mth_getNameResult != null) {
                ocb.activate(_mth_getNameResult, 1);
            }

            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getNameResult,
                    "Bert");

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 : _whereResult) {
            if (_dotEl1 == null) {
                continue;
            }

            if (_dotEl1 != null) {
                ocb.activate(_dotEl1, 1);
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                _dotEl1.getEmploys();

            if (_mth_getEmploysResult != null) {
                ocb.activate(_mth_getEmploysResult, 2);
            }

            if (_mth_getEmploysResult != null) {
                ocb.activate(_mth_getEmploysResult, 2);
            }

            _dotResult1.addAll(_mth_getEmploysResult);
            _dotIndex1++;
        }

        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult3 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex3 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl3 : _dotResult1) {
            if (_dotEl3 == null) {
                continue;
            }

            if (_dotEl3 != null) {
                ocb.activate(_dotEl3, 2);
            }

            java.lang.String _mth_getNameResult1 = _dotEl3.getName();

            if (_mth_getNameResult1 != null) {
                ocb.activate(_mth_getNameResult1, 1);
            }

            pl.wcislo.sbql4j.examples.model.advanced.Address _mth_getAddressResult =
                _dotEl3.getAddress();

            if (_mth_getAddressResult != null) {
                ocb.activate(_mth_getAddressResult, 1);
            }

            java.lang.Boolean _existsResult = _mth_getAddressResult != null;
            Boolean _b0 = _existsResult;
            java.lang.String _conditionalResult;

            if (_b0) {
                pl.wcislo.sbql4j.examples.model.advanced.Address _mth_getAddressResult1 =
                    _dotEl3.getAddress();

                if (_mth_getAddressResult1 != null) {
                    ocb.activate(_mth_getAddressResult1, 1);
                }

                pl.wcislo.sbql4j.examples.model.advanced.Address _dotEl2 = _mth_getAddressResult1;

                if (_mth_getAddressResult1 != null) {
                    ocb.activate(_mth_getAddressResult1, 2);
                }

                java.lang.String _mth_getCityResult = _dotEl2.getCity();

                if (_mth_getCityResult != null) {
                    ocb.activate(_mth_getCityResult, 1);
                }

                _conditionalResult = _mth_getCityResult;
            } else {
                _conditionalResult = "No address";
            }

            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_mth_getNameResult1,
                    _conditionalResult, "", "");

            if (_commaResult != null) {
                ocb.activate(_commaResult, 2);
            }

            _dotResult3.add(_commaResult);
            _dotIndex3++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult3, ocb);

        return _dotResult3;
    }
}
