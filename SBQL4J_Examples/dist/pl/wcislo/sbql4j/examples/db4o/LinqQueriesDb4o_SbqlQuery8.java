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


public class LinqQueriesDb4o_SbqlQuery8 {
    private List<java.lang.String> words;
    private com.db4o.ObjectContainer db;

    public LinqQueriesDb4o_SbqlQuery8(final java.lang.String[] words,
        final com.db4o.ObjectContainer db) {
        this.words = ArrayUtils.toList(words);
        this.db = db;
    }

    /**
     * original query='db.(
                         (words).
                         (toUpperCase() as upper, toLowerCase() as lower)
                        )'
     *
     * query after optimization='(words.(toUpperCase() as upper, toLowerCase() as lower) group as _aux0).db._aux0'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<java.lang.String> _ident_words = words;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex = 0;

        for (java.lang.String _dotEl : _ident_words) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.String _mth_toUpperCaseResult = _dotEl.toUpperCase();
            java.lang.String _asResult_upper = _mth_toUpperCaseResult;
            java.lang.String _mth_toLowerCaseResult = _dotEl.toLowerCase();
            java.lang.String _asResult_lower = _mth_toLowerCaseResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_upper,
                    _asResult_lower, "upper", "lower");
            _dotResult.add(_commaResult);
            _dotIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _groupAsResult_aux0 =
            _dotResult;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotEl2 = _groupAsResult_aux0;
        com.db4o.ObjectContainer _ident_db = db;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult1 = _ident_db.query(new LinqQueriesDb4o_SbqlQuery8Db4o0(
                    _groupAsResult_aux0));

        return _dotResult1;
    }
}
