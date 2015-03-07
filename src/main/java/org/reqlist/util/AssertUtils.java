package org.reqlist.util;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class AssertUtils {

    public static boolean isNull(Object object) {
        return object == null;
    }
    
    public static boolean isNotNull(Object object) {
        return object != null;
    }
    
}
