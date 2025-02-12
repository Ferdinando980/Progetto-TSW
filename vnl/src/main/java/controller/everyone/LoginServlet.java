package controller.everyone;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.UsersDao;
import model.javabeans.Users;
import model.util.Utils; 

@WebServlet(name = "Login", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("Email");
        String password = Utils.toHash(request.getParameter("Password"));

        UsersDao service = new UsersDao();

        Users user = service.doRetrievebyEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession(true);
            Map<String, String> userData = new HashMap<>();

            String isLogged = "true";
            userData.put("Username", user.getUsername());
            userData.put("Email", user.getEmail());
            userData.put("nTelefono", user.getNumeroDiTelefono());
            userData.put("IsLogged", isLogged);
            userData.put("DataNascita", user.getDataDiNascita().toString());

            session.setAttribute("UserData", userData);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/homepage.jsp");
            dispatcher.forward(request, response);
        }


    }
}
