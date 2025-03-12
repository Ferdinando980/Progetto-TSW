package controller.registered;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.OrderDao;
import model.javabeans.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name="ViewOrder", value="/ViewOrder")
public class ViewOrderServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<String, String> userData = (Map<String, String>) session.getAttribute("UserData");

        if (userData == null) {
            response.sendRedirect(request.getContextPath() + "/Homepage");
        }else if(userData!=null){

            OrderDao orderDao = new OrderDao();

            ArrayList<Order> ordini = orderDao.doRetrievebyUsers(userData.get("UserId"));
            session.setAttribute("orders", ordini);
            response.sendRedirect("ViewOrder");
        }


    }
}
