package fr.gtm.servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.entities.FilmDTO;
import fr.gtm.entities.Panier;

/**
 * Servlet implementation class ValiderPanier
 */
@WebServlet("/ValiderPanier")
public class ValiderPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private Panier panier;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/valider-panier.jsp";
		
		List<FilmDTO> filmsDto = panier.getFilmsDto();
		
		Double total = panier.getPrixTotal();
		
		request.setAttribute("filmsDto", filmsDto);
		request.setAttribute("total", total);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
