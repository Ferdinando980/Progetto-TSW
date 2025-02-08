package controller.everyone;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.javabeans.Users;
import model.dao.UsersDao;
import model.dao.Eccezioni.ValidException;

@WebServlet(name = "Registrazione", value = "/Registrazione")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/registration.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dateString = request.getParameter("DataDiNascita");

        String nazione = request.getParameter("Nazione");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ntelefono = request.getParameter("NumeroDiTelefono");
        ntelefono = "+" + nazione + ntelefono;

        LocalDate date = LocalDate.parse(dateString, formatter);
        String formattedDate = date.toString();
        Users reqUser = new Users(
                request.getParameter("Username"),
                request.getParameter("Password"),
                request.getParameter("Email"),
                formattedDate,
                ntelefono);

        String passwordCheck = request.getParameter("CPassword");
        UsersDao service = new UsersDao();

        ;

        try {
            validateInputs(reqUser, passwordCheck, service);
            reqUser.setPassword(toHash(reqUser.getPassword()));
        } catch (ValidException e) {
            // debug System.out.println("Errore di validazione: " + e.getMessage());
            return;
        }

        boolean success = service.doSave(reqUser);

        if (success) {

            response.sendRedirect("Login.jsp");

        }

    }

    private boolean emailInUso(String email, UsersDao service) throws ValidException {
        if (service.doRetrievebyEmail(email) != null)
            return true;
        return false;
    }

    private boolean usernameInUso(String username, UsersDao service) throws ValidException {
        if (service.doRetrievebyUsername(username) != null)
            return true;
        return false;
    }

    private void validateInputs(Users user, String passwordCheck, UsersDao service) {
        List<String> errors = new ArrayList<>();

        if (user.getEmail() == null || user.getEmail().isEmpty() || !isValidEmail(user.getEmail())) {
            errors.add("Email inserita in modo errato");
        }
        if (user.getDataDiNascita() == null) {
            errors.add("Data di nascita non valida");
        }
        if (user.getNumeroDiTelefono() == null || user.getNumeroDiTelefono().isEmpty()
                || !isValidPhone(user.getNumeroDiTelefono())) {
            errors.add("Numero di telefono inserito in modo errato");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            errors.add("Password vuota");
        }
        if (!user.getPassword().equals(passwordCheck) || !isValidPassword(user.getPassword())) {
            errors.add("Le password non corrispondono o non soddisfano i criteri di validità");
        }
        if (user.getUsername() == null || user.getUsername().isEmpty() || !isValidUsername(user.getUsername())) {
            errors.add("Username non valido");
        }

        if (usernameInUso(user.getUsername(), service)) {
            errors.add("Username Già In Uso");

        }

        if (emailInUso(user.getEmail(), service)) {
            errors.add("Email già in uso");

        }

        if (!errors.isEmpty()) {
            throw new ValidException(errors);
        }
    }

    private boolean isValidUsername(String username) {
        return username != null && username.length() >= 6 && username.length() <= 12
                && username.matches("^[a-zA-Z0-9 ]+$");
    }

    private boolean isValidPhone(String numeroTel) {
        String phoneRegex = "^[0-9]{3} [0-9]{3} [0-9]{4}$";

        // esempio 123 456 7890 TODO? non è gestito il prefisso.//

        return numeroTel != null && numeroTel.matches(phoneRegex);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email != null && email.matches(emailRegex);
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6 && password.length() <= 15
                && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*");

    }

    private String toHash(String password) {
        StringBuilder hashString = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            for (byte b : hash) {
                hashString.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e);
        }
        return hashString.toString();
    }
}
