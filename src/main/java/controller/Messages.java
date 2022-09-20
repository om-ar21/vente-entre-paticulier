package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import model.Messagerie;
import model.MessagerieDAO;

/**
 * Servlet implementation class Messages
 */
@WebServlet("/Messages")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
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
		boolean erreur= false;
		boolean disable = false;
		boolean profildel=false;
		HttpSession session = request.getSession( true );
		int idrec= Integer.parseInt(request.getParameter("idrec"));
		int idem= Integer.parseInt(request.getParameter("idem"));
		int idan= Integer.parseInt(request.getParameter("idan"));
		
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
			
				MessagerieDAO mdao = new MessagerieDAO();
				ArrayList<Messagerie> m = mdao.getAllByAnnonce(idrec, idem, idan);
				AnnonceDAO adao = new AnnonceDAO();
				Annonce a = adao.getById(idan);
				
				if(a.getUser().isDel()==true) {
					profildel=true;
				}
				if(a.isDel()==true) {
					disable=true;
				}
				request.setAttribute("disable", disable);
				request.setAttribute("m", m);
				request.setAttribute("a", a);
				
				
			if(request.getParameter("btncontact")!=null) {
				String message = request.getParameter("message");
				if(message.isEmpty()|| message.equals(" ")) {
					erreur=true;
				}else {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					String date = now.format(formatter);
					try {
						 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						  java.util.Date parsedDate = dateFormat.parse(date);
						   Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
						   if(a.getId_user()==iduser) {
							   Messagerie newm = new Messagerie(idem,iduser,idan,message,timestamp,idem);
							    mdao.save(newm);
							    load =true;
							    response.sendRedirect(request.getHeader("referer"));
						   }else {
							   Messagerie newm = new Messagerie(a.getId_user(),iduser,idan,message,timestamp,iduser);
							    mdao.save(newm);
							    load =true;
							    response.sendRedirect(request.getHeader("referer"));
						   }
						 
					    } catch (ParseException e) {
					      System.out.println("Exception :" + e);
					      
					    }
				}
			}
             for(Messagerie  last : m) {
				
				if(iduser != last.getId_em()) {
					
					last.setEtat(true);
					mdao.update(last);
				}
					
				
				
				}
		}
		request.setAttribute("erreur", erreur);
		request.setAttribute("profildel", profildel);
		if(!load) {
			request.getRequestDispatcher( "messagerie.jsp" ).forward( request, response );
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
