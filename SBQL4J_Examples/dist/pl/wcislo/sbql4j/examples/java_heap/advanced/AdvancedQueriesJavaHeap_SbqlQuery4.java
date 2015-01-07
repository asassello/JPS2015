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


public class AdvancedQueriesJavaHeap_SbqlQuery4 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept;

    public AdvancedQueriesJavaHeap_SbqlQuery4(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept) {
        this.dept = dept;
    }

    /**
     * original query='(dept where boss.name == "Bert").
                            employs.
                            (name, (exists(address) ? address.city : "No address") )'
     *
     * query after optimization='(dept where getBoss().getName() == "Bert").getEmploys().(getName(), ( exists getAddress() ? getAddress().getCity() : "No address"))'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept =
            dept;
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _whereEl : _ident_dept) {
            if (_whereEl == null) {
                continue;
            }

            pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult =
                _whereEl.getBoss();
            pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl = _mth_getBossResult;
            java.lang.String _mth_getNameResult = _dotEl.getName();
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getNameResult,
                    "Bert");

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 : _whereResult) {
            if (_dotEl1 == null) {
                continue;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                _dotEl1.getEmploys();
            _dotResult1.addAll(_mth_getEmploysResult);
            _dotIndex1++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex3 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl3 : _dotResult1) {
            if (_dotEl3 == null) {
                continue;
            }

            java.lang.String _mth_getNameResult1 = _dotEl3.getName();
            pl.wcislo.sbql4j.examples.model.advanced.Address _mth_getAddressResult =
                _dotEl3.getAddress();
            java.lang.Boolean _existsResult = _mth_getAddressResult != null;
            Boolean _b0 = _existsResult;
            java.lang.String _conditionalResult;

            if (_b0) {
                pl.wcislo.sbql4j.examples.model.advanced.Address _mth_getAddressResult1 =
                    _dotEl3.getAddress();
                pl.wcislo.sbql4j.examples.model.advanced.Address _dotEl2 = _mth_getAddressResult1;
                java.lang.String _mth_getCityResult = _dotEl2.getCity();
                _conditionalResult = _mth_getCityResult;
            } else {
                _conditionalResult = "No address";
            }

            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_mth_getNameResult1,
                    _conditionalResult, "", "");
            _queryResult.add(_commaResult);
            _dotIndex3++;
        }

        return _queryResult;
    }
}
