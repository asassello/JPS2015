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


public class LinqQueriesJavaHeap_SbqlQuery13 {
    private List<java.lang.Integer> numbersA;
    private List<java.lang.Integer> numbersB;

    public LinqQueriesJavaHeap_SbqlQuery13(final int[] numbersA,
        final int[] numbersB) {
        this.numbersA = ArrayUtils.toList(numbersA);
        this.numbersB = ArrayUtils.toList(numbersB);
    }

    /**
     * original query='numbersA as a, numbersB as b
                    where a < b'
     *
     * query after optimization='numbersA as a, numbersB as b where a < b'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<java.lang.Integer> _ident_numbersA = numbersA;
        java.util.List<java.lang.Integer> _asResult_a = _ident_numbersA;
        java.util.List<java.lang.Integer> _ident_numbersB = numbersB;
        java.util.List<java.lang.Integer> _asResult_b = _ident_numbersB;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _commaResult = OperatorUtils.cartesianProductCC(_asResult_a,
                _asResult_b, "a", "b");
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _whereEl : _commaResult) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.Integer _ident_a = (java.lang.Integer) _whereEl.get("a");
            java.lang.Integer _ident_b = (java.lang.Integer) _whereEl.get("b");

            Boolean _lessResult = _ident_a < _ident_b;

            if (_lessResult) {
                _queryResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        return _queryResult;
    }
}
