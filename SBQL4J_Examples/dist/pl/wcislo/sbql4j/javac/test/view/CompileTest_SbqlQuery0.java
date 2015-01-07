package pl.wcislo.sbql4j.javac.test.view;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.exception.*;
import pl.wcislo.sbql4j.java.model.compiletime.Signature.SCollectionType;
import pl.wcislo.sbql4j.java.model.runtime.*;
import pl.wcislo.sbql4j.java.model.runtime.Struct;
import pl.wcislo.sbql4j.java.model.runtime.factory.*;
import pl.wcislo.sbql4j.java.utils.ArrayUtils;
import pl.wcislo.sbql4j.java.utils.OperatorUtils;
import pl.wcislo.sbql4j.java.utils.Pair;
import pl.wcislo.sbql4j.javac.test.view.Customer;
import pl.wcislo.sbql4j.javac.test.view.Product;
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

import java.util.*;
import java.util.ArrayList;
import java.util.List;


public class CompileTest_SbqlQuery0 {
    private java.util.List<pl.wcislo.sbql4j.javac.test.view.Product> pr;

    public CompileTest_SbqlQuery0(
        final java.util.List<pl.wcislo.sbql4j.javac.test.view.Product> pr) {
        this.pr = pr;
    }

    /**
     * original query='pr.category'
     *
     * query after optimization='pr.category'
    */
    public java.util.List<java.lang.String> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.javac.test.view.Product> _ident_pr = pr;
        java.util.List<java.lang.String> _queryResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.javac.test.view.Product _dotEl : _ident_pr) {
            if (_dotEl == null) {
                continue;
            }

            java.lang.String _ident_category = ((_dotEl == null) ? null
                                                                 : _dotEl.category);
            _queryResult.add(_ident_category);
            _dotIndex++;
        }

        return _queryResult;
    }
}
