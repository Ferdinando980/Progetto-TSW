package controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.dao.ProductDao;
import model.javabeans.Product;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,  
    maxFileSize = 1024 * 1024 * 10,       
    maxRequestSize = 1024 * 1024 * 50    
)
@WebServlet(name="AddProduct", value="/AddProduct")
public class AddProductServlet extends HttpServlet {
    private static final String IMAGE_UPLOAD_DIRECTORY = "C:/Users/giuli/Desktop/tsw/Progetto-TSW/vnl/src/main/webapp/assets/product/"; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/addproducts.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

        HttpSession session = request.getSession();
        Map<String, String> userData = (Map<String, String>) session.getAttribute("UserData");

        if (userData == null) response.sendRedirect("Homepage");
        else{
        try {
            String tipo = request.getParameter("tipo");
            float prezzo = Float.parseFloat(request.getParameter("prezzo"));
            String descrizione = request.getParameter("descrizione");
            String condizione = request.getParameter("condizione");
            String marca = request.getParameter("marca");
            
            String nomeVnl = request.getParameter("nomeVnl");

            Product product;
            String imgPath = null;

            
        Part filePart = request.getPart("img");
        if (filePart != null && filePart.getSize() > 0) {
            
            File uploadDir = new File(IMAGE_UPLOAD_DIRECTORY);
            if (!uploadDir.exists()) uploadDir.mkdirs();

    
            String fileExtension = filePart.getSubmittedFileName().substring(filePart.getSubmittedFileName().lastIndexOf('.'));
            String fileName = nomeVnl + fileExtension;

        
            String filePath = IMAGE_UPLOAD_DIRECTORY + fileName;
            filePart.write(filePath);

        
            imgPath = "assets/product/" + fileName;

    
            if ("vinile".equalsIgnoreCase(tipo) || "cd".equalsIgnoreCase(tipo)) {
             
                String artista = request.getParameter("artista");
                String genere = request.getParameter("genere");
                product = new Product(prezzo, descrizione, condizione, tipo, marca, nomeVnl, artista, genere, imgPath); 
            } else if ("giradischi".equalsIgnoreCase(tipo)) {
                product = new Product(prezzo, descrizione, condizione, tipo, marca, nomeVnl, null,null, imgPath); 
            } else {
                throw new IllegalArgumentException("Invalid product type: " + tipo);
            }

          

    
            ProductDao productDAO = new ProductDao();
            productDAO.doSave(product);

            response.sendRedirect("ListaProdotti");
        } 

    }catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("/jsp/error.jsp");
    }

}
}
}
