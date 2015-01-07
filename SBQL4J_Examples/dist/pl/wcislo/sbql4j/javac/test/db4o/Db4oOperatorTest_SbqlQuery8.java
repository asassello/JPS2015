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


public class Db4oOperatorTest_SbqlQuery8 {
    private com.db4o.ObjectContainer db;

    public Db4oOperatorTest_SbqlQuery8(final com.db4o.ObjectContainer db) {
        this.db = db;
    }

    /**
     * original query='db.(bag(bag(1,2,3)))'
     *
     * query after optimization='(( bag bag1 union 2 union 3) group as _aux0).db._aux0'
    */
    public java.util.Collection<java.lang.Integer> executeQuery() {
        java.util.Collection<java.lang.Integer> _unionResult = new java.util.ArrayList<java.lang.Integer>();
        _unionResult.add(1);
        _unionResult.add(2);

        java.util.Collection<java.lang.Integer> _unionResult1 = new java.util.ArrayList<java.lang.Integer>();
        _unionResult1.addAll(_unionResult);
        _unionResult1.add(3);

        java.util.Collection<java.lang.Integer> _bagResult = new ArrayList();
        _bagResult.addAll(_unionResult1);

        java.util.Collection<java.lang.Integer> _bagResult1 = new ArrayList();
        _bagResult1.addAll(_bagResult);

        java.util.Collection<java.lang.Integer> _groupAsResult_aux0 = _bagResult1;
        java.util.Collection<java.lang.Integer> _dotEl1 = _groupAsResult_aux0;
        com.db4o.ObjectContainer _ident_db = db;
        java.util.Collection<java.lang.Integer> _dotResult = _ident_db.query(new Db4oOperatorTest_SbqlQuery8Db4o0(
                    _groupAsResult_aux0));

        return _dotResult;
    }
}