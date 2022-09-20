package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Database;
import model.Hash;
import model.User;
import model.UserDAO;

/**
 * Servlet implementation class Modifiermdp
 */
@WebServlet("/Modifiermdp")
public class Modifiermdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifiermdp() {
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
		boolean falsemdp=false;
		boolean inputvide = false;
		boolean  mdppasidentique=false;
		boolean mdpweak=false;
		boolean mdplength=false;
		boolean mdpok=false;
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
		}
		UserDAO us = new UserDAO();
		int userid= (int)session.getAttribute("userid");
		User u = us.getById(userid);
		if(request.getParameter("bupdatemdp")!=null) {
			String mdp=request.getParameter("oldpassword");
			String newmdp=request.getParameter("newpassword");
			String cnewmdp=request.getParameter("tpassword");
			Hash hs = new Hash();
			String hpass = hs.sha1(mdp);
			System.out.println(hpass +" "+u.getMdp());
			Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
			Pattern lowerCasePatten = Pattern.compile("[a-z ]");
			Pattern digitCasePatten = Pattern.compile("[0-9 ]");
			if(!hpass.equals(u.getMdp())) {
				falsemdp=true;
				
			}
			//si les input sont vide 
			else if((mdp.isEmpty()|| mdp.equals(" ")) || (newmdp.isEmpty()|| newmdp.equals(" ")) || (cnewmdp.isEmpty()|| cnewmdp.equals(" "))) { 
				inputvide = true;	
			}//si le mot de passe et la confirmation ne sont pas identique 
			else if (!newmdp.equals(cnewmdp)) {
				 mdppasidentique=true;
			}//mot de passe trop court
			 else if (newmdp.length() < 8) {
				 mdplength=true;
			}// caract�re sp�cial
			 else if (!specailCharPatten.matcher(newmdp).find()) {
				 mdpweak=true;
			    }
			// majiscule
			 else if (!UpperCasePatten.matcher(newmdp).find()) {
				 mdpweak=true;
			    }
			//miniscule
			  else if (!lowerCasePatten.matcher(newmdp).find()) {
				  mdpweak=true;
			    }
			//chiffre
			  else if (!digitCasePatten.matcher(newmdp).find()) {
				  mdpweak=true;
			  }else {
				  String mdphash=hs.sha1(newmdp);
				  u.setMdp(mdphash);
				  us.save(u);
				  mdpok=true;
				  
			  }
		}
		
		request.setAttribute("mdplength",mdplength);
		request.setAttribute("falsemdp",falsemdp);
		request.setAttribute("mdpok",mdpok);
		request.setAttribute("mdpweak",mdpweak);
		request.setAttribute("inputvide",inputvide);
		request.setAttribute("mdppasidentique",mdppasidentique);
		request.setAttribute("u", u);
		if(!load) {
			request.getRequestDispatcher( "modifiermdp.jsp" ).forward( request, response );
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
