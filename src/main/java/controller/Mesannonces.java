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
import model.VisiteDAO;

/**
 * Servlet implementation class Mesannonces
 */
@WebServlet("/Mesannonces")
public class Mesannonces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mesannonces() {
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
		
		
		if(session.getAttribute("userid")==null) {
			load=true;
			response.sendRedirect("Index"); 
		}else {
			boolean del=(boolean)session.getAttribute("isdel");
			if( del==true) {
				 session.setAttribute( "userid", 0 );
			     session.setAttribute( "usernom", "" );
			     session.setAttribute( "isConnected", false );
			     response.sendRedirect("Index"); 
			}
			AnnonceDAO annoncedao=new AnnonceDAO();
			
			int userid=(int)session.getAttribute("userid");
			ArrayList<Annonce> annonce=annoncedao.getAllByUser(userid);
			VisiteDAO vdao = new VisiteDAO();
			int visite =0;
			for(Annonce a:annonce) {
				visite=vdao.getVisite(a.getId());
				request.setAttribute("visite", visite);
			}
			request.setAttribute("annonce", annonce);
			if(request.getParameter("delete")!=null) {
				load = true;
				int idn=Integer.parseInt(request.getParameter("delete"));
				annoncedao.hideById(idn);
				response.sendRedirect(request.getHeader("referer"));
			}
			
			
		}
		
		if(!load) {
			request.getRequestDispatcher( "mesannonces.jsp" ).forward( request, response );
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
