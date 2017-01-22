package com.tsimura.auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.tsimura.auth.SharedTag.LOGIN_KEY;
import static com.tsimura.auth.SharedTag.LOGIN_PATH;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session == null || session.getAttribute(LOGIN_KEY) == null) {
            response.sendRedirect(LOGIN_PATH);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("Hello, " + session.getAttribute(LOGIN_KEY));
            out.println("<form name='logout' method='post'><input type='submit' value='Logout'></form>");
            out.println("</body></html>");
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute(LOGIN_KEY, null);
        response.sendRedirect(LOGIN_PATH);
    }
}
