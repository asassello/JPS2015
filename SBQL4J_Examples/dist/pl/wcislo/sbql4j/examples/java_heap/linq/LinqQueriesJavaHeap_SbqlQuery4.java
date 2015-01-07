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


public class LinqQueriesJavaHeap_SbqlQuery4 {
    private List<java.lang.String> digits;

    public LinqQueriesJavaHeap_SbqlQuery4(final java.lang.String[] digits) {
        this.digits = ArrayUtils.toList(digits);
    }

    /**
     * original query='digits where length() < $index'
     *
     * query after optimization='digits where length() < $index'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<java.lang.String> _ident_digits = digits;
        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        int _whereLoopIndex = 0;

        for (java.lang.String _whereEl : _ident_digits) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.Integer _mth_lengthResult = _whereEl.length();
            java.lang.Integer _ident_$index = _whereLoopIndex;

            Boolean _lessResult = _mth_lengthResult < _ident_$index;

            if (_lessResult) {
                _queryResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        return _queryResult;
    }
}
