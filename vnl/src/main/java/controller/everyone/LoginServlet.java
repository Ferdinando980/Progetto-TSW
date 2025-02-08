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

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsersDao usersDao = new UsersDao();

        Users user = usersDao.doRetrievebyEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }



        /* /     //check per vedere se l'ugente è già loggato e si sta registrando, in quel caso invalido la sessione e loggo l'utente registrato
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            session = request.getSession(true);

            Map<String, String> userData = new HashMap<>();
            String isLogged = "true";
            userData.put("Username", reqUser.getUsername());
            userData.put("Email", reqUser.getEmail());
            userData.put("nTelefono", reqUser.getNumeroDiTelefono());
            userData.put("IsLogged", isLogged);

            session.setAttribute("UserData", userData);

            */
    }
}
