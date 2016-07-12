package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by user on 7/8/2016.
 */
public class EntityManagerImplTest {

    @Test
    public void testFindAll(){
            EntityManagerImpl emi = new EntityManagerImpl();
            List<Department> result = emi.findAll(Department.class);
            Assert.assertEquals("Department should have 27 entries.", 27, result.size());

    }

}
