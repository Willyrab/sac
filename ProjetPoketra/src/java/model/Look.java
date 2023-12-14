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
public class Look {
     
    private int id;
    private String look;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public Look(int id, String look) {
        this.id = id;
        this.look = look;
    }
    
    public Look(String look) {
        this.look = look;
    }
    
    // Méthode pour insérer un nouveau look dans la base de données
    public void insererLook() {
        try (Connection connection = DatabaseConnexion.getConnexion()) {
            String query = "INSERT INTO look (look) VALUES (?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, this.look);
                pstmt.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Méthode pour récupérer tous les looks de la base de données
    public static List<Look> recupererLooks() throws ClassNotFoundException, SQLException {
        List<Look> looks = new ArrayList<>();
        try (Connection connection = DatabaseConnexion.getConnexion()) {
            String query = "SELECT * FROM look";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        Look look = new Look(resultSet.getString("look"));
                        look.setId(resultSet.getInt("id"));
                        looks.add(look);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return looks;
    }
}
