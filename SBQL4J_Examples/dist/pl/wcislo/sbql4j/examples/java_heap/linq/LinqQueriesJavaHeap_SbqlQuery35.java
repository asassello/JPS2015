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


public class LinqQueriesJavaHeap_SbqlQuery35 {
    private List<java.lang.String> words;

    public LinqQueriesJavaHeap_SbqlQuery35(final java.lang.String[] words) {
        this.words = ArrayUtils.toList(words);
    }

    /**
     * original query='(unique(words.charAt(0)) as f).
                    (f as firstLetter, (words as w where w.charAt(0) == f) group as words)'
     *
     * query after optimization='(words as w group as _aux0).( unique words.charAt(0) as f).(f as firstLetter, (_aux0 where w.charAt(0) == f) group as words)'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<java.lang.String> _ident_words = words;
        java.util.List<java.lang.String> _asResult_w = _ident_words;
        java.util.List<java.lang.String> _groupAsResult_aux0 = _asResult_w;
        java.util.List<java.lang.String> _dotEl3 = _groupAsResult_aux0;
        java.util.List<java.lang.String> _ident_words1 = words;
        java.util.List<java.lang.Character> _dotResult = new java.util.ArrayList<java.lang.Character>();
        int _dotIndex = 0;

        for (java.lang.String _dotEl : _ident_words1) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.Character _mth_charAtResult = _dotEl.charAt(0);
            _dotResult.add(_mth_charAtResult);
            _dotIndex++;
        }

        java.util.List<java.lang.Character> _uniqueResult = new java.util.ArrayList<java.lang.Character>();
        Set<java.lang.Character> _tmp1 = new LinkedHashSet<java.lang.Character>();
        _tmp1.addAll(_dotResult);
        _uniqueResult.addAll(_tmp1);

        java.util.List<java.lang.Character> _asResult_f = _uniqueResult;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult2 = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex2 = 0;

        for (java.lang.Character _dotEl2 : _asResult_f) {
            if (_dotEl2 == null) {
                continue;
            }

            java.lang.Character _ident_f = _dotEl2;
            java.lang.Character _asResult_firstLetter = _ident_f;
            java.util.List<java.lang.String> _ident__aux0 = _dotEl3;
            java.util.List<java.lang.String> _whereResult = new java.util.ArrayList<java.lang.String>();
            int _whereLoopIndex = 0;

            for (java.lang.String _whereEl : _ident__aux0) {
                if (_whereEl == null) {
                    continue;
                }

                java.lang.String _ident_w = _whereEl;
                java.lang.String _dotEl1 = _ident_w;
                java.lang.Character _mth_charAtResult1 = _dotEl1.charAt(0);
                java.lang.Character _ident_f1 = _dotEl2;
                java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_charAtResult1,
                        _ident_f1);

                if (_equalsResult) {
                    _whereResult.add(_whereEl);
                }

                _whereLoopIndex++;
            }

            java.util.List<java.lang.String> _groupAsResultwords = _whereResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_firstLetter,
                    _groupAsResultwords, "firstLetter", "words");
            _dotResult2.add(_commaResult);
            _dotIndex2++;
        }

        return _dotResult2;
    }
}
