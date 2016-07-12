package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 * Created by user on 7/8/2016.
 */
public class EntityManagerImpl implements EntityManager{


    @Override
    public <T> T findById(Class<T> entityClass, Long id) {
        return null;
    }

    @Override
    public int getNextIdVal(String tableName, String columnIdName) {
        return 0;
    }

    @Override
    public <T> Object insert(T entity) {
        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        //connect to DB
        Connection conn = DBManager.getConnection();

        //get table name, columns using the methods from EntityUtils class
        String tablename = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> list = new ArrayList<ColumnInfo>();
        list = EntityUtils.getColumns(entityClass);

        //create a QueryBuilder object  in which you have to set the name of the table, columns, query type
        QueryBuilder builder = new QueryBuilder();
        builder.setTableName((Object) tablename);
        builder.setQueryType(QueryType.SELECT);
        builder.addQueryColumns(list);

        //call createQuery() method from QueryBuilder.java
        String res = builder.createQuery();

        //create a resultSet object using Statement and execute the query obtained above
        ResultSet result = null;
        try (Statement smtm = conn.createStatement()){
              result = smtm.executeQuery(res);

            //create an ArrayList of type T
            ArrayList<T> array = new ArrayList<T>();
              /*-	while the resultSet has any values (resultSet.next()) then:
           you have to create an instance of type T;
           iterate through ColumnInfo list and obtain the field of the instance using getColumnName().
           Ex: instance.getClass().getDeclaredField(column.getColumnName());
           make the field accessible;
           set the value of the field with the value obtained from resultSet object;
           add the instance in ArrayList;
      */

            while (result.next()){
                T ceva = null;
                ceva = entityClass.newInstance();
                for(ColumnInfo elem : list){
                    Field field = ceva.getClass().getDeclaredField(elem.getColumnName());
                    field.setAccessible(true);
                    field.set(ceva,EntityUtils.castFromSqlType(result.getObject(elem.getDbName()),field.getType()));
                    array.add(ceva);
                }
            }

            return array;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
