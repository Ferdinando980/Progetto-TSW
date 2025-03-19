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
        String condizione= request.getParameter("condizione");
        

    
        
    
        ProductDao productDao = new ProductDao();
        Product oldproduct= productDao.doRetrieveById(id);
        Product product;

        if(oldproduct.getTipo().equals("giradischi")){
            String marca= request.getParameter("marca");
            product = new Product(prezzo, descrizione, condizione,oldproduct.getTipo(), marca, oldproduct.getImg(), nomeVnl, oldproduct.getArtista(), oldproduct.getGenere());
        }else{
            product = new Product(prezzo, descrizione, condizione,oldproduct.getTipo(), oldproduct.getMarca(), oldproduct.getImg(), nomeVnl, oldproduct.getArtista(), oldproduct.getGenere());
        }
        product.setId(oldproduct.getId());
  

        
        
        productDao.doUpdate(product);
        
    
        response.sendRedirect("Prodotto?id=" + id);
    }


    
}
