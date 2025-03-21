package controller.everyone;

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

@WebServlet(name = "Registrazione", value = "/Registrazione")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


                      
        if (request.getSession().getAttribute("UserData") != null) {
            response.sendRedirect("/vnl-1.0-SNAPSHOT/Homepage");
            return; 
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/registration.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                request.getParameter("Username"),
                request.getParameter("Password"),
                request.getParameter("Email"),
                formattedDate,
                ntelefono);
                

        String passwordCheck = request.getParameter("CPassword");
        UsersDao service = new UsersDao();

        try {
            validateInputs(reqUser, passwordCheck, service);
            reqUser.setPassword(Utils.toHash(reqUser.getPassword()));
        } catch (ValidException e) {
            System.out.println(e.getErrorMessages());
            String errorMessagesJson = new Gson().toJson(e.getErrorMessages());
            request.setAttribute("errorMessagesJson", errorMessagesJson);
            request.setAttribute("userData", reqUser);
 
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/registration.jsp");
            dispatcher.forward(request, response);
        }

        boolean success = service.doSave(reqUser);

        if (success) {
            response.sendRedirect("/vnl-1.0-SNAPSHOT/Login");
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
