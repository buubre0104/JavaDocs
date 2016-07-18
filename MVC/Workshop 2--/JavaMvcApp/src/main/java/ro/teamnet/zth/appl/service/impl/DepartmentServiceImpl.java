package ro.teamnet.zth.appl.service.impl;

import ro.teamnet.zth.api.annotations.MyService;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.service.DepartmentService;

import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
@MyService
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public List<?> findAllDepartments() {
            List<Department> listDepartments;
            DepartmentDao instance = new DepartmentDao();
            listDepartments = instance.findAllDepartments();
            return listDepartments;

    }
}
