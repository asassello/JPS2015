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


public class LinqQueriesJavaHeap_SbqlQuery26 {
    private List<java.lang.String> words;
    private java.util.Comparator<java.lang.String> comp;

    public LinqQueriesJavaHeap_SbqlQuery26(final java.lang.String[] words,
        final java.util.Comparator<java.lang.String> comp) {
        this.words = ArrayUtils.toList(words);
        this.comp = comp;
    }

    /**
     * original query='words as w
                        order by w using comp'
     *
     * query after optimization='words as w order by (w using comp)'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<java.lang.String> _ident_words = words;
        java.util.List<java.lang.String> _asResult_w = _ident_words;
        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        _queryResult.addAll(_asResult_w);

        Comparator<java.lang.String> _comparator3 = new Comparator<java.lang.String>() {
                public int compare(java.lang.String _leftObj,
                    java.lang.String _rightObj) {
                    if (_leftObj == null) {
                        return -1;
                    }

                    int res = 0;
                    java.lang.String _leftParam0;

                    {
                        java.lang.String _ident_w = _leftObj;
                        _leftParam0 = _ident_w;
                    }

                    java.lang.String _rightParam0;

                    {
                        java.lang.String _ident_w = _rightObj;
                        _rightParam0 = _ident_w;
                    }

                    java.util.Comparator _ident_comp = comp;

                    if (_ident_comp != null) {
                        res = _ident_comp.compare(_leftParam0, _rightParam0);
                    } else {
                        res = 0;
                    }

                    return res;
                }
            };

        Collections.sort(_queryResult, _comparator3);

        return _queryResult;
    }
}