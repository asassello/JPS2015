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


public class XMLExamples_SbqlQuery0 {
    private pl.wcislo.sbql4j.lang.xml.XMLDataSource xmlSource;

    public XMLExamples_SbqlQuery0(
        final pl.wcislo.sbql4j.lang.xml.XMLDataSource xmlSource) {
        this.xmlSource = xmlSource;
    }

    /**
     * original query='xmlSource.catalogue'
     *
     * query after optimization='xmlSource.catalogue'
    */
    public pl.wcislo.sbql4j.java.model.runtime.Struct executeQuery() {
        XMLTypeMapper __typeMapper0 = new XMLTypeMapper(Arrays.asList(
                    new XMLTypeMapper.XMLTypeMapperEntry(
                        new String[] { "catalogue", "book", "price" }, 3,
                        SCollectionType.SEQUENCE, true),
                    new XMLTypeMapper.XMLTypeMapperEntry(
                        new String[] { "catalogue", "book", "rok" }, 24,
                        SCollectionType.NO_COLLECTION, false),
                    new XMLTypeMapper.XMLTypeMapperEntry(
                        new String[] { "catalogue", "book", "year" }, 24,
                        SCollectionType.NO_COLLECTION, false)));
        xmlSource.getParser().setMapper(__typeMapper0);

        pl.wcislo.sbql4j.java.model.runtime.Struct _ident_xmlSource = xmlSource.getParsedData();
        pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl = _ident_xmlSource;
        pl.wcislo.sbql4j.java.model.runtime.Struct _ident_catalogue = (pl.wcislo.sbql4j.java.model.runtime.Struct) _dotEl.get(
                "catalogue");
        pl.wcislo.sbql4j.java.model.runtime.Struct _newRes0 = (pl.wcislo.sbql4j.java.model.runtime.Struct) pl.wcislo.sbql4j.xml.utils.XMLUtils.derefIfNecessary(_ident_catalogue);

        return _newRes0;
    }
}
