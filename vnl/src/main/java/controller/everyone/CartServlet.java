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

        int productID = Integer.parseInt(request.getParameter("productID"));
        int quantita = Integer.parseInt(request.getParameter("quantity"));
        ProductDao productDao = new ProductDao();
        Product p = productDao.doRetrieveById(productID);

        if (carrello == null) {
            carrello = new ArrayList<>();
            session.setAttribute("cart", carrello);



            OrderItems orderItems = new OrderItems();
            orderItems.setProdotto(productID);
            orderItems.setQuantita(quantita);
            orderItems.setPrezzo(p.getPrezzo()*orderItems.getQuantita());



            if (orderItems != null) {
                carrello.add(orderItems);
            }

        } else {
            boolean trovato=false;
            for (int i=0; i<carrello.size(); i++) {

                if (carrello.get(i).getProdotto() == productID) {
                    int quantitaTot = carrello.get(i).getQuantita()+quantita;
                    carrello.get(i).setQuantita(quantitaTot);
                    carrello.get(i).setPrezzo(p.getPrezzo()* quantitaTot);
                    trovato=true;
                }
            }
            if (!trovato) {
                OrderItems orderItems = new OrderItems();
                orderItems.setProdotto(productID);
                orderItems.setQuantita(quantita);
                orderItems.setPrezzo(p.getPrezzo()*orderItems.getQuantita());
                carrello.add(orderItems);
            }
        }

        response.sendRedirect("Cart");
    }
}