package controller.everyone;

    
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.ProductDao;
import model.javabeans.Product;

@WebServlet(name = "Prodotto", value = "/Prodotto")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         String id = request.getParameter("id");
         Product product= null;

         if (id != null) {
            try {
        
               
                ProductDao productDAO = new ProductDao();
                product = productDAO.doRetrieveById(id);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                

            }

            request.getRequestDispatcher("/jsp/product.jsp").forward(request, response);
   
    }
}
}
    

