package controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.ProductDao;
import model.javabeans.Product;


@WebServlet(name="ModifyProduct", value="/ModifyProduct")
public class ModifyProductServlet extends HttpServlet{


    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    


     String productId = request.getParameter("id");
     int id= Integer.parseInt(productId);
    
        ProductDao productDao = new ProductDao();
        Product product = productDao.doRetrieveById(id);
        
    
        request.setAttribute("product", product);
        
    
        request.getRequestDispatcher("/jsp/modifyproduct.jsp").forward(request, response);
}
    
}
