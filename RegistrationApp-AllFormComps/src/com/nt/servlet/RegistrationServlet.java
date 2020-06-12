package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,gender=null,ms=null,qlfy=null,crs[]=null,hb[]=null;
		String fbUrl=null,dob=null,dobLocal=null,month=null,week=null,email=null,color=null,searchWords=null;
	    int age=0,salaryRange=0,pin=0;
		long phone=0L;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("name");
		age=Integer.parseInt(req.getParameter("age"));
		addrs=req.getParameter("addrs");
		gender=req.getParameter("gender");
		phone=Long.parseLong(req.getParameter("phone"));
		ms=req.getParameter("ms");
		qlfy=req.getParameter("qlfy");
		crs=req.getParameterValues("crs");
		hb=req.getParameterValues("hb");
		fbUrl=req.getParameter("fbUrl");
		dob=req.getParameter("dob");
		dobLocal=req.getParameter("dobLocal");
		month=req.getParameter("month");
		week=req.getParameter("week");
		email=req.getParameter("email");
		color=req.getParameter("color");
		salaryRange=Integer.parseInt(req.getParameter("salaryRange"));
		pin=Integer.parseInt(req.getParameter("pin"));
		searchWords=req.getParameter("searchWords");
		//write Business logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1 style='color:blue'>Master." +name+" You Are a Baby Boy</h1>");
			else if(age<=12)
				pw.println("<h1 style='color:pink'>Master." +name+" You Are a Small Boy</h1>");
			else if(age<=19)
				pw.println("<h1 style='color:green'>Mr." +name+" You Are a TeenAge Boy</h1>");
			else if(age<=35)
				pw.println("<h1 style='color:cyan'>Mr." +name+" You Are a  Young Man</h1>");
			else if(age<=50)
				pw.println("<h1 style='color:red'>Mr." +name+" You Are a Middle-Age Man</h1>");
			else
				pw.println("<h1 style='color:crimson'>Mr." +name+" You Are a Budda</h1>");
		}
		else {
			if(age<5)
				pw.println("<h1 style='color:blue'>Master." +name+" You Are a Baby Girl</h1>");
			else if(age<=12)
				pw.println("<h1 style='color:pink'>Master." +name+" You Are a Small Girl</h1>");
			else if(age<=19) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:green'>Mrs." +name+" You Are a Married Girl</h1>");
				else
					pw.println("<h1 style='color:yellow'>Miss." +name+" You Are a TeenAge Girl</h1>");
			}
				
			else if(age<=35) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:cyan'>Mrs." +name+" You Are a  Young Woman</h1>");
				else
					pw.println("<h1 style='color:maroon'>Mrs." +name+" You Are a  Young Woman Girl</h1>");
			}
				
			else if(age<=50) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:cyan'>Mrs." +name+" You Are a Middle-Age Woman</h1>");
				else
					pw.println("<h1 style='color:black'>Mrs." +name+" You Are a Middle-Age Woman</h1>");
			}
				
			else {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:cyan'>Mrs." +name+" You Are a Old Woman</h1>");
				else
					pw.println("<h1 style='color:red'>Mrs." +name+" You Are a Old Woman</h1>");
			}
				
		}
		pw.println("<br><h1 style='color:green'>Display Form Data::-></h1>");
		pw.println("<br><b>Name::"+ name +"</b>");
		pw.println("<br><b>Age::"+ age +"</b>");
		pw.println("<br><b>Address::"+ addrs +"</b>");
		pw.println("<br><b>Gender::"+ gender +"</b>");
		pw.println("<br><b>Phone No::"+ phone +"</b>");
		pw.println("<br><b>Marital Status::"+ ms +"</b>");
		pw.println("<br><b>Qualification::"+ qlfy +"</b>");
		pw.println("<br><b>Course::"+ Arrays.toString(crs) +"</b>");
		pw.println("<br><b>Hobbies::"+ Arrays.toString(hb) +"</b>");
		pw.println("<br><b>Facebook URL::"+ fbUrl +"</b>");
		pw.println("<br><b>Date of Birth::"+ dob +"</b>");
		pw.println("<br><b>Date Time of Birth::"+ dobLocal +"</b>");
		pw.println("<br><b>Month of Birth::"+ month +"</b>");
		pw.println("<br><b>Week Day of Birth::"+ week +"</b>");
		pw.println("<br><b>Email Id::"+ email +"</b>");
		pw.println("<br><b>Favourite Color::"+ color +"</b>");
		pw.println("<br><b>Salary::"+ salaryRange +"</b>");
		pw.println("<br><b>Pin No::"+ pin +"</b>");
		pw.println("<br><b>Search Words::"+ searchWords +"</b>");
		//add hyperlink
		pw.println("<br><a href='register.html'>Home</a>");
		//close Stream
		pw.close();
	}
	
   @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
