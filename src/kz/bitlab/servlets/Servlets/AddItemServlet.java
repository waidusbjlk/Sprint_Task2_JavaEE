package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.servlets.db.DBConnection;
import kz.bitlab.servlets.db.Items;
import kz.bitlab.servlets.db.Users;

import java.io.IOException;

@WebServlet(value = "/AddItem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users users = (Users) request.getSession().getAttribute("currentUser");


        if(users!=null){
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String price = request.getParameter("price");

            double ItemPrice = Double.parseDouble(price);

            Items items = new Items();
            items.setName(name);
            items.setDescription(description);
            items.setPrice(ItemPrice);

            DBConnection.addItem(items);
        }else {
            response.sendRedirect("/login");
        }


    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/AddItem.jsp").forward(request,response);
    }
}