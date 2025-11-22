package com.ministore.mini_store.servlet;

import com.ministore.mini_store.dao.UserDAO;
import com.ministore.mini_store.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/auth/register.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        UserDAO userDAO = new UserDAO();

        try {
            String password_hash = BCrypt.hashpw(password, BCrypt.gensalt());
            User user = new User(username, email, password_hash);

            userDAO.CreateUser(user);

            resp.sendRedirect(req.getContextPath() + "/login");

        } catch (SQLException e) {
            if (e.getMessage() != null && e.getMessage().contains("existe déjà")) {
                req.setAttribute("errorMessage", "Cet email est déjà utilisé. Veuillez vous connecter ou utiliser un autre email.");
                req.getRequestDispatcher("/WEB-INF/views/auth/register.jsp").forward(req, resp);
            } else {
                throw new ServletException("Erreur de base de données lors de l'inscription.", e);
            }
        }
    }
}