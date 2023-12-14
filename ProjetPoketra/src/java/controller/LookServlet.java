/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Admin
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Look;

@WebServlet("/LookServlet")
public class LookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        String lookName = request.getParameter("look");

        // Vérifier si le nom de la Look n'est pas vide
        if (lookName != null && !lookName.isEmpty()) {
            // Créer un objet Look avec les données du formulaire
            Look look = new Look(lookName);

            // Appeler la méthode pour insérer la Look dans la base de données
            look.insererLook();

            // Rediriger vers une page de confirmation ou une autre page après l'insertion
            response.sendRedirect("look.jsp");
        } else {
            // Gérer le cas où le nom de la Look est vide
            request.setAttribute("message", "Le nom de la Look ne peut pas être vide.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

