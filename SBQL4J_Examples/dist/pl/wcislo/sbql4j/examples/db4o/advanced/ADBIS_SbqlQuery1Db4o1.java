package pl.wcislo.sbql4j.examples.db4o.advanced;

import com.db4o.*;

import com.db4o.config.Configuration;
import com.db4o.config.ObjectClass;

import com.db4o.events.ObjectContainerEventArgs;

import com.db4o.ext.ExtObjectContainer;
import com.db4o.ext.StoredClass;

import com.db4o.foundation.*;

import com.db4o.internal.*;
import com.db4o.internal.btree.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.db4o.*;
import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.exception.*;
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


public class ADBIS_SbqlQuery1Db4o1 implements Db4oSBQLQuery {
    private java.lang.String reqJob;

    public ADBIS_SbqlQuery1Db4o1(java.lang.String reqJob) {
        this.reqJob = reqJob;
    }

    /**
     * query='db2.(Employee where getJob() == reqJob)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_Employee1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        ClassMetadata _classMeta3 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Employee");
        long[] _ids3 = _classMeta3.getIDs(transLocal);

        for (long _id3 : _ids3) {
            LazyObjectReference _ref3 = transLocal.lazyReferenceFor((int) _id3);
            _ident_Employee1.add((pl.wcislo.sbql4j.examples.model.advanced.Employee) _ref3.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _whereResult1 =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        int _whereLoopIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _whereEl1 : _ident_Employee1) {
            if (_whereEl1 == null) {
                continue;
            }

            if (_whereEl1 != null) {
                ocb.activate(_whereEl1, 1);
            }

            java.lang.String _mth_getJobResult = _whereEl1.getJob();

            if (_mth_getJobResult != null) {
                ocb.activate(_mth_getJobResult, 1);
            }

            java.lang.String _ident_reqJob = reqJob;
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getJobResult,
                    _ident_reqJob);

            if (_equalsResult) {
                _whereResult1.add(_whereEl1);
            }

            _whereLoopIndex1++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_whereResult1, ocb);

        return _whereResult1;
    }
}
