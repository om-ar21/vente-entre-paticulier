<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Annonce"%>
    <%@page import="model.AnnonceDAO"%>
<%@page import="java.util.ArrayList"%>
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
width:200px !important;
height:224px !important;
 box-sizing:border-box !important;
}

</style>
</head>
<body>

<jsp:include page="Header" />
      <section class="page-title-2" >
            <div class="auto-container">
                
                <div class="info-box clearfix">
                    <div class="left-column pull-left clearfix">
                        <!-- <div class="image-box"><img src="assets/images/resource/admin-1.png" alt=""></div> -->
                        <h4>${u.getNom().substring(0,1)}. ${u.getPrenom()}<i class="icon-18"></i></h4>
                    
                        
                        <h5><span>membre depuis:</span>${u.getDate_inscription()}</h5>
                    </div>
                 
                </div>
            </div>
        </section>
       <section class="feature-style-three">
            <div class="auto-container">
               
		<div class="tabs-box">    
               <div class="tabs-content">
    <div class="tab active-tab" id="tab-1">
                            <div class="row clearfix">
                            <%
							
							annonce=(ArrayList)request.getAttribute("a");
							for(Annonce an:annonce){ 
							%>
							 
							
							 
                                <div class="col-lg-6 col-md-12 col-sm-12 feature-block test">
                                    <div class="feature-block-one  wow fadeInLeft animated animated" data-wow-delay="00ms" data-wow-duration="1500ms">
                                        <div class="inner-box">
                                            <div class="image-box">
                                                <figure class="image"><img  src="assets/img/<%=an.getImage()%>" class="imga"  alt=""></figure>
                                               
                                            </div>
                                            <div class="lower-content">
                                             
                                                <div class="category"><i class="fas fa-tags"></i><p> <%= an.getCat().getTitre() %></p></div>
                                                <h4><a href="Annoncedetail?idan=<%= an.getId() %>"><%=an.getTitre() %></a></h4>
                                               
                                                <ul class="info clearfix">
                                                    <li><i class="far fa-clock"></i><%= an.getDate_pub() %></li>
                                                    <li><i class="fas fa-map-marker-alt"></i><%=an.getVille() %></li>
                                                </ul>
                                                <div class="lower-box d-flex justify-content-between" >
                                                    <h5><span>Prix:</span> <%=an.getPrix() %> €</h5>
                                                     
                                                
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