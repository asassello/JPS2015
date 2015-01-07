package pl.wcislo.sbql4j.examples.db4o;

import com.db4o.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.exception.*;
import pl.wcislo.sbql4j.java.model.compiletime.Signature.SCollectionType;
import pl.wcislo.sbql4j.java.model.runtime.*;
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

import java.text.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;


public class LinqQueriesDb4o_SbqlQuery48 {
    private List<java.lang.String> strings;
    private com.db4o.ObjectContainer db;

    public LinqQueriesDb4o_SbqlQuery48(final java.lang.String[] strings,
        final com.db4o.ObjectContainer db) {
        this.strings = ArrayUtils.toList(strings);
        this.db = db;
    }

    /**
     * original query='db.(
                    (strings as s where s.charAt(0) == 'o')[0]
                    )'
     *
     * query after optimization='((strings as s where s.charAt(0) == 'o')[0] group as _aux0).db._aux0'
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

        java.lang.String _element_atResult;
        _element_atResult = null;

        if (!_whereResult.isEmpty()) {
            _element_atResult = _whereResult.get(0);
        }

        java.lang.String _groupAsResult_aux0 = _element_atResult;
        java.lang.String _dotEl2 = _groupAsResult_aux0;
        com.db4o.ObjectContainer _ident_db = db;
        java.lang.String _dotResult1 = _ident_db.query(new LinqQueriesDb4o_SbqlQuery48Db4o0(
                    _groupAsResult_aux0));

        return _dotResult1;
    }
}
