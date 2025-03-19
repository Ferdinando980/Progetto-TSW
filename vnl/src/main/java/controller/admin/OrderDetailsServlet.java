package controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.OrderDao;
import model.dao.OrderItemsDao;
import model.javabeans.Order;

@WebServlet(name="OrderDetails", value="/OrderDetails")
public class OrderDetailsServlet extends HttpServlet{
     private OrderDao orderDao = new OrderDao();
    private OrderItemsDao orderItemsDao = new OrderItemsDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
         response.setHeader("Pragma", "no-cache");
         response.setDateHeader("Expires", 0);

        try{
        String orderId = request.getParameter("id");
        Order order = orderDao.doRetrieveById(orderId);
        request.setAttribute("order", order);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/orderDetails.jsp");
        dispatcher.forward(request, response);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
    }
    
}
