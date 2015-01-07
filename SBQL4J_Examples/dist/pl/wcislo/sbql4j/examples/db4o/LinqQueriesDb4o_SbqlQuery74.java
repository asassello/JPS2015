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


public class LinqQueriesDb4o_SbqlQuery74 {
    private List<java.lang.String> wordsA;
    private List<java.lang.String> wordsB;
    private com.db4o.ObjectContainer db;

    public LinqQueriesDb4o_SbqlQuery74(final java.lang.String[] wordsA,
        final java.lang.String[] wordsB, final com.db4o.ObjectContainer db) {
        this.wordsA = ArrayUtils.toList(wordsA);
        this.wordsB = ArrayUtils.toList(wordsB);
        this.db = db;
    }

    /**
     * original query='db.(
                      all wordsA as a
                      a == wordsB[$index]
                    )'
     *
     * query after optimization='(( all wordsA as a a == wordsB[$index]) group as _aux0).db._aux0'
    */
    public java.lang.Boolean executeQuery() {
        java.util.List<java.lang.String> _ident_wordsA = wordsA;
        java.util.List<java.lang.String> _asResult_a = _ident_wordsA;
        java.lang.Boolean _allResult = true;
        Integer _allIndex = 0;

        for (java.lang.String _allEl : _asResult_a) {
            java.lang.String _ident_a = _allEl;
            java.util.List<java.lang.String> _ident_wordsB = wordsB;
            java.lang.Integer _ident_$index = _allIndex;
            java.lang.String _element_atResult;
            _element_atResult = null;

            if (!_ident_wordsB.isEmpty()) {
                _element_atResult = _ident_wordsB.get(_ident_$index);
            }

            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_a,
                    _element_atResult);

            if (!_equalsResult) {
                _allResult = false;

                break;
            }
        }

        java.lang.Boolean _groupAsResult_aux0 = _allResult;
        java.lang.Boolean _dotEl1 = _groupAsResult_aux0;
        com.db4o.ObjectContainer _ident_db = db;
        java.lang.Boolean _dotResult = _ident_db.query(new LinqQueriesDb4o_SbqlQuery74Db4o0(
                    _groupAsResult_aux0));

        return _dotResult;
    }
}
