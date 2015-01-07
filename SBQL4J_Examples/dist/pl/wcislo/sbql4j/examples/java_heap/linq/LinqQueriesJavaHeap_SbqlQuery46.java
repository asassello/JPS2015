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

import java.lang.Double;

import java.util.*;


public class LinqQueriesJavaHeap_SbqlQuery46 {
    private List<java.lang.Object> numbers;

    public LinqQueriesJavaHeap_SbqlQuery46(final java.lang.Object[] numbers) {
        this.numbers = ArrayUtils.toList(numbers);
    }

    /**
     * original query='numbers as n
                        where n instanceof Double'
     *
     * query after optimization='numbers as n where n instanceof Double'
    */
    public java.util.List<java.lang.Object> executeQuery() {
        java.util.List<java.lang.Object> _ident_numbers = numbers;
        java.util.List<java.lang.Object> _asResult_n = _ident_numbers;
        java.util.List<java.lang.Object> _queryResult = new java.util.ArrayList<java.lang.Object>();
        int _whereLoopIndex = 0;

        for (java.lang.Object _whereEl : _asResult_n) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.Object _ident_n = _whereEl;
            java.lang.Boolean _instanceofResult = _ident_n instanceof java.lang.Double;

            if (_instanceofResult) {
                _queryResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        return _queryResult;
    }
}
