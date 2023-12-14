/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Admin
 */
import model.MatiereProduit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insererMatiereProduitServlet")
public class InsererMatiereProduitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        int lookId = Integer.parseInt(request.getParameter("lookId"));
        int matiereId = Integer.parseInt(request.getParameter("matiereId"));
        String taille = request.getParameter("taille");
        double quantite = Double.parseDouble(request.getParameter("quantite"));

        // Créer un objet MatiereProduit avec les données du formulaire
        MatiereProduit matiereProduit = new MatiereProduit(lookId, matiereId, taille, quantite);

        // Appeler la méthode insererMatiereProduit pour insérer les données dans la base
        matiereProduit.insererMatiereProduit();

        // Vous pouvez ajouter des redirections ou des messages de succès ici
        response.sendRedirect("ProduitMatiere.jsp");
    }
}

