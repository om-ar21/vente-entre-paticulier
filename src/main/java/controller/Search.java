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

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
        AnnonceDAO adao=new AnnonceDAO();
        UserDAO userdao= new UserDAO();
		ArrayList<Annonce> annoncerech = new ArrayList<Annonce>();
		
		HttpSession session = request.getSession( true );
		String mot=request.getParameter("mot");
		annoncerech=adao.Rechercher(mot); 
	  
				
			
		System.out.println(annoncerech);
		request.setAttribute("mot", mot);
		System.out.println("mot : " + mot);
		request.setAttribute("annoncerech", annoncerech);
		request.getRequestDispatcher( "recherche.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
