package pl.wcislo.sbql4j.examples.db4o.advanced;

import com.db4o.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
import pl.wcislo.sbql4j.examples.model.advanced.Employee;
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

import java.text.*;

import java.util.*;


public class AdvancedQueriesDb4o_SbqlQuery10 {
    private com.db4o.ObjectContainer db;

    public AdvancedQueriesDb4o_SbqlQuery10(final com.db4o.ObjectContainer db) {
        this.db = db;
    }

    /**
     * original query='db.(
                                    ((0 as i close by (i+1000 where i <= max(Employee.salary)) as i)
                                    join (count(Employee where salary >= i and salary < i+1000) as c)
                                    join (c==1 ? ("" as n, "s" as v) : ("s" as n, "" as v)) ).
                                    (c + " employee" + n + " earn"+ v +" between "+ i +" and " + (i+999)) as message
                            )'
     *
     * query after optimization='db.((0 as i close by (i + 1000 where i <=  max(Employee.getSalary())) as i join  count((Employee where getSalary() >= i and getSalary() < i + 1000)) as c join c == 1 ? "" as n, "s" as v : "s" as n, "" as v).(c + " employee" + n + " earn" + v + " between " + i + " and " + i + 999) as message)'
    */
    public java.util.List<java.lang.String> executeQuery() {
        com.db4o.ObjectContainer _ident_db = db;
        java.util.List<java.lang.String> _queryResult = _ident_db.query(new AdvancedQueriesDb4o_SbqlQuery10Db4o0());

        return _queryResult;
    }
}