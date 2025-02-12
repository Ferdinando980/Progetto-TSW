package controller.everyone;

    
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.ProductDao;
import model.javabeans.Product;


@WebServlet(name="ListaProdotti", value= "/ListaProdotti")
public class ProductsListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Product> products=null;
        ProductDao productDao= new ProductDao();
        products = productDao.doRetrieveAll();
        System.out.println("Retrieved products count: " + products.size());
    
        request.setAttribute("products", products);
        request.getRequestDispatcher("/jsp/productslist.jsp").forward(request, response);

            }

}

