package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Contact;
import model.ContactDAO;
import model.Database;

/**
 * Servlet implementation class Contactme
 */
@WebServlet("/Contactme")
public class Contactme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contactme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		boolean msgok=false;
		boolean erreur = false;
		HttpSession session = request.getSession( true );
		ContactDAO cdao=new ContactDAO();
		if(session.getAttribute("isConnected")==null) {
			session.setAttribute( "isConnected", false );
			System.out.println("session vide");
		}
		if(request.getParameter("btncontact")!=null) {
			String email=request.getParameter("email");
			String sujet = request.getParameter("sujet");
			String message=request.getParameter("message");
			if(email.isEmpty()||email.equals(" ") || sujet.isEmpty()|| sujet.equals(" ") || message.isEmpty()||message.equals(" ")) {
				erreur = true;
			}else {
				int id_user;
				if((boolean)session.getAttribute("isConnected")==false) {
					id_user=1;
				}else {
					id_user=(int)session.getAttribute("userid");
				}
				Contact con = new Contact(id_user,email,sujet,message);
				cdao.save(con);
				msgok =  true;
			}
			
			
		}
		request.setAttribute("msgok", msgok);
		request.setAttribute("erreur", erreur);
		request.getRequestDispatcher( "contact.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
