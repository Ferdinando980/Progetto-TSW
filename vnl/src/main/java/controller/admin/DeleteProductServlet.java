package controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.ProductDao;
import model.javabeans.Product;

@WebServlet(name="DeleteProduct",value="/DeleteProduct")
public class DeleteProductServlet  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            ProductDao productDao = new ProductDao();
            Product product= productDao.doRetrieveById(productId);
            boolean success = productDao.delete(product);

            if (success) {
                response.sendRedirect("ListaProdotti");
            } else {
                response.sendRedirect("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Error");
        }
    }
}
    

