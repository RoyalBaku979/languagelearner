package util;

import com.company.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityUtil {

    public static User getLoggedInUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("loggedInUser")!=null) {
            User user = (User) session.getAttribute("loggedInUser");
            return user;
        }
        return null;
    }

}
