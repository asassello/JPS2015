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


public class LinqQueriesJavaHeap_SbqlQuery24 {
    private List<java.lang.String> words;

    public LinqQueriesJavaHeap_SbqlQuery24(final java.lang.String[] words) {
        this.words = ArrayUtils.toList(words);
    }

    /**
     * original query='words as w order by w.length()'
     *
     * query after optimization='words as w order by (w.length())'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<java.lang.String> _ident_words = words;
        java.util.List<java.lang.String> _asResult_w = _ident_words;
        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        _queryResult.addAll(_asResult_w);

        Comparator<java.lang.String> _comparator1 = new Comparator<java.lang.String>() {
                public int compare(java.lang.String _leftObj,
                    java.lang.String _rightObj) {
                    if (_leftObj == null) {
                        return -1;
                    }

                    int res = 0;
                    java.lang.Integer _leftParam0;

                    {
                        java.lang.String _ident_w = _leftObj;
                        java.lang.String _dotEl = _ident_w;
                        java.lang.Integer _mth_lengthResult = _dotEl.length();
                        _leftParam0 = _mth_lengthResult;
                    }

                    java.lang.Integer _rightParam0;

                    {
                        java.lang.String _ident_w = _rightObj;
                        java.lang.String _dotEl = _ident_w;
                        java.lang.Integer _mth_lengthResult = _dotEl.length();
                        _rightParam0 = _mth_lengthResult;
                    }

                    if (_leftParam0 != null) {
                        res = _leftParam0.compareTo(_rightParam0);
                    } else {
                        return -1;
                    }

                    return res;
                }
            };

        Collections.sort(_queryResult, _comparator1);

        return _queryResult;
    }
}
