package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  
		PrintWriter pw=null;
		int code=0;
		String capitals[]= {"NewDelhi","Islamabad","Bejing","WashingtonDC","Colombo"};
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//get country code
		code=Integer.parseInt(req.getParameter("country"));
		//display the capitals
		pw.println("<h1 style='color:blue;text-align:center'>Capital Is::"+capitals[code]+"</h1>");
		//add hyperlink
		pw.println("<br><a href='form.html'>Home</a>");
		//close stream
		pw.close();
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	 doPost(req, res);
	}

}
