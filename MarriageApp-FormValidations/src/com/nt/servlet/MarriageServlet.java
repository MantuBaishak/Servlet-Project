package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doPost(-,-)");
		PrintWriter pw = null;
		String name = null, gender = null, tage = null;
		int age = 0;
		List<String> errsList = null;
		String vstatus = null;
		// get PrintWriter
		pw = res.getWriter();
		// set response ContentType
		res.setContentType("text/html");
		// read from data..(req param values)
		name = req.getParameter("pname");
		tage = req.getParameter("page");
		gender = req.getParameter("gender");

		// read vflag req param value to know wheather client side form validations are
		// done or not done
		vstatus = req.getParameter("vflag");

		// enable server side form validations only when client side form validations
		// are no done
		if (vstatus.equalsIgnoreCase("no")) {

			// Write Form Validations logic server side
			System.out.println("MarriageServlet::Server side form validation logic");
			errsList = new ArrayList<>();
			if (name == null || name.length() == 0 || name.equals("")) {
				errsList.add("Person name is required");
			} else if (name.length() < 5 || name.length() > 15) {
				errsList.add("Person name must have min of 5 chars and max of 15 chars");
			}
			if (tage == null || tage.length() == 0 || tage.equals("")) {
				errsList.add("Person age is required");
			} else {
				try {
					age = Integer.parseInt(tage);
					if (age < 1 || age > 125) {
						errsList.add("Person age must be 1 through 125 required");
					}
				} catch (NumberFormatException nfe) {
					errsList.add("Person age must be numeric value");
				}
			}

			if (errsList.size() != 0) {
				pw.println("<ul>");
				for (String msg : errsList) {
					pw.println("<li style='color:red'>" + msg + "</li>");
				}
				pw.print("</ul>");
				return;
			}
		} // if
		else {
			age=Integer.parseInt(tage);
		}

		// write b.logic or request processing logic
		System.out.println("B.logic execution..");
		if (gender.equalsIgnoreCase("M")) {
			if (age >= 21) {
				pw.println(
						"<h1 style='color:red;text-align:center'>Mr." + name + " you are eligible for Marriage</h1>");

			} // if
			else {
				pw.println("<h1 style='color:blue;text-align:center'>Mr." + name
						+ " you are not eligible for Marriage</h1>");
			} // else
		} // if
		else if (gender.equalsIgnoreCase("F")) {
			if (age >= 18) {
				pw.println(
						"<h1 style='color:red;text-align:center'>Miss." + name + " you are eligible for Marriage</h1>");
			} // if
			else {
				pw.println("<h1 style='color:blue;text-align:center'>Miss." + name
						+ " you are not eligible for Marriage</h1>");
			} // else
		} // else if
		else {
			pw.println("<h1 style='color:green;text-align:center'>Unknown Gender</h1>");
		}
		pw.println("<br><b>Date and Time" + new Date() + "</b><br>");

		// close stream
		pw.close();
	}// service(-,-)

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doGet()");
		PrintWriter pw = null;
		// get printWriter
		pw = res.getWriter();
		res.setContentType("text/html");
		// write b.logic
		pw.println("<h1 style='color:red;text-align:center'>Date and Time:::" + new Date() + "</h1>");
		// add hyperlink
		pw.println("<br><a href='input.html'><img src='images/home.jpg' width='100' height='100'/></a>");
		// close stream
		pw.close();
	}

}// class
