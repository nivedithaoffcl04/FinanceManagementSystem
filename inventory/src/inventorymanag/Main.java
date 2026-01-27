package inventorymanag;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InventoryService service = new InventoryService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Product");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> service.addProduct();
                case 2 -> service.viewProducts();
                case 3 -> service.updateQuantity();
                case 4 -> service.deleteProduct();
                case 5 -> service.searchProduct();
                case 6 -> System.out.println("Thank You!");
                default -> System.out.println("Invalid Choice!");
            }
        } while (choice != 6);
    }
}
