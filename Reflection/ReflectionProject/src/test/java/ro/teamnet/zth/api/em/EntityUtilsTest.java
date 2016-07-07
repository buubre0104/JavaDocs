package ro.teamnet.zth.api.em;

/**
 * Created by user on 7/7/2016.
 */

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import static org.junit.Assert.assertEquals;

public class EntityUtilsTest {


    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }
}