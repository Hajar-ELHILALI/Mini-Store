package com.ministore.mini_store.servlet;

import com.ministore.mini_store.dao.ProductDAO;
import com.ministore.mini_store.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/products/*")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if(path.equals("/") || path==null){
            listProducts(req, resp);
        }
        else if (path.equals("/new")) {
            showForm(req, resp, null);
        }
        else {
            // Optionnel : Gérer les actions inconnues en redirigeant vers la liste
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action non supportée.");
        }
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.getProducts();
        if (products != null) {
            System.out.println("Nombre de produits récupérés : " + products.size());
        } else {
            System.out.println("Products est null !");
        }
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        productDAO.createProduct(new Product(name, price, description));
        resp.sendRedirect(req.getContextPath()+"/products/");
    }

    private void showForm(HttpServletRequest req, HttpServletResponse resp, Product product) throws ServletException, IOException {
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/views/product/form.jsp").forward(req, resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        try {
                if (path.equals("/")) {
                    createProduct(req,  resp);
                }else if (path.equals("/delete")) {
                    int id = Integer.parseInt(req.getParameter("id"));
                    productDAO.deleteProduct(id);
                    resp.sendRedirect(req.getContextPath() + "/products/");
                }


        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void updtProduct(HttpServletRequest req) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        productDAO.updateProduct(new Product(id, name, price, description,  null));
    }
}
