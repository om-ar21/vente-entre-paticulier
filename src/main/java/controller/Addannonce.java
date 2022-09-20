package controller;

//import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Annonce;
import model.AnnonceDAO;
import model.Categorie;
import model.CategorieDAO;
import model.Database;
import model.ImageDAO;

import model.Image;

/**
 * Servlet implementation class Addannonce
 */
@MultipartConfig
@WebServlet("/Addannonce")
public class Addannonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addannonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		request.setCharacterEncoding("UTF-8");
		CategorieDAO categoriedao=new CategorieDAO();
		ArrayList<Categorie> cat = categoriedao.getAll();
		boolean erreur = false;
		HttpSession session = request.getSession( true );
		boolean del=(boolean)session.getAttribute("isdel");
		boolean load=false;
		boolean add=false;
		if(session.getAttribute("userid")==null) {
			load=true;
			response.sendRedirect("Index"); 
		}else {
			
			if( del==true) {
				 session.setAttribute( "userid", 0 );
			     session.setAttribute( "usernom", "" );
			     session.setAttribute( "isConnected", false );
			     response.sendRedirect("Index"); 
			}
			if(request.getParameter("publier")!=null) {
				//
				int userid=(int)session.getAttribute("userid");
				AnnonceDAO annonce=new AnnonceDAO();
				//récupérer les inputs
				String titre = request.getParameter("titre");
				System.out.println(titre);
				String ville = request.getParameter("ville");
				int idsoucat=Integer.valueOf(request.getParameter("soucat"));
				Part img = request.getPart("image");
				String prix = request.getParameter("prix");
				String description= request.getParameter("description");
				String image = img.getSubmittedFileName(); //le nom du ficher à inserer dans la bd
				image = image.replaceAll("\\s","");
				long millis  = System.currentTimeMillis();
				Date currentdate = new Date(millis);
				if(idsoucat==0 || (image ==" " || image.isEmpty()) || (titre==" "|| titre.isEmpty()) || (ville==" "|| ville.isEmpty()) || (prix.isEmpty()||prix==" ")){
					erreur=true;
				}else {
					System.out.println(idsoucat);
					//image
					System.out.println("image selectionnée est :" + image);
					String path ="C:/Users/user/Desktop/me/CDA/eclipse/projet-cda/src/main/webapp/assets/img/"+image;
					System.out.println("le path de l image est  :" + path);
					FileOutputStream fos= new FileOutputStream(path);
					InputStream is = img.getInputStream();
					byte[] data= new byte[is.available()];
					is.read(data);
					fos.write(data);
					fos.close();
					//************************
					double price = Double.parseDouble(prix);
					Annonce a = new Annonce(titre,idsoucat,userid,description,currentdate,image,ville,price);
					annonce.save(a);
					System.out.println("add ok");
					int max = annonce.getMax();
					System.out.println(max);
					add=true;
					for(int i=1;i<5;i++) {
						 img = request.getPart("image"+i);
						 image = img.getSubmittedFileName();
						 image = image.replaceAll("\\s","");
						 if(image ==null || image.isEmpty()) {
							System.out.println("c'est vide ");

						 }else {
							 System.out.println("image selectionnée est :" + image);
								path ="C:/Users/user/Desktop/me/CDA/eclipse/projet-cda/src/main/webapp/assets/img/"+image;
								System.out.println("le path de l image est  :" + path);
								fos= new FileOutputStream(path);
								 is = img.getInputStream();
								data= new byte[is.available()];
								is.read(data);
								fos.write(data);
								fos.close();
							ImageDAO imagedao = new ImageDAO();
							Image im = new Image(max,image);
							imagedao.save(im);
							System.out.println("image supplémentaire ok");
						 }
					}
				}
				
				
			}
			
		}
		request.setAttribute("add", add);
		request.setAttribute("erreur", erreur);
		request.setAttribute("cat", cat);
		if(!load) {
			request.getRequestDispatcher( "addannonce.jsp" ).forward( request, response );
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
