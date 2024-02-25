package models.utils;

import jakarta.servlet.http.HttpSession;

public class SessionUtils {

    public static boolean isAttributeValid(HttpSession session, String attribute) {
        if (session == null){
            return true;
        }
        String attr = (String) session.getAttribute(attribute);
        if (attr == null){
            return false;
        }
        return !attr.equals("N/A");
    }
}
