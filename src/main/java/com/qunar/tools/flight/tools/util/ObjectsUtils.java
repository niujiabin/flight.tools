package com.qunar.tools.flight.tools.util;

/**
 * @author jiabin.niu
 * @date 2019.01
 */
public class ObjectsUtils {

    public static void main(String[] args) {
        ObjectsUtils objectsUtils = new ObjectsUtils();
        boolean is = objectsUtils.allNoNull(new Integer(1), new Integer(2));
        System.out.println(is);
    }

    public boolean allNoNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                return false;
            }
        }
        return true;
    }
}
