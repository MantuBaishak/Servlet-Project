package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doPost(-,-)");
		PrintWriter pw=null;
		String name=null,gender=null;
		int age=0;
		//get PrintWriter
		pw=res.getWriter();
		//set response ContentType
		res.setContentType("text/html");
		//read from data..(req param values)
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		gender=req.getParameter("gender");
		//write b.logic or request processing logic
		if(gender.equalsIgnoreCase("M")) {
			if(age>=21) {
				pw.println("<h1 style='color:red;text-align:center'>Mr."+ name +" you are eligible for Marriage</h1>");
				
			}//if
			else {
				pw.println("<h1 style='color:blue;text-align:center'>Mr."+ name +" you are not eligible for Marriage</h1>");
			}//else
		}//if
		else if(gender.equalsIgnoreCase("F")) {
			if(age>=18) {
				pw.println("<h1 style='color:red;text-align:center'>Miss."+ name +" you are eligible for Marriage</h1>");
			}//if
			else {
				pw.println("<h1 style='color:blue;text-align:center'>Miss."+ name +" you are not eligible for Marriage</h1>");
			}//else
		}//else if
		else {
			pw.println("<h1 style='color:green;text-align:center'>Unknown Gender</h1>");
		}
		pw.println("<br><b>Date and Time"+new Date()+"</b><br>");
		
		//close stream
		pw.close();
	}//service(-,-)
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doGet()");
		PrintWriter pw=null;
		//get printWriter
		pw=res.getWriter();
		res.setContentType("text/html");
		//write b.logic
		pw.println("<h1 style='color:red;text-align:center'>Date and Time:::"+new Date()+"</h1>");
		//add hyperlink
				pw.println("<br><a href='input.html'><img src='images/home.jpg' width='100' height='100'/></a>");
		//close stream
		pw.close();
	}

}//class
