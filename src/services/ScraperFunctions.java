package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraperFunctions {

	private ScraperFunctions() {
		// TODO Auto-generated constructor stub
	}

	public static void redirect(String location, HttpServletRequest request,
			HttpServletResponse response) {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/WEB-INF/views/" + location);
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatcherEx;
			dispatcherEx = request
					.getRequestDispatcher("/WEB-INF/views/index.html");
		}

	}
	
	public static Set getParsedInfo(Elements elements,String attributeType){
		//creating conainers for links(links and immages) conainers
		//Set container allows us to save unique values
		Set<String> result_links = new HashSet<String>();
		
		for (Element link : elements){
			//gets attribute from a tag
			String linkHref = link.attr("abs:"+attributeType);
			result_links.add(linkHref);
		}
		
		return result_links;
	}

	public static boolean checkUrl(String s) {
		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		try {
			Pattern patt = Pattern.compile(regex);
			Matcher matcher = patt.matcher(s);
			return matcher.matches();
		} catch (RuntimeException e) {
			return false;
		}
	}
}
