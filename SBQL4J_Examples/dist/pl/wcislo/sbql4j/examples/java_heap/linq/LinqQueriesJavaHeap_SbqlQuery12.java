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


public class LinqQueriesJavaHeap_SbqlQuery12 {
    private List<java.lang.Integer> numbers;
    private List<java.lang.String> digits;

    public LinqQueriesJavaHeap_SbqlQuery12(final int[] numbers,
        final java.lang.String[] digits) {
        this.numbers = ArrayUtils.toList(numbers);
        this.digits = ArrayUtils.toList(digits);
    }

    /**
     * original query='((numbers as n) where n < 5).
                        (digits[n])'
     *
     * query after optimization='(numbers as n where n < 5).(digits[n])'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<java.lang.Integer> _ident_numbers = numbers;
        java.util.List<java.lang.Integer> _asResult_n = _ident_numbers;
        java.util.List<java.lang.Integer> _whereResult = new java.util.ArrayList<java.lang.Integer>();
        int _whereLoopIndex = 0;

        for (java.lang.Integer _whereEl : _asResult_n) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.Integer _ident_n = _whereEl;

            Boolean _lessResult = _ident_n < 5;

            if (_lessResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (java.lang.Integer _dotEl : _whereResult) {
            if (_dotEl == null) {
                continue;
            }

            java.util.List<java.lang.String> _ident_digits = digits;
            java.lang.Integer _ident_n1 = _dotEl;
            java.lang.String _element_atResult;
            _element_atResult = null;

            if (!_ident_digits.isEmpty()) {
                _element_atResult = _ident_digits.get(_ident_n1);
            }

            _queryResult.add(_element_atResult);
            _dotIndex++;
        }

        return _queryResult;
    }
}
