package pl.wcislo.sbql4j.examples.xml;

import org.apache.commons.collections.CollectionUtils;

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
import pl.wcislo.sbql4j.lang.xml.XMLDataSource;
import pl.wcislo.sbql4j.lang.xml.XMLMetadata;
import pl.wcislo.sbql4j.lang.xml.XMLMetadata.SourceType;
import pl.wcislo.sbql4j.model.*;
import pl.wcislo.sbql4j.model.collections.*;
import pl.wcislo.sbql4j.util.*;
import pl.wcislo.sbql4j.util.Utils;
import pl.wcislo.sbql4j.xml.model.*;
import pl.wcislo.sbql4j.xml.parser.store.*;

import java.io.File;

import java.util.*;


public class XMLExamples_SbqlQuery4 {
    private pl.wcislo.sbql4j.lang.xml.XMLDataSource xmlSource;

    public XMLExamples_SbqlQuery4(
        final pl.wcislo.sbql4j.lang.xml.XMLDataSource xmlSource) {
        this.xmlSource = xmlSource;
    }

    /**
     * original query='sum(xmlSource.catalogue.book.price where kind == "retail")'
     *
     * query after optimization=' sum (xmlSource.catalogue.book.price where kind == "retail")'
    */
    public java.lang.Double executeQuery() {
        XMLTypeMapper __typeMapper4 = new XMLTypeMapper(Arrays.asList(
                    new XMLTypeMapper.XMLTypeMapperEntry(
                        new String[] { "catalogue", "book", "price" }, 3,
                        SCollectionType.SEQUENCE, true),
                    new XMLTypeMapper.XMLTypeMapperEntry(
                        new String[] { "catalogue", "book", "rok" }, 24,
                        SCollectionType.NO_COLLECTION, false),
                    new XMLTypeMapper.XMLTypeMapperEntry(
                        new String[] { "catalogue", "book", "year" }, 24,
                        SCollectionType.NO_COLLECTION, false)));
        xmlSource.getParser().setMapper(__typeMapper4);

        pl.wcislo.sbql4j.java.model.runtime.Struct _ident_xmlSource = xmlSource.getParsedData();
        pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl = _ident_xmlSource;
        pl.wcislo.sbql4j.java.model.runtime.Struct _ident_catalogue = (pl.wcislo.sbql4j.java.model.runtime.Struct) _dotEl.get(
                "catalogue");
        pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl1 = _ident_catalogue;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _ident_book = (java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct>) _dotEl1.get(
                "book");
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult2 = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex2 = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl2 : _ident_book) {
            if (_dotEl2 == null) {
                continue;
            }

            java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _ident_price =
                (java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct>) _dotEl2.get(
                    "price");
            _dotResult2.addAll(_ident_price);
            _dotIndex2++;
        }

        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _whereResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.java.model.runtime.Struct _whereEl : _dotResult2) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.String _ident_kind = (java.lang.String) _whereEl.get(
                    "kind");
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_ident_kind,
                    "retail");

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        List<java.lang.Double> __whereResult_deref0 = new ArrayList<java.lang.Double>();

        for (Struct _s0 : _whereResult) {
            __whereResult_deref0.add((java.lang.Double) _s0.get("_value"));
        }

        Number _sum0 = null;

        for (Number _sumEl0 : __whereResult_deref0) {
            _sum0 = MathUtils.sum(_sum0, _sumEl0);
        }

        java.lang.Double _queryResult = (java.lang.Double) _sum0;
        java.lang.Double _newRes4 = (java.lang.Double) pl.wcislo.sbql4j.xml.utils.XMLUtils.derefIfNecessary(_queryResult);

        return _newRes4;
    }
}
