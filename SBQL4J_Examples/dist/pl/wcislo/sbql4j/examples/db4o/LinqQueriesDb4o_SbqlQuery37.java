package pl.wcislo.sbql4j.examples.db4o;

import com.db4o.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.examples.model.linq.Customer;
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


public class LinqQueriesDb4o_SbqlQuery37 {
    private com.db4o.ObjectContainer db;

    public LinqQueriesDb4o_SbqlQuery37(final com.db4o.ObjectContainer db) {
        this.db = db;
    }

    /**
     * original query='db.(
                            (Customer as c).
                            (c.companyName as companyName join
                            (
                              ( unique(c.orders.orderDate.year ) as year join
                                (c.orders where orderDate.year == year) group as yearGroups
                              ).
                                (year as year,
                                      (
                                        (unique(yearGroups.orderDate.month) as month) join
                                        (yearGroups where orderDate.month == month) group as orders
                                      ) group as monthGroups
                                    ) group as yearGroups
                              )
                            )
                            )'
     *
     * query after optimization='db.(Customer as c).(( unique c.orders.orderDate.getYear() as year join (c.orders where orderDate.getYear() == year) group as yearGroups).(year as year, ( unique yearGroups.orderDate.getMonth() as month join (yearGroups where orderDate.getMonth() == month) group as orders) group as monthGroups) group as yearGroups group as _aux0).(c.companyName as companyName join _aux0)'
    */
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        com.db4o.ObjectContainer _ident_db = db;
        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult =
            _ident_db.query(new LinqQueriesDb4o_SbqlQuery37Db4o0());

        return _queryResult;
    }
}