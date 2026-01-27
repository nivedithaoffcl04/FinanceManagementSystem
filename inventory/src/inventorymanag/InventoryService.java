package inventorymanag;


import java.util.List;
import java.util.Scanner;

public class InventoryService {

    ProductDAO dao = new ProductDAOImpl();
    Scanner sc = new Scanner(System.in);

    public void addProduct() {
        System.out.print("Product Name: ");
        String name = sc.nextLine();

        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();
        sc.nextLine();


        dao.addProduct(new ProductDTO(name, qty, price));
        System.out.println("Product Added Successfully!");
    }

    public void viewProducts() {
        List<ProductDTO> list = dao.viewProducts();
        System.out.println("\nID\tName\tQty\tPrice");
        for (ProductDTO p : list) {
            System.out.println(
                p.getProductId() + "\t" +
                p.getProductName() + "\t" +
                p.getQuantity() + "\t" +
                p.getPrice()
            );
        }
    }

    public void updateQuantity() {
        System.out.print("Product ID: ");
        int id = sc.nextInt();
        System.out.print("New Quantity: ");
        int qty = sc.nextInt();
        dao.updateQuantity(id, qty);
        System.out.println("Quantity Updated!");
    }

    public void deleteProduct() {
        System.out.print("Product ID: ");
        int id = sc.nextInt();
        dao.deleteProduct(id);
        System.out.println("Product Deleted!");
    }

    public void searchProduct() {
        System.out.print("Product ID: ");
        int id = sc.nextInt();
        ProductDTO p = dao.searchProduct(id);

        if (p != null) {
            System.out.println("Name: " + p.getProductName());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Price: " + p.getPrice());
        } else {
            System.out.println("Product Not Found!");
        }
    }
}
