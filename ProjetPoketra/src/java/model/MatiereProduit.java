/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MatiereProduit {

    private int id;
    private int lookId;
    private int matiereId;
    private String taille;
    private double quantite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLookId() {
        return lookId;
    }

    public void setLookId(int lookId) {
        this.lookId = lookId;
    }

    public int getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(int matiereId) {
        this.matiereId = matiereId;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    
    public MatiereProduit(int lookId, int matiereId, String taille, double quantite) {
        this.lookId = lookId;
        this.matiereId = matiereId;
        this.taille = taille;
        this.quantite = quantite;
    }

    // Méthode pour insérer des données dans la table Matiere_produit
    public void insererMatiereProduit() {
        try (Connection connection = DatabaseConnexion.getConnexion()) {
            String query = "INSERT INTO Matiere_produit (look, matiere, taille, quantite) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, this.lookId);
                pstmt.setInt(2, this.matiereId);
                pstmt.setString(3, this.taille);
                pstmt.setDouble(4, this.quantite);
                pstmt.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

     // Méthode pour récupérer toutes les matières en fonction du look
public static List<Matiere> recupererMatieresParLook(int lookId) {
    List<Matiere> matieres = new ArrayList<>();
    try (Connection connection = DatabaseConnexion.getConnexion()) {
        String query = "SELECT m.* FROM Matiere_produit mp " +
               "INNER JOIN matiere m ON mp.matiere = m.id " +
               "WHERE mp.look = ?";


        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, lookId);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Matiere matiere = new Matiere();
                    matiere.setId(resultSet.getInt("id"));
                    matiere.setMatiere(resultSet.getString("matiere"));
                    // Ajoutez d'autres propriétés de Matiere si nécessaire
                    matieres.add(matiere);
                }
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    return matieres;
}

  
}
