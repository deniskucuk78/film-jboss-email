package fr.gtm.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import fr.gtm.email.Util;
import fr.gtm.entities.Panier;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private Panier panier;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email1 = request.getParameter("email1");
		String htmlFile = "/template1.html";
		String html = Files.readString(Paths.get(htmlFile));
		Map<String, String> map = new HashMap<String, String>();
		Double total = panier.getPrixTotal();
		map.put("email", email1);
		map.put("prix", total+" €");
		html = Util.replace(html, map);
		
		HtmlEmail email = new HtmlEmail();
		email.setHostName("bovoyages.net");
		email.setSmtpPort(25);
		try {
			email.setFrom("commercial@bovoyages.net","Bovoyage");
			email.setSubject("Votre commande");
			email.addTo(email1);
			email.setHtmlMsg(html);
			email.setTextMsg("Your email client does not support HTML messages");
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Fin de l'envoi");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
