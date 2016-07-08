package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 7/8/2016.
 */
public class DBManagerTest {

    @Test
    public void TestForgetConnection(){
        Connection conn = DBManager.getConnection();
        assertNotEquals(null,conn);
    }

    @Test
    public void TestForcheckConnection(){
        Connection conn = DBManager.getConnection();
        boolean r = DBManager.checkConnection(conn);
        assertEquals(true,r);
    }
}
