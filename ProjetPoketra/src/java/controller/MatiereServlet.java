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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Matiere;

@WebServlet("/MatiereServlet")
public class MatiereServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        String matiereName = request.getParameter("matiere");

        // Vérifier si le nom de la matiere n'est pas vide
        if (matiereName != null && !matiereName.isEmpty()) {
            // Créer un objet Matiere avec les données du formulaire
            Matiere matiere = new Matiere(matiereName);

            try {
                // Appeler la méthode pour insérer la Matiere dans la base de données
                matiere.insererMatiere();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MatiereServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MatiereServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Rediriger vers une page de confirmation ou une autre page après l'insertion
            response.sendRedirect("matiere.jsp");
        } else {
            // Gérer le cas où le nom de la matiere est vide
            request.setAttribute("message", "Le nom de la matiere ne peut pas être vide.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

