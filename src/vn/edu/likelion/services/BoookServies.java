package vn.edu.likelion.services;

import vn.edu.likelion.model.Books;

public interface BoookServies {
    void addBook(Books book);
    void editBook(Books book);
    void deleteBook(String id);
    void findBookById(int id);
    void showAllBooks();
}
