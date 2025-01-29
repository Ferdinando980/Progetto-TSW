package controller.everyone;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.javabeans.Users;
import model.dao.UsersDao;
import model.dao.Eccezioni.ValidException;

@WebServlet(name = "Registrazione", value = "/Registrazione")
public class RegistrationServlet extends HttpServlet {

    private Users ReqUser;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            String dateString = request.getParameter("date");
             LocalDate date = LocalDate.parse(dateString);
              Users reqUser = new Users(
                request.getParameter("Username"),
                request.getParameter("Password"),
                request.getParameter("Email"),
                date,
                request.getParameter("NumeroDiTelefono"));

        String passwordCheck = request.getParameter("CPassword");
        UsersDao service = new UsersDao();

        ;

        try {
            validateInputs(reqUser, passwordCheck);
        } catch (ValidException e) {
            // debug System.out.println("Errore di validazione: " + e.getMessage());
            return;
        }



        // aggiungere check TODO 
        service.doSave(ReqUser);
        // aggiungere check TODO 

        HttpSession session = request.getSession();

        Map<String, String> userData = new HashMap<>();
        String isLogged = "true";
        //TODO sarebbe meglio prendere il dato restituito dal database, così hai anahce l'id, ora l'id è vuoto, ha senso mettere l'id, senò da ricercare in futuro//
        userData.put("Username", reqUser.getUsername());
        userData.put("Email", reqUser.getEmail());
        userData.put("nTelefono", reqUser.getNumeroDiTelefono());
        userData.put("IsLogged", isLogged);

        session.setAttribute("UserData", userData);

        response.sendRedirect("home.jsp");

        

    }

    private boolean emailInUso(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'emailInUso'");
    }

    private boolean usernameInUso(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usernameInUso'");
    }

    private void validateInputs(Users user, String passwordCheck) {
        List<String> errors = new ArrayList<>();

        if (user.getEmail() == null || user.getEmail().isEmpty() || !isValidEmail(user.getEmail())) {
            errors.add("Email inserita in modo errato");
        }
        if (user.getDataDiNascita() == null ) {
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

        if (usernameInUso(user.getUsername())) {
            errors.add("Username Già In Uso");

        }

        if (emailInUso(user.getEmail())) {
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


}
