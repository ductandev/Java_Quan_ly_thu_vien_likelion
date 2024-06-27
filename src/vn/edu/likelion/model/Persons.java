package vn.edu.likelion.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Persons {
    private String personId;
    private String namePerson;
    private int age;
    private ArrayList<HireBook> hireBooks = new ArrayList<>();

    public Persons() {}


    public Persons(String personId, String namePerson, int age, ArrayList<HireBook> hireBooks) {
        this.personId = personId;
        this.namePerson = namePerson;
        this.age = age;
        this.hireBooks = hireBooks;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<HireBook> getHireBooks() {
        return hireBooks;
    }

    public void setHireBooks(ArrayList<HireBook> hireBooks) {
        this.hireBooks = hireBooks;
    }

    public String getHireBooksToString() {
        String result = "";
        int count = 0;
        for (HireBook hireBook : hireBooks) {
            if (count == 2 ){
                result += "...";
                break;
            }
            result += hireBook.getBookId() + "-" + hireBook.getQuantityHire() + ",";
            count++;
        }
        return  result;
    }

    public void addHireBook(HireBook hireBook) {
        hireBooks.add(hireBook);
    }

    public void addHireBook(String bookID, int quantity, LocalDate dayHire, LocalDate dayBack) {
        hireBooks.add(new HireBook(bookID, quantity, dayHire, dayBack));
    }
}
