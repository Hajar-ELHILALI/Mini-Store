package com.ministore.mini_store.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBC {
    // Utiliser la DataSource comme champ statique
    private static final HikariDataSource dataSource;

    static {
        // Configuration de la source de données
        HikariConfig config = new HikariConfig();
        // Le nom de la classe du pilote est facultatif
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/ministore");
        config.setUsername("postgres");
        config.setPassword("123");
        config.setDriverClassName("org.postgresql.Driver");

        // Paramètres spécifiques au pool
        config.setMaximumPoolSize(10); // Taille max du pool
        config.setConnectionTimeout(30000); // 30 secondes

        // Initialiser la DataSource
        dataSource = new HikariDataSource(config);
    }

    // Fournit l'objet Connection (issu du pool)
    public static Connection getConnection() throws SQLException {
        // Obtenir une connexion du pool
        return dataSource.getConnection();
    }
}