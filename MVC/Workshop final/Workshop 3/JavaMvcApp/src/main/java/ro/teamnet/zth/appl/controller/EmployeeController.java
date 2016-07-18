package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.service.EmployeeService;
import ro.teamnet.zth.appl.service.EmployeeServiceImpl;

import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {
private final EmployeeService instance = new EmployeeServiceImpl();

    @MyRequestMethod(urlPath = "/all")
    public List<Employee> getAllEmployees() {
        //return "allEmployees";
        return instance.findAllEmployees();
    }

    @MyRequestMethod(urlPath = "/one")
    public Employee getOneEmployee(@MyRequestParam(name="id") Long employeeid){
       // return "oneRandomEmployee";
        //Employee employee = new Employee();
       // employee.setFirstName("CEVA");
       // employee.setLastName("ALTCEVA");
       // employee.setId(10l);
        return instance.findOneEmployee(employeeid);
    }

    @MyRequestMethod(urlPath = "/delete", methodType = "DELETE")
    public void deleteOneEmployee(@MyRequestParam(name="id") Long id){
        instance.deleteOneEmployee(id);
    }



}
