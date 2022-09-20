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
import model.Categorie;
import model.CategorieDAO;
import model.Database;
import model.Favoris;
import model.FavorisDAO;
import model.SousCat;
import model.SousCatDAO;

/**
 * Servlet implementation class Allsoucat
 */
@WebServlet("/Allsoucat")
public class Allsoucat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allsoucat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		AnnonceDAO adao= new AnnonceDAO();
		SousCatDAO cat = new SousCatDAO();
		int idsoucat = Integer.parseInt(request.getParameter("idsouscat"));
		ArrayList<Annonce> annonce = adao.getAllByIdSousCat(idsoucat);
		SousCat c = cat.getById(idsoucat);
		boolean load=false;
		  HttpSession session = request.getSession( true );
	     	if(session.getAttribute("isConnected")==null) {
				session.setAttribute( "isConnected", false );
			}
	     FavorisDAO favorisdao= new FavorisDAO();
	     Favoris fv = new Favoris();
	     if(request.getParameter("btnadd")!=null) {
	    	 load=true;
	    	 int ida=Integer.valueOf(request.getParameter("idp"));
	    	 int userid=(int)session.getAttribute("userid");
	    	 System.out.println(ida + " "+userid);
	    	 fv.setId_annonce(ida);
	    	 fv.setId_user(userid);
	    	 favorisdao.save(fv);
	    	 response.sendRedirect(request.getHeader("referer"));
	    	 
	     }
	     if(request.getParameter("btnrmv")!=null) {
				load=true;
				int idp = Integer.valueOf(request.getParameter("idp"));
				favorisdao.deleteById(idp);
				response.sendRedirect(request.getHeader("referer"));
			}
		
	   
		request.setAttribute("c", c);
		request.setAttribute("annonce", annonce);
		if(!load) {
			request.getRequestDispatcher( "allsoucat.jsp" ).forward( request, response );
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
