package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
public class EmployeeServiceImpl implements EmployeeService{

    private  final EmployeeDao daoInstance = new EmployeeDao();
    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> listEmployees;
        //EmployeeDao daoInstance = new EmployeeDao();
        listEmployees = daoInstance.getAllEmployees();
        return listEmployees;
    }

    @Override
    public Employee findOneEmployee(Long id) {
        Employee employee;
        //EmployeeDao daoInstance = new EmployeeDao();
        employee = daoInstance.getEmployeeById(id);
        return employee;
    }

    @Override
    public void deleteOneEmployee(Long id) {
        daoInstance.deleteEmployee(daoInstance.getEmployeeById(id));
    }

}
