package controller;

import java.io.IOException;

import java.sql.Date;
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
import model.Favoris;
import model.FavorisDAO;
import model.Image;
import model.ImageDAO;
import model.Messagerie;
import model.MessagerieDAO;
import model.Signalement;
import model.SignalementDAO;
import model.Visite;
import model.VisiteDAO;

/**
 * Servlet implementation class Annoncedetail
 */
@WebServlet("/Annoncedetail")
public class Annoncedetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Annoncedetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		boolean load=false;
		boolean rmv=false;
		boolean signaler=false;
		boolean signaleok=false;
		boolean erreur =false;
		boolean contact=false;
		boolean messageno=false;
		boolean messageok=false;
		AnnonceDAO adao = new AnnonceDAO();
		FavorisDAO fav = new FavorisDAO();
		ImageDAO im =new ImageDAO();
		MessagerieDAO mdao=new MessagerieDAO();
		int ida = Integer.parseInt(request.getParameter("idan"));
		
		Annonce a = adao.getById(ida);
		Favoris f= fav.getByIdAnnonce(ida);
		
		
		ArrayList<Image> img=im.getAllByIdAnnonce(ida);
		if(a.isVal()==false || a.isDel()==true) {
			load=true;
			response.sendRedirect("Index"); 
		}
		
		
		int id_user;
		if((boolean)session.getAttribute("isConnected")==false) {
			id_user=(1); //un est defini comme le guest dans ma bd.
			
		}else{
			id_user = (int) session.getAttribute("userid");
			if(f.getId_user()==id_user && f.getId_annonce()==a.getId()) {
				rmv=true;
			}
			
		}
		if((a.getId_user()!=id_user) &&  id_user!=1) {
			contact=true;
		}
		if(request.getParameter("btnadd")!=null) {
			load =true;
			f.setId_annonce(ida);
			f.setId_user(id_user);
			fav.save(f);
			rmv=true;
			response.sendRedirect(request.getHeader("referer"));
		}if(request.getParameter("btnrmv")!=null) {
			load =true;
			int idf = Integer.parseInt(request.getParameter("idf"));
			fav.deleteById(idf);
			rmv=false;
			response.sendRedirect(request.getHeader("referer"));
		}
		
		if(request.getParameter("signaler")!=null) {
		
			String msg = request.getParameter("message");
			int userid;
			if((boolean)session.getAttribute("isConnected")==false) {
				userid=(1); //un est defini comme le guest dans ma bd.
				
			}else{
				userid=(int)session.getAttribute("userid");
			}
			if(request.getParameter("motif").equals("0") || (msg.isEmpty()|| msg.equals(" "))) {
				erreur =true;
			}else {
				String mot = request.getParameter("motif");
				String message = request.getParameter("message");
				SignalementDAO signale=new SignalementDAO();
				
				Signalement s = new Signalement(userid,ida,mot,message);
				System.out.println(s);
				signale.save(s);
				signaleok=true;
					
			}
			
			
//			
		}
		if(request.getParameter("envoyer")!=null) {
			
		int	id_em = (int) session.getAttribute("userid");
		int id_rec= a.getId_user();
		int id_annonce= a.getId();
		String mess= request.getParameter("message");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String date = now.format(formatter);
		
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			  java.util.Date parsedDate = dateFormat.parse(date);
			    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			    
			    System.out.println(id_em);
			    System.out.println(id_rec);
			    System.out.println(id_annonce);
			    System.out.println(mess);
			    System.out.println(timestamp);
			    Messagerie m = new Messagerie(id_rec,id_em,id_annonce,mess,timestamp,id_em);
			    mdao.save(m);
			    messageok=true;
		    } catch (ParseException e) {
		      System.out.println("Exception :" + e);
		      
		    }
		
		}
//		vis.setId_user(id_user);
//		vis.setDate_visite(currentdate);
//		vis.setId_annonce(ida);
		long millis  = System.currentTimeMillis();
		Date currentdate = new Date(millis);
		VisiteDAO vdao = new VisiteDAO();
		Visite vis = new Visite(id_user,ida,currentdate);
		vdao.save(vis);
		request.setAttribute("signaleok", signaleok);
		request.setAttribute("messageno", messageno);
		request.setAttribute("messageok", messageok);
		request.setAttribute("contact", contact);
		request.setAttribute("erreur", erreur);
		request.setAttribute("signaler", signaler);
		request.setAttribute("rmv", rmv);
		request.setAttribute("a", a);
		request.setAttribute("f", f);
		request.setAttribute("img", img);
		
		if(!load) {
			request.getRequestDispatcher( "annoncedetail.jsp" ).forward( request, response );
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
