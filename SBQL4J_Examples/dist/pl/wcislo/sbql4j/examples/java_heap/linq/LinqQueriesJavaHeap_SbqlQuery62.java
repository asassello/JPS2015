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


public class LinqQueriesJavaHeap_SbqlQuery62 {
    private List<java.lang.String> words;

    public LinqQueriesJavaHeap_SbqlQuery62(final java.lang.String[] words) {
        this.words = ArrayUtils.toList(words);
    }

    /**
     * original query='min(words.length())'
     *
     * query after optimization=' min(words.length())'
    */
    public java.lang.Integer executeQuery() {
        java.util.List<java.lang.String> _ident_words = words;
        java.util.List<java.lang.Integer> _dotResult = new java.util.ArrayList<java.lang.Integer>();
        int _dotIndex = 0;

        for (java.lang.String _dotEl : _ident_words) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.Integer _mth_lengthResult = _dotEl.length();
            _dotResult.add(_mth_lengthResult);
            _dotIndex++;
        }

        Number _min1 = null;

        for (Number _minEl1 : _dotResult) {
            _min1 = MathUtils.min(_min1, _minEl1);
        }

        java.lang.Integer _queryResult = (java.lang.Integer) _min1;

        return _queryResult;
    }
}
