package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import model.Image;
import model.ImageDAO;

/**
 * Servlet implementation class Modifierannonce
 */
@MultipartConfig
@WebServlet("/Modifierannonce")
public class Modifierannonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifierannonce() {
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
		AnnonceDAO adao = new AnnonceDAO();
		CategorieDAO cdao=new CategorieDAO();
		ArrayList<Categorie> cat = cdao.getAll();
		ImageDAO idao = new ImageDAO();
		HttpSession session = request.getSession( true );
		boolean load=false;
		boolean add=false;
		
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
			int iduser = (int)session.getAttribute("userid");
			int idan=Integer.parseInt(request.getParameter("idann"));
			System.out.println(idan);
			Annonce an = adao.getById(idan); 
			System.out.println(an.getId_user());
			request.setAttribute("an", an);
			ArrayList<Image> im = idao.getAllByIdAnnonce(idan);
			request.setAttribute("im", im);
			if(an.getId_user()!=iduser || an.isVal()==false) {
				load=true;
				response.sendRedirect("Index"); 
			}if(request.getParameter("idsup")!=null){
				load=true;
				int idimg=Integer.parseInt(request.getParameter("idsup"));
				System.out.println();
				idao.deleteById(idimg);
				response.sendRedirect(request.getHeader("referer"));
			}if(request.getParameter("idupdate")!=null) {
				load=true;
				Part img = request.getPart("image1");
				String image = img.getSubmittedFileName(); //le nom du ficher � inserer dans la bd
				image = image.replaceAll("\\s","");
				if(image==null || image ==" " || image.isEmpty() ) {
					System.out.println("l'image n'a pas �t� mise � jours");
					
				}else {
					System.out.println("une image � �t� modifi� ");
					System.out.println("image selectionn�e est :" + image);
					String path ="C:/Users/user/Desktop/me/CDA/eclipse/projet-cda/src/main/webapp/assets/img/"+image;
					System.out.println("le path de l image est  :" + path);
					FileOutputStream fos= new FileOutputStream(path);
					InputStream is = img.getInputStream();
					byte[] data= new byte[is.available()];
					is.read(data);
					fos.write(data);
					fos.close();
				}
				
			}if(request.getParameter("maj")!=null) {
				load=true;
				Part img = request.getPart("image");
				String image = img.getSubmittedFileName(); //le nom du ficher � inserer dans la bd
				image = image.replaceAll("\\s","");
				System.out.println(image);
				String titre=request.getParameter("titre");
				int idsoucat=Integer.valueOf(request.getParameter("soucat"));
				Double prix = Double.parseDouble(request.getParameter("prix"));
				String ville = request.getParameter("ville");
				String desc=request.getParameter("description");
				an.setTitre(titre);
				an.setId_souscat(idsoucat);
				an.setPrix(prix);
				an.setVille(ville);
				an.setDescription(desc);
				an.setVal(false);
				if(image==null || image ==" " || image.isEmpty() ) {
					System.out.println("l'image n'a pas �t� mise � jours");
					adao.save(an);
				}else {
					System.out.println("image selectionn�e est :" + image);
					String path ="C:/Users/user/Desktop/me/CDA/eclipse/projet-cda/src/main/webapp/assets/img/"+image;
					System.out.println("le path de l image est  :" + path);
					FileOutputStream fos= new FileOutputStream(path);
					InputStream is = img.getInputStream();
					byte[] data= new byte[is.available()];
					is.read(data);
					fos.write(data);
					fos.close();
					//************************
					an.setImage(image);
					adao.save(an);
					add=true;
				}
				System.out.println(titre+" "+ idsoucat+" "+prix+" "+ville+" "+desc);
				response.sendRedirect("Mesannonces");
				}
				
			
		}
		request.setAttribute("add", add);
		request.setAttribute("cat", cat);
		if(!load) {
			request.getRequestDispatcher( "modifierannonce.jsp" ).forward( request, response );
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
