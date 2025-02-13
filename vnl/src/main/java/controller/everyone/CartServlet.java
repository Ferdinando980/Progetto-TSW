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
import model.dao.ProductDao;
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

        String product = request.getParameter("product");
        String quantita = request.getParameter("quantita");

        ProductDao productDao = new ProductDao();
        Product p = productDao.doRetrieveById(product);

        OrderItems orderItems = new OrderItems();
        orderItems.setProdotto(product);
        orderItems.setQuantita(Integer.parseInt(quantita));
        orderItems.setPrezzo(p.getPrezzo()*orderItems.getQuantita());

        if (orderItems != null) {
            carrello.add(orderItems);
        }

        response.sendRedirect("cartOrder.jsp");
    }
}