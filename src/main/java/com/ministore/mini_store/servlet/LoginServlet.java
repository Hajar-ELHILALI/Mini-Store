package com.ministore.mini_store.servlet;

import com.ministore.mini_store.dao.UserDAO;
import com.ministore.mini_store.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByEmail(email);

            if(user!=null && BCrypt.checkpw(password, user.getPassword())) {
                req.getSession().setAttribute("user", user);
                req.getSession().setMaxInactiveInterval(60);
                resp.sendRedirect(req.getContextPath()+"/products/");

            }else  {
                resp.sendRedirect(req.getContextPath()+"/login");
                System.out.println("error");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
