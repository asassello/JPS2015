package pl.wcislo.sbql4j.examples.java_heap.advanced;

import org.apache.commons.collections.CollectionUtils;

import pl.wcislo.sbql4j.examples.*;
import pl.wcislo.sbql4j.examples.model.advanced.*;
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

import java.util.*;
import java.util.Collection;
import java.util.List;


public class AdvancedQueriesJavaHeap_SbqlQuery11 {
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> emp;
    private java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept;

    public AdvancedQueriesJavaHeap_SbqlQuery11(
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> emp,
        final java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> dept) {
        this.emp = emp;
        this.dept = dept;
    }

    /**
     * original query='((unique(dept.location)) as deptcity).
                            ((((dept where deptcity in location) group as citydepts)
                            where count(citydepts.employs.(emp where job == "clerk")) < 100).
                            (deptcity as cityLocation,
                                            (citydepts.name) group as cityDeptNames,
                                            avg(citydepts.boss.salary) as cityDeptBossAvgSal))'
     *
     * query after optimization='((emp where getJob() == "clerk") group as _aux0).( unique dept.getLocation() as deptcity).(deptcity as cityLocation group as _aux1).((dept where deptcity in getLocation()) group as citydepts where  count(citydepts.getEmploys()._aux0) < 100).(_aux1, citydepts.getName() group as cityDeptNames,  avg(citydepts.getBoss().getSalary()) as cityDeptBossAvgSal)'
    */
    public java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> executeQuery() {
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident_emp =
            emp;
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _whereResult =
            new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
        int _whereLoopIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Employee _whereEl : _ident_emp) {
            if (_whereEl == null) {
                continue;
            }

            java.lang.String _mth_getJobResult = _whereEl.getJob();
            java.lang.Boolean _equalsResult = OperatorUtils.equalsSafe(_mth_getJobResult,
                    "clerk");

            if (_equalsResult) {
                _whereResult.add(_whereEl);
            }

            _whereLoopIndex++;
        }

        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _groupAsResult_aux0 =
            _whereResult;
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotEl9 =
            _groupAsResult_aux0;
        java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept =
            dept;
        java.util.List<java.lang.String> _dotResult = new java.util.ArrayList<java.lang.String>();
        int _dotIndex = 0;

        for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl : _ident_dept) {
            if (_dotEl == null) {
                continue;
            }

            java.util.List<java.lang.String> _mth_getLocationResult = _dotEl.getLocation();
            _dotResult.addAll(_mth_getLocationResult);
            _dotIndex++;
        }

        java.util.List<java.lang.String> _uniqueResult = new java.util.ArrayList<java.lang.String>();
        Set<java.lang.String> _tmp1 = new LinkedHashSet<java.lang.String>();
        _tmp1.addAll(_dotResult);
        _uniqueResult.addAll(_tmp1);

        java.util.List<java.lang.String> _asResult_deptcity = _uniqueResult;
        java.util.List<pl.wcislo.sbql4j.java.model.runtime.Struct> _dotResult8 = new java.util.ArrayList<pl.wcislo.sbql4j.java.model.runtime.Struct>();
        int _dotIndex8 = 0;

        for (java.lang.String _dotEl8 : _asResult_deptcity) {
            if (_dotEl8 == null) {
                continue;
            }

            java.lang.String _ident_deptcity = _dotEl8;
            java.lang.String _asResult_cityLocation = _ident_deptcity;
            java.lang.String _groupAsResult_aux1 = _asResult_cityLocation;
            java.lang.String _dotEl7 = _groupAsResult_aux1;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_dept1 =
                dept;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _whereResult1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Department>();
            int _whereLoopIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _whereEl1 : _ident_dept1) {
                if (_whereEl1 == null) {
                    continue;
                }

                java.lang.String _ident_deptcity1 = _dotEl8;
                java.util.List<java.lang.String> _mth_getLocationResult1 = _whereEl1.getLocation();
                Collection _inLeftCol1 = new ArrayList();
                _inLeftCol1.add(_ident_deptcity1);

                Collection _inRightCol1 = new ArrayList(_mth_getLocationResult1);
                java.lang.Boolean _inResult = _inRightCol1.containsAll(_inLeftCol1);

                if (_inResult) {
                    _whereResult1.add(_whereEl1);
                }

                _whereLoopIndex1++;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _groupAsResultcitydepts =
                _whereResult1;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _whereEl2 =
                _groupAsResultcitydepts;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_citydepts =
                _whereEl2;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult1 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            int _dotIndex1 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl1 : _ident_citydepts) {
                if (_dotEl1 == null) {
                    continue;
                }

                java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _mth_getEmploysResult =
                    _dotEl1.getEmploys();
                _dotResult1.addAll(_mth_getEmploysResult);
                _dotIndex1++;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult2 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            int _dotIndex2 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl2 : _dotResult1) {
                if (_dotEl2 == null) {
                    continue;
                }

                java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _ident__aux0 =
                    _dotEl9;
                _dotResult2.addAll(_ident__aux0);
                _dotIndex2++;
            }

            java.lang.Integer _countResult = _dotResult2.size();

            Boolean _lessResult = _countResult < 100;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _whereResult2 =
                null;

            if (_lessResult) {
                _whereResult2 = _groupAsResultcitydepts;
            }

            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _dotEl6 =
                _whereResult2;
            java.lang.String _ident__aux1 = _dotEl7;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_citydepts1 =
                _dotEl6;
            java.util.List<java.lang.String> _dotResult3 = new java.util.ArrayList<java.lang.String>();
            int _dotIndex3 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl3 : _ident_citydepts1) {
                if (_dotEl3 == null) {
                    continue;
                }

                java.lang.String _mth_getNameResult = _dotEl3.getName();
                _dotResult3.add(_mth_getNameResult);
                _dotIndex3++;
            }

            java.util.List<java.lang.String> _groupAsResultcityDeptNames = _dotResult3;
            pl.wcislo.sbql4j.java.model.runtime.Struct _commaResult = OperatorUtils.cartesianProductSS(_ident__aux1,
                    _groupAsResultcityDeptNames, "cityLocation", "cityDeptNames");
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Department> _ident_citydepts2 =
                _dotEl6;
            java.util.List<pl.wcislo.sbql4j.examples.model.advanced.Employee> _dotResult4 =
                new java.util.ArrayList<pl.wcislo.sbql4j.examples.model.advanced.Employee>();
            int _dotIndex4 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Department _dotEl4 : _ident_citydepts2) {
                if (_dotEl4 == null) {
                    continue;
                }

                pl.wcislo.sbql4j.examples.model.advanced.Employee _mth_getBossResult =
                    _dotEl4.getBoss();
                _dotResult4.add(_mth_getBossResult);
                _dotIndex4++;
            }

            java.util.List<java.lang.Double> _dotResult5 = new java.util.ArrayList<java.lang.Double>();
            int _dotIndex5 = 0;

            for (pl.wcislo.sbql4j.examples.model.advanced.Employee _dotEl5 : _dotResult4) {
                if (_dotEl5 == null) {
                    continue;
                }

                java.lang.Double _mth_getSalaryResult = _dotEl5.getSalary();
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
            _dotResult8.add(_commaResult1);
            _dotIndex8++;
        }

        return _dotResult8;
    }
}
