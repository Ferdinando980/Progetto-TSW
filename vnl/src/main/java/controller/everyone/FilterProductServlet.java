package controller.everyone;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.ProductDao;
import model.javabeans.Product;



public class FilterProductServlet extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        String tipo = request.getParameter("tipo");
        String condizione = request.getParameter("condizione");
        
        if (tipo == null || condizione == null || tipo.trim().isEmpty() || condizione.trim().isEmpty()) {
            response.sendRedirect("jsp/productslist.jsp");
            return;
        }
        
        
        ProductDao productDao = new ProductDao();
        ArrayList<Product> filteredProducts = productDao.getProductbyTypeandCondition(tipo, condizione);
        
    
        request.setAttribute("tipo", tipo);
        request.setAttribute("condizione", condizione);
        request.setAttribute("products", filteredProducts);
        
        request.getRequestDispatcher("/jsp/filteredproducts.jsp").forward(request, response);
    }
    
}
