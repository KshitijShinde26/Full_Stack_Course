package com.basic.Session_Management;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/site")
public class SiteController extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "home";
        }

        switch (action) {

            case "login":
                // FORWARD
                request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                        .forward(request, response);
                break;

            case "member":
                request.getRequestDispatcher("/WEB-INF/views/member.jsp")
                        .forward(request, response);
                break;

            case "logout":
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }

                // REDIRECT
                response.sendRedirect(request.getContextPath() + "/site?action=login");
                break;

            case "home":
            default:
                request.getRequestDispatcher("index.jsp")
                        .forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("loginUser".equals(action)) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if ("admin".equals(username) && "123".equals(password)) {

                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                // REDIRECT after login
                response.sendRedirect(request.getContextPath() + "/site?action=member");

            } else {

                request.setAttribute("error", "Invalid Credentials!");

                // FORWARD (because error message must stay)
                request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                        .forward(request, response);
            }
        }
    }
}
