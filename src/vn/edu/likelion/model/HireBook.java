package vn.edu.likelion.model;

import java.time.LocalDate;

public class HireBook {
    private String bookId;
    private int quantityHire;
    private LocalDate dayHire;
    private LocalDate dayBack;

    public HireBook () {}

    public HireBook (String bookId, int quantityHire, LocalDate dayHire, LocalDate dayBack) {
        this.bookId = bookId;
        this.quantityHire = quantityHire;
        this.dayHire = dayHire;
        this.dayBack = dayBack;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getQuantityHire() {
        return quantityHire;
    }

    public void setQuantityHire(int quantityHire) {
        this.quantityHire = quantityHire;
    }

    public LocalDate getDayHire() {
        return dayHire;
    }

    public void setDayHire(LocalDate dayHire) {
        this.dayHire = dayHire;
    }

    public LocalDate getDayBack() {
        return dayBack;
    }

    public void setDayBack(LocalDate dayBack) {
        this.dayBack = dayBack;
    }
}
