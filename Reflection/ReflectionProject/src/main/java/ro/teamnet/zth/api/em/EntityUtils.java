package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by user on 7/7/2016.
 */
public class EntityUtils {

    public EntityUtils() throws UnsupportedOperationException{
    }

    public static String getTableName(Class entity){
        if ( entity.getClass().getAnnotation(Table.class).name() !=null )
                         return entity.getClass().getAnnotation(Table.class).name();
         else return entity.getName();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity){
        ArrayList<ColumnInfo> c = new ArrayList<ColumnInfo>();
        LinkedList<Field> a = new LinkedList<Field>();
        for(Field elem: entity.getClass().getFields()){
            Annotation a1 =elem.getAnnotation(Column.class);
            Annotation a2 =elem.getAnnotation(Id.class);
            if(a1!=null) c.add((ColumnInfo) a1);
            if(a2!=null) c.add((ColumnInfo) a2);
        }
        return c;
    }


    public static Object castFromSqlType(Object value, Class wantedType){
        String a=value.getClass().getName();
        String b=wantedType.getClass().getName();
        if(a.equals("BigDecimal") && b.equals("Integer")) return ((BigDecimal) value).intValue();
        if(a.equals("BigDecimal") && b.equals("Long")) return ((BigDecimal) value).longValue();
        if(a.equals("BigDecimal") && b.equals("Float")) return ((BigDecimal) value).floatValue();
        if(a.equals("BigDecimal") && b.equals("Double")) return ((BigDecimal) value).doubleValue();
        if(!a.equals("BigDecimal")) return value;
        return value;
    }

     public static ArrayList<Field> getFieldsByAnnotations(Class clazz, Class annotation){
         ArrayList<Field> a = new ArrayList<Field>();
         for(Field elem : clazz.getClass().getDeclaredFields()){
             Annotation b = elem.getAnnotation(annotation);
             if(b!=null) a.add(elem);
         }
         return a;
     }
/*
-	create a public static method getSqlValue(Object object), which will return an Object. Steps:
•	if object class is annotated with @Table, get the field annotated with @Id, set it accessible,
    and return the object associated with the id field;
•	if object class is not annotated with @Table, return the object

 */

     public static Object getSqlValue(Object object){
         Annotation a = object.getClass().getAnnotation(Table.class);
         if(a!=null){
             Annotation b = object.getClass().getAnnotation(Id.class);
             if(b!=null){
                 
             }
         }
         else return object;
     }

}
