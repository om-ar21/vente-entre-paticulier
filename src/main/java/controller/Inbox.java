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
import model.Messagerie;
import model.MessagerieDAO;

/**
 * Servlet implementation class Inbox
 */
@WebServlet("/Inbox")
public class Inbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inbox() {
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
		boolean clr = false;
	
		MessagerieDAO mdao = new MessagerieDAO();
		HttpSession session = request.getSession( true );
		if(session.getAttribute("userid")==null) {
			load=true;
			response.sendRedirect("Index"); 
			
		}else{
			boolean del=(boolean)session.getAttribute("isdel");
			if( del==true) {
				 session.setAttribute( "userid", 0 );
			     session.setAttribute( "usernom", "" );
			     session.setAttribute( "isConnected", false );
			     response.sendRedirect("Index"); 
			}
			int userid= (int)session.getAttribute("userid");
			ArrayList<Messagerie> m=mdao.getAllByuserid(userid);
			
			
			ArrayList<Messagerie> mess = mdao.getAllById(userid);

 			request.setAttribute("clr", clr);
			request.setAttribute("m", m);
			request.setAttribute("mess", mess);
		}
						
			
			
		
		
		if(!load) {
			request.getRequestDispatcher( "inbox.jsp" ).forward( request, response );
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
