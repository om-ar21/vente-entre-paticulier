<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<title>Insert title here</title>
<link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,300;0,400;0,600;0,700;0,800;0,900;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<!-- Stylesheets -->
<link href="assets/css/font-awesome-all.css" rel="stylesheet">
<link href="assets/css/flaticon.css" rel="stylesheet">
<link href="assets/css/owl.css" rel="stylesheet">
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/jquery.fancybox.min.css" rel="stylesheet">
<link href="assets/css/animate.css" rel="stylesheet">
<link href="assets/css/nice-select.css" rel="stylesheet">
<link href="assets/css/color.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/responsive.css" rel="stylesheet">
</head>
<body>

<jsp:include page="Header" />
       <section class="login-section bg-color-2">
            <div class="container-fluid">
                <div class="row mr-0">
                <div class="inner-container  d-lg-flex justify-content-lg-center">
              
                    <div class="col-10 offset-1  col-lg-4 inner-box mx-5 mt-5">
                        <h2>Mon profil</h2>
                       <% if((boolean)request.getAttribute("profilajour")==true){ %>
                                <div class="alert alert-success mt-5" role="alert">
								 Votre profil a bien été mis à jour
								</div>
								<% } %>
						<% if((boolean)request.getAttribute("telinvalide")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								numéro de téléphone invalide
								</div>
								<% } %>
						<% if((boolean)request.getAttribute("userexiste")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								Cet adresse email est déja utilisé par un autre utilisateur
								</div>
								<% } %>
                      <% if((boolean)request.getAttribute("inputvide")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  veuillez remplir tous les champs
								</div>
								<% } %>
					
						 <% if((boolean)request.getAttribute("emailinvalide")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Veuillez entrer un email valide
								</div>
								<% } %>
					 
					  
                        <form method="post" class="signup-form">
                            <div class="form-group">
                                <label>Nom</label>
                                <input placeholder="nom" type="text" value="${u.getNom() }"   name="nom" required="">
                            </div>
                               <div class="form-group">
                                <label>Prénom</label>
                                <input placeholder="prenom" type="text" value="${u.getPrenom() }" name="prenom" required="">
                            </div>
                               <div class="form-group">
                                <label>Numéro de téléphone</label>
                                <input value="${u.getTel() }" placeholder="entrez votre numéro de téléphone sans espace" type="text" name="tel" required="">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input  type="email" value="${u.getEmail() }" name="email" required="">
                            </div>
                            
                             <div align="center" class="form-group message-btn my-5 mx-auto">
                                <a href="Modifiermdp"  class="theme-btn-one">Modifier mon mot de passe</a>
                            </div>
                            
                            <div class="form-group message-btn">
                                <button type="submit" name="bmodifier" class="theme-btn-one">Confirmer</button>
                            </div>
                        </form>
                        
                    </div>


					

                </div>
                </div>
                <div class="row ">
                 <div class="col-10 offset-2   mx-5 mt-5">
                        <h2 class=" text-center mb-5">Supprimer mon profil</h2>
                     
					 
					  
                        
                            
                            <div class="form-group message-btn d-flex justify-content-center">
                                <a href="Confirmer" class="theme-btn-one">Supprimer mon profil</a>
                            </div>
                       
                        
                    </div>
                    </div>
            </div>
        </section>
 <jsp:include page="Footer" />
  <!-- jequery plugins -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.js"></script>
    <script src="assets/js/wow.js"></script>
    <script src="assets/js/validation.js"></script>
    <script src="assets/js/jquery.fancybox.js"></script>
    <script src="assets/js/appear.js"></script>
    <script src="assets/js/scrollbar.js"></script>
    <script src="assets/js/jquery.nice-select.min.js"></script>
    <script src="assets/js/product-filter.js"></script>

    <!-- main-js -->
    <script src="assets/js/script.js"></script>
</body>
</html>