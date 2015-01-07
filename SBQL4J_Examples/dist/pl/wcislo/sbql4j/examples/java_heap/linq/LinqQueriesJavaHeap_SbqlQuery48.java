package pl.wcislo.sbql4j.examples.java_heap.linq;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
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

import java.util.*;


public class LinqQueriesJavaHeap_SbqlQuery48 {
    private List<java.lang.String> strings;

    public LinqQueriesJavaHeap_SbqlQuery48(final java.lang.String[] strings) {
        this.strings = ArrayUtils.toList(strings);
    }

    /**
     * original query='(strings as s where s.charAt(0) == 'o')[0]'
     *
     * query after optimization='(strings as s where s.charAt(0) == 'o')[0]'
    */
    public java.lang.String executeQuery() {
        java.util.List<java.lang.String> _ident_strings = strings;
        java.util.List<java.lang.String> _asResult_s = _ident_strings;
        java.util.List<java.lang.String> _whereResult = new java.util.ArrayList<java.lang.String>();
        int _whereLoopIndex = 0;

        for (java.lang.String _whereEl : _asResult_s) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.String _ident_s = _whereEl;
            java.lang.String _dotEl = _ident_s;
            java.lang.Character _mth_charAtResult = _dotEl.charAt(0);
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_charAtResult,
                    'o');

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.lang.String _queryResult;
        _queryResult = null;

        if (!_whereResult.isEmpty()) {
            _queryResult = _whereResult.get(0);
        }

        return _queryResult;
    }
}
