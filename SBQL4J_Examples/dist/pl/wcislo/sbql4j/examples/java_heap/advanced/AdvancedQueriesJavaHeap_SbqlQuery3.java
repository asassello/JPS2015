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


public class AdvancedQueriesJavaHeap_SbqlQuery3 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> emp;

    public AdvancedQueriesJavaHeap_SbqlQuery3(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> emp) {
        this.emp = emp;
    }

    /**
     * original query='(emp where name == "Poe")[0].worksIn.boss.name'
     *
     * query after optimization='((emp where getName() == "Poe")[0]).getWorksIn().getBoss().getName()'
    */
    public java.lang.String executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_emp =
            emp;
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _whereEl : _ident_emp) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.String _mth_getNameResult = _whereEl.getName();
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getNameResult,
                    "Poe");

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        pl.wcislo.sbql4j.examples.model.advanced.Employee _element_atResult;
        _element_atResult = null;

        if (!_whereResult.isEmpty()) {
            _element_atResult = _whereResult.get(0);
        }

        pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl = _element_atResult;
        pl.wcislo.sbql4j.examples.model.advanced.Department _mth_getWorksInResult =
            _dotEl.getWorksIn();
        pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 = _mth_getWorksInResult;
        pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult = _dotEl1.getBoss();
        pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl2 = _mth_getBossResult;
        java.lang.String _mth_getNameResult1 = _dotEl2.getName();

        return _mth_getNameResult1;
    }
}
