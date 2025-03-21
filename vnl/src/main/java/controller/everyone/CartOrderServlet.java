package controller.everyone;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.OrderDao;
import model.dao.OrderItemsDao;
import model.dao.UsersDao;
import model.javabeans.Order;
import model.javabeans.OrderItems;
import model.javabeans.Users;

@WebServlet(name="CartOrder", value="/CartOrder")
public class CartOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/cartOrder.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Map<String, String> userData = (Map<String, String>) session.getAttribute("UserData");
        if(userData!=null){

            Order order = new Order();
            LocalDate date = LocalDate.now();
            Date dataSQl = Date.valueOf(date);

            UsersDao usersDao = new UsersDao();
            Users users = usersDao.doRetrievebyUsername(userData.get("Username"));

            order.setUsers(users.getUserId());
            order.setNome(request.getParameter("nome"));
            order.setCognome(request.getParameter("cognome"));
            order.setVia(request.getParameter("via"));
            order.setCivico(request.getParameter("civico"));
            order.setCap(request.getParameter("cap"));
            order.setPaese(request.getParameter("paese"));
            order.setStato("Elaborando");
            order.setDataOrdine(dataSQl);

            List<OrderItems> carrello = (List<OrderItems>) session.getAttribute("cart");

            try {

                OrderDao orderDao = new OrderDao();
                OrderItemsDao orderItemsDao = new OrderItemsDao();
                float totale = 0;

                for (int i=0;i<carrello.size();i++) {
                    totale+=carrello.get(i).getPrezzo();
                }

                order.setTotAmount(totale);
                orderDao.doSave(order);

                ArrayList<Order> orders = orderDao.doRetrievebyUsers(order.getUsers());

                for (OrderItems orderItem: carrello) {

                    orderDao.doRetrievebyUsers(order.getUsers());

                    orderItem.setOrdine_id(orders.getLast().getId());
                    orderItem.setOrdine_users(order.getUsers());

                    orderItemsDao.doSave(orderItem);
                }

                session.removeAttribute("cart");
                response.sendRedirect("ConfermaOrdine");

            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Errore nell'inserimento dell'ordine.");
            }
        }
        else response.sendRedirect("Login");


    }
}