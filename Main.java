import java.util.Scanner;

//Author: All members
public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

 
    public static void pressEnterToContinue() { 
        System.out.println("Press Enter key to continue...");
        input.nextLine();
        input.nextLine();
       
    }

    public static void main(String[] args) {
        int adminId;
        String name;
        int numOfProducts;
        int numOfCustomers;

        System.out.print("Enter admin id: ");
        adminId = input.nextInt();
        System.out.print("Enter admin name: ");
        name = input.next();
        ProductManager productManager = new ProductManager(adminId, name);
        clearScreen();
        System.out.println("Hello " + productManager.getName());
        System.out.print("Enter number of products: ");
        numOfProducts = input.nextInt();
        System.out.print("Enter number of customers: ");
        numOfCustomers = input.nextInt();
        Product products[] = new Product[numOfProducts];
        Customer customers[] = new Customer[numOfCustomers];
        System.out.println("You have successfully added " + numOfProducts + " products and " + numOfCustomers + " customers.");
        pressEnterToContinue();
        clearScreen();

      int choice = 0;
      do {
        System.out.println("Convenience Corner\n");
        System.out.println("Product\t\t\tPurchase");
        System.out.println("1. Add Product\t\t8. Add Purchase");
        System.out.println("2. Delete Product\t9. Show All Purchases");
        System.out.println("3. Modify Product\t");
        System.out.println("4. Show All Products");
        System.out.println("\nCustomer\t\tLoyalty Program");
        System.out.println("5. Add Customer\t\t10. Most Valuable Customer");
        System.out.println("6. Show All Customers\t11. Add Loyalty Points (Discount)");
        System.out.println("7. Delete Customer\t");

        System.out.println("\n0. Exit");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();

        switch (choice) {
          case 1:
            clearScreen();
            productManager.addProduct(products);
            break;
          case 2:
            clearScreen();
            System.out.print("Enter product id: ");
            int id = input.nextInt();
            productManager.deleteProduct(products, id);
          
            break;
        case 3:
            clearScreen();
            System.out.print("Enter product id: ");
            int idModify = input.nextInt();
            productManager.updateProduct(products, idModify);
            
            break;
        case 4:
            clearScreen();
            productManager.displayProduct(products);
            
            break;
        case 5:
            clearScreen();
            productManager.addCustomer(customers);
            
            break;
        case 6:
            clearScreen();
            productManager.displayCustomer(customers);
            
            break;
        case 7:
            clearScreen();
            System.out.print("Enter customer id: ");
            int idDelete = input.nextInt();
            productManager.deleteCustomer(customers, idDelete);
        
            break;
        case 8:
            clearScreen();
            System.out.print("Enter customer id: ");
            int customerId = input.nextInt();
            System.out.print("Enter product id: ");
            int productId = input.nextInt();
            productManager.buyProduct(customers, products, customerId, productId);
        
            break;
        case 9:
            clearScreen();
            productManager.displayCustomer(customers);
            break;
        case 10:
            clearScreen();
            productManager.mostValuableCustomer(customers);
            break;
        case 11:
            clearScreen();
            System.out.print("Enter customer id: ");
            int idLoyalty = input.nextInt();
            productManager.addLoyaltyPoints(customers, idLoyalty);
            break;
      }
      pressEnterToContinue();
        clearScreen();
    } while (choice != 0);
    System.out.println("Thank you for using our system!");
    System.out.println("Members:\nBrian Caliwag\nDominick Dela Cruz\nMitchelle Garilles\nHarold Ocampo\nJoshua Saplan\nVan Suliva");
    }
}