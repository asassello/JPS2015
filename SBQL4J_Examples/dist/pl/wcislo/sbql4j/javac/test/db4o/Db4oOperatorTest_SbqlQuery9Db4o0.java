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


public class Db4oOperatorTest_SbqlQuery9Db4o0 implements Db4oSBQLQuery {
    private pl.wcislo.sbql4j.java.model.runtime.Struct _groupAsResult_aux0;

    public Db4oOperatorTest_SbqlQuery9Db4o0(
        pl.wcislo.sbql4j.java.model.runtime.Struct _groupAsResult_aux0) {
        this._groupAsResult_aux0 = _groupAsResult_aux0;
    }

    /**
     * query='db._aux0'
    '
     **/
    public pl.wcislo.sbql4j.java.model.runtime.Struct executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        pl.wcislo.sbql4j.java.model.runtime.Struct _ident__aux0 = _groupAsResult_aux0;
        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_ident__aux0, ocb);

        return _ident__aux0;
    }
}
