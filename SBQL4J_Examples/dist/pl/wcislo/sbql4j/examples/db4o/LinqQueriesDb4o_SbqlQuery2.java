package pl.wcislo.sbql4j.examples.db4o;

import com.db4o.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.examples.model.linq.Product;
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


public class LinqQueriesDb4o_SbqlQuery2 {
    private com.db4o.ObjectContainer db;
    private java.lang.Integer minUnitsInStock;
    private java.lang.Integer minUnitPrice;

    public LinqQueriesDb4o_SbqlQuery2(final com.db4o.ObjectContainer db,
        final int minUnitsInStock, final int minUnitPrice) {
        this.db = db;
        this.minUnitsInStock = minUnitsInStock;
        this.minUnitPrice = minUnitPrice;
    }

    /**
     * original query='db.(Product where unitsInStock > minUnitsInStock and unitPrice > minUnitPrice)'
     *
     * query after optimization='db.(Product where unitsInStock > minUnitsInStock and unitPrice > minUnitPrice)'
    */
    public java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery() {
        com.db4o.ObjectContainer _ident_db = db;
        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _queryResult =
            _ident_db.query(new LinqQueriesDb4o_SbqlQuery2Db4o0(
                    minUnitsInStock, minUnitPrice));

        return _queryResult;
    }
}