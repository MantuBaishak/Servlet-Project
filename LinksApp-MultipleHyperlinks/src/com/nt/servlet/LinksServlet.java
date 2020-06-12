package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LinksServlet.doGet()");
		PrintWriter pw=null;
		String pval=null;
		Locale locales[]=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read additional req param value(s1)
		pval=req.getParameter("s1");
		//get All available locales
		locales=Locale.getAvailableLocales();
		//differentiate logics for hyperlink
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h4>All Languages</h4><br>");
			for(Locale l:locales) {
				pw.println("<b>"+l.getDisplayLanguage()+",</b>");
			}
			
		}
		else if(pval.equalsIgnoreCase("link2")) {
			pw.println("<h4>All Countries</h4><br>");
			for(Locale l:locales) {
				pw.println("<b>"+l.getDisplayCountry()+",</b>");
			}
			
		}
		else {
			pw.println("<h2>System Properties Are</h2>");
			pw.println("<br>"+System.getProperties());
		}
		//add hyperlink
		pw.println("<a href='links.html'><img src='images/home.jpg' width='50' height='50'></a>");
		//close stream
		pw.close();
	}//doGet()
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LinksServlet.doPost(-,-)"); 
		doPost(req, res);
	}//doPost()

}//class
