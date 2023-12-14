/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Type {
    
    private int id;
    private String type;

    public Type(String type) {
        this.type = type;
    }

    public Type(int id, String type) {
        this.id = id;
        this.type = type;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
       // Méthode pour insérer un nouveau type dans la base de données
    public void insererType() throws ClassNotFoundException, SQLException {
        try (Connection connection = DatabaseConnexion.getConnexion()) {
            String query = "INSERT INTO type (type) VALUES (?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, this.type);
                pstmt.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer tous les types de la base de données
    public static List<Type> recupererTypes() {
        List<Type> types = new ArrayList<>();
        try (Connection connection = DatabaseConnexion.getConnexion()) {
            String query = "SELECT * FROM type";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        Type type = new Type(resultSet.getString("type"));
                        type.setId(resultSet.getInt("id"));
                        types.add(type);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return types;
    }
    
}
