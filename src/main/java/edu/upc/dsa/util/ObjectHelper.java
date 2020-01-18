package edu.upc.dsa.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i = 0;

        for (Field f : fields) sFields[i++] = f.getName();

        return sFields;

    }


    public static void setter(Object object, String property, Object value) throws InvocationTargetException, IllegalAccessException {
        Object result = null;
        Class theClass = object.getClass();
        Method[] methods = theClass.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                if (method.getName().regionMatches(true, 3, property, 0, property.length()))
                    method.invoke(object, value);
            }

        }

    }

    public static Object getter(Object object, String property) throws InvocationTargetException, IllegalAccessException {
        Object result = null;
        Class theClass = object.getClass();
        Method[] methods = theClass.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                if ((method.getName().regionMatches(true, 3, property, 0, property.length())) || (method.getName().regionMatches(true, 2, property, 0, property.length())))
                    result = method.invoke(object);
            }
        }
    return result;
    }
}


