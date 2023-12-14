/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Matiere;
import model.MatiereProduit;

/**
 *
 * @author Admin
 */
@WebServlet("/rechercheMatiereServlet")
public class RechercheMatiereServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer le look sélectionné depuis le formulaire
            int lookId = Integer.parseInt(request.getParameter("lookId"));

            // Récupérer la liste des matières en fonction du look
            List<Matiere> matieres = MatiereProduit.recupererMatieresParLook(lookId);

            System.out.println("Nombre de matières récupérées : " + matieres.size());

            if (matieres != null) {
                request.setAttribute("matieres", matieres);
            } else {
                System.out.println("La liste de matières est null.");
                request.setAttribute("matieres", new ArrayList<Matiere>());
            }

            // Rediriger vers la JSP pour afficher les résultats
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListMatiereLook.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Une erreur s'est produite lors de la récupération des matières.", e);
        }
    }
}
