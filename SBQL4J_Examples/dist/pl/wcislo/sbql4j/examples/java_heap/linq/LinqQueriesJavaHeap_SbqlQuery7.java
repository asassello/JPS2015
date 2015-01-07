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


public class LinqQueriesJavaHeap_SbqlQuery7 {
    private List<java.lang.Integer> numbers;
    private List<java.lang.String> strings;

    public LinqQueriesJavaHeap_SbqlQuery7(final int[] numbers,
        final java.lang.String[] strings) {
        this.numbers = ArrayUtils.toList(numbers);
        this.strings = ArrayUtils.toList(strings);
    }

    /**
     * original query='(numbers as n).
                        (strings[n])'
     *
     * query after optimization='(numbers as n).(strings[n])'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<java.lang.Integer> _ident_numbers = numbers;
        java.util.List<java.lang.Integer> _asResult_n = _ident_numbers;
        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (java.lang.Integer _dotEl : _asResult_n) {
            if (_dotEl == null) {
                continue;
            }

            java.util.List<java.lang.String> _ident_strings = strings;
            java.lang.Integer _ident_n = _dotEl;
            java.lang.String _element_atResult;
            _element_atResult = null;

            if (!_ident_strings.isEmpty()) {
                _element_atResult = _ident_strings.get(_ident_n);
            }

            _queryResult.add(_element_atResult);
            _dotIndex++;
        }

        return _queryResult;
    }
}
