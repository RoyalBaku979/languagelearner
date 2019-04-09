package util;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtil {


    public static void forward(HttpServletRequest request,
                               HttpServletResponse response,
                               String jsp){
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
            dispatcher.forward(request, response);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
