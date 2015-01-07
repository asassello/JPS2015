package pl.wcislo.sbql4j.examples.db4o;

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
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.exception.*;
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


public class Db4oIndexQueries_SbqlQuery2Db4o0 implements Db4oSBQLQuery {
    public Db4oIndexQueries_SbqlQuery2Db4o0() {
    }

    /**
     * query='db.(Product_ByIndex[productName]("Ikura") where unitsInStock > 0)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta2 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        FieldMetadata _fieldMeta2 = _classMeta2.fieldMetadataForName(
                "productName");
        BTreeRange _range2 = _fieldMeta2.search(t, "Ikura");
        Iterator4 _it2 = _range2.pointers();

        while (_it2.moveNext()) {
            BTreePointer _point2 = (BTreePointer) _it2.current();
            FieldIndexKeyImpl _pointKey2 = (FieldIndexKeyImpl) _point2.key();
            int _id2 = _pointKey2.parentID();
            LazyObjectReference _ref2 = transLocal.lazyReferenceFor(_id2);
            pl.wcislo.sbql4j.examples.model.linq.Product _obj2 = (pl.wcislo.sbql4j.examples.model.linq.Product) _ref2.getObject();

            if (_obj2 != null) {
                ocb.activate(_obj2);
            }

            _ident_Product.add(_obj2);
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Product _whereEl : _ident_Product) {
            if (_whereEl == null) {
                continue;
            }

            if (_whereEl != null) {
                ocb.activate(_whereEl, 1);
            }

            java.lang.Integer _ident_unitsInStock = ((_whereEl == null) ? null
                                                                        : _whereEl.unitsInStock);

            if (_ident_unitsInStock != null) {
                ocb.activate(_ident_unitsInStock, 1);
            }

            Boolean _moreResult = _ident_unitsInStock > 0;

            if (_moreResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_whereResult, ocb);

        return _whereResult;
    }
}
