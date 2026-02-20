package com.basic.DB_Connection;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/home")
public class home extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "LIST";

        try {

            switch (action) {

                case "DELETE":
                    deleteUser(request, response);
                    break;

                case "EDIT":
                    editUser(request, response);
                    break;

                default:
                    listUsers(request, response);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            if ("INSERT".equals(action))
                insertUser(request, response);

            else if ("UPDATE".equals(action))
                updateUser(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- LIST ----------------
    private void listUsers(HttpServletRequest request,
                           HttpServletResponse response)
            throws Exception {

        Connection conn = dbConnection.getConnection();
        String sql = "SELECT * FROM users";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Map<String,String>> list = new ArrayList<>();

        while (rs.next()) {
            Map<String,String> user = new HashMap<>();
            user.put("id", rs.getString("id"));
            user.put("name", rs.getString("name"));
            user.put("email", rs.getString("email"));
            list.add(user);
        }

        request.setAttribute("userList", list);

        request.getRequestDispatcher("include/listusers.jsp")
               .forward(request, response);

        conn.close();
    }

    // ---------------- INSERT ----------------
    private void insertUser(HttpServletRequest request,
                            HttpServletResponse response)
            throws Exception {

        Connection conn = dbConnection.getConnection();
        String sql = "INSERT INTO users(name,email) VALUES(?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, request.getParameter("name"));
        ps.setString(2, request.getParameter("email"));
        ps.executeUpdate();

        conn.close();
        response.sendRedirect("home");
    }

    // ---------------- UPDATE ----------------
    private void updateUser(HttpServletRequest request,
                            HttpServletResponse response)
            throws Exception {

        Connection conn = dbConnection.getConnection();
        String sql = "UPDATE users SET name=?, email=? WHERE id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, request.getParameter("name"));
        ps.setString(2, request.getParameter("email"));
        ps.setInt(3, Integer.parseInt(request.getParameter("id")));

        ps.executeUpdate();
        conn.close();

        response.sendRedirect("home");
    }

    // ---------------- DELETE ----------------
    private void deleteUser(HttpServletRequest request,
                            HttpServletResponse response)
            throws Exception {

        Connection conn = dbConnection.getConnection();
        String sql = "DELETE FROM users WHERE id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
        ps.executeUpdate();

        conn.close();
        response.sendRedirect("home");
    }

    // ---------------- EDIT ----------------
    private void editUser(HttpServletRequest request,
                          HttpServletResponse response)
            throws Exception {

        Connection conn = dbConnection.getConnection();
        String sql = "SELECT * FROM users WHERE id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            request.setAttribute("id", rs.getInt("id"));
            request.setAttribute("name", rs.getString("name"));
            request.setAttribute("email", rs.getString("email"));
        }

        request.getRequestDispatcher("include/index.jsp")
               .forward(request, response);

        conn.close();
    }
}
