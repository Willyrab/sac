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
import model.Type; // Importez la classe Type que vous avez créée

@WebServlet("/TypeServlet")
public class TypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        String typeName = request.getParameter("type");

        // Vérifier si le nom de la type n'est pas vide
        if (typeName != null && !typeName.isEmpty()) {
            // Créer un objet Type avec les données du formulaire
            Type type = new Type(typeName);

            try {
                // Appeler la méthode pour insérer la type dans la base de données
                type.insererType();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TypeServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TypeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Rediriger vers une page de confirmation ou une autre page après l'insertion
            response.sendRedirect("type.jsp");
        } else {
            // Gérer le cas où le nom de la type est vide
            request.setAttribute("message", "Le nom de la type ne peut pas être vide.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
