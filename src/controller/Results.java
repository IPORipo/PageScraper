package controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import services.ScraperFunctions;

/**
 * Servlet implementation class result
 */
@WebServlet("/results")
public class Results extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Results() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String site_path = request.getParameter("site-path");
		
		try{
			//if ste_path is not correct throws Exception
			new URL(site_path).openStream().close();

			/*document of url user has filed,we are going to parse this document*/
			Document doc = Jsoup.connect(site_path).timeout(60000).get();
			
			//gets all a tags with href
			Elements links = doc.select("a[href]");
			
			//gets all img tags 
			Elements immages = doc.select("img");
			
			//puts link taht youser has filleds
			request.setAttribute("requested_link", site_path);
			
			//puts links and immages containers to request object and redirect to result page
			request.setAttribute("result_links", ScraperFunctions.getParsedInfo(links,"href"));
			request.setAttribute("result_imgs", ScraperFunctions.getParsedInfo(immages,"src"));
			
			ScraperFunctions.redirect("result.jsp", request, response);
		
		}catch(MalformedURLException ex){
			response.sendRedirect("home?message=link you have entered is not correct");
			//if url is incorrect
		}catch(Exception ex){
			response.sendRedirect("home?message=link you have entered dont exist");
			//if process takes a long time(60000)
		}
	}
}
