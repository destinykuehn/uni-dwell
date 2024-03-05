package models.utils;

import jakarta.servlet.http.HttpSession;

public class SessionUtils {

    public static boolean attrEqualVal(HttpSession session, String attribute, String value) {
        if (session == null){
            return false;
        }
        if (session.getAttribute(attribute) == null) {
            return false;
        }

        if (session.getAttribute(attribute).equals(value)) {
            return true;
        }
        return false;
    }
}
