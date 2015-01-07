package pl.wcislo.sbql4j.examples.db4o;

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


public class LinqQueriesDb4o_SbqlQuery29Db4o0 implements Db4oSBQLQuery {
    private java.util.List<java.lang.String> words;

    public LinqQueriesDb4o_SbqlQuery29Db4o0(
        java.util.List<java.lang.String> words) {
        this.words = words;
    }

    /**
     * query='db.(words order by (toLowerCase() DESC ))'
    '
     **/
    public java.util.List<java.lang.String> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        java.util.List<java.lang.String> _ident_words = words;
        java.util.List<java.lang.String> _orderByResult = new java.util.ArrayList<java.lang.String>();

        if (_ident_words != null) {
            ocb.activate(_ident_words, 2);
        }

        _orderByResult.addAll(_ident_words);

        Comparator<java.lang.String> _comparator6 = new Comparator<java.lang.String>() {
                public int compare(java.lang.String _leftObj,
                    java.lang.String _rightObj) {
                    if (_leftObj == null) {
                        return 1;
                    }

                    if (_leftObj != null) {
                        ocb.activate(_leftObj, 1);
                    }

                    if (_rightObj != null) {
                        ocb.activate(_rightObj, 1);
                    }

                    int res = 0;
                    java.lang.String _leftParam0;

                    {
                        java.lang.String _mth_toLowerCaseResult = _leftObj.toLowerCase();

                        if (_mth_toLowerCaseResult != null) {
                            ocb.activate(_mth_toLowerCaseResult, 1);
                        }

                        _leftParam0 = _mth_toLowerCaseResult;
                    }

                    java.lang.String _rightParam0;

                    {
                        java.lang.String _mth_toLowerCaseResult = _rightObj.toLowerCase();

                        if (_mth_toLowerCaseResult != null) {
                            ocb.activate(_mth_toLowerCaseResult, 1);
                        }

                        _rightParam0 = _mth_toLowerCaseResult;
                    }

                    if (_leftParam0 != null) {
                        res = _leftParam0.compareTo(_rightParam0);
                    } else {
                        return 1;
                    }

                    return -res;
                }
            };

        Collections.sort(_orderByResult, _comparator6);
        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_orderByResult,
            ocb);

        return _orderByResult;
    }
}
