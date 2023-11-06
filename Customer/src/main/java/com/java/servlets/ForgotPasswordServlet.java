package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.servlets.SendMail;

public class ForgotPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ForgotPasswordServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        PrintWriter out = response.getWriter();

        try {
            CustomerDAO dao = new CustomerDAOImpl();
            Customer customer = dao.searchByUserName(userName);

            if (customer != null) {
                String resetToken = generateResetToken();
                dao.saveResetTokenInDatabase(userName, resetToken);
                sendResetTokenByEmail(customer.getEmail(), resetToken);
                out.println("A reset token has been sent to your email address.");
            } else {
                out.println("Customer does not exist.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred. Please try again later.");
        }
    }

    private String generateResetToken() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder token = new StringBuilder();
        Random random = new Random();
        int tokenLength = 10;
        for (int i = 0; i < tokenLength; i++) {
            int index = random.nextInt(characters.length());
            token.append(characters.charAt(index));
        }
        return token.toString();
    }

    private void sendResetTokenByEmail(String userEmail, String resetToken) {
        // Use your SendMail class to send the email here
        String subject = "Password Reset Request";
        String content = "Dear user,\n\n";
        content += "You have requested to reset your password. ";
        content += "To reset your password, please use the following token:\n";
        content += resetToken + "\n\n";
        content += "If you did not request a password reset, please ignore this email.\n\n";
        content += "Best regards,\nYour Website Team";

        // Use your SendMail class to send the email with subject and content
        SendMail.sendEmail("your_email@gmail.com", "your_password", userEmail, subject, content);
    }
}
