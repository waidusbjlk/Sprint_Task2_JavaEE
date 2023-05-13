package kz.bitlab.servlets.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.servlets.db.DBManager;
import kz.bitlab.servlets.db.Items;


import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/shop")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ArrayList<Items> tasks = DBManager.getTasks();
        request.setAttribute("example",tasks);
        request.getRequestDispatcher("/shop.jsp").forward(request,response);
    }

}
