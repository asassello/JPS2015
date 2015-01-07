package edu.pjwstk.jps;

import edu.pjwstk.jps.model.Address;
import edu.pjwstk.jps.model.Car;
import edu.pjwstk.jps.model.Firm;
import edu.pjwstk.jps.model.Person;

import org.apache.commons.collections.CollectionUtils;

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

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class ExampleData_SbqlQuery0 {
    private java.util.List<edu.pjwstk.jps.model.Person> persons;
    private java.lang.String c;

    public ExampleData_SbqlQuery0(
        final java.util.List<edu.pjwstk.jps.model.Person> persons,
        final java.lang.String c) {
        this.persons = persons;
        this.c = c;
    }

    /**
     * original query='persons where address.city == c'
     *
     * query after optimization='persons where getAddress().getCity() == c'
    */
    public java.util.List<edu.pjwstk.jps.model.Person> executeQuery() {
        java.util.List<edu.pjwstk.jps.model.Person> _ident_persons = persons;
        java.util.List<edu.pjwstk.jps.model.Person> _queryResult = new java.util.ArrayList<edu.pjwstk.jps.model.Person>();
        int _whereLoopIndex = 0;

        for (edu.pjwstk.jps.model.Person _whereEl : _ident_persons) {
            if (_whereEl == null) {
                continue;
            }

            edu.pjwstk.jps.model.Address _mth_getAddressResult = _whereEl.getAddress();
            edu.pjwstk.jps.model.Address _dotEl = _mth_getAddressResult;
            java.lang.String _mth_getCityResult = _dotEl.getCity();
            java.lang.String _ident_c = c;
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getCityResult,
                    _ident_c);

            if (_equalsResult) {
                _queryResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        return _queryResult;
    }
}
