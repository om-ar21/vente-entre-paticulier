package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Categorie;
import model.CategorieDAO;
import model.Database;
import model.FavorisDAO;
import model.Messagerie;
import model.MessagerieDAO;
import model.Recherche;
import model.RechercheDAO;
import model.SousCat;
import model.SousCatDAO;
import model.UserDAO;

/**
 * Servlet implementation class Header
 */
@WebServlet("/Header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		CategorieDAO categoriedao = new CategorieDAO();
		SousCatDAO souscatdao = new SousCatDAO();
		FavorisDAO fav = new FavorisDAO();
		ArrayList<Categorie> cat=categoriedao.getAll();
		UserDAO userdao= new UserDAO();
		boolean notif = false;
		MessagerieDAO mdao = new MessagerieDAO();
		HttpSession session = request.getSession( true );
		
		if(session.getAttribute("isConnected")==null) {
			session.setAttribute( "isConnected", false );
			System.out.println("session vide");
		}if(session.getAttribute("userid")!=null) {
			int userid=(int)session.getAttribute("userid");
			int count = fav.countFavoris(userid);
			request.setAttribute("count", count);
			ArrayList<Messagerie> m = mdao.getAllById(userid);
			for (Messagerie ms:m) {
				if(ms.getId_rec()==userid && ms.isEtat()==false) {
					notif=true;
					break;
				}
			}
		}
		  if(request.getParameter("bcherche")!=null) {
			  String mot=request.getParameter("mot");
			  Recherche recherche = new Recherche();
				RechercheDAO recherchedao= new RechercheDAO();

			    int id_user;
					   if((boolean)session.getAttribute("isConnected")==false) {
							id_user=1;
						}else {
							id_user=(int)session.getAttribute("userid");
						
							
						}
					   
					   long mill  = System.currentTimeMillis();
						Date currentdate = new Date(mill);
						recherche.setDate_rech(currentdate);
						
						recherche.setId_user(id_user);
						recherche.setMot(mot);
						recherchedao.save(recherche);
						
				
		  }
		  System.out.println(notif);
		  request.setAttribute("notif", notif);
		request.setAttribute("cat", cat);
		request.getRequestDispatcher("header.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
