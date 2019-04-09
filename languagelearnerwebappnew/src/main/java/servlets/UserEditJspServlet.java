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
@WebServlet(urlPatterns = {"/useredit"})
public class UserEditJspServlet extends HttpServlet {//Controller


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDaoInter userDao = Context.instanceUserDao();

        Integer userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.getById(userId);
        request.setAttribute("user", user);
        ServletUtil.forward(request, response, "useredit.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDaoInter userDao = Context.instanceUserDao();
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.getById(userId);

        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);

        userDao.update(user);

        response.sendRedirect("users");
    }

}
