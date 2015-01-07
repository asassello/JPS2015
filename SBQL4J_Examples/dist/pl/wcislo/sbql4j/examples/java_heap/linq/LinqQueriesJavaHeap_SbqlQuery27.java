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


public class LinqQueriesJavaHeap_SbqlQuery27 {
    private List<java.lang.Double> doubles;

    public LinqQueriesJavaHeap_SbqlQuery27(final double[] doubles) {
        this.doubles = ArrayUtils.toList(doubles);
    }

    /**
     * original query='doubles as d
                    order by d desc'
     *
     * query after optimization='doubles as d order by (d DESC )'
    */
    public java.util.List<java.lang.Double> executeQuery() {
        java.util.List<java.lang.Double> _ident_doubles = doubles;
        java.util.List<java.lang.Double> _asResult_d = _ident_doubles;
        java.util.List<java.lang.Double> _queryResult = new java.util.ArrayList<java.lang.Double>();
        _queryResult.addAll(_asResult_d);

        Comparator<java.lang.Double> _comparator4 = new Comparator<java.lang.Double>() {
                public int compare(java.lang.Double _leftObj,
                    java.lang.Double _rightObj) {
                    if (_leftObj == null) {
                        return 1;
                    }

                    int res = 0;
                    java.lang.Double _leftParam0;

                    {
                        java.lang.Double _ident_d = _leftObj;
                        _leftParam0 = _ident_d;
                    }

                    java.lang.Double _rightParam0;

                    {
                        java.lang.Double _ident_d = _rightObj;
                        _rightParam0 = _ident_d;
                    }

                    if (_leftParam0 != null) {
                        res = _leftParam0.compareTo(_rightParam0);
                    } else {
                        return 1;
                    }

                    return -res;
                }
            };

        Collections.sort(_queryResult, _comparator4);

        return _queryResult;
    }
}
