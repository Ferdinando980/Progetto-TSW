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
        List<String> carrello = (List<String>) session.getAttribute("cart");

        if (carrello == null) {
            carrello = new ArrayList<>();
            session.setAttribute("cart", carrello);
        }

        String prodotto = request.getParameter("prodotto");
        if (prodotto != null) {
            carrello.add(prodotto);
        }

        response.sendRedirect("cart.jsp");
    }
}