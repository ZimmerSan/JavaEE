package com.tsimura.jspservlet.web;

import com.tsimura.jspservlet.model.CoffeeExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CoffeeSelect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String c = request.getParameter("type");
        CoffeeExpert ce = new CoffeeExpert();
        List result = ce.getTypes(c);
        request.setAttribute("styles", result);

        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}
