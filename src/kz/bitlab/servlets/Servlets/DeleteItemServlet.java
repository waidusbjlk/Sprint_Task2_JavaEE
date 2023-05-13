package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.servlets.db.DBConnection;
import kz.bitlab.servlets.db.Users;

import java.io.IOException;

@WebServlet("/DeleteItem")
public class DeleteItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users = (Users) request.getSession().getAttribute("currentUser");
        if(users!=null){
            int id = Integer.parseInt(request.getParameter("id"));

            DBConnection.DeleteItem(id);

            response.sendRedirect("/");
        }else{
            response.sendRedirect("/login");
        }
    }
}