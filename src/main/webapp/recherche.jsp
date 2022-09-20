<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.SousCat"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="model.SousCatDAO"%>
    <%@page import="model.AnnonceDAO"%>
    <%@page import="model.Annonce"%>
        <%@page import="model.FavorisDAO"%>
    <%@page import="model.Favoris"%>
    <%ArrayList<Annonce> annonce = new ArrayList<Annonce>();%> 
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
.imga{
width:100% !important;
height:224px !important;
 box-sizing:border-box !important;
}
</style>
</head>
<body>

<jsp:include page="Header" />
 <section class="feature-style-two four-column">
            <div class="auto-container">
                <div class="sec-title centred">
                    <span> </span>
                    <h2>Resultat de votre recherche : <%=request.getAttribute("mot")  %></h2>
                    
                </div>
                <div class="tabs-box">
                   
                    <div class="tabs-content">
                        <div class="tab active-tab" id="tab-1">
                            <div class="row clearfix">
                               
                            
                               <%
                               annonce=(ArrayList)request.getAttribute("annoncerech");
                               for(Annonce anc:annonce){
                               %>
                              
                                <div class="col-lg-3 col-md-6 col-sm-12 feature-block">
                                    <div class="feature-block-one wow fadeInUp animated animated" data-wow-delay="600ms" data-wow-duration="1500ms">
                                        <div class="inner-box">
                                            <div class="image-box">
                                                <figure class="image"><img  src="assets/img/<%=anc.getImage()%>" class="imga" alt=""></figure>
                                                
                                            </div>
                                            <div class="lower-content">
                                                <div class="category"><i class="fas fa-tags"></i><p><%= anc.getCat().getTitre() %></p></div>
                                                <h4><a href="Annoncedetail?idan=<%= anc.getId()%>"><%=anc.getTitre() %></a></h4>
                                                
                                                <ul class="info clearfix">
                                                    <li><i class="far fa-clock"></i><%= anc.getDate_pub() %></li>
                                                    <li><i class="fas fa-map-marker-alt"></i><%= anc.getVille() %></li>
                                                </ul>
                                                <div class="lower-box">
                                                    <h5><%=anc.getPrix() %> €</h5>
                                                    <form method="get">
                                                    <ul class="react-box">
                                                        <% if((boolean)session.getAttribute("isConnected")==true ){
                                                        
                                                        Favoris fav =anc.getFavoris(anc.getId());
                                                        if(fav.getId_user()==(int)session.getAttribute("userid")&& fav.getId_annonce()==anc.getId()){
                                                        %>

                          								<li ><a  href="Allannonce" >
                           				 <button style="background-color:white; color: rgb(234, 115, 23); " type="submit" name="btnrmv" >&#10084;</button>
												 <input type="hidden" name="idp" value="<%= fav.getId() %>" />
                          								</a></li>
                        						<%}else{ %>
                        						 
                          								<li ><a  href="Allannonce" >
                           								 <button style="background-color:white; " type="submit" name="btnadd"><i class="icon-22"></i></button>
														<input type="hidden" name="idp" value="<%= anc.getId() %>" />
                          								</a></li>
                                                        <%}}%>
                                                
                                                    </ul>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%} %>
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