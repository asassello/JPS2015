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


public class LinqQueriesDb4o_SbqlQuery34 {
    private List<java.lang.Integer> numbers;
    private com.db4o.ObjectContainer db;

    public LinqQueriesDb4o_SbqlQuery34(final int[] numbers,
        final com.db4o.ObjectContainer db) {
        this.numbers = ArrayUtils.toList(numbers);
        this.db = db;
    }

    /**
     * original query='db.(
                          (unique((numbers as n).(n % 5)) as r).
                          (r as remainder, (numbers as n where n % 5 == r) group as numbers)
                        )'
     *
     * query after optimization='((numbers as n group as _aux1).( unique (numbers as n).(n % 5) as r).(r as remainder, (_aux1 where n % 5 == r) group as numbers) group as _aux0).db._aux0'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<java.lang.Integer> _ident_numbers = numbers;
        java.util.List<java.lang.Integer> _asResult_n = _ident_numbers;
        java.util.List<java.lang.Integer> _groupAsResult_aux1 = _asResult_n;
        java.util.List<java.lang.Integer> _dotEl2 = _groupAsResult_aux1;
        java.util.List<java.lang.Integer> _ident_numbers1 = numbers;
        java.util.List<java.lang.Integer> _asResult_n1 = _ident_numbers1;
        java.util.List<java.lang.Integer> _dotResult = new java.util.ArrayList<java.lang.Integer>();
        int _dotIndex = 0;

        for (java.lang.Integer _dotEl : _asResult_n1) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.Integer _ident_n = _dotEl;
            java.lang.Integer _moduloResult = _ident_n % 5;
            _dotResult.add(_moduloResult);
            _dotIndex++;
        }

        java.util.List<java.lang.Integer> _uniqueResult = new java.util.ArrayList<java.lang.Integer>();
        Set<java.lang.Integer> _tmp0 = new LinkedHashSet<java.lang.Integer>();
        _tmp0.addAll(_dotResult);
        _uniqueResult.addAll(_tmp0);

        java.util.List<java.lang.Integer> _asResult_r = _uniqueResult;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult1 = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex1 = 0;

        for (java.lang.Integer _dotEl1 : _asResult_r) {
            if (_dotEl1 == null) {
                continue;
            }

            java.lang.Integer _ident_r = _dotEl1;
            java.lang.Integer _asResult_remainder = _ident_r;
            java.util.List<java.lang.Integer> _ident__aux1 = _dotEl2;
            java.util.List<java.lang.Integer> _whereResult = new java.util.ArrayList<java.lang.Integer>();
            int _whereLoopIndex = 0;

            for (java.lang.Integer _whereEl : _ident__aux1) {
                if (_whereEl == null) {
                    continue;
                }

                java.lang.Integer _ident_n1 = _whereEl;
                java.lang.Integer _moduloResult1 = _ident_n1 % 5;
                java.lang.Integer _ident_r1 = _dotEl1;
                java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_moduloResult1,
                        _ident_r1);

                if (_equalsResult) {
                    _whereResult.add(_whereEl);
                }

                _whereLoopIndex++;
            }

            java.util.List<java.lang.Integer> _groupAsResultnumbers = _whereResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_remainder,
                    _groupAsResultnumbers, "remainder", "numbers");
            _dotResult1.add(_commaResult);
            _dotIndex1++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _groupAsResult_aux0 =
            _dotResult1;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotEl4 = _groupAsResult_aux0;
        com.db4o.ObjectContainer _ident_db = db;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult3 = _ident_db.query(new LinqQueriesDb4o_SbqlQuery34Db4o0(
                    _groupAsResult_aux0));

        return _dotResult3;
    }
}
