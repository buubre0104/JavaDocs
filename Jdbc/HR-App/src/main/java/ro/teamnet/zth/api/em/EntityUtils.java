package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 7/7/2016.
 */
public class EntityUtils {

    public static final String EMPTY_STRING = "";

    private EntityUtils() {
        throw new UnsupportedOperationException();
    }

    /*
    * Returneaza numele tabelei asociate clasei entity
    */
    public static String getTableName(Class entity) {
        Table tableAnnotation = (Table) entity.getAnnotation(Table.class);
        return EMPTY_STRING.equals(tableAnnotation.name()) ? entity.getClass().getSimpleName() : tableAnnotation.name();
    }

    /*
    * Returneaza o lista (List<ColumnInfo>) cu
    * informatii despre campurile clasei entity
    */
    public static List<ColumnInfo> getColumns(Class entity) {
        List<ColumnInfo> columns = new ArrayList<>();
        Field[] fields = entity.getDeclaredFields();
        for(Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            ColumnInfo columnInfo = new ColumnInfo();
            columnInfo.setColumnName(field.getName());
            columnInfo.setColumnType(field.getType());
            if(column != null) {
                columnInfo.setDbName(column.name());
            } else {
                Id id = field.getAnnotation(Id.class);
                columnInfo.setDbName(id.name());
                columnInfo.setId(true);
            }
            columns.add(columnInfo);
        }
        return columns;
    }

    /*
    * Metoda primeste un obiect din baza de date (value),
    * si il transforma intr-un obiect de tip wantedType
    */
    public static Object castFromSqlType(Object value, Class wantedType) {
        if(value != null) {
            if(value instanceof BigDecimal) {
                BigDecimal bdValue = (BigDecimal) value;
                return wantedType.equals(Integer.class) ? bdValue.intValue() :
                        wantedType.equals(Long.class) ? bdValue.longValue() :
                                wantedType.equals(Float.class) ? bdValue.floatValue() :
                                        wantedType.equals(Double.class) ? bdValue.doubleValue() : value;
            } else {
                return value;
            }
        }
        return null;
    }

    /*
    * Returneaza o lista (List<Field>) ce contine campurile
    * clasei clazz annotate cu annotarea annotation
    */
    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        List<Field> fields = new ArrayList<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field declaredField : declaredFields) {
            if(declaredField.getAnnotation(annotation) != null) {
                fields.add(declaredField);
            }
        }
        return fields;
    }
}
