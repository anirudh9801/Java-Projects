package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ResetPasswordServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resetToken = request.getParameter("resetToken");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        PrintWriter out = response.getWriter();

        try {
            boolean isValidToken = isValidResetToken(resetToken);

            if (!isValidToken) {
                out.println("Invalid or expired reset token. Please request a new reset token.");
            } else if (!newPassword.equals(confirmPassword)) {
                out.println("Passwords do not match. Please try again.");
            } else if (updatePassword(resetToken, newPassword)) {
                out.println("Your password has been successfully reset.");
            } else {
                out.println("Password reset failed. Please try again.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred. Please try again later.");
        }
    }

    private boolean isValidResetToken(String resetToken) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionHelper.getConnection();
        String cmd = "SELECT COUNT(*) AS count FROM reset_tokens WHERE token = ?";
        PreparedStatement pst = connection.prepareStatement(cmd);
        pst.setString(1, resetToken);
        ResultSet rs = pst.executeQuery();
        rs.next();
        int count = rs.getInt("count");
        connection.close();

        return count == 1;
    }

    private boolean updatePassword(String resetToken, String newPassword)
            throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionHelper.getConnection();
        String cmd = "UPDATE users SET password = ? WHERE reset_token = ?";
        PreparedStatement pst = connection.prepareStatement(cmd);
        pst.setString(1, newPassword);
        pst.setString(2, resetToken);
        int rowsUpdated = pst.executeUpdate();
        connection.close();
        return rowsUpdated == 1;
    }
}
