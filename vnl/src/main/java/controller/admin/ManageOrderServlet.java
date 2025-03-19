package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.OrderDao;
import model.javabeans.Order;


@WebServlet(name="ManageOrder", value="/ManageOrder")
public class ManageOrderServlet  extends HttpServlet{

     private OrderDao orderDao = new OrderDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Order> orders = orderDao.doRetrieveAll();
        System.out.println("Orders retrieved: " + orders.size());

        request.setAttribute("orders", orders);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/manageorder.jsp");
        dispatcher.forward(request, response);
    }
    
}
