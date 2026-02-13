package com.basic.Forms_Under_Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.getWriter().println("Controller reached");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.getWriter().println(request.getParameter("fullname")+"<br/>");
        response.getWriter().println(request.getParameter("gender")+"<br/>");
        PrintWriter out = response.getWriter();
        String[] program = request.getParameterValues("language");
        boolean hasError = false;
        if (request.getParameter("fullname") == null || request.getParameter("fullname").trim().isEmpty()) {
            out.println("❌ Full Name is required");
            hasError = true;
        }

        if (request.getParameter("gender") == null) {
        	out.println("❌ Please select gender");
        	hasError = true;
        }

        if (request.getParameter("skill") == null || request.getParameter("skill").trim().isEmpty()) {
        	out.println("❌ Skill is required");
        	hasError = true;
        }
        if(request.getParameter("language")==null||request.getParameter("language").trim().isEmpty()) {
        	out.println("❌Language is required");
        	hasError = true;
        }
        if(hasError) {
        	return;
        }
        out.println("<h2>Form Submitted Successfully</h2>");
        out.println("Full Name: " + request.getParameter("fullname") + "<br>");
        out.println("Gender: " + request.getParameter("gender") + "<br>");
        out.println("Language: " + request.getParameter("language") + "<br>");
        out.println("Skill: " + request.getParameter("skill"));
    }
}
