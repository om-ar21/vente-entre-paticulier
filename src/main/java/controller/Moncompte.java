package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import model.Database;
import model.UserDAO;

/**
 * Servlet implementation class Moncompte
 */
@WebServlet("/Moncompte")
public class Moncompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Moncompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		HttpSession session = request.getSession( true );
		boolean load=false;
		boolean inputvide=false;
		boolean userexiste = false;
		boolean telinvalide=false;
		boolean emailinvalide = false;
		boolean profilajour=false;
		if(session.getAttribute("userid")==null) {
			load=true;
			response.sendRedirect("Index"); 
		}
		boolean del=(boolean)session.getAttribute("isdel");
		if( del==true) {
			 session.setAttribute( "userid", 0 );
		     session.setAttribute( "usernom", "" );
		     session.setAttribute( "isConnected", false );
		     response.sendRedirect("Index"); 
		}else {
		UserDAO us = new UserDAO();
		int userid= (int)session.getAttribute("userid");
		User u = us.getById(userid);
	if(request.getParameter("bmodifier")!=null) {
		
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String tel = request.getParameter("tel");
			String email=request.getParameter("email");
			int d=us.verifyEmail(email);
			Pattern verifyEmail = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\."+"[A-zA-Z0-9_+&*-]+)*@"+
					"(?:[A-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
					Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
					Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
					Pattern lowerCasePatten = Pattern.compile("[a-z ]");
					
					Pattern verifyTel = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
			//si les input sont vide 
			if ((nom.isEmpty() || nom.equals(" ")) || (prenom.isEmpty() || prenom.equals(" ")) || (tel.isEmpty() || tel.equals(" "))
			|| (email.isEmpty() || email.equals(" ")) ) { 
				inputvide = true;	
			}else if( d>1 && email!=u.getEmail()) {
				userexiste=true;
			} else if((verifyTel.matcher(tel).find() && verifyTel.matcher(tel).group().equals(tel)) || UpperCasePatten.matcher(tel).find() || lowerCasePatten.matcher(tel).find() || specailCharPatten.matcher(tel).find() ) {
		    	telinvalide=true;
		    }else if (!verifyEmail.matcher(email).matches()) { 
				emailinvalide = true;	
					
			}else {
				u.setNom(nom);
				u.setPrenom(prenom);
				u.setTel(tel);
				u.setEmail(email);
				us.save(u);
				profilajour=true;
			}
		
	}
		
		
	
	request.setAttribute("userexiste",userexiste);
	request.setAttribute("telinvalide",telinvalide);
	request.setAttribute("emailinvalide",emailinvalide);
	request.setAttribute("inputvide",inputvide);
	request.setAttribute("profilajour",profilajour );
	request.setAttribute("u", u);
		}
		
		if(!load) {
			request.getRequestDispatcher( "moncompte.jsp" ).forward( request, response );
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
