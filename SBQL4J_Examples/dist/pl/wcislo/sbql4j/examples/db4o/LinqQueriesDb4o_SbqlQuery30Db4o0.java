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


public class LinqQueriesDb4o_SbqlQuery30Db4o0 implements Db4oSBQLQuery {
    private java.util.List<java.lang.String> digits;

    public LinqQueriesDb4o_SbqlQuery30Db4o0(
        java.util.List<java.lang.String> digits) {
        this.digits = digits;
    }

    /**
     * query='db.(digits as d order by (d.length(), d))'
    '
     **/
    public java.util.List<java.lang.String> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        java.util.List<java.lang.String> _ident_digits = digits;
        java.util.List<java.lang.String> _asResult_d = _ident_digits;
        java.util.List<java.lang.String> _orderByResult = new java.util.ArrayList<java.lang.String>();

        if (_asResult_d != null) {
            ocb.activate(_asResult_d, 2);
        }

        _orderByResult.addAll(_asResult_d);

        Comparator<java.lang.String> _comparator7 = new Comparator<java.lang.String>() {
                public int compare(java.lang.String _leftObj,
                    java.lang.String _rightObj) {
                    if (_leftObj == null) {
                        return -1;
                    }

                    if (_leftObj != null) {
                        ocb.activate(_leftObj, 1);
                    }

                    if (_rightObj != null) {
                        ocb.activate(_rightObj, 1);
                    }

                    int res = 0;
                    java.lang.Integer _leftParam0;

                    {
                        java.lang.String _ident_d = _leftObj;
                        java.lang.String _dotEl = _ident_d;
                        java.lang.Integer _mth_lengthResult = _dotEl.length();

                        if (_mth_lengthResult != null) {
                            ocb.activate(_mth_lengthResult, 1);
                        }

                        _leftParam0 = _mth_lengthResult;
                    }

                    java.lang.Integer _rightParam0;

                    {
                        java.lang.String _ident_d = _rightObj;
                        java.lang.String _dotEl = _ident_d;
                        java.lang.Integer _mth_lengthResult = _dotEl.length();

                        if (_mth_lengthResult != null) {
                            ocb.activate(_mth_lengthResult, 1);
                        }

                        _rightParam0 = _mth_lengthResult;
                    }

                    if (_leftParam0 != null) {
                        res = _leftParam0.compareTo(_rightParam0);
                    } else {
                        return -1;
                    }

                    if (res != 0) {
                        return res;
                    }

                    java.lang.String _leftParam1;

                    {
                        java.lang.String _ident_d1 = _leftObj;
                        _leftParam1 = _ident_d1;
                    }

                    java.lang.String _rightParam1;

                    {
                        java.lang.String _ident_d1 = _rightObj;
                        _rightParam1 = _ident_d1;
                    }

                    if (_leftParam1 != null) {
                        res = _leftParam1.compareTo(_rightParam1);
                    } else {
                        return -1;
                    }

                    return res;
                }
            };

        Collections.sort(_orderByResult, _comparator7);
        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_orderByResult,
            ocb);

        return _orderByResult;
    }
}
