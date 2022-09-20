<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.ImageDAO"%>
     <%@page import="model.Image"%>
     <%@page import="model.AnnonceDAO"%>
     <%@page import="model.Annonce"%>
     <%@page import="java.util.ArrayList"%>
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
.imgg{
width: 138px !important;
height: 78px;
}
</style>
</head>
<body>

<jsp:include page="Header" />
   <section class="browse-add-details bg-color-2">
            <div class="auto-container">
                <div class="row clearfix">
                    <div class="col-lg-8 col-md-12 col-sm-12 content-side">
                        <div class="add-details-content">
                         
                            <div class="content-two single-box">
                             <div class="text d-flex justify-content-between ">
                             <h3>${a.getTitre()}</h3> 
                             <form method="get">
                                                   <ul class="react-box">
                                                        <% if((boolean)session.getAttribute("isConnected")==true ){
                                                        
                                                        	if((boolean)request.getAttribute("rmv")==true){ %>

                          								<li ><a  href="Allannonce" >
                           				 <button style="background-color:white; color: rgb(234, 115, 23);" type="submit" name="btnrmv" > <i class="fas fa-heart"></i></button>
												 <input type="hidden" name="idf" value="${f.getId()}" />
												 <input type="hidden" name="idan" value="${a.getId()}" />
                          								</a></li>
                        						<%}else{ %>
                        						 
                          								<li ><a  href="Allannonce" >
                           								 <button style="background-color:white; " type="submit" name="btnadd"><i class="icon-22"></i></button>
														
														<input type="hidden" name="idan" value="${a.getId()}" />
                          								</a></li>
                                                        <%}}%>
                                                
                                                    </ul>
                                                    </form>
                             </div>
                                <div class="bxslider">
                                    <div class="slider-content">
                                        <div class="product-image">
                                            <figure class="image"><img src="assets/img/${a.getImage()}" style="width: 710px !important; height:400px !important;" alt=""></figure>
                                        </div>
                                        <div class="slider-pager">
                                            <ul class="thumb-box clearfix">
                                             
                                                <li>
                                                    <a class="active" data-slide-index="0" href="#"><figure><img class="imgg" src="assets/img/${a.getImage() }"  alt=""></figure></a>
                                                </li>
                                                 <%
                           image=(ArrayList)request.getAttribute("img");
							for(Image an:image){ %>
                                                <li>
                                                    <a data-slide-index="1" href="#"><figure><img class="imgg" src="assets/img/<%= an.getLien() %> " alt=""></figure></a>
                                                </li>
                                                 <%} %>
                                            </ul>
                                        </div>
                                    </div>
                                    </div>
                                    </div>
                                   
                                     <div class="content-one single-box">
                                     <div class="text">
                                     <p>Prix :  ${a.getPrix()} €</p>
                                     <p><i class="far fa-clock mr-3"></i>  ${a.getDate_pub()}</p>
                                      <p><i class="far fa-map mr-3"></i>   ${a.getVille()}</p>
                                      <div class="category d-flex mb-3"><i class="fas fa-tags mr-3"></i><p>${a.getCat().getTitre()}</p></div>
                                     </div>
                                     
                                      
                                      
                                <div class="text">
                                    <h3>Description</h3>
                                    
                                    <p>${a.getDescription()}</p>
                                </div>
                            </div>
                                    </div>
                                    </div>
                                     <div class="col-lg-4 col-md-12 col-sm-12 sidebar-side">
                        <div class="default-sidebar category-sidebar">
                            <div class="sidebar-search sidebar-widget">
                              
                                <div class=" info-box clearfix">
                                <div   class="  clearfix">
                        <div align="center" class="image-box"><img src="assets/images/resource/user.jpg" style="width:50%; border-radius:50%;" alt=""></div>
                       <a href="Userdetail?idu=${a.getId_user()}"><h4 align="center" class="my-3" >${a.getUser().getNom().substring(0,1)}. ${a.getUser().getPrenom()} </h4></a>
                       
                        
                
                    </div>
                    </div>
                               
                            </div>
                             <% if((boolean)session.getAttribute("isConnected")==true ){%>
                    <% if((boolean)request.getAttribute("contact")==true){ %>
                             <div class="sidebar-search sidebar-widget mt-5">
                              <% if((boolean)request.getAttribute("messageno")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Veuillez remplir tous les champs 
								</div>
								<% } %>
								<% if((boolean)request.getAttribute("messageok")==true){ %>
                                <div class="alert alert-success mt-5" role="alert">
								  votre message a bien été envoyé
								</div>
								<% } %>
                                <div class="widget-title">
                                    <h3>Contacter</h3>
                                </div>
                                <div class="widget-content">
                                    <form method="post" class="search-form">
                                        
                                       
                                        <label class="ml-1">Votre message*</label>
                                         <div class="form-group column border rounded">
                                            
                                            <input type="text" name="message"  required="">
                                            
                                        </div> 
                                        
                                       <button class="theme-btn-one"  name="envoyer">Envoyer</button>
                                       <input type="hidden" name="idan" value="${a.getId()}" />
                                    </form>
                                </div>
                            </div>
                            <%}} %>
                            
                            <div class="sidebar-search sidebar-widget mt-5">
                              <% if((boolean)request.getAttribute("erreur")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Veuillez remplir tous les champs 
								</div>
								<% } %>
								<% if((boolean)request.getAttribute("signaleok")==true){ %>
                                <div class="alert alert-success mt-5" role="alert">
								  Nous avons bien reçu votre demande, elle sera traitée dans les meilleurs délais
								</div>
								<% } %>
                                <div class="widget-title">
                                    <h3>Signaler</h3>
                                </div>
                                <div class="widget-content">
                                    <form method="post" class="search-form">
                                        
                                        <div class="form-group">
                                            <i class="fas fa-exclamation-triangle "></i>
                                            <select class="wide" name="motif">
                                               <option value="0">Selectionner un motif*</option>
                                               <option value="fraude">Fraude</option>
                                               <option value="discrimination">Discrimination</option>
                                               <option value="contrefaçon">Contrefaçon</option>
                                               <option value="autre">Autre</option>
                                            </select>
                                            
                                        </div>
                                        <label class="ml-1">Votre message*</label>
                                         <div class="form-group column border rounded">
                                            
                                            <input type="text" name="message" required="">
                                            
                                        </div> 
                                        
                                       <button class="theme-btn-one"  name="signaler">confirmer</button>
                                       <input type="hidden" name="idan" value="${a.getId()}" />
                                    </form>
                                </div>
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
    <script src="assets/js/bxslider.js"></script>

    <!-- main-js -->
    <script src="assets/js/script.js"></script>
</body>
</html>