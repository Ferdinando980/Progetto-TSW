package controller.everyone;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.UsersDao;
import model.javabeans.Users;

public class LoginServlet extends HttpServlet{

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
    
}
}
