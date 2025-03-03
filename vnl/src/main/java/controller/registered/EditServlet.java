package controller.registered;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.validation.constraints.Null;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.javabeans.Users;
import model.Eccezioni.ValidException;
import model.dao.UsersDao;
import model.util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet(name = "EditProfile", value = "/EditProfile")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

  
        if (request.getSession().getAttribute("UserData") == null) {
            response.sendRedirect(request.getContextPath() + "/Homepage");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditProfile.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        Map<String, String> userData = (Map<String, String>) session.getAttribute("UserData");

        if (userData == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }

      
        String dateString = request.getParameter("DataDiNascita");
        Date formattedDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateString, formatter);
            formattedDate = Date.valueOf(date);
        } catch (DateTimeParseException e) {
            System.out.println("Formato data non valido: " + dateString);
        }


        String nazione = request.getParameter("Nazione");
        String ntelefono = request.getParameter("NumeroDiTelefono");
        

       
        ntelefono = "+" + nazione + ntelefono;

   
        Users reqUser = new Users(
                userData.get("UserId"),
                request.getParameter("Username"),
                request.getParameter("Password"), 
                request.getParameter("Email"),
                formattedDate,
                ntelefono
        );

        String passwordCheck = request.getParameter("CPassword");
        UsersDao service = new UsersDao();

        try {
           
            validateInputs(reqUser, passwordCheck, service, userData.get("UserId"));
            
         
            if (reqUser.getPassword() == null || reqUser.getPassword().isEmpty()) {
                
                Users existingUser = service.doRetrieveById(userData.get("UserId"));
                if (existingUser != null) {
                    reqUser.setPassword(existingUser.getPassword()); 
                }
            } else {

                reqUser.setPassword(Utils.toHash(reqUser.getPassword()));
            }

        } catch (ValidException e) {
            System.out.println("Validation error: " + e.getErrorMessages());
            
      
            String errorMessagesJson = new Gson().toJson(e.getErrorMessages());
            request.setAttribute("errorMessagesJson", errorMessagesJson);
            request.setAttribute("userData", reqUser);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditProfile.jsp");
            dispatcher.forward(request, response);
            return;
        }


        boolean success = service.doUpdate(reqUser);

        if (success) {

            userData.put("Username", reqUser.getUsername());
            userData.put("Email", reqUser.getEmail());
            userData.put("DataNascita", reqUser.getDataDiNascita().toString());
            userData.put("nTelefono", reqUser.getNumeroDiTelefono());
            
            session.setAttribute("UserData", userData);
            

            JsonObject successMessage = new JsonObject();
            successMessage.addProperty("success", "Profilo aggiornato con successo");
            String successJson = new Gson().toJson(successMessage);
            request.setAttribute("successJson", successJson);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditProfile.jsp");
            dispatcher.forward(request, response);
        } else {

            JsonObject errorMessage = new JsonObject();
            errorMessage.addProperty("error", "Si è verificato un errore durante l'aggiornamento");
            String errorJson = new Gson().toJson(errorMessage);
            request.setAttribute("errorMessagesJson", errorJson);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditProfile.jsp");
            dispatcher.forward(request, response);
        }
    }


    private void validateInputs(Users user, String passwordCheck, UsersDao service, String currentUserId) {
        List<String> errors = new ArrayList<>();


        if (user.getEmail() == null || user.getEmail().isEmpty() || !Utils.isValidEmail(user.getEmail())) {
            errors.add("Email inserita in modo errato");
        } else if (emailInUso(user.getEmail(), currentUserId, service)) {
            errors.add("Email già in uso");
        }
        

        if (user.getDataDiNascita() == null) {
            errors.add("Data di nascita non valida");
        } else {
            LocalDate today = LocalDate.now();
            LocalDate birthDate = user.getDataDiNascita().toLocalDate();
            
            if (birthDate.isAfter(today)) {
                errors.add("La data di nascita non può essere nel futuro");
            } else if (birthDate.plusYears(120).isBefore(today)) {
                errors.add("La data di nascita non è realistica");
            }
        }
        

        if (user.getNumeroDiTelefono() == null || user.getNumeroDiTelefono().isEmpty() 
                || !Utils.isValidPhone(user.getNumeroDiTelefono())) {
            errors.add("Numero di telefono inserito in modo errato");
        }
        

        if (user.getUsername() == null || user.getUsername().isEmpty() || !Utils.isValidUsername(user.getUsername())) {
            errors.add("Username non valido");
        } else if (usernameInUso(user.getUsername(), currentUserId, service)) {
            errors.add("Username già in uso");
        }
        

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            if (!Utils.isValidPassword(user.getPassword())) {
                errors.add("La password non soddisfa i criteri di validità");
            }
            if (!user.getPassword().equals(passwordCheck)) {
                errors.add("Le password non corrispondono");
            }
        }

        if (!errors.isEmpty()) {
            throw new ValidException(errors);
        }
    }


    private boolean usernameInUso(String username, String currentUserId, UsersDao service) {
        Users existingUser = service.doRetrievebyUsername(username);
        return existingUser != null && !existingUser.getUserId().equals(currentUserId);
    }


    private boolean emailInUso(String email, String currentUserId, UsersDao service) {
        Users existingUser = service.doRetrievebyEmail(email);
        return existingUser != null && !existingUser.getUserId().equals(currentUserId);
    }
}