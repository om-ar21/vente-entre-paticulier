<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@page import="model.ImageDAO"%>
     <%@page import="model.Image"%>
    <%@page import="model.SousCatDAO"%>
<%@page import="model.CategorieDAO"%>
    <%@page import="model.Categorie"%> 
<%@page import="model.SousCat"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Categorie> cat = new ArrayList<Categorie>();%> 
<%ArrayList<SousCat> soucat = new ArrayList<SousCat>();%> 
<%ArrayList<Image> image = new ArrayList<Image>();%> 
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
<style>
.image-upload>input {
  display: none;
}
.imga{
max-height:224px;
}
</style>
</head>
<body>

<jsp:include page="Header" />
   <section class="browse-add-details bg-color-2">
            <div class="auto-container">
                <div class="row clearfix">
                    <div class="col-lg-8 offset-lg-2 col-md-12 col-sm-12 content-side">
                        <div class="add-details-content">
                        <div class="content-five single-box">
                                <div class="text">
                                    <h4>Modifier mon annonce: ${an.getTitre() }</h4>
                                  <%--    <% if((boolean)request.getAttribute("erreur")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Veuillez repmlir tous les champs
								</div>
								<% } %> --%>
							<%-- 	<% if((boolean)request.getAttribute("add")==true){ %>
                                <div class="alert alert-success mt-5" role="alert">
								  Nous avons reçu votre annonce, elle sera traitée dans les meilleurs délais
								</div>
								<% } %> --%>
                                   
                                </div>
                                <form  method="post" class="review-form" enctype="multipart/form-data">
                                    <div class="row clearfix">
                                     <div class="col-lg-12 col-md-12 col-sm-12 mb-2 column">
                                            <div class="form-group">
                                                <label>Titre*</label>
                                                <input type="text" name="titre" value="${an.getTitre() }" required="">
                                            </div>
                                        </div>
     
                                        <div class="col-lg-6 col-md-6 col-sm-12 mb-2 column">
                                            <div class="form-group  ">
                                                <label>Catégorie*</label>
 
                                                 <select class="nice-select" name="soucat">
   													  <option value="${an.getId_souscat() }">${an.getCat().getTitre()}</option>
    												<%
     												cat=(ArrayList)request.getAttribute("cat");
 													 for(Categorie cats:cat){
  														 %>
     											<optgroup  label="<%= cats.getTitre()%>">
    													  <%
                                        
       											  SousCatDAO  sou= new SousCatDAO();
                                        		int idcat = cats.getId();
                                				ArrayList<SousCat> souca= sou.getAllById(idcat); 
                                		
                                        
                                       		 for( SousCat sous:souca){
                                       			 %>       
     									   <option value="<%= sous.getId() %>"><%= sous.getTitre() %></option>
       											 <%} %>
   	  											 </optgroup>
   										   <%} %> 
   											 </select>
                                            </div>
                                        </div>
                                      <!--   col-lg-12 col-md-12 col-sm-12 feature-block test -->
                                   <div class="col-lg-12 col-md-12 col-sm-12 feature-block test">
                                    <div class="feature-block-one  wow fadeInLeft animated animated" data-wow-delay="00ms" data-wow-duration="1500ms">
                                       
                                        <div class="inner-box">
                                        <div class="row ">
                                            <div class=" col-lg-10 col-12">
                                                <figure class="image"><img  src="assets/img/${an.getImage()}" class="imga"  alt=""></figure>
                                               
                                            </div>
                                            <div class="lower-content col-lg-2 col-12">
                                             <div class=" column">
                                            <div class="image-upload">
  												<label for="file-input">
    												<i class="fas fa-pen" ></i>
  												</label>

  											<input id="file-input" name="image" type="file" />
												</div> 
                                        </div>
                                           </div>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                                <% image=(ArrayList)request.getAttribute("im");
 													 for(Image im:image){%>
                                 <div class="col-lg-12 col-md-12 col-sm-12 feature-block test">
                                    <div class="feature-block-one  wow fadeInLeft animated animated" data-wow-delay="00ms" data-wow-duration="1500ms">
                                       
                                        <div class="inner-box">
                                        <div class="row ">
                                            <div class=" col-lg-6 col-12">
                                                <figure class="image"><img  src="assets/img/<%=im.getLien() %>" class="imga"  alt=""></figure>
                                               
                                            </div>
                                            <div class="lower-content col-lg-6 col-12">
                                             <div class=" column">
                                            <div class="form-group">
                                                <label>Image (optionnelle)</label>
                                                <input type="file" name="image1"  accept="image/png, image/jpeg">
                                            </div>
                                             
                                           <div class="text text-primary mt-2 ">
                                           <a href="Modifierannonce?idann=<%=im.getId_annonce() %>&idupdate=<%=im.getId()%>">
                                              <h6 class=" w-50 p-3 border  border-success rounded">charger l'image</h6>
                                           </a>
                                           </div>
                             
												<div class="image-upload mt-5"  >
  												
    												<a href="Modifierannonce?idann=<%=im.getId_annonce() %>&idsup=<%=im.getId()%>"><i class="fas fa-trash"></i></a>
  						
												</div>
                                        </div>
                        
                                            </div>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                                <%} %>
                                      
                                   
                                        <div class="col-lg-12 col-md-12 col-sm-12 mb-2 column">
                                            <div class="form-group">
                                                <label>Prix*</label>
                                                <input type="text" value="${an.getPrix() }" name="prix" >
                                            </div>
                                        </div>
                                         <div class="col-lg-12 col-md-12 col-sm-12 mb-2 column">
                                            <div class="form-group">
                                                <label>Ville*</label>
                                                <input type="text" value="${an.getVille() }" name="ville" >
                                            </div>
                                        </div>
                                      	
                                        <div class="col-lg-12 col-md-12 col-sm-12 column">
                                            <div class="form-group">
                                                <label>Description*</label>
                                                <textarea  name="description">${an.getDescription()}</textarea>
                                            </div>
                                        </div>
                                        
                                        <div class="col-lg-12 col-md-12 col-sm-12 column">
                                            <div class="form-group message-btn">
                                                <button type="submit"  name="maj" class="theme-btn-one">Mettre à jour</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        
                        
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