<%-- 
    Document   : ListMatiereLook
    Created on : 14 déc. 2023, 08:58:24
    Author     : Admin
--%>

<%@page import="model.Matiere"%>
<%@page import="model.Look"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <title>Page | ListMatiereLook</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="temp_sac/css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

       
  </head>
  <body>
		
		<div class="wrapper d-flex align-items-stretch">
			<nav id="sidebar">
				<div class="p-4 pt-5">
		  		<a href="#" class="img logo rounded-circle mb-5" style="background-image: url(temp_sac/images/IMG_3499.jpeg);"></a>
	        <ul class="list-unstyled components mb-5">
	          <li>
	            <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><span class="fa fa-home mr-3"></span>Home</a>
	            <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="#">Home 1</a>
                    </li>
                    <li>
                        <a href="#">Home 2</a>
                    </li>
                    <li>
                        <a href="#">Home 3</a>
                    </li>
                    </ul>
	          </li>
            <li>
              <a href="#">
                
                  <span class="fa fa-user" style="margin-right: 15px;"></span>
                  About
              </a>
          </li>
          
	          <li>
              <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><span class="fa fa-cogs"  style="margin-right: 15px;"></span>Services</a>
              <ul class="collapse list-unstyled" id="pageSubmenu">
                <li>
                    <a href="type.jsp">Type</a>
                </li>
                <li>
                    <a href="look.jsp">Look</a>
                </li>
                <li class="active">
                    <a href="matiere.jsp">Matiere</a>
                </li>
                <li >
                  <a href="ProduitMatiere.jsp">Produit par Matiere</a>
              </li>
              </ul>
	          </li>
	          <li>
              <a href="#"><span class="fa fa-paper-plane" style="margin-right: 15px;"></span> Contact</a>
	          </li>
            <li>
              <a href="#"><span class="fa fa-sign-out mr-3" style="margin-right: 15px;"></span> Sign Out</a>
            </li>
	        </ul>

	        <div class="footer">
	        	<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">andrianirina@gmail.com</a>
						  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
	        </div>

	      </div>
    	</nav>

        <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container-fluid">

            <button type="button" id="sidebarCollapse" class="btn btn-primary">
              <i class="fa fa-bars"></i>
              <span class="sr-only">Toggle Menu</span>
            </button>
            <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fa fa-bars"></i>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="nav navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>

   <div class="container mt-5">
    <form action="rechercheMatiereServlet" method="post">
        <div class="form-row align-items-center">
            <div class="col-auto">
                <label class="sr-only" for="lookId">Look</label>
                <select class="form-control mb-2" name="lookId" id="lookId">
                    <!-- Remplacez cette partie par votre propre code pour récupérer les looks depuis la base -->
                    <% List<Look> looks = Look.recupererLooks(); %>
                    <% for (Look look : looks) { %>
                        <option value="<%= look.getId()%>"><%= look.getLook() %></option>
                    <% } %>
                </select>
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-2">Rechercher</button>
            </div>
        </div>
    </form>

   
    <!-- Tableau pour afficher les résultats -->
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Matière</th>
                <!-- Ajoutez d'autres colonnes au besoin -->
            </tr>
        </thead>
        <tbody>
            <!-- Le contenu du tableau sera généré dynamiquement dans le servlet -->
        
            <% List<Matiere> matieres = (List<Matiere>) request.getAttribute("matieres"); %>
            <% if (matieres != null) { %>
                <% for (Matiere matiere : matieres) { %>
                    <tr>
                        <td><%= matiere.getMatiere() %></td>
                    </tr>
                <% } %>
            <% } else { %>
                <tr>
                    <td colspan="3">Aucune matière trouvée.</td>
                </tr>
            <% } %>


        </tbody>
    </table>

</div>

        
        

        



      </div>
	</div>


  <script src="temp_sac/js/jquery.min.js"></script>
  <script src="temp_sac/js/popper.js"></script>
  <script src="temp_sac/js/bootstrap.min.js"></script>
  <script src="temp_sac/js/main.js"></script>
    
  </body>
</html>
