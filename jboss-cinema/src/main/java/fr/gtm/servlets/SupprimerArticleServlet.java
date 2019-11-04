package fr.gtm.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.entities.FilmDTO;
import fr.gtm.entities.Panier;
import fr.gtm.service.FilmService;

/**
 * Servlet implementation class SupprimerArticleServlet
 */
@WebServlet("/SupprimerArticleServlet")
public class SupprimerArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private Panier panier;
	@EJB private FilmService service;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		
		FilmDTO filmDto = service.getFilmDto(id);
		
		panier.deleteFilm(filmDto);
		
		List<FilmDTO> filmsDto = panier.getFilmsDto();
		
		Double total = panier.getPrixTotal();
		
		request.setAttribute("filmsDto", filmsDto);
		request.setAttribute("total", total);
		
		String page = "/panier.jsp";
		
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

