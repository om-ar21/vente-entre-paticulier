<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="model.Messagerie"%>
        <%@page import="model.MessagerieDAO"%>
      <%@page import="java.util.ArrayList"%>
    <%ArrayList<Messagerie> msg = new ArrayList<Messagerie>();%> 
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
 .em{

  
 
background-color:#7360ff;
border-radius:25px;
 padding:4px 15px;
 /* margin-bottom:50px; */
 
} 
 .rec{

  
 
background-color:#f85c70;
border-radius:25px;
 padding:4px 15px;
 /* margin-bottom:50px; */
 
}
.outgoing_msg{ overflow:hidden; margin:26px 0 26px;}
.sent_msg {
  float: right;
  
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
                                <div class="text d-flex" <%if((boolean)request.getAttribute("disable")==true){ %> style="pointer-events:none; opacity:0.5;" <%} %> >
                                   <div class="image-box"><img src="assets/img/${a.getImage()}" class="rounded"  width="70px;" height="70px;" alt=""></div> <a href="Annoncedetail?idan=${a.getId()}"><h4 class="ml-2">${a.getTitre()} </h4></a>
                                   <p class="mx-3">${a.getPrix()} eur</p> <%if((boolean)request.getAttribute("disable")==true){ %>  <span class="">(annonce supprimée)</span><%} %>
                                    
                                   
                                </div>
                                
                             <% if((boolean)request.getAttribute("erreur")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Veuillez repmlir tous les champs
								</div>
								<% } %>
                             <%
                               msg=(ArrayList)request.getAttribute("m");
                               for(Messagerie mess:msg){
                            	   int iduser=(int)session.getAttribute("userid"); 
                            	   if( mess.getId_rec()!= iduser ){
                               %>
                             
 								<div class="outgoing_msg">
                               <div class=" sent_msg">
                                <span class="em text-white  " ><%= mess.getMessage() %></span><br>
                                <span><%= mess.getDate_message().toString().substring(0,mess.getDate_message().toString().length()-2) %></span>
                                <p><%=mess.getUser(mess.getId_em()).getNom() %> </p>
                               </div>
                               </div> 
                              <%}else {  %>
                                <span class="rec text-white  my-5" ><%= mess.getMessage() %></span><br>
                                
                                <span><%= mess.getDate_message().toString().substring(0,mess.getDate_message().toString().length()-2) %></span>
                                <% 
                                if(iduser == mess.getAnnonce().getId_user()){ %>
                                 <%if((boolean)request.getAttribute("profildel")==true){  %><p><%=mess.getUser(mess.getContact()).getNom() %> </p><span class="">(Profil supprimé)</span><%}else{ %>
                                <a href="Userdetail?idu=<%=mess.getContact()%>"><p><%=mess.getUser(mess.getContact()).getNom() %></p></a><%} %>
                                <br>
                                <br>
                                <%}else{ %>
                                <%if((boolean)request.getAttribute("profildel")==true){  %><p><%=mess.getUser(mess.getId_em()).getNom() %> </p><span class="">(Profil supprimé)</span><%}else{ %>
                                <a href="Userdetail?idu=<%=mess.getId_em() %>"><p><%=mess.getUser(mess.getId_em()).getNom() %></p></a><%} %>
                                <br>
                                <br>
                              
                               <%}}} %>
                               
                                	 
                                <form  method="post" class="review-form">
                                    <div class="row clearfix">
                                        
                                        
                                        
                                     
                                       
                                        <div class="col-lg-12 col-md-12 col-sm-12 column mt-3">
                                            <div class="form-group">
                                                
                                                <textarea name="message" required=""></textarea>
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12 column">
                                            <div class="form-group message-btn">
                                                <button type="submit" name="btncontact" class="theme-btn-one">Envoyer</button>
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