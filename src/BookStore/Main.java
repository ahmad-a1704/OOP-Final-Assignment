package BookStore;
import java.util.Scanner;

// The main class executes the entire program from the command line.
public class Main {
    public static void main(String[] args) {
        // instantiating BookStoreManagementSystenm
        BookstoreManagementSystem system = new BookstoreManagementSystem();
        system.loadInventory();
        system.loadSalesHistory();
        system.loadCustomerInfo();

        Scanner scanner = new Scanner(System.in); // Scanner object to take user input
        int choice;
        // A do-while loop is employed to execute a code block at least once before evaluating the loop condition.
        do {
            System.out.println("1. Add new book to inventory");
            System.out.println("2. Update book quantity");
            System.out.println("3. Display available books");
            System.out.println("4. Process sale");
            System.out.println("5. Display sales history");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: // Option to add new book
                    System.out.print("Enter Book ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter Quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    system.getInventory().addBook(new Book(id, title, author, price, quantity));
                    break;
                case 2: // Option to update quantity
                    System.out.print("Enter Book ID: ");
                    int bookID = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter New Quantity: ");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    system.getInventory().updateQuantity(bookID, newQuantity);
                    break;
                case 3: // Option to display booklist
                    system.getInventory().displayBooks();
                    break;
                case 4: // Option to process sale
                    System.out.print("Enter Book ID: ");
                    int saleBookID = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Quantity Sold: ");
                    int saleQuantity = Integer.parseInt(scanner.nextLine());
                    system.processSale(saleBookID, saleQuantity); // Processing a sale and updating sales history
                    system.saveCustomerInfo(); // Saving customer info
                    break;
                case 5:
                    system.getSales().displaySalesHistory(); // Printing sales history
                    break;
                case 6: // Saving and exiting
                    system.saveInventory();
                    system.saveSalesHistory();
                    break;
                default: // Invalid input message
                    System.out.println("Invalid choice");
            }
        } while (choice != 6); // Loop condition
        scanner.close();
    }
}