package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
        String name=null;
		 int age=0;
		 double amount=0;
		//get PrintWriter
	    pw=res.getWriter();
	    //set response contentType
	    res.setContentType("text/html");
       //read from data---(req parameter values)
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		amount=Double.parseDouble(req.getParameter("pamount"));
       //write B.logic
		if(amount<5000)
			pw.println("<h1 style='color:green;text-align:center'>Mr./Miss./Mrs. "+name+" You Are Not Eligible For Open An Account</h1>");
		else
			pw.println("<h1 style='color:blue;text-align:center'>Mr./Miss./Mrs. "+name+" You Are Eligible For Open An Account</h1>");
         
		pw.println("<br><b>Date and Time"+new Date()+"</b><br>");
		//add home hyperlink
		pw.println("<br><a href='input.html'><img src='image/home1.jpg' height='100' width='200'></a>");

		//close Stream
		pw.close();
	}

}
