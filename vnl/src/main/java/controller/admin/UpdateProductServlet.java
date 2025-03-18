package controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.ProductDao;
import model.javabeans.Product;


@WebServlet(name="UpdateProduct", value="/UpdateProduct")
public class UpdateProductServlet  extends HttpServlet{

    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    
        int id = Integer.parseInt(request.getParameter("id"));
        String nomeVnl = request.getParameter("nomeVnl");
        String descrizione = request.getParameter("descrizione");
        float prezzo = Float.parseFloat(request.getParameter("prezzo"));
        String img = request.getParameter("img");
        
    
        ProductDao productDao = new ProductDao();
        Product product = new Product();
        product.setId(id);
        product.setNomeVnl(nomeVnl);
        product.setDescrizione(descrizione);
        product.setPrezzo(prezzo);
        product.setImg(img);
        
        
        productDao.doUpdate(product);
        
    
        response.sendRedirect("Prodotto?id=" + id);
    }


    
}
