package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pval=null;
		float val1=0.0f,val2=0.0f;
		Calendar calendar=null;
		//get PrintWriter
		pw=res.getWriter();
		//set Response content Type
		res.setContentType("text/html");
		//read additional req param value(s1)
		pval=req.getParameter("s1");
		//read form data only when hyperlink are not clicked
		if(!pval.equalsIgnoreCase("link1") && !pval.equalsIgnoreCase("link2")) {
			val1=Float.parseFloat(req.getParameter("t1"));
			val2=Float.parseFloat(req.getParameter("t2"));
		}
		else {
			calendar=Calendar.getInstance();
		}
		//different logic
		if(pval.equalsIgnoreCase("Add")) {
			pw.println("<h1 style='color:blue'>Addition::"+(val1+val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("Sub")) {
			pw.println("<h1 style='color:green'>Subtraction::"+(val1-val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("Mul")) {
			pw.println("<h1 style='color:red'>Multiplication::"+(val1*val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("Div")) {
			pw.println("<h1 style='color:black'>Division::"+(val1/val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1 style='color:red'>Current Day In The year::"+calendar.get(Calendar.DAY_OF_YEAR)+"</h1>");
		}
		else {
			pw.println("<h1 style='color:red'>Current Week Number In The year::"+calendar.get(Calendar.WEEK_OF_YEAR)+"</h1>");
		}
		//add Hyperlink
		pw.println("<br><a href='form.html'><img src='images/home.jpg' width='100' height='100'/></a>");
		//close stream
		pw.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

}
