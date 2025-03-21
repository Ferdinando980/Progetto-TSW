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
import model.dao.OrderItemsDao;
import model.dao.ProductDao;
import model.javabeans.Order;
import model.javabeans.OrderItems;
import model.javabeans.Product;

@WebServlet(name="OrderDetails", value="/OrderDetails")
public class OrderDetailsServlet extends HttpServlet{
     private OrderDao orderDao = new OrderDao();
    private OrderItemsDao orderItemsDao = new OrderItemsDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
         response.setHeader("Pragma", "no-cache");
         response.setDateHeader("Expires", 0);

         OrderDao orderDao = new OrderDao();
         OrderItemsDao orderItemsDao = new OrderItemsDao();
         ProductDao productDao = new ProductDao();

        try{
        String orderId = request.getParameter("id");
        Order order = orderDao.doRetrieveById(orderId);
        ArrayList<OrderItems> orderItems = orderItemsDao.doRetrieveByKey(orderId, order.getUsers());
            System.out.println("order items retrieved"+orderItems.size());

        ArrayList<Product> products = new ArrayList<>();
        for (OrderItems item : orderItems) {
             Product product = productDao.doRetrieveById(Integer.parseInt(item.getProdotto()));
        if (product != null) {
            products.add(product);
            }
        }
        System.out.println("products retrieved"+products.size());

 

        request.setAttribute("orderItems", orderItems);
        request.setAttribute("products", products);
        request.setAttribute("order", order);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/orderDetails.jsp");
        dispatcher.forward(request, response);
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
    }
    
}
