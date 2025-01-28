package controller.everyone;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import model.javabeans.Users;
import model.dao.UsersDao;

@WebServlet(name = "Registrazione", value = "/Registrazione")
public class RegistrationServlet extends HttpServlet {

    private Users ReqUser;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users reqUser = new Users(
                request.getParameter("Username"),
                request.getParameter("Password"),
                request.getParameter("Email"),
                request.getParameter("DataDiNascita"),
                request.getParameter("NumeroDiTelefono"));

        String passwordCheck = request.getParameter("CPassword");
        UsersDao service = new UsersDao();

        ;

        if (!validateInputs(reqUser, passwordCheck)) {
            // error(request, response, "Alcuni campi sono vuoti o inseriti in modo
            // errato");
            return;
        }

        service.doSave(ReqUser);

    }

    private boolean validateInputs(Users user, String passwordCheck) {
        if (user.getEmail() == null || user.getEmail().isEmpty() || !isValidEmail(user.getEmail())) {
            return false;
        }
        if (user.getDataDiNascita() == null || !isValidDDataDiNascita(user.getDataDiNascita())) {
            return false;
        }
        if (user.getNumeroDiTelefono() == null || user.getNumeroDiTelefono().isEmpty()
                || !isValidPhone(user.getNumeroDiTelefono())) {
            return false;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return false;
        }
        if (!user.getPassword().equals(passwordCheck) || !isValidPassword(user.getPassword())) {
            return false;
        }

        if (user.getUsername() == null || !user.getUsername().isEmpty() || !isValidUsername(user.getUsername())) {
            return false;
        }
        return true;
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

    private boolean isValidDDataDiNascita(String password){
        return true;
        //TODO//
    }
}
