package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.Annonce;
import model.AnnonceDAO;
import model.Database;
import model.UserDAO;

/**
 * Servlet implementation class Userdetail
 */
@WebServlet("/Userdetail")
public class Userdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userdetail() {
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
		UserDAO userdao = new UserDAO();
		int idu = Integer.parseInt(request.getParameter("idu"));
		User u = userdao.getById(idu);
		if(u.isDel()==true) {
			load=true;
			response.sendRedirect("Notfound");  
				
		}
		AnnonceDAO an=new AnnonceDAO();
		ArrayList<Annonce> a = an.getAllByIdUser(idu);
		
		request.setAttribute("u", u);
		request.setAttribute("a", a);
		if(!load) {
			request.getRequestDispatcher( "userdetail.jsp" ).forward( request, response );
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
