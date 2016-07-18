package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.service.DepartmentService;
import ro.teamnet.zth.appl.service.impl.DepartmentServiceImpl;

import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/departments")
public class DepartmentController {
private final DepartmentService instance = new DepartmentServiceImpl();

    @MyRequestMethod(urlPath = "/all")
    public List<?> getAllDepartments(){
        return instance.findAllDepartments();
        //return "allDepartments";
    }

    @MyRequestMethod(urlPath = "/one")
    public String getOneDepartment(){
        return "oneRandomDepartment";
    }
}
