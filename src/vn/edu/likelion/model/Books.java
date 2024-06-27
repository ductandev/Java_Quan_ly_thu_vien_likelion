package vn.edu.likelion.model;

public class Books {
    private String bookId;
    private String nameBook;
    private String author;
    private int quantity;

    public Books() {}

    public Books(String bookId, String nameBook, String author, int quantity) {
        this.bookId = bookId;
        this.nameBook = nameBook;
        this.author = author;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        bookId = bookId;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
