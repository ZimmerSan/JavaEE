package com.tsimura.auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.tsimura.auth.SharedTag.INDEX_PATH;
import static com.tsimura.auth.SharedTag.LOGIN_KEY;

public class AuthServlet extends HttpServlet {
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "admin";
    public static final String ERROR_REQUIRED = "Both Fields Are Required.";
    public static final String ERROR_UNKNOWN_USER = "User not found.";

    public static final String LOGIN_FORM_TEMPLATE =
            "<form action='login' method='post'>" +
            "<p><input type='text' name='login' placeholder='Login'></p>" +
            "<p><input type='password' name='password' placeholder='Password'></p>" +
            "<p><input type='submit' value='login'></p>" +
            "</form>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.print(LOGIN_FORM_TEMPLATE);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (login.equals(LOGIN) && pass.equals(PASSWORD)) {
            request.getSession().setAttribute(LOGIN_KEY, login);
            response.sendRedirect(INDEX_PATH);
        } else if (emptyString(login) || emptyString(pass)) {
            failAuth(ERROR_REQUIRED, response);
        } else {
            failAuth(ERROR_UNKNOWN_USER, response);
        }
    }

    private void failAuth(String error, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.print(LOGIN_FORM_TEMPLATE);
        out.print("<p><font color=red>" + error + "</font></p>");
        out.println("</body></html>");
    }

    private boolean emptyString(String s) {
        return s == null || s.equals("");
    }
}
