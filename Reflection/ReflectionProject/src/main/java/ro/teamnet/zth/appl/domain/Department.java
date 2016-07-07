package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by user on 7/7/2016.
 */


@Table(name="Departments")
public class Department {
    @Id(name = "department_id")
    private Long id;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "location_id")
    private Location location;

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Location getLocation() {
        return location;
    }


    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
