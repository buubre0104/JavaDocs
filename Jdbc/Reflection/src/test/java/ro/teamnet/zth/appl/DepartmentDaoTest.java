package ro.teamnet.zth.appl;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.dao.*;


import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 7/11/2016.
 */
public class DepartmentDaoTest {

    @Test
    public void testgetDepartmentById(){
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Department res = entityManager.findById(Department.class, (long) 190);
        assertEquals("depart_name = Contracting","Contracting", res.getDepartmentName());
    }


    @Test
    public void testfindAll(){
        EntityManagerImpl emi = new EntityManagerImpl();
        List<Department> result = emi.findAll(Department.class);
        assertEquals("Department should have 27 entries.", 27, result.size());
    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testInsert(){
        EntityManagerImpl manager = new EntityManagerImpl();
        Department d = new Department();
        d.setDepartmentName("BlaBla");
        d.setLocation(1000l);
        d.setId(278L);

        Department res = (Department) (manager.insert(d));
        assertEquals(d, res);
    }

    @Test
    public void testUpdate(){
        EntityManagerImpl emi = new EntityManagerImpl();
        Department d = emi.findById(Department.class, new Long(180));
        d.setDepartmentName("testUpdate");
        emi.update(d);
        Assert.assertEquals("updated department_name='testUpdate'.",
                "testUpdate", emi.findById(Department.class, new Long(180)).getDepartmentName());
    }



        @Test
        public void testGetDepartmentById(){
            DepartmentDao dTest = new DepartmentDao();
            Department result = dTest.getDepartmentById(60L);
            Assert.assertEquals("Department should be IT.", "IT", result.getDepartmentName());
        }

        @Test
        public void testGetAllDepartments(){
            DepartmentDao dTest = new DepartmentDao();
            List<Department> result = dTest.getAllDepartments();
            Assert.assertEquals("Department should have 27 entries.", 27, result.size());
        }

        @Test
        public void testInsertDepartment(){
            DepartmentDao dTest = new DepartmentDao();
            Department d = new Department();
            Long newDep = 280L;
            d.setId(newDep);
            d.setDepartmentName("test");
            d.setLocation(1500l);
            dTest.insertDepartment(d);
            Assert.assertEquals("Recent inserted department should have 280 ID.",
                    newDep, dTest.getDepartmentById(280L).getId());
        }

        @Test
        public void testUpdateDepartment(){
            DepartmentDao dTest = new DepartmentDao();
            Department d = dTest.getDepartmentById(180l);
            d.setDepartmentName("testUpdate");
            dTest.updateDepartment(d);
            Assert.assertEquals("Recent updated department should have department_name='testUpdate'.",
                    "testUpdate", dTest.getDepartmentById(180l).getDepartmentName());
        }

        @Test
        public void testDeleteDepartment(){
            DepartmentDao dTest = new DepartmentDao();
            Department d = dTest.getDepartmentById(280l);
            dTest.deleteDepartment(d);
            Assert.assertNull(dTest.getDepartmentById(280l));
        }



}
