package controller.everyone;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.OrderDao;
import model.dao.OrderItemsDao;
import model.dao.ProductDao;
import model.dao.UsersDao;
import model.javabeans.Order;
import model.javabeans.OrderItems;
import model.javabeans.Product;
import model.javabeans.Users;


import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet(name="CartOrder", value="/CartOrder")
public class CartOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("UserData") != null) {
            response.sendRedirect("/vnl-1.0-SNAPSHOT/Homepage");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/cartOrder.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Order od = new Order();
        LocalDate date = LocalDate.now();
        Date dataSQl = Date.valueOf(date);

        od.setNome(request.getParameter("nome"));
        od.setCognome(request.getParameter("cognome"));
        od.setVia(request.getParameter("via"));
        od.setCivico(request.getParameter("civico"));
        od.setCap(request.getParameter("cap"));
        od.setPaese(request.getParameter("paese"));

        od.setStato("Confermato");
        od.setDataOrdine(dataSQl);

        HttpSession session = request.getSession();

        Users users = (Users)session.getAttribute("users");
        od.setUsers(users.getUserId());

        List<OrderItems> carrello = (List<OrderItems>) session.getAttribute("cart");

        OrderDao odd = new OrderDao();
        OrderItemsDao orderItemsDao = new OrderItemsDao();

        try {

            odd.doSave(od);

            session.removeAttribute("cart");
            for (int i = 0; i < carrello.size(); i++) {
                OrderItems orderItems = carrello.get(i);

                orderItems.setOrdine_id(od.getId());
                orderItems.setOrdine_users(od.getUsers());

                orderItemsDao.doSave(orderItems);
            }
            response.sendRedirect("/ConfermaOrdine.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Errore nell'inserimento dell'ordine.");
        }
    }
}