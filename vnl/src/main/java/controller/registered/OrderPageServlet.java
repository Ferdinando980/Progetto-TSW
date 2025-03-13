package controller.registered;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.OrderDao;
import model.dao.OrderItemsDao;
import model.javabeans.Order;
import model.javabeans.OrderItems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


@WebServlet (name="OrderPage", value="/OrderPage")
public class OrderPageServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<String, String> userData = (Map<String, String>) session.getAttribute("UserData");

        String idString = request.getParameter("id");

        if (userData == null) {
            response.sendRedirect(request.getContextPath() + "/Homepage");
        }else if(userData!=null){

            if(idString!=null) {

                OrderItemsDao orderItemsDao = new OrderItemsDao();
                ArrayList<OrderItems> orderItems = orderItemsDao.doRetrieveByKey(idString, userData.get("UserId"));

                session.setAttribute("orderID", idString);
                session.setAttribute("orderItems", orderItems);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/orderPage.jsp");
                dispatcher.forward(request, response);
            }else response.sendRedirect(request.getContextPath() + "/ViewOrder");
        }

    }
}