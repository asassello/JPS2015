package pl.wcislo.sbql4j.examples.java_heap.linq;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
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

import java.util.*;


public class LinqQueriesJavaHeap_SbqlQuery47 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products;

    public LinqQueriesJavaHeap_SbqlQuery47(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products) {
        this.products = products;
    }

    /**
     * original query='(products where productID == 12)[0]'
     *
     * query after optimization='(products where productID == 12)[0]'
    */
    public pl.wcislo.sbql4j.examples.model.linq.Product executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products =
            products;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Product _whereEl : _ident_products) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.Integer _ident_productID = ((_whereEl == null) ? null
                                                                     : _whereEl.productID);
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_productID,
                    12);

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        pl.wcislo.sbql4j.examples.model.linq.Product _queryResult;
        _queryResult = null;

        if (!_whereResult.isEmpty()) {
            _queryResult = _whereResult.get(0);
        }

        return _queryResult;
    }
}
