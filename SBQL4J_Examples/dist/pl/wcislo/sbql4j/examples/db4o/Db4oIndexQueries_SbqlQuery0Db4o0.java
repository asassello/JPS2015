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


public class Db4oIndexQueries_SbqlQuery0Db4o0 implements Db4oSBQLQuery {
    private java.lang.String _groupAsResult_aux0;

    public Db4oIndexQueries_SbqlQuery0Db4o0(
        java.lang.String _groupAsResult_aux0) {
        this._groupAsResult_aux0 = _groupAsResult_aux0;
    }

    /**
     * query='db.Product_ByIndex[productName](_aux0)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        java.lang.String _ident__aux0 = _groupAsResult_aux0;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_Product =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        ClassMetadata _classMeta0 = ocb.classCollection()
                                       .getClassMetadata("pl.wcislo.sbql4j.examples.model.linq.Product");
        FieldMetadata _fieldMeta0 = _classMeta0.fieldMetadataForName(
                "productName");
        BTreeRange _range0 = _fieldMeta0.search(t, _ident__aux0);
        Iterator4 _it0 = _range0.pointers();

        while (_it0.moveNext()) {
            BTreePointer _point0 = (BTreePointer) _it0.current();
            FieldIndexKeyImpl _pointKey0 = (FieldIndexKeyImpl) _point0.key();
            int _id0 = _pointKey0.parentID();
            LazyObjectReference _ref0 = transLocal.lazyReferenceFor(_id0);
            pl.wcislo.sbql4j.examples.model.linq.Product _obj0 = (pl.wcislo.sbql4j.examples.model.linq.Product) _ref0.getObject();

            if (_obj0 != null) {
                ocb.activate(_obj0);
            }

            _ident_Product.add(_obj0);
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_ident_Product,
            ocb);

        return _ident_Product;
    }
}
