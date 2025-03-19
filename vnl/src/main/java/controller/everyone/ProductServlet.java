package controller.everyone;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
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

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
         response.setHeader("Pragma", "no-cache");
         response.setDateHeader("Expires", 0);

         String idString = request.getParameter("id");
    
         Product product= null;

         if (idString != null) {
            try {
                int id = Integer.parseInt(idString);
               
                ProductDao productDAO = new ProductDao();
                product = productDAO.doRetrieveById(id);

                if (product != null) {
                    request.setAttribute("product", product);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/product.jsp");
                    dispatcher.forward(request, response);
                }
                else{
                    System.out.println("product not found");
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                

            }
      

          
   
    }
    else{ System.out.println("id not found in the request");}
}
}
    

