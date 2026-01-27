package inventorymanag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    Connection con;

    public ProductDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventory_db",
                "root",
                "nivi"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduct(ProductDTO p) {
        try {
            String sql = "INSERT INTO products(product_name, quantity, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setInt(2, p.getQuantity());
            ps.setDouble(3, p.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProductDTO> viewProducts() {
        List<ProductDTO> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            while (rs.next()) {
                ProductDTO p = new ProductDTO();
                p.setProductId(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setQuantity(rs.getInt(3));
                p.setPrice(rs.getDouble(4));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateQuantity(int id, int qty) {
        try {
            String sql = "UPDATE products SET quantity=? WHERE product_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, qty);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try {
            String sql = "DELETE FROM products WHERE product_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProductDTO searchProduct(int id) {
        ProductDTO p = null;
        try {
            String sql = "SELECT * FROM products WHERE product_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new ProductDTO();
                p.setProductId(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setQuantity(rs.getInt(3));
                p.setPrice(rs.getDouble(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}


