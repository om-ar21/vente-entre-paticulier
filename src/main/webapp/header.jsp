<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Categorie"%> 
<%@page import="model.SousCat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SousCatDAO"%>
<%@page import="model.CategorieDAO"%>
<%ArrayList<Categorie> cat = new ArrayList<Categorie>();%> 
<%ArrayList<SousCat> soucat = new ArrayList<SousCat>();%> 
<style>
.cercle {
    width: 10px;
    height: 10px;
    border-radius: 20px;
    background: #27C7D4;
    animation: flash 1s infinite;
}
.wishlist {
    width: 20px !important;
    height: 20px !important;
     border-radius: 10px !important; 
    background: #27C7D4 !important;
   
}
@keyframes flash{
	from{
	opacity: 0;
	}
	to{
	opacity: 1;
	}
}
<%if((boolean)request.getAttribute("notif")==false){ %>
.cercle{
display:none;
}
<%}%>
</style>



      <header class="main-header style-two">

            <!-- header-lower -->
            <div class="header-lower">
                <div class="auto-container">
                    <div class="outer-box">
                        <div class="logo-box">
                            <figure class="logo"><a href="index.html"><img src="assets/images/logo-2.png" alt=""></a></figure>
                        </div>
                        <div class="menu-area">
                            <!--Mobile Navigation Toggler-->
                            <div class="mobile-nav-toggler">
                                <i class="icon-bar"></i>
                                <i class="icon-bar"></i>
                                <i class="icon-bar"></i>
                            </div>
                            <nav class="main-menu navbar-expand-md navbar-light">
                                <div class="collapse navbar-collapse show clearfix" id="navbarSupportedContent">
                                    <ul class="navigation clearfix">
                                        <li ><a href="Allannonce">Accueil</a>
                                            
                                        </li> 
                                        <li class="dropdown"><a>Categories</a>
                                            <ul>
                                            <li ><a href="Allannonce">Toutes les catégories</a></li>
                                                 <% 
       		cat=(ArrayList)request.getAttribute("cat");
       		for( Categorie cats:cat){
       		%>
                                                <li class="dropdown"><a href="Allcat?idcat=<%= cats.getId() %>"><%= cats.getTitre() %></a>
                                                    <ul>
                                        <%
                                        
                                        SousCatDAO  sou= new SousCatDAO();
                                        int idcat = cats.getId();
                                		ArrayList<SousCat> souca= sou.getAllById(idcat); 
                                		
                                        
                                        for( SousCat sous:souca){
                                        %>            
                                                        <li> <a href="Allsoucat?idsouscat=<%= sous.getId() %>"><%= sous.getTitre() %></a></li>
                                                        
                                        <%} %>
                                                    </ul>
                                                    
                                                </li>
              <%} %>
                                                
                                            </ul>
                                        </li>  
                                        
                                        <li ><a href="Contactme">Contactez-nous</a>
                                            
                                        </li>
                                      
                                      
                                    </ul>
                                </div>
                            </nav>
                        </div>
                       <div class="btn-box">
                        <% if((boolean)session.getAttribute("isConnected")==false){ %> 
                            <a href="Connexion" class="theme-btn-one"><i class="fas fa-user-alt"></i> Connexion/Inscription</a>
                            
                           <%}else{ %>
                           <nav class="main-menu navbar-expand-md navbar-light">
                           <div class=" collapse navbar-collapse show clearfix" id="navbarSupportedContent">
                         <ul class="navigation clearfix ">
                        <li class="dropdownuser dropdown">
                          <a  class=" theme-btn-one "><div style=" display:inline-block; vertical-align:middle;"><p class="cercle mr-2"></p></div><div style=" display:inline-block; vertical-align:middle;"><i class="fas fa-user-alt"></i> Bonjour ${usernom }</div></a> 
                            <ul>
                            <li><a href="Moncompte">Mon profil</a></li>
                            <li><a href="Mesannonces">Mes annonces</a></li>
                            <li><a href="Wishlist">Mes favoris <span >${count}</span></a></li>
                            <li><a href="Addannonce">Publier une annonce</a></li>
                            <li><a  href="Inbox"><div style=" display:inline-block; vertical-align:middle;"><p class="cercle mr-2"> </p></div><div style=" display:inline-block; vertical-align:middle;">Mes messages</div></a></li>
                            <li><a href="Deconnexion">Deconnexion</a></li>
                           
                           </ul>
                           </li>
                           </ul>
                           </div> 
                           </nav>
                           <%} %>
                        </div>
                    </div>
                </div>
            </div>

            <!--sticky Header-->
            <div class="sticky-header">
                <div class="auto-container">
                    <div class="outer-box">
                        <div class="logo-box">
                            <figure class="logo"><a href="index.html"><img src="assets/images/logo.png" alt=""></a></figure>
                        </div>
                        <div class="menu-area">
                            <nav class="main-menu clearfix">
                                <!--Keep This Empty / Menu will come through Javascript-->
                            </nav>
                        </div>
                        <div class="btn-box">
                        <% if((boolean)session.getAttribute("isConnected")==false){ %> 
                            <a href="Connexion" class="theme-btn-one"><i class="fas fa-user-alt"></i> Connexion/Inscription</a>
                            
                           <%}else{ %>
                              <nav class="  navbar-expand-md navbar-light">
                           
               <ul class="navbar-nav mr-auto ">
                    <li class="nav-item dropdown">
        <a class="theme-btn-one nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <div style=" display:inline-block; vertical-align:middle;"><p class="cercle mr-2"></p></div><div style=" display:inline-block; vertical-align:middle;"><i class="fas fa-user-alt"></i> Bonjour ${usernom }</div>
        </a>
        <ul>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        
        
        
          <li class="mx-3"><a href="Moncompte" class="text-dark">Mon profil</a></li>
          <li class="mx-3"><a href="Mesannonces" class="text-dark">Mes annonces</a></li>
          <li class="mx-3"><a href="Wishlist" class="text-dark">Mes favoris <span >${count}</span></a></li>
          <li class="mx-3"><a href="Addannonce" class="text-dark">Publier une annonce</a></li>
          <li class="mx-3"><a  href="Inbox" class="text-dark"><div style=" display:inline-block; vertical-align:middle;"><p class="cercle mr-2"> </p></div><div style=" display:inline-block; vertical-align:middle;">Mes messages</div></a></li>
          <li class="mx-3"><a href="Deconnexion" class="text-dark">Deconnexion</a></li>
          
        </div>
         </ul>
     </li>
     </ul>
     
                           </nav>
                            
                           <%} %>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
         <!-- Mobile Menu  -->
        <div class="mobile-menu">
            <div class="menu-backdrop"></div>
            <div class="close-btn"><i class="fas fa-times"></i></div>
            
            <nav class="menu-box">
                <div class="nav-logo"><a href="index.html"><img src="assets/images/logo-2.png" alt="" title=""></a></div>
                <div class="menu-outer"><!--Here Menu Will Come Automatically Via Javascript / Same Menu as in Header--></div>
                <div class="contact-info">
                    <h4>Contact Info</h4>
                    <ul>
                        <li>Chicago 12, Melborne City, USA</li>
                        <li><a href="tel:+8801682648101">+88 01682648101</a></li>
                        <li><a href="mailto:info@example.com">info@example.com</a></li>
                    </ul>
                </div>
                <div class="social-links">
                    <ul class="clearfix">
                        <li><a href="index.html"><span class="fab fa-twitter"></span></a></li>
                        <li><a href="index.html"><span class="fab fa-facebook-square"></span></a></li>
                        <li><a href="index.html"><span class="fab fa-pinterest-p"></span></a></li>
                        <li><a href="index.html"><span class="fab fa-instagram"></span></a></li>
                        <li><a href="index.html"><span class="fab fa-youtube"></span></a></li>
                    </ul>
                </div>
            </nav>
        </div><!-- End Mobile Menu -->
        <section class="banner-section style-two centred" style="background-image: url(assets/images/banner/store-4156934.png);">
            <div class="auto-container">
                <div class="content-box">
                     <div class="text">
                        <h1>Achetez, Vendez, Echangez <br />en un seul Clic</h1>
                        <p>Tout cela entre particulier</p>
                    </div> 
                    <div class="form-inner">
                       
                        <form  method="GET" action="Search">
                            <div class="input-inner clearfix">
                                <div class="form-group " style="width:90% !important;">
                                    <i class="icon-2"></i>
                                    <input type="search" name="mot" placeholder="Search Keyword..." required="">
                                </div>
                                
                              
                                <div class="btn-box ">
                                    <button type="submit" name="bcherche"><i class="icon-2"></i>Search</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div> 
            </div>
        </section>