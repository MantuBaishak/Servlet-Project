package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet2 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LinksServlet2.doGet()");
		PrintWriter pw=null;
		String pval=null;
		Calendar calendar=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read additional req param value(s1)
		pval=req.getParameter("s1");
		//get All available Calendar
		calendar=Calendar.getInstance();
		//differentiate logics for hyperlink
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h3>Current Month</h3><br>");
			pw.println("<b>"+calendar.get(Calendar.MONTH)+",</b><br>");
		}
		else if(pval.equalsIgnoreCase("link2")) {
			pw.println("<h3>Current Date</h3><br>");
            pw.println("<b>"+calendar.get(Calendar.DATE)+",</b><br>");
		}
		else if(pval.equalsIgnoreCase("link3")) {
			pw.println("<h3>Current WeekDay</h3><br>");
            pw.println("<b>"+calendar.get(Calendar.DAY_OF_WEEK)+",</b><br>");
		}
		else {
			pw.println("<h2>Current Year</h2>");
			pw.println("<br><b>"+calendar.get(Calendar.YEAR)+",</b><br>");
		}
		//add hyperlink
		pw.println("<a href='links.html'><img src='images/home1.jpg' width='100' height='100'></a>");
		//close stream
		pw.close();
	}//doGet()
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LinksServlet2.doPost(-,-)"); 
		doPost(req, res);
	}//doPost()

}
