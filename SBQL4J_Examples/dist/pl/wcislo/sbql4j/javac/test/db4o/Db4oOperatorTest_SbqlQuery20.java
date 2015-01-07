package pl.wcislo.sbql4j.javac.test.db4o;

import com.db4o.*;

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


public class Db4oOperatorTest_SbqlQuery20 {
    public Db4oOperatorTest_SbqlQuery20() {
    }

    /**
     * original query='bag(bag(1,2),3).("Ala")'
     *
     * query after optimization='( bag( bag1 union 2), 3)."Ala"'
    */
    public java.util.Collection<java.lang.String> executeQuery() {
        java.util.Collection<java.lang.Integer> _unionResult = new java.util.ArrayList<java.lang.Integer>();
        _unionResult.add(1);
        _unionResult.add(2);

        java.util.Collection<java.lang.Integer> _bagResult = new ArrayList();
        _bagResult.addAll(_unionResult);

        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _commaResult =
            OperatorUtils.cartesianProductCS(_bagResult, 3, "", "");
        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _bagResult1 =
            new ArrayList();
        _bagResult1.addAll(_commaResult);

        java.util.Collection<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl : _bagResult1) {
            if (_dotEl == null) {
                continue;
            }

            _queryResult.add("Ala");
            _dotIndex++;
        }

        return _queryResult;
    }
}
