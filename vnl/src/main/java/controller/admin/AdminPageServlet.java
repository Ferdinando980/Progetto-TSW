package controller.admin;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name="AdminPage", value="/AdminPage")
public class AdminPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session!=null){
            Map<String, String> userData = (Map<String, String>) session.getAttribute("UserData");

            if (userData == null) response.sendRedirect("Homepage");
            else{
                String tipo = userData.get("tipo");
                if(!"admin".equals(tipo)) response.sendRedirect("Homepage");
                else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/pageAdmin.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }


    }
}
