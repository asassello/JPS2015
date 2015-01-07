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


public class LinqQueriesJavaHeap_SbqlQuery37 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers;

    public LinqQueriesJavaHeap_SbqlQuery37(
        final java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> customers) {
        this.customers = customers;
    }

    /**
     * original query='(customers as c).
                            (c.companyName as companyName join
                            (
                              ( unique(c.orders.orderDate.year ) as year join
                                (c.orders where orderDate.year == year) group as yearGroups
                              ).
                                (year as year,
                                      (
                                        (unique(yearGroups.orderDate.month) as month) join
                                        (yearGroups where orderDate.month == month) group as orders
                                      ) group as monthGroups
                                    ) group as yearGroups
                              )
                            )'
     *
     * query after optimization='(customers as c).(( unique c.orders.orderDate.getYear() as year join (c.orders where orderDate.getYear() == year) group as yearGroups).(year as year, ( unique yearGroups.orderDate.getMonth() as month join (yearGroups where orderDate.getMonth() == month) group as orders) group as monthGroups) group as yearGroups group as _aux0).(c.companyName as companyName join _aux0)'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _ident_customers =
            customers;
        java.util.List<pl.wcislo.sbql4j.examples.model.linq.Customer> _asResult_c =
            _ident_customers;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _queryResult = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex11 = 0;

        for (pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl11 : _asResult_c) {
            if (_dotEl11 == null) {
                continue;
            }

            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c = _dotEl11;
            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl = _ident_c;
            java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders =
                ((_dotEl == null)
                ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                : _dotEl.orders);
            java.util.List<java.util.Date> _dotResult1 = new java.util.ArrayList<java.util.Date>();
            int _dotIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.linq.Order _dotEl1 : _ident_orders) {
                if (_dotEl1 == null) {
                    continue;
                }

                java.util.Date _ident_orderDate = ((_dotEl1 == null) ? null
                                                                     : _dotEl1.orderDate);
                _dotResult1.add(_ident_orderDate);
                _dotIndex1++;
            }

            java.util.List<java.lang.Integer> _dotResult2 = new java.util.ArrayList<java.lang.Integer>();
            int _dotIndex2 = 0;

            for (java.util.Date _dotEl2 : _dotResult1) {
                if (_dotEl2 == null) {
                    continue;
                }

                java.lang.Integer _mth_getYearResult = _dotEl2.getYear();
                _dotResult2.add(_mth_getYearResult);
                _dotIndex2++;
            }

            java.util.List<java.lang.Integer> _uniqueResult = new java.util.ArrayList<java.lang.Integer>();
            Set<java.lang.Integer> _tmp3 = new LinkedHashSet<java.lang.Integer>();
            _tmp3.addAll(_dotResult2);
            _uniqueResult.addAll(_tmp3);

            java.util.List<java.lang.Integer> _asResult_year = _uniqueResult;
            java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult =
                new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
            int _joinIndex = 0;

            for (java.lang.Integer _joinEl : _asResult_year) {
                pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c1 = _dotEl11;
                pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl3 = _ident_c1;
                java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_orders1 =
                    ((_dotEl3 == null)
                    ? new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>()
                    : _dotEl3.orders);
                java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _whereResult =
                    new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>();
                int _whereLoopIndex = 0;

                for (pl.wcislo.sbql4j.examples.model.linq.Order _whereEl : _ident_orders1) {
                    if (_whereEl == null) {
                        continue;
                    }

                    java.util.Date _ident_orderDate1 = ((_whereEl == null)
                        ? null : _whereEl.orderDate);
                    java.util.Date _dotEl4 = _ident_orderDate1;
                    java.lang.Integer _mth_getYearResult1 = _dotEl4.getYear();
                    java.lang.Integer _ident_year = _joinEl;
                    java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getYearResult1,
                            _ident_year);

                    if (_equalsResult) {
                        _whereResult.add(_whereEl);
                    }

                    _whereLoopIndex++;
                }

                java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _groupAsResultyearGroups =
                    _whereResult;
                _joinResult.add(OperatorUtils.cartesianProductSS(_joinEl,
                        _groupAsResultyearGroups, "year", "yearGroups"));
                _joinIndex++;
            }

            java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult8 =
                new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
            int _dotIndex8 = 0;

            for (pl.wcislo.sbql4j.java.model.runtime.Struct _dotEl8 : _joinResult) {
                if (_dotEl8 == null) {
                    continue;
                }

                java.lang.Integer _ident_year1 = (java.lang.Integer) _dotEl8.get(
                        "year");
                java.lang.Integer _asResult_year1 = _ident_year1;
                java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_yearGroups =
                    (java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order>) _dotEl8.get(
                        "yearGroups");
                java.util.List<java.util.Date> _dotResult5 = new java.util.ArrayList<java.util.Date>();
                int _dotIndex5 = 0;

                for (pl.wcislo.sbql4j.examples.model.linq.Order _dotEl5 : _ident_yearGroups) {
                    if (_dotEl5 == null) {
                        continue;
                    }

                    java.util.Date _ident_orderDate2 = ((_dotEl5 == null)
                        ? null : _dotEl5.orderDate);
                    _dotResult5.add(_ident_orderDate2);
                    _dotIndex5++;
                }

                java.util.List<java.lang.Integer> _dotResult6 = new java.util.ArrayList<java.lang.Integer>();
                int _dotIndex6 = 0;

                for (java.util.Date _dotEl6 : _dotResult5) {
                    if (_dotEl6 == null) {
                        continue;
                    }

                    java.lang.Integer _mth_getMonthResult = _dotEl6.getMonth();
                    _dotResult6.add(_mth_getMonthResult);
                    _dotIndex6++;
                }

                java.util.List<java.lang.Integer> _uniqueResult1 = new java.util.ArrayList<java.lang.Integer>();
                Set<java.lang.Integer> _tmp4 = new LinkedHashSet<java.lang.Integer>();
                _tmp4.addAll(_dotResult6);
                _uniqueResult1.addAll(_tmp4);

                java.util.List<java.lang.Integer> _asResult_month = _uniqueResult1;
                java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _joinResult1 =
                    new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
                int _joinIndex1 = 0;

                for (java.lang.Integer _joinEl1 : _asResult_month) {
                    java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _ident_yearGroups1 =
                        (java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order>) _dotEl8.get(
                            "yearGroups");
                    java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _whereResult1 =
                        new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.linq.Order>();
                    int _whereLoopIndex1 = 0;

                    for (pl.wcislo.sbql4j.examples.model.linq.Order _whereEl1 : _ident_yearGroups1) {
                        if (_whereEl1 == null) {
                            continue;
                        }

                        java.util.Date _ident_orderDate3 = ((_whereEl1 == null)
                            ? null : _whereEl1.orderDate);
                        java.util.Date _dotEl7 = _ident_orderDate3;
                        java.lang.Integer _mth_getMonthResult1 = _dotEl7.getMonth();
                        java.lang.Integer _ident_month = _joinEl1;
                        java.lang.Boolean _equalsResult1 = OperatorUtils.equalsSafe(_mth_getMonthResult1,
                                _ident_month);

                        if (_equalsResult1) {
                            _whereResult1.add(_whereEl1);
                        }

                        _whereLoopIndex1++;
                    }

                    java.util.List<pl.wcislo.sbql4j.examples.model.linq.Order> _groupAsResultorders =
                        _whereResult1;
                    _joinResult1.add(OperatorUtils.cartesianProductSS(
                            _joinEl1, _groupAsResultorders, "month", "orders"));
                    _joinIndex1++;
                }

                java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _groupAsResultmonthGroups =
                    _joinResult1;
                pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_asResult_year1,
                        _groupAsResultmonthGroups, "year", "monthGroups");
                _dotResult8.add(_commaResult);
                _dotIndex8++;
            }

            java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _groupAsResultyearGroups1 =
                _dotResult8;
            java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _groupAsResult_aux0 =
                _groupAsResultyearGroups1;
            java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotEl10 = _groupAsResult_aux0;
            pl.wcislo.sbql4j.examples.model.linq.Customer _ident_c2 = _dotEl11;
            pl.wcislo.sbql4j.examples.model.linq.Customer _dotEl9 = _ident_c2;
            java.lang.String _ident_companyName = ((_dotEl9 == null) ? null
                                                                     : _dotEl9.companyName);
            java.lang.String _asResult_companyName = _ident_companyName;
            java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _ident__aux0 =
                _dotEl10;
            pl.wcislo.sbql4j.java.model.runtime.Struct _joinResult2 = OperatorUtils.cartesianProductSS(_asResult_companyName,
                    _ident__aux0, "companyName", "yearGroups");
            _queryResult.add(_joinResult2);
            _dotIndex11++;
        }

        return _queryResult;
    }
}
