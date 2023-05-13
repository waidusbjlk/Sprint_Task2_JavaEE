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

@WebServlet(value = "/SaveItem")
public class SaveItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users users = (Users)request.getSession().getAttribute("currentUser");
        if(users!=null){
            int id = Integer.parseInt(request.getParameter("item_id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));

            Items item = DBConnection.getItem(id);
            if(item!=null){
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);
                DBConnection.UpdateItem(item);
                response.sendRedirect("/details?item_id="+id);
            }else {
                response.sendRedirect("/");
            }
        }else {
            response.sendRedirect("/login");
        }
    }
}