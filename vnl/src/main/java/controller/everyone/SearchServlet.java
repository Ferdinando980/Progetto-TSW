package controller.everyone;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.ProductDao;
import model.javabeans.Product;


@WebServlet(name="Search", value="/Search")
public class SearchServlet  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                 String keyword = request.getParameter("search");
        
    try{
        if (keyword == null || keyword.trim().isEmpty()) {
            response.sendRedirect("ListaProdotti"); 
            return;
        }

        ProductDao productDao= new ProductDao();

        ArrayList<Product> searchResults = productDao.searchProducts(keyword);
        request.setAttribute("keyword", keyword);
        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("/jsp/searchresults.jsp").forward(request, response);



    }catch(Exception e){
                System.err.println(e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
            dispatcher.forward(request, response);

    }

    }


            }


    

