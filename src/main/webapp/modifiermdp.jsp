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
                    <div class="form-group message-btn ">
                                <a href="Moncompte" class="theme-btn-one">Retour</a>
                        </div>
                        <h2 class="mb-5">Modifier mon mot de passe</h2>
                        
                         <% if((boolean)request.getAttribute("mdpok")==true){ %>
                                <div class="alert alert-success mt-5" role="alert">
								 Votre mot de passe a bien été modifié 
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
						 <% if((boolean)request.getAttribute("falsemdp")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Votre mot de passe n'est pas correct
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
                                <label>Ancien Mot de passe</label>
                                
                                <input  type="password" name="oldpassword" required="">
                            </div>
                            <div class="form-group mt-5">
                                <label>Votre nouveau mot de passe</label>
                                <p class="font-weight-light" style="font-size: small;">Doit contenir au moins 8 caractères (1 majuscule, 1 chiffre, 1 caractère spécial)</p>
                                <input type="password" name="newpassword" required="">
                            </div>
                            <div class="form-group mb-5">
                                <label>Confirmer mot de passe</label>
                                <input  type="password" name="tpassword" required="">
                            </div>
                            <div class="form-group message-btn">
                                <button type="submit" name="bupdatemdp" class="theme-btn-one">Confirmer</button>
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