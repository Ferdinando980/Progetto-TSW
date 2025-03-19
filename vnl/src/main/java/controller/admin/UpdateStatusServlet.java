package controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.OrderDao;


@WebServlet(name="UpdateStatus", value="UpdateStatus")
public class UpdateStatusServlet extends HttpServlet{
     private OrderDao orderDao = new OrderDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        String newStatus = request.getParameter("status");

        boolean success = orderDao.updateOrderStatus(orderId, newStatus);
        if (success) {
            response.sendRedirect("OrderDetails?id=" + orderId);
        } else {
            response.getWriter().println("Failed to update order status.");
        }
    }
}
    

