import java.util.Scanner;

//Author: Van Suliva
class ProductManager extends User {
    Scanner sc = new Scanner(System.in);
    public ProductManager(int id, String name) {
        super(id, name);
    }

    public void addProduct(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.print("Enter product name: ");
            String name = sc.next();
            System.out.print("Enter product price: ");
            int price = sc.nextInt();
            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();
            products[i] = new Product(i, name, price, quantity);
        }
    }

    public void displayProduct(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i].displayProduct();
            }
        }
    }

    public void deleteProduct(Product[] products, int id) {
    
        if (!isProductExist(products, id)) {
            System.out.println("Product does not exist");
            return;
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                products[i] = null;
            }
        }
    }

public void updateProduct(Product[] products, int id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getId() == id) {
                System.out.print("Enter product name: ");
                String name = sc.next();
                System.out.print("Enter product price: ");
                int price = sc.nextInt();
                System.out.print("Enter product quantity: ");
                int quantity = sc.nextInt();
                products[i] = new Product(i, name, price, quantity);
            }
        }
    }

    public void showAllProducts(Product[] products) {
        if (products.length == 0) {
            System.out.println("No products available");
        }
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
    }

    public boolean isProductExist(Product[] products, int id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addCustomer(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            System.out.print("Enter customer name: ");
            String name = sc.next();
            System.out.print("Enter customer address: ");
            String address = sc.next();
            System.out.print("Enter customer balance: ");
            double balance = sc.nextInt();
            customers[i] = new Customer(i, name, address, balance, 0);
        }
    }

  
    public void displayCustomer(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }
    }

  
    public void deleteCustomer(Customer[] customers, int id) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId() == id) {
                customers[i] = null;
            }
        }
    }

    public boolean isCustomerExist(Customer[] customers, int id) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void buyProduct(Customer[] customers, Product[] products, int customerId, int productId) {
        if (customerId >= customers.length || customers[customerId] == null) {
            System.out.println("Customer does not exist");
            return;
        }
    
        if (productId >= products.length || products[productId] == null) {
            System.out.println("Product does not exist");
            return;
        }
    
        if (products[productId].getQuantity() == 0) {
            System.out.println("Product out of stock");
            return;
        }
    
        double price = products[productId].getPrice();
        if (customers[customerId].getBalance() < price) {
            System.out.println("Insufficient balance");
            return;
        }
        customers[customerId].setBalance(customers[customerId].getBalance() - price);
        products[productId].setQuantity(products[productId].getQuantity() - 1);
        customers[customerId].setLoyaltyPoints(customers[customerId].getLoyaltyPoints() + 1);
    
        System.out.println("Product bought successfully");
    }

    public void showAllCustomers(Customer[] customers) {
        if (customers.length == 0) {
            System.out.println("No customers available");
        }
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }
    }

    public void mostValuableCustomer(Customer[] customers) {
        double max = 0;
        int index = -1; 
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getBalance() > max) {
                max = customers[i].getBalance();
                index = i;
            }
        }
        if (index >= 0) {
            System.out.println(customers[index]);
        } else {
            System.out.println("No valid customers found.");
        }
    }
    

    public void addLoyaltyPoints(Customer[] customers, int id) {
        if (id >= customers.length || customers[id] == null) {
            System.out.println("Customer does not exist");
            return;
        }
        for (int i = 0; i < customers.length; i++) {
            if (customers[i]!= null || customers[i].getId() == id) {
                System.out.print("Enter loyalty points: ");
                int points = sc.nextInt();
                customers[i].setLoyaltyPoints(customers[i].getLoyaltyPoints() + points);
            }
        }
    }
}


