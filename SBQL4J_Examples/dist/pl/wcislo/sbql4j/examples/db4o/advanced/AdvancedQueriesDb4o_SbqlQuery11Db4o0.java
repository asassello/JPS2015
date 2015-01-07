package pl.wcislo.sbql4j.examples.db4o.advanced;

import com.db4o.*;

import com.db4o.foundation.*;

import com.db4o.internal.*;
import com.db4o.internal.btree.*;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.db4o.*;
import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
import pl.wcislo.sbql4j.examples.model.linq.*;
import pl.wcislo.sbql4j.exception.*;
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

import java.text.*;

import java.util.*;


public class AdvancedQueriesDb4o_SbqlQuery11Db4o0 implements Db4oSBQLQuery {
    public AdvancedQueriesDb4o_SbqlQuery11Db4o0() {
    }

    /**
     * query='db.((Employee where getJob() == "clerk") group as _aux0).( unique Department.getLocation() as deptcity).(deptcity as cityLocation group as _aux1).((Department where deptcity in getLocation()) group as citydepts where  count(citydepts.getEmploys()._aux0) < 100).(_aux1, citydepts.getName() group as cityDeptNames,  avg(citydepts.getBoss().getSalary()) as cityDeptBossAvgSal)'
    '
     **/
    public java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery(
        final ObjectContainerBase ocb, final Transaction t) {
        final LocalTransaction transLocal = (LocalTransaction) t;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_Employee =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        ClassMetadata _classMeta15 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Employee");
        long[] _ids15 = _classMeta15.getIDs(transLocal);

        for (long _id15 : _ids15) {
            LazyObjectReference _ref15 = transLocal.lazyReferenceFor((int) _id15);
            _ident_Employee.add((pl.wcislo.sbql4j.examples.model.advanced.Employee) _ref15.getObject());
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _whereEl : _ident_Employee) {
            if (_whereEl == null) {
                continue;
            }

            if (_whereEl != null) {
                ocb.activate(_whereEl, 1);
            }

            java.lang.String _mth_getJobResult = _whereEl.getJob();

            if (_mth_getJobResult != null) {
                ocb.activate(_mth_getJobResult, 1);
            }

            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getJobResult,
                    "clerk");

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _groupAsResult_aux0 =
            _whereResult;
        java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotEl9 =
            _groupAsResult_aux0;
        final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
        ClassMetadata _classMeta16 = ocb.classCollection()
                                        .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
        long[] _ids16 = _classMeta16.getIDs(transLocal);

        for (long _id16 : _ids16) {
            LazyObjectReference _ref16 = transLocal.lazyReferenceFor((int) _id16);
            _ident_Department.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref16.getObject());
        }

        java.util.Collection<java.lang.String> _dotResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl : _ident_Department) {
            if (_dotEl == null) {
                continue;
            }

            if (_dotEl != null) {
                ocb.activate(_dotEl, 1);
            }

            java.util.List<java.lang.String> _mth_getLocationResult = _dotEl.getLocation();

            if (_mth_getLocationResult != null) {
                ocb.activate(_mth_getLocationResult, 2);
            }

            if (_mth_getLocationResult != null) {
                ocb.activate(_mth_getLocationResult, 2);
            }

            _dotResult.addAll(_mth_getLocationResult);
            _dotIndex++;
        }

        java.util.Collection<java.lang.String> _uniqueResult = new java.util.ArrayList<java.lang.String>();
        Set<java.lang.String> _tmp1 = new LinkedHashSet<java.lang.String>();
        _tmp1.addAll(_dotResult);
        _uniqueResult.addAll(_tmp1);

        java.util.Collection<java.lang.String> _asResult_deptcity = _uniqueResult;
        java.util.Collection<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult8 =
            new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex8 = 0;

        for (java.lang.String _dotEl8 : _asResult_deptcity) {
            if (_dotEl8 == null) {
                continue;
            }

            if (_dotEl8 != null) {
                ocb.activate(_dotEl8, 2);
            }

            java.lang.String _ident_deptcity = _dotEl8;

            if (_ident_deptcity != null) {
                ocb.activate(_ident_deptcity, 1);
            }

            java.lang.String _asResult_cityLocation = _ident_deptcity;
            java.lang.String _groupAsResult_aux1 = _asResult_cityLocation;
            java.lang.String _dotEl7 = _groupAsResult_aux1;
            final java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_Department1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
            ClassMetadata _classMeta17 = ocb.classCollection()
                                            .getClassMetadata("pl.wcislo.sbql4j.examples.model.advanced.Department");
            long[] _ids17 = _classMeta17.getIDs(transLocal);

            for (long _id17 : _ids17) {
                LazyObjectReference _ref17 = transLocal.lazyReferenceFor((int) _id17);
                _ident_Department1.add((pl.wcislo.sbql4j.examples.model.advanced.Department) _ref17.getObject());
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _whereResult1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
            int _whereLoopIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _whereEl1 : _ident_Department1) {
                if (_whereEl1 == null) {
                    continue;
                }

                if (_whereEl1 != null) {
                    ocb.activate(_whereEl1, 1);
                }

                java.lang.String _ident_deptcity1 = _dotEl8;

                if (_ident_deptcity1 != null) {
                    ocb.activate(_ident_deptcity1, 1);
                }

                java.util.List<java.lang.String> _mth_getLocationResult1 = _whereEl1.getLocation();

                if (_mth_getLocationResult1 != null) {
                    ocb.activate(_mth_getLocationResult1, 2);
                }

                Collection _inLeftCol1 = new ArrayList();
                _inLeftCol1.add(_ident_deptcity1);

                Collection _inRightCol1 = new ArrayList(_mth_getLocationResult1);
                java.lang.Boolean _inResult = _inRightCol1.containsAll(_inLeftCol1);

                if (_inResult) {
                    _whereResult1.add(_whereEl1);
                }

                _whereLoopIndex1++;
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _groupAsResultcitydepts =
                _whereResult1;

            if (_groupAsResultcitydepts != null) {
                ocb.activate(_groupAsResultcitydepts, 2);
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _whereEl2 =
                _groupAsResultcitydepts;
            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_citydepts =
                _whereEl2;

            if (_ident_citydepts != null) {
                ocb.activate(_ident_citydepts, 2);
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            int _dotIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 : _ident_citydepts) {
                if (_dotEl1 == null) {
                    continue;
                }

                if (_dotEl1 != null) {
                    ocb.activate(_dotEl1, 1);
                }

                java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                    _dotEl1.getEmploys();

                if (_mth_getEmploysResult != null) {
                    ocb.activate(_mth_getEmploysResult, 2);
                }

                if (_mth_getEmploysResult != null) {
                    ocb.activate(_mth_getEmploysResult, 2);
                }

                _dotResult1.addAll(_mth_getEmploysResult);
                _dotIndex1++;
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult2 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            int _dotIndex2 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl2 : _dotResult1) {
                if (_dotEl2 == null) {
                    continue;
                }

                if (_dotEl2 != null) {
                    ocb.activate(_dotEl2, 1);
                }

                java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident__aux0 =
                    _dotEl9;

                if (_ident__aux0 != null) {
                    ocb.activate(_ident__aux0, 2);
                }

                if (_ident__aux0 != null) {
                    ocb.activate(_ident__aux0, 2);
                }

                _dotResult2.addAll(_ident__aux0);
                _dotIndex2++;
            }

            java.lang.Integer _countResult = _dotResult2.size();

            Boolean _lessResult = _countResult < 100;
            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _whereResult2 =
                null;

            if (_lessResult) {
                _whereResult2 = _groupAsResultcitydepts;
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _dotEl6 =
                _whereResult2;
            java.lang.String _ident__aux1 = _dotEl7;

            if (_ident__aux1 != null) {
                ocb.activate(_ident__aux1, 1);
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_citydepts1 =
                _dotEl6;

            if (_ident_citydepts1 != null) {
                ocb.activate(_ident_citydepts1, 2);
            }

            java.util.Collection<java.lang.String> _dotResult3 = new java.util.ArrayList<java.lang.String>();
            int _dotIndex3 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl3 : _ident_citydepts1) {
                if (_dotEl3 == null) {
                    continue;
                }

                if (_dotEl3 != null) {
                    ocb.activate(_dotEl3, 1);
                }

                java.lang.String _mth_getNameResult = _dotEl3.getName();

                if (_mth_getNameResult != null) {
                    ocb.activate(_mth_getNameResult, 1);
                }

                if (_mth_getNameResult != null) {
                    ocb.activate(_mth_getNameResult, 1);
                }

                _dotResult3.add(_mth_getNameResult);
                _dotIndex3++;
            }

            java.util.Collection<java.lang.String> _groupAsResultcityDeptNames = _dotResult3;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_ident__aux1,
                    _groupAsResultcityDeptNames, "cityLocation", "cityDeptNames");
            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_citydepts2 =
                _dotEl6;

            if (_ident_citydepts2 != null) {
                ocb.activate(_ident_citydepts2, 2);
            }

            java.util.Collection<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult4 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            int _dotIndex4 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl4 : _ident_citydepts2) {
                if (_dotEl4 == null) {
                    continue;
                }

                if (_dotEl4 != null) {
                    ocb.activate(_dotEl4, 1);
                }

                pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult =
                    _dotEl4.getBoss();

                if (_mth_getBossResult != null) {
                    ocb.activate(_mth_getBossResult, 1);
                }

                if (_mth_getBossResult != null) {
                    ocb.activate(_mth_getBossResult, 1);
                }

                _dotResult4.add(_mth_getBossResult);
                _dotIndex4++;
            }

            java.util.Collection<java.lang.Double> _dotResult5 = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex5 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl5 : _dotResult4) {
                if (_dotEl5 == null) {
                    continue;
                }

                if (_dotEl5 != null) {
                    ocb.activate(_dotEl5, 1);
                }

                java.lang.Double _mth_getSalaryResult = _dotEl5.getSalary();

                if (_mth_getSalaryResult != null) {
                    ocb.activate(_mth_getSalaryResult, 1);
                }

                if (_mth_getSalaryResult != null) {
                    ocb.activate(_mth_getSalaryResult, 1);
                }

                _dotResult5.add(_mth_getSalaryResult);
                _dotIndex5++;
            }

            java.lang.Double _avgResult = 0d;

            if ((_dotResult5 != null) && !_dotResult5.isEmpty()) {
                Number _avgSum2 = null;

                for (Number _avgEl2 : _dotResult5) {
                    _avgSum2 = MathUtils.sum(_avgSum2, _avgEl2);
                }

                _avgResult = _avgSum2.doubleValue() / _dotResult5.size();
            }

            java.lang.Double _asResult_cityDeptBossAvgSal = _avgResult;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult1 = OperatorUtils.cartesianProductSS(_commaResult,
                    _asResult_cityDeptBossAvgSal, "", "cityDeptBossAvgSal");

            if (_commaResult1 != null) {
                ocb.activate(_commaResult1, 2);
            }

            _dotResult8.add(_commaResult1);
            _dotIndex8++;
        }

        pl.wcislo.sbql4j.db4o.utils.DerefUtils.activateResult(_dotResult8, ocb);

        return _dotResult8;
    }
}
