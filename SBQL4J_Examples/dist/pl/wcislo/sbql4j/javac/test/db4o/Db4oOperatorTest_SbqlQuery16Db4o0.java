package pl.wcislo.sbql4j.javac.test.db4o;

import com.db4o.*;

import com.db4o.foundation.*;

import com.db4o.internal.*;
import com.db4o.internal.btree.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.db4o.*;
import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
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

import java.util.*;


public class Db4oOperatorTest_SbqlQuery16Db4o0 implements Db4oSBQLQuery {
    public Db4oOperatorTest_SbqlQuery16Db4o0() {
    }

    /**
     * query='db.Emp.getAddress().getStreet()'
    '
     **/
    public java.util.Collection<java.lang.String> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.Emp> _ident_Emp =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.Emp>();
        ClassMetadata _classMeta2 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.Emp");
        long[] _ids2 = _classMeta2.getIDs(transLocal);

        for (long _id2 : _ids2) {
            LazyObjectReference _ref2 = transLocal.lazyReferenceFor((int) _id2);
            _ident_Emp.add((pl.wcislo.sbql4j.examples.model.Emp) _ref2.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.Emp.Address> _dotResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.Emp.Address>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.Emp _dotEl : _ident_Emp) {
            if (_dotEl == null) {
                continue;
            }

            if (_dotEl != null) {
                ocb.activate(_dotEl, 1);
            }

            pl.wcislo.sbql4j.examples.model.Emp.Address _mth_getAddressResult = _dotEl.getAddress();

            if (_mth_getAddressResult != null) {
                ocb.activate(_mth_getAddressResult, 1);
            }

            if (_mth_getAddressResult != null) {
                ocb.activate(_mth_getAddressResult, 1);
            }

            _dotResult.add(_mth_getAddressResult);
            _dotIndex++;
        }

        java.util.Collection<java.lang.String> _dotResult1 = new java.util.ArrayList<java.lang.String>();
        int _dotIndex1 = 0;

        for (pl.wcislo.sbql4j.examples.model.Emp.Address _dotEl1 : _dotResult) {
            if (_dotEl1 == null) {
                continue;
            }

            if (_dotEl1 != null) {
                ocb.activate(_dotEl1, 1);
            }

            java.lang.String _mth_getStreetResult = _dotEl1.getStreet();

            if (_mth_getStreetResult != null) {
                ocb.activate(_mth_getStreetResult, 1);
            }

            if (_mth_getStreetResult != null) {
                ocb.activate(_mth_getStreetResult, 1);
            }

            _dotResult1.add(_mth_getStreetResult);
            _dotIndex1++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult1, ocb);

        return _dotResult1;
    }
}
