package servlets;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.company.Context;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import util.SecurityUtil;
import util.ServletUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author sarkhanrasullu
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginJspServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletUtil.forward(request, response, "login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UserDaoInter userDAO = Context.instanceUserDao();
            User user = userDAO.getByEmail(email);
            if (user != null && user.getPassword().equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInUser", user);
                    response.sendRedirect("index");
            }else{
                response.sendRedirect("login?error");
            }
    }

}
