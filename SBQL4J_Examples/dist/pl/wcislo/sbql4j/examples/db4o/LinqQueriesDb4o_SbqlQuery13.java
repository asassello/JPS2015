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


public class LinqQueriesDb4o_SbqlQuery13 {
    private List<java.lang.Integer> numbersA;
    private List<java.lang.Integer> numbersB;
    private com.db4o.ObjectContainer db;

    public LinqQueriesDb4o_SbqlQuery13(final int[] numbersA,
        final int[] numbersB, final com.db4o.ObjectContainer db) {
        this.numbersA = ArrayUtils.toList(numbersA);
        this.numbersB = ArrayUtils.toList(numbersB);
        this.db = db;
    }

    /**
     * original query='db.(
                            numbersA as a, numbersB as b
                            where a < b
                    )'
     *
     * query after optimization='((numbersA as a, numbersB as b where a < b) group as _aux0).db._aux0'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<java.lang.Integer> _ident_numbersA = numbersA;
        java.util.List<java.lang.Integer> _asResult_a = _ident_numbersA;
        java.util.List<java.lang.Integer> _ident_numbersB = numbersB;
        java.util.List<java.lang.Integer> _asResult_b = _ident_numbersB;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _commaResult = OperatorUtils.cartesianProductCC(_asResult_a,
                _asResult_b, "a", "b");
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _whereResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _whereEl : _commaResult) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.Integer _ident_a = (java.lang.Integer) _whereEl.get("a");
            java.lang.Integer _ident_b = (java.lang.Integer) _whereEl.get("b");

            Boolean _lessResult = _ident_a < _ident_b;

            if (_lessResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _groupAsResult_aux0 =
            _whereResult;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotEl1 = _groupAsResult_aux0;
        com.db4o.ObjectContainer _ident_db = db;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult = _ident_db.query(new LinqQueriesDb4o_SbqlQuery13Db4o0(
                    _groupAsResult_aux0));

        return _dotResult;
    }
}
