package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Database;

import model.FavorisDAO;
import model.Hash;
import model.User;
import model.UserDAO;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		request.setCharacterEncoding("UTF-8");
		 UserDAO userdao=new UserDAO();
		 HttpSession session = request.getSession( true );
		
		boolean messageinscriptionok=false;
		boolean inputvide=false;
		boolean mdppasidentique = false;
		boolean mdplength= false;
		boolean mdpweak= false;
		boolean emailinvalide = false;
		boolean telinvalide=false;
		boolean userexiste = false;
		
		boolean messageconnexionno=false;
		boolean connected=false;
	
		if(request.getParameter("binscription")!=null) {
			
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String tel = request.getParameter("tel");
			String email=request.getParameter("email");
			String mdp=request.getParameter("password");
			String cmdp=request.getParameter("tpassword");
			long mill  = System.currentTimeMillis();
			Date currentdate = new Date(mill);
			
			int d=userdao.verifyEmail(email);
			Pattern verifyEmail = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\."+"[A-zA-Z0-9_+&*-]+)*@"+
			"(?:[A-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
			Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
			Pattern lowerCasePatten = Pattern.compile("[a-z ]");
			Pattern digitCasePatten = Pattern.compile("[0-9 ]");
			Pattern verifyTel = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
			
			//si les input sont vide 
			if ((nom.isEmpty() || nom.equals(" ")) || (prenom.isEmpty() || prenom.equals(" ")) || (tel.isEmpty() || tel.equals(" "))
			|| (email.isEmpty() || email.equals(" ")) || (mdp.isEmpty()|| mdp.equals(" ")) || (cmdp.isEmpty()|| cmdp.equals(" "))) { 
				inputvide = true;	
			}
			
			//si l'email n'est pas valide
			else if( d!=0) {
				userexiste=true;
			}
			//si le numero de tel n'est pas valide
			 else if((verifyTel.matcher(tel).find() && verifyTel.matcher(tel).group().equals(tel)) || UpperCasePatten.matcher(tel).find() || lowerCasePatten.matcher(tel).find() || specailCharPatten.matcher(tel).find() ) {
			    	telinvalide=true;
			    }
			
			 else if (!verifyEmail.matcher(email).matches()) { 
				emailinvalide = true;	
					
			}
			
			//si le mot de passe et la confirmation ne sont pas identique 
			else if (!mdp.equals(cmdp)) {
				 mdppasidentique=true;
			    }
			//mot de passe trop court
			 else if (mdp.length() < 8) {
				 mdplength=true;
			    }
			// caract�re sp�cial
			 else if (!specailCharPatten.matcher(mdp).find()) {
				 mdpweak=true;
			    }
			// majiscule
			 else if (!UpperCasePatten.matcher(mdp).find()) {
				 mdpweak=true;
			    }
			//miniscule
			  else if (!lowerCasePatten.matcher(mdp).find()) {
				  mdpweak=true;
			    }
			//chiffre
			  else if (!digitCasePatten.matcher(mdp).find()) {
				  mdpweak=true;
			    }
			  else {
				   
				    Hash hs = new Hash();
					String hpass = hs.hashPwd(mdp);
				    User u=new User(nom,prenom,currentdate,tel,email,hpass);
					userdao.save(u);
					System.out.println("INSCRIPTION OK");
					messageinscriptionok=true;
			    }
		}
		
		
		if(request.getParameter("bconnexion")!=null ) {
			
			String email=request.getParameter("cemail");
			String password=request.getParameter("cpassword");
			Hash hs = new Hash();//changer le hash avec Bcrypt
			String hpass = hs.hashPwd(password);
			UserDAO utilisateurdao=new UserDAO();
			User u=utilisateurdao.connexion(email, hpass);
			
			if(u==null) {
				System.out.println("CONNEXION NO");
				messageconnexionno=true;
			}else if( u.isDel()==true) {
				 session.setAttribute( "userid", 0 );
			     session.setAttribute( "usernom", "" );
			     session.setAttribute( "isConnected", false );
			     messageconnexionno=true;
			}
			else {
				System.out.println("CONNEXION OK");
				
		        session.setAttribute( "userid", u.getId() );
		        session.setAttribute( "usernom", u.getNom() );
		        session.setAttribute( "usermail", u.getEmail() );
		        session.setAttribute("isdel", u.isDel());
		        session.setAttribute( "isConnected", true );
				connected=true;
				response.sendRedirect("Index");  
			}
		}
		
		
		request.setAttribute("mdplength",mdplength);
		request.setAttribute("userexiste",userexiste);
		request.setAttribute("telinvalide",telinvalide);
		request.setAttribute("emailinvalide",emailinvalide);
		request.setAttribute("mdpweak",mdpweak);
		request.setAttribute("inputvide",inputvide);
		request.setAttribute("mdppasidentique",mdppasidentique);
		request.setAttribute("messageinscriptionok", messageinscriptionok);
		request.setAttribute("messageconnexionno", messageconnexionno);
		if(connected==false ) {
		request.getRequestDispatcher( "connexion.jsp" ).forward( request, response );
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
