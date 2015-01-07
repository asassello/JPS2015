package pl.wcislo.sbql4j.examples.db4o;

import com.db4o.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.exception.*;
import pl.wcislo.sbql4j.java.model.compiletime.Signature.SCollectionType;
import pl.wcislo.sbql4j.java.model.runtime.*;
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

import java.text.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;


public class LinqQueriesDb4o_SbqlQuery21 {
    private List<java.lang.Integer> numbers;
    private com.db4o.ObjectContainer db;

    public LinqQueriesDb4o_SbqlQuery21(final int[] numbers,
        final com.db4o.ObjectContainer db) {
        this.numbers = ArrayUtils.toList(numbers);
        this.db = db;
    }

    /**
     * original query='db.(numbers[4..*])'
     *
     * query after optimization='(numbers[4..*] group as _aux0).db._aux0'
    */
    public java.util.List<java.lang.Integer> executeQuery() {
        java.util.List<java.lang.Integer> _ident_numbers = numbers;
        java.util.List<java.lang.Integer> _element_atResult;
        _element_atResult = new ArrayList();

        if (!_ident_numbers.isEmpty()) {
            _element_atResult = new java.util.ArrayList<java.lang.Integer>();

            Integer _lowBound2 = 4;
            Integer _upBound2 = _ident_numbers.size() - 1;

            if (_upBound2 >= _ident_numbers.size()) {
                _upBound2 = _ident_numbers.size() - 2;
            }

            _element_atResult = _ident_numbers.subList(_lowBound2, _upBound2 +
                    1);
        }

        java.util.List<java.lang.Integer> _groupAsResult_aux0 = _element_atResult;
        java.util.List<java.lang.Integer> _dotEl1 = _groupAsResult_aux0;
        com.db4o.ObjectContainer _ident_db = db;
        java.util.List<java.lang.Integer> _dotResult = _ident_db.query(new LinqQueriesDb4o_SbqlQuery21Db4o0(
                    _groupAsResult_aux0));

        return _dotResult;
    }
}
