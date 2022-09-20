package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Database;
import model.Favoris;
import model.FavorisDAO;

/**
 * Servlet implementation class Wishlist
 */
@WebServlet("/Wishlist")
public class Wishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wishlist() {
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
			int iduser=(int)session.getAttribute("userid");
			FavorisDAO fdao= new FavorisDAO();
			ArrayList<Favoris> fav=fdao.getAllById(iduser);
			request.setAttribute("fav", fav);
		
			if(request.getParameter("idsup")!=null) {
				load=true;
				int ida=Integer.parseInt(request.getParameter("idsup"));
				fdao.deleteById(ida);
				response.sendRedirect(request.getHeader("referer"));
			}
			
		}
		
		
		
		
		if(!load) {
			request.getRequestDispatcher( "wishlist.jsp" ).forward( request, response );

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
