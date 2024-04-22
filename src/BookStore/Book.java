package BookStore;

// Book inheriting characteristics from product
class Book extends Product {
    private String author;

    // Constructor
    public Book(int productID, String title, String author, double price, int quantity) {
        // Accessing attributes from the parent class
        super(productID, title, price, quantity);
        // initializing own attribute of child class
        this.author = author;
    }

    // Getters and setters for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
