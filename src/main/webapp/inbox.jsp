<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="model.Messagerie"%>
        <%@page import="model.MessagerieDAO"%>
      <%@page import="java.util.ArrayList"%>
    <%ArrayList<Messagerie> msg = new ArrayList<Messagerie>();%> 
    <%ArrayList<Messagerie> msgs = new ArrayList<Messagerie>();%> 
    <%ArrayList<Integer> etat = new ArrayList<Integer>();%> 
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

         <section class="browse-add-details bg-color-2">
            <div class="auto-container">
           
                 <div class="row clearfix">
               
<div class="col-lg-8 offset-lg-2 col-md-12 col-sm-12 content-side">
                        <div class="blog-sidebar default-sidebar">
 <div class="post-widget sidebar-widget">
                                <div class="widget-title">
                                    <h3>Mes messages</h3>
                                </div>
                                <div class="post-inner">
                                
                               <%
                               int iduser=(int)session.getAttribute("userid");
                               msg=(ArrayList)request.getAttribute("m");
                               msgs=(ArrayList)request.getAttribute("mess");
                                /* etat=(ArrayList)request.getAttribute("etat");*/
                               int i=0;  
                              
                               
                               for(Messagerie mess:msg){
                            	   for(Messagerie ms:msgs){
                                	  if( ms.getId_rec()==iduser && ms.getId_annonce()==mess.getId_annonce() &&ms.getContact()==mess.getContact() && ms.isEtat()==false){
                                		  i++;
                                		  break;
                                	  }
                                   }
                            
                               %>
                                	
<%--  <style>


.del{
opacity:0.5;
}
.supp{
display:block;
}
<%}else{%>
.del{
opacity:1;
}
.supp{
display:none;
}
<%}%>
</style> --%>                      	 
                            	
                                    <div class=" post rounded" <%if(mess.getAnnonce().isDel()==true){ %>style="opacity:0.5;"<%} %> <%if(i!=0){; %>  style="background-color: #add8e6;" <%} %>>
                                        <figure class="post-thumb"><a href="blog-details.html"><img src="assets/img/<%= mess.getAnnonce().getImage() %>" alt=""></a></figure>
                                        <h5><a href="Messages?idrec=<%=mess.getId_rec()%>&idem=<%=mess.getId_em()%>&idan=<%=mess.getId_annonce()%>"><%= mess.getAnnonce().getTitre() %></a> </h5><%if(mess.getAnnonce().isDel()==true){ %> <span >annonce supprimée</span><%} %>
                                        <% if(iduser==mess.getAnnonce().getId_user()){ %>
                                        <p><i class="fas fa-user-alt"></i>&emsp;<%=mess.getUser(mess.getId_em()).getNom() %> ${i} </p>
                                        <%}else{ %>
                                         <p><i class="fas fa-user-alt"></i>&emsp;<%=mess.getUser(mess.getAnnonce().getId_user()).getNom() %></p>
                                         <%} %>
                                        
                                    </div>
                                    <%i=0;} /*  */%>
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
    <script src="assets/js/product-filter.js"></script>

    <!-- main-js -->
    <script src="assets/js/script.js"></script>
</body>
</html>