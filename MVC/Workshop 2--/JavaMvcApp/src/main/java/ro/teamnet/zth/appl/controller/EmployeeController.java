package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.InjectionService;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.service.EmployeeService;

import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {
//private final EmployeeService instance = new EmployeeServiceImpl();
private final EmployeeService instance;

    @InjectionService
    public EmployeeController(EmployeeService instance) {

        this.instance = instance;
    }

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

    @MyRequestMethod(urlPath = "/onedelete")
    public void deleteOneEmployee(@MyRequestParam(name="id") Long id){
        instance.deleteOneEmployee(id);
    }
/*
    @MyRequestMethod(urlPath = "/oneadd")
    public void addOneEmployee(@MyRequestParam(name="employee")JSObject obj) {
        //asta e o mizerie!!!.....-_-
        instance.addOneEmployee((Employee) obj);
    }
*/


}
