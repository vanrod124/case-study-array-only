//Author: Brian Caliwag
class Customer extends User {
    private String address;
    private double balance;
    private int loyaltyPoints;

    public Customer(int id, String name, String address, double balance, int loyaltyPoints) {
        super(id, name);
        this.address = address;
        this.balance = balance;
        this.loyaltyPoints = loyaltyPoints;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String toString() {
        return "Customer" +
                "ID:" + getId() +
                "\nName: " + getName() +
                "\nAddress= " + address + 
                "\nBalance= " + balance +
                "\nLoyalty Points= " + loyaltyPoints 
                ;
    }    
}
