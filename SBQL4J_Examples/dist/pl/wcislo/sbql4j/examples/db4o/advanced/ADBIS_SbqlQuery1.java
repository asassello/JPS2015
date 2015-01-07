package pl.wcislo.sbql4j.examples.db4o.advanced;

import com.db4o.*;

import com.db4o.config.Configuration;
import com.db4o.config.ObjectClass;

import com.db4o.events.ObjectContainerEventArgs;

import com.db4o.ext.ExtObjectContainer;
import com.db4o.ext.StoredClass;

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


public class ADBIS_SbqlQuery1 {
    private com.db4o.ObjectContainer db1;
    private java.lang.Double minSalary;
    private com.db4o.ObjectContainer db2;
    private java.lang.String reqJob;

    public ADBIS_SbqlQuery1(final com.db4o.ObjectContainer db1,
        final java.lang.Double minSalary, final com.db4o.ObjectContainer db2,
        final java.lang.String reqJob) {
        this.db1 = db1;
        this.minSalary = minSalary;
        this.db2 = db2;
        this.reqJob = reqJob;
    }

    /**
     * original query='db1.(Employee where salary > minSalary)
                            union db2.(Employee where job == reqJob)'
     *
     * query after optimization='db1.(Employee where getSalary() > minSalary) union db2.(Employee where getJob() == reqJob)'
    */
    public java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> executeQuery() {
        com.db4o.ObjectContainer _ident_db1 = db1;
        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult =
            _ident_db1.query(new ADBIS_SbqlQuery1Db4o0(minSalary));
        com.db4o.ObjectContainer _ident_db2 = db2;
        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult1 =
            _ident_db2.query(new ADBIS_SbqlQuery1Db4o1(reqJob));
        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _queryResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        _queryResult.addAll(_dotResult);
        _queryResult.addAll(_dotResult1);

        return _queryResult;
    }
}
