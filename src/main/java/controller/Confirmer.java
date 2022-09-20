package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Annonce;
import model.AnnonceDAO;
import model.Database;
import model.UserDAO;
import model.User;
/**
 * Servlet implementation class Confirmer
 */
@WebServlet("/Confirmer")
public class Confirmer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		boolean load=false;
		HttpSession session = request.getSession( true );
		if(session.getAttribute("userid")==null) {
			load=true;
			response.sendRedirect("Index"); 
			
		}else {
			if(request.getParameter("delete")!=null) {
				load =true;
				int userid=(int)session.getAttribute("userid");
				UserDAO udao = new UserDAO();
				User u =udao.getById(userid);
				AnnonceDAO adao = new AnnonceDAO();
				ArrayList<Annonce> a = adao.getAllDel(userid);
				for(Annonce an:a) {
					an.setDel(true);
					adao.save(an);
				}
				u.setDel(true);
				udao.save(u);
				session.setAttribute( "userid", 0 );
			    session.setAttribute( "usernom", "" );
			    session.setAttribute( "isConnected", false );
				response.sendRedirect("Connexion"); 
			}
		}
		if(!load) {
			request.getRequestDispatcher( "confirmer.jsp" ).forward( request, response );
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
