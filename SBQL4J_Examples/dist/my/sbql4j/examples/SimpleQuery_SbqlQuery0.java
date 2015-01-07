package my.sbql4j.examples;

import org.apache.commons.collections.CollectionUtils;

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

import java.util.*;


public class SimpleQuery_SbqlQuery0 {
    private List<java.lang.Integer> numbers;

    public SimpleQuery_SbqlQuery0(final int[] numbers) {
        this.numbers = ArrayUtils.toList(numbers);
    }

    /**
     * original query='(numbers as num).
    (num % 2 == 1 ? "odd" : "even")'
     *
     * query after optimization='(numbers as num).(num % 2 == 1 ? "odd" : "even")'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<java.lang.Integer> _ident_numbers = numbers;
        java.util.List<java.lang.Integer> _asResult_num = _ident_numbers;
        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (java.lang.Integer _dotEl : _asResult_num) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.Integer _ident_num = _dotEl;
            java.lang.Integer _moduloResult = _ident_num % 2;
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_moduloResult,
                    1);
            Boolean _b0 = _equalsResult;
            java.lang.String _conditionalResult;

            if (_b0) {
                _conditionalResult = "odd";
            } else {
                _conditionalResult = "even";
            }

            _queryResult.add(_conditionalResult);
            _dotIndex++;
        }

        return _queryResult;
    }
}
