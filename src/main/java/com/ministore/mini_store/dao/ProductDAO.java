package com.ministore.mini_store.dao;

import com.ministore.mini_store.model.Product;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from product";
        try {
            Connection conn = JDBC.getConnection();
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description")
                );
                product.setCreated_at(rs.getTimestamp("created_at"));

                products.add(product);
            }


            return products;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Product createProduct(Product product) {
        Product NewProduct = new Product();

        try{
            Connection conn = JDBC.getConnection();
            PreparedStatement statement = conn.prepareStatement("insert into product(name, price, description) values(?,?,?)");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.execute();
            return NewProduct;
    }catch(Exception e){
        e.printStackTrace();
        }
        return null;
    }

    public void deleteProduct(int id) throws SQLException {
        try{
            Connection conn=JDBC.getConnection();
            PreparedStatement state=conn.prepareStatement("delete from product where id=?");
            state.setInt(1, id);
            state.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) throws SQLException {
        try{
            Connection conn=JDBC.getConnection();
            PreparedStatement statement= conn.prepareStatement("update product set name=?,price=?,description=? where id=?");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setInt(4, product.getId());
            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
