package controller.everyone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Eccezioni.ValidException;
import model.dao.UsersDao;
import model.javabeans.Users;
import model.util.Utils;

@WebServlet(name = "Login", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("UserData") != null) {
            response.sendRedirect("/vnl-1.0-SNAPSHOT/Homepage");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("Username");
        String password = (request.getParameter("Password"));

        String HashedPSW = Utils.toHash(password);

        try {

            List<String> errorMessages = new ArrayList<>();

            if (!Utils.isValidPassword(password)) {
                errorMessages.add("Invalid password");
            }
            if (!Utils.isValidUsername(username)) {
                errorMessages.add("Invalid username");
            }

            if (!errorMessages.isEmpty()) {
                throw new ValidException(errorMessages);
            }

        } catch (ValidException e) {
            System.err.println(e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        UsersDao service = new UsersDao();

        Users user = service.doRetrievebyUsername(username);

        if (user != null && user.getPassword().equals(HashedPSW)) {
            HttpSession session = request.getSession(true);
            Map<String, String> userData = new HashMap<>();

            String isLogged = "true";
            userData.put("Username", user.getUsername());
            userData.put("Email", user.getEmail());
            userData.put("nTelefono", user.getNumeroDiTelefono());
            userData.put("IsLogged", isLogged);
            userData.put("tipo", user.getTipo());
            userData.put("DataNascita", user.getDataDiNascita().toString());

            session.setAttribute("UserData", userData);
            response.sendRedirect("/vnl-1.0-SNAPSHOT/Homepage");
            return; 
        } else {
            JsonObject errorMessages = new JsonObject();
            errorMessages.addProperty("error", "Login Fallito");
            String errorMessagesJson = new Gson().toJson(errorMessages);
            request.setAttribute("errorMessagesJson", errorMessagesJson);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
            dispatcher.forward(request, response);

        }

    }
}
