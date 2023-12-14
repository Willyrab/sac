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
public class Matiere {
    
    private int id;
    private String matiere;

    public Matiere(String matiere) {
        this.matiere = matiere;
    }
    
      public Matiere() {
        
    }
    public Matiere(int id, String matiere) {
        this.id = id;
        this.matiere = matiere;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
        // Méthode pour insérer une nouvelle matière dans la base de données
    public void insererMatiere() throws ClassNotFoundException, SQLException {
        try (Connection connection = DatabaseConnexion.getConnexion()) {
            String query = "INSERT INTO matiere (matiere) VALUES (?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, this.matiere);
                pstmt.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


// Méthode pour récupérer toutes les matières de la base de données
public static List<Matiere> recupererMatieres() throws ClassNotFoundException, SQLException {
    List<Matiere> matieres = new ArrayList<>();
    try (Connection connection = DatabaseConnexion.getConnexion()) {
        String query = "SELECT * FROM matiere";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Matiere matiere = new Matiere(resultSet.getString("matiere"));
                    matiere.setId(resultSet.getInt("id"));
                    matieres.add(matiere);
                }
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        throw e; // Renvoie l'exception plutôt que de l'imprimer
    }
    return matieres;
}

}
