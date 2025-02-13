package controller.everyone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.javabeans.Order;
import model.javabeans.OrderItems;
import model.javabeans.Product;

@WebServlet(name = "Cart", value = "/Cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/cart.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<OrderItems> carrello = (List<OrderItems>) session.getAttribute("cart");

        if (carrello == null) {
            carrello = new ArrayList<>();
            session.setAttribute("cart", carrello);
        }

        OrderItems orderItems = request.getParameter("orderItems");
        if (orderItems != null) {
            carrello.add(orderItems);
        }

        response.sendRedirect("cartOrder.jsp");
    }
}