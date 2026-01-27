package inventorymanag;



import java.util.List;

public interface ProductDAO {
    void addProduct(ProductDTO product);
    List<ProductDTO> viewProducts();
    void updateQuantity(int productId, int quantity);
    void deleteProduct(int productId);
    ProductDTO searchProduct(int productId);
}
