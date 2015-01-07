package pl.wcislo.sbql4j.examples.db4o;

import com.db4o.*;

import com.db4o.config.Configuration;
import com.db4o.config.ObjectClass;

import com.db4o.events.ObjectContainerEventArgs;

import com.db4o.ext.ExtObjectContainer;
import com.db4o.ext.StoredClass;

import org.apache.commons.collections.CollectionUtils;

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

import javax.swing.JFrame;


public class Db4oIndexQueries_SbqlQuery0 {
    private List<java.lang.String> name;
    private com.db4o.ObjectContainer db;

    public Db4oIndexQueries_SbqlQuery0(final java.lang.String[] name,
        final com.db4o.ObjectContainer db) {
        this.name = ArrayUtils.toList(name);
        this.db = db;
    }

    /**
     * original query='db.(Product where ((name as n where n.startsWith("I"))[0]) == productName)'
     *
     * query after optimization='((name as n where n.startsWith("I"))[0] group as _aux0).db.Product_ByIndex[productName](_aux0)'
    */
    public java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery() {
        java.util.List<java.lang.String> _ident_name = name;
        java.util.List<java.lang.String> _asResult_n = _ident_name;
        java.util.List<java.lang.String> _whereResult = new java.util.ArrayList<java.lang.String>();
        int _whereLoopIndex = 0;

        for (java.lang.String _whereEl : _asResult_n) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.String _ident_n = _whereEl;
            java.lang.String _dotEl = _ident_n;
            java.lang.Boolean _mth_startsWithResult = _dotEl.startsWith("I");

            if (_mth_startsWithResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.lang.String _element_atResult;
        _element_atResult = null;

        if (!_whereResult.isEmpty()) {
            _element_atResult = _whereResult.get(0);
        }

        java.lang.String _groupAsResult_aux0 = _element_atResult;
        java.lang.String _dotEl2 = _groupAsResult_aux0;
        com.db4o.ObjectContainer _ident_db = db;
        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _dotResult1 =
            _ident_db.query(new Db4oIndexQueries_SbqlQuery0Db4o0(
                    _groupAsResult_aux0));

        return _dotResult1;
    }
}
