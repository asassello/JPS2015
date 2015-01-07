package pl.wcislo.sbql4j.examples.db4o.advanced;

import com.db4o.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
import pl.wcislo.sbql4j.examples.model.advanced.Department;
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


public class AdvancedQueriesDb4o_SbqlQuery11 {
    private com.db4o.ObjectContainer db;

    public AdvancedQueriesDb4o_SbqlQuery11(final com.db4o.ObjectContainer db) {
        this.db = db;
    }

    /**
     * original query='db.(
                                    ((unique(Department.location)) as deptcity).
                                    ((((Department where deptcity in location) group as citydepts)
                                    where count(citydepts.employs.(Employee where job == "clerk")) < 100).
                                    (deptcity as cityLocation,
                                                    (citydepts.name) group as cityDeptNames,
                                                    avg(citydepts.boss.salary) as cityDeptBossAvgSal))
                            )'
     *
     * query after optimization='db.((Employee where getJob() == "clerk") group as _aux0).( unique Department.getLocation() as deptcity).(deptcity as cityLocation group as _aux1).((Department where deptcity in getLocation()) group as citydepts where  count(citydepts.getEmploys()._aux0) < 100).(_aux1, citydepts.getName() group as cityDeptNames,  avg(citydepts.getBoss().getSalary()) as cityDeptBossAvgSal)'
    */
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        com.db4o.ObjectContainer _ident_db = db;
        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult =
            _ident_db.query(new AdvancedQueriesDb4o_SbqlQuery11Db4o0());

        return _queryResult;
    }
}
