package controller.registered;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import model.javabeans.Users;
import model.Eccezioni.ValidException;
import model.dao.UsersDao;
import model.util.Utils;
import com.google.gson.Gson;

@WebServlet(name = "EditProfile", value = "/EditProfile")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("UserData") == null) {
            response.sendRedirect("/vnl-1.0-SNAPSHOT/Homepage");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditProfile.jsp");
        dispatcher.forward(request, response);
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session = request.getSession();
    Users sessionUser = (Users) session.getAttribute("UserData"); 
    
    if (sessionUser == null) {
        response.sendRedirect("/vnl-1.0-SNAPSHOT/Login");
        return;
    }

    String dateString = request.getParameter("DataDiNascita");
    String nazione = request.getParameter("Nazione");
    String ntelefono = request.getParameter("NumeroDiTelefono");
    ntelefono = "+" + nazione + ntelefono;
    Date formattedDate = null;

    try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        formattedDate = Date.valueOf(date);
    } catch (DateTimeParseException e) {
        System.out.println("Invalid date format: " + dateString);
    }


    Users reqUser = new Users(
            sessionUser.getUserId(),  
            request.getParameter("Username"),
            request.getParameter("Password"), 
            request.getParameter("Email"),
            formattedDate,
            ntelefono
    );

    String passwordCheck = request.getParameter("CPassword");
    UsersDao service = new UsersDao();

    try {
        validateInputs(reqUser, passwordCheck, service);
        
        if (reqUser.getPassword() == null || reqUser.getPassword().isEmpty()) {
            reqUser.setPassword(null); 
        } else {
            reqUser.setPassword(Utils.toHash(reqUser.getPassword()));
        }

    } catch (ValidException e) {
        System.out.println(e.getErrorMessages());
        String errorMessagesJson = new Gson().toJson(e.getErrorMessages());
        request.setAttribute("errorMessagesJson", errorMessagesJson);
        request.setAttribute("userData", reqUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditProfile.jsp");
        dispatcher.forward(request, response);
        return;
    }

    boolean success = service.doUpdate(reqUser);

    if (success) {
 
        sessionUser.setUsername(reqUser.getUsername());
        sessionUser.setEmail(reqUser.getEmail());
        sessionUser.setDataDiNascita(reqUser.getDataDiNascita());
        sessionUser.setNumeroDiTelefono(reqUser.getNumeroDiTelefono());
        
        session.setAttribute("UserData", sessionUser); 
        response.sendRedirect("/vnl-1.0-SNAPSHOT/Profile"); 
    }
}


    private void validateInputs(Users user, String passwordCheck, UsersDao service) {
        List<String> errors = new ArrayList<>();

        if (user.getEmail() == null || user.getEmail().isEmpty() || !Utils.isValidEmail(user.getEmail())) {
            errors.add("Email inserita in modo errato");
        }
        if (user.getDataDiNascita() == null) {
            errors.add("Data di nascita non valida");
        }
        if (user.getNumeroDiTelefono() == null || user.getNumeroDiTelefono().isEmpty()
                || !Utils.isValidPhone(user.getNumeroDiTelefono())) {
            errors.add("Numero di telefono inserito in modo errato");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            errors.add("Password vuota");
        }
        if (!user.getPassword().equals(passwordCheck) || !Utils.isValidPassword(user.getPassword())) {
            errors.add("Le password non corrispondono o non soddisfano i criteri di validità");
        }
        if (user.getUsername() == null || user.getUsername().isEmpty() || !Utils.isValidUsername(user.getUsername())) {
            errors.add("Username non valido");
        }

        if (usernameInUso(user.getUsername(), service)) {
            errors.add("Username già in uso");
        }

        if (emailInUso(user.getEmail(), service)) {
            errors.add("Email già in uso");
        }

        if (!errors.isEmpty()) {
            throw new ValidException(errors);
        }
    }

    private boolean usernameInUso(String username, UsersDao service) throws ValidException {
        return service.doRetrievebyUsername(username) != null;
    }

    private boolean emailInUso(String email, UsersDao service) throws ValidException {
        return service.doRetrievebyEmail(email) != null;
    }
}
