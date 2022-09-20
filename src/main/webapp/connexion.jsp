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
<style>
::placeholder{
font-size: small;
opacity: 0.5;
}
</style>
<body>

<jsp:include page="Header" />
        <section class="login-section bg-color-2">
            <div class="container-fluid">
                <div class="row mr-0">
                <div class="inner-container  d-lg-flex justify-content-lg-center">
                   
                    <div class="col-10 offset-1  col-lg-4 inner-box mx-5 mt-5">
                        <h2>Connexion</h2>
                                   <% if((boolean)request.getAttribute("messageconnexionno")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Adresse e-mail ou mot de passe invalide
								</div>
								<% } %>
								
                        <form  method="post" class="login-form">
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" name="cemail" required="">
                            </div>
                            <div class="form-group">
                                <label>Mot de passe</label>
                                <input type="password" name="cpassword" required>
                            </div>
                          
                            <div class="form-group message-btn">
                                <button type="submit" name="bconnexion" class="theme-btn-one">Se connecter</button>
                            </div>
                        </form>
                     
                    </div>
                    <div class="col-10 offset-1  col-lg-4 inner-box mx-5 mt-5">
                        <h2>Inscription</h2>
                        <% if((boolean)request.getAttribute("messageinscriptionok")==true){ %>
                                <div class="alert alert-success mt-5" role="alert">
								 Votre inscription a bien été prise en compte, veuillez vous connecter
								</div>
								<% } %>
						<% if((boolean)request.getAttribute("telinvalide")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								numéro de téléphone invalide
								</div>
								<% } %>
						<% if((boolean)request.getAttribute("userexiste")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								compte déja existant, veuillez vous connecter
								</div>
								<% } %>
                      <% if((boolean)request.getAttribute("inputvide")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  veuillez remplir tous les champs
								</div>
								<% } %>
					  <% if((boolean)request.getAttribute("mdppasidentique")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  le mot de passe et la confirmation du mot de passe doivent être identique
								</div>
								<% } %>
						 <% if((boolean)request.getAttribute("emailinvalide")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Veuillez entrer un email valide
								</div>
								<% } %>
					 <% if((boolean)request.getAttribute("mdplength")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  le mot de passe n'est pas assez long
								</div>
								<% } %>
					 <% if((boolean)request.getAttribute("mdpweak")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  le mot de passe n'est pas assez sécurisé
								</div>
								<% } %>
                        <form method="post" class="signup-form">
                            <div class="form-group">
                                <label>Nom</label>
                                <input placeholder="nom" type="text" name="nom" required="">
                            </div>
                               <div class="form-group">
                                <label>Prénom</label>
                                <input placeholder="prenom" type="text" name="prenom" required="">
                            </div>
                               <div class="form-group">
                                <label>Numéro de téléphone</label>
                                <input placeholder="entrez votre numéro de téléphone sans espace" type="text" name="tel" required="">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input placeholder="email" type="email" name="email" required="">
                            </div>
                            <div class="form-group">
                                <label>Mot de passe</label>
                                <p class="font-weight-light" style="font-size: small;">Doit contenir au moins 8 caractères (1 majuscule, 1 chiffre, 1 caractère spécial)</p>
                                <input placeholder= " mot de passe " type="password" name="password" required="">
                            </div>
                            <div class="form-group">
                                <label>Confirmer mot de passe</label>
                                <input placeholder="confirmer le mot de passe" type="password" name="tpassword" required="">
                            </div>
                            <div class="form-group message-btn">
                                <button type="submit" name="binscription" class="theme-btn-one">S'inscrire</button>
                            </div>
                        </form>
                        
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