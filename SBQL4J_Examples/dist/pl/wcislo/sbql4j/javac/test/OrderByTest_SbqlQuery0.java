package pl.wcislo.sbql4j.javac.test;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
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
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.text.*;

import java.util.*;


public class OrderByTest_SbqlQuery0 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products;
    private java.text.Collator plCollator;

    public OrderByTest_SbqlQuery0(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> products,
        final java.text.Collator plCollator) {
        this.products = products;
        this.plCollator = plCollator;
    }

    /**
     * original query='products order by
                                unitsInStock desc;
                                productName DESC using plCollator'
     *
     * query after optimization='products order by (unitsInStock DESC , productName DESC  using plCollator)'
    */
    public java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _ident_products =
            products;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Product> _queryResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Product>();
        _queryResult.addAll(_ident_products);

        Comparator<pl.wcislo.sbql4j.examples.model.linq.Product> _comparator0 = new Comparator<pl.wcislo.sbql4j.examples.model.linq.Product>() {
                public int compare(
                    pl.wcislo.sbql4j.examples.model.linq.Product _leftObj,
                    pl.wcislo.sbql4j.examples.model.linq.Product _rightObj) {
                    if (_leftObj == null) {
                        return 1;
                    }

                    int res = 0;
                    java.lang.Integer _leftParam0;

                    {
                        java.lang.Integer _ident_unitsInStock = ((_leftObj == null)
                            ? null : _leftObj.unitsInStock);
                        _leftParam0 = _ident_unitsInStock;
                    }

                    java.lang.Integer _rightParam0;

                    {
                        java.lang.Integer _ident_unitsInStock = ((_rightObj == null)
                            ? null : _rightObj.unitsInStock);
                        _rightParam0 = _ident_unitsInStock;
                    }

                    if (_leftParam0 != null) {
                        res = _leftParam0.compareTo(_rightParam0);
                    } else {
                        return 1;
                    }

                    if (res != 0) {
                        return -res;
                    }

                    java.lang.String _leftParam1;

                    {
                        java.lang.String _ident_productName = ((_leftObj == null)
                            ? null : _leftObj.productName);
                        _leftParam1 = _ident_productName;
                    }

                    java.lang.String _rightParam1;

                    {
                        java.lang.String _ident_productName = ((_rightObj == null)
                            ? null : _rightObj.productName);
                        _rightParam1 = _ident_productName;
                    }

                    java.text.Collator _ident_plCollator = plCollator;

                    if (_ident_plCollator != null) {
                        res = _ident_plCollator.compare(_leftParam1,
                                _rightParam1);
                    } else {
                        res = 0;
                    }

                    return -res;
                }
            };

        Collections.sort(_queryResult, _comparator0);

        return _queryResult;
    }
}
