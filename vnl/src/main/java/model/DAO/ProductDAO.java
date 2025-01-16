package model.DAO;
import model.javabeans.Product;
import java.util.List;
import java.util.ArrayList;

public interface ProductDAO{
    Product getProductByID(String productId);

    List<Product> getAllProducts();
    void createProduct(Product newProd);
    void updateProduct(Product upProd);
    void deleteProduct(String productId);
}
