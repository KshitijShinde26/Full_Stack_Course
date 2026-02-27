package com.basic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        // Set content type
        response.setContentType("text/html");

        // Get writer object
        PrintWriter out = response.getWriter();

        // Print HTML content
        out.println("<h1>Hello World!</h1>");
        out.println("<h2>Welcome to your first Servlet</h2>");
        out.println("<p>This is running on Tomcat 10 (Jakarta)</p>");
    }
}