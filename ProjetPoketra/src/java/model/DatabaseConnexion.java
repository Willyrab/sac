/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DatabaseConnexion {
       public static Connection getConnexion() throws ClassNotFoundException, SQLException {
        Connection c = null;

        // Charger le pilote JDBC
        Class.forName("org.postgresql.Driver");

        // Établir la connexion à la base de données
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/poketra", "postgres", "123456willy");

        return c;
    }
}
