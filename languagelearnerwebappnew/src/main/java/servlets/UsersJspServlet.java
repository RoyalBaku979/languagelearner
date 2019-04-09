package servlets;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.company.Context;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author sarkhanrasullu
 */
@WebServlet(urlPatterns = {"/users"})
public class UsersJspServlet extends HttpServlet {//Controller


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name= request.getParameter("name");
        String surname = request.getParameter("surname");

        UserDaoInter userDao = Context.instanceUserDao();
        List<User> users = null;
        if(name!=null && !name.trim().isEmpty()) {
            users = userDao.getAll(name);
        }else{
            users = userDao.getAll();//MODEL - View - Controller
        }

        request.setAttribute("users", users);
        ServletUtil.forward(request, response, "users.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action= request.getParameter("action");
        if(action!=null && action.trim().equalsIgnoreCase("delete")){
           Integer userId = Integer.parseInt(request.getParameter("userId"));
            UserDaoInter userDao = Context.instanceUserDao();
            userDao.remove(new User(userId));
        }

        response.sendRedirect("users");
    }


}
