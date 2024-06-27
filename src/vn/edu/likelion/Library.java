package vn.edu.likelion;

import vn.edu.likelion.model.Books;
import vn.edu.likelion.model.HireBook;
import vn.edu.likelion.model.Persons;
import vn.edu.likelion.services.BoookServies;
import vn.edu.likelion.services.PersonServices;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library implements BoookServies, PersonServices {
    private ArrayList<Books> books = new ArrayList<>();
    private ArrayList<Persons> persons = new ArrayList<>();

    public ArrayList<Books> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Books> books) {
        this.books = books;
    }

    public ArrayList<Persons> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Persons> persons) {
        this.persons = persons;
    }


    @Override
    public void showAllBooks() {
        int stt = 1;
        System.out.println("==============================================================================================");
        System.out.println("|                              TẤT CẢ SÁCH                                                   |");
        System.out.println("| Stt | Sách ID |          Tên sách                        |       Tác giả        | Số lượng |");
        for (Books book : books) {
            System.out.printf("| %-3d | %-7s | %-40s | %-20s | %-8d |\n",
                    stt, book.getBookId(), book.getNameBook(), book.getAuthor(), book.getQuantity());
            stt++;
        }
        System.out.println("==============================================================================================");
    }

    @Override
    public void addBook(Books book) {
        books.add(book);
    }

    @Override
    public void editBook(Books book) {
        for (Books bookCurrent : books) {
            if (bookCurrent.getBookId().equals(book.getBookId())) {
                if (!(book.getNameBook().equals("0"))) {
                    bookCurrent.setNameBook(book.getNameBook());
                }
                if ((!book.getAuthor().equals("0"))) {
                    bookCurrent.setAuthor(book.getAuthor());
                }
                if (book.getQuantity() != 0) {
                    bookCurrent.setQuantity(book.getQuantity());
                }
                System.out.println("Cập nhật sách thành công !");
                return;
            }
        }
        System.out.println("* Error: Sách ID không tồn tại !!!");
    }

    @Override
    public void deleteBook(String bookId) {
        ArrayList<Books> tempBooks = new ArrayList<>();
        for (Books book : books) {
            tempBooks.add(book);
        }

        for (Books bookCurrent : tempBooks) {
            if (bookCurrent.getBookId().equals(bookId)) {
                books.remove(bookCurrent);
                System.out.println("Xóa sách thành công !");
            }
        }
    }

    @Override
    public void showAllPerson() {
        int stt = 1;
        System.out.println("===============================================================================================");
        System.out.println("|                              DANH SÁCH KHÁCH HÀNG                                           |");
        System.out.printf("| %-3s | %-13s | %-25s | %-5s | %-15s | %-15s |\n", "Stt", "Khách hàng ID", "Tên khách hàng", "Tuổi", "SL sách đã thuê", "Sách đã thuê");
        for (Persons person : persons) {
            System.out.printf("| %-3d | %-13s | %-25s | %-5s | %-15s | %-15s |\n",
                    stt, person.getPersonId(), person.getNamePerson(), person.getAge(), person.getHireBooks().size(), person.getHireBooksToString());
            stt++;
        }
        System.out.println("===============================================================================================");
    }

    @Override
    public void addPerson(Persons person) {
        persons.add(person);
    }

    @Override
    public void editPerson(Persons person) {
        for (Persons personCurrent : persons) {
            if (personCurrent.getPersonId().equals(person.getPersonId())) {
                if (!(person.getNamePerson().equals("0"))) {
                    personCurrent.setNamePerson(person.getNamePerson());
                }
                if (person.getAge() != 0) {
                    personCurrent.setAge(person.getAge());
                }
                System.out.println("Sửa thông tin khách hàng thành công !!!");
                return;
            }
        }
        System.out.println("* Error: Người dùng ID không tồn tại !!!");
    }

    @Override
    public void personDetailById(String id) {
        int stt = 1;
        System.out.println("===============================================================================================");
        System.out.println("|                          Chi tiết thông tin khách hàng                                      |");
        System.out.printf("| %-3s | %-13s | %-25s | %-5s | %-15s |\n", "Stt", "Khách hàng ID", "Tên khách hàng", "Tuổi", "SL sách đã thuê");

        for (Persons person : persons) {
            if (person.getPersonId().equals(id)) {
                System.out.printf("| %-3d | %-13s | %-25s | %-5s | %-15s |\n",
                        stt, person.getPersonId(), person.getNamePerson(), person.getAge(), person.getHireBooks().size());

                System.out.println("\n                     CHI TIẾT CÁC SÁCH ĐÃ THUÊ !!!");
                System.out.printf("| %-3s | %-7s | %-35s | %-8s | %-10s | %-10s |\n", "Stt", "Sách ID", "Tên sách", "Số lượng", "Ngày thuê", "Ngày trả");
                for (HireBook hireBook : person.getHireBooks()) {
                    for (Books book : books) {
                        if (book.getBookId().equals(hireBook.getBookId())) {
                            System.out.printf("| %-3s | %-7s | %-35s | %-8s | %-10s | %-10s |\n",
                                    stt, hireBook.getBookId(), book.getNameBook(), hireBook.getQuantityHire(), hireBook.getDayHire(), hireBook.getDayBack());
                            stt++;
                        }
                    }
                }
            }
        }
        System.out.println("===============================================================================================");
    }

    @Override
    public void findBookById(int id) {

    }

    @Override
    public void deletePerson(Persons persons) {

    }

    public void addHireBook(String personID, String bookID, int quantity, LocalDate dayHire, LocalDate dayBack) {
        Persons personCurrent = findPersonById(personID);
        Books bookCurrent = findBookById(bookID);
        if (personCurrent == null) {
            System.err.println("Không tìm thấy người dùng ID !!!");
            return;
        } else if (personCurrent.getAge() < 16) {
            System.err.println("Người dùng ID phải trên 16 tuổi để có thể thuê sách !!!");
            return;
        } else if (bookCurrent == null) {
            System.err.println("Không tìm thấy Sách ID !!!");
            return;
        } else if (bookCurrent.getQuantity() == 0 || quantity > bookCurrent.getQuantity()) {
            System.err.println("Số lượng sách bé hơn số lượng bạn đang muốn thuế !!!");
            return;
        } else if (dayBack.isBefore(dayHire)) {
            System.err.print("Ngày trả sách không được nhỏ hơn ngày thuê sách !!!");
        } else {
            // Cập nhật số lượng sách cũ trừ đi số lượng sách người dùng muốn thuê
            bookCurrent.setQuantity(bookCurrent.getQuantity() - quantity);

            personCurrent.addHireBook(bookID, quantity, dayHire, dayBack);
            System.out.println("Thuê sách thành công !!!");
            return;
        }

//        for (Persons person : persons) {
//            // Kiểm tra người dùng ID phải có trong danh sách người dùng trước
//            if (person.getPersonId().equals(personID)) {
//                // Kiểm tra người dùng Id phải lớn hơn 16 tuổi
//                if (person.getAge() > 16) {
//                    // kiểm tra sách ID nhập vào và giàm bớt số lượng khi người dùng thuê sách
//                    for (Books bookCurrent : books) {
//                        // Tìm đúng cuốn sách người dùng muốn thuê
//                        if (bookCurrent.getBookId().equals(bookID)) {
//                            // Kiểm tra số lượng sách mà người dùng muốn thuê có còn thõa mãn hay không ?
//                            if (bookCurrent.getQuantity() > 0 && quantity < bookCurrent.getQuantity()) {
//                                // Cập nhật số lượng sách cũ trừ đi số lượng sách người dùng muốn thuê
//                                bookCurrent.setQuantity(bookCurrent.getQuantity() - quantity);
//
//                                person.addHireBook(bookID, quantity, dayHire, dayBack);
//                                System.out.println("Thuê sách thành công !!!");
//                                return;
//                            } else {
//                                System.out.println("Số lượng sách bé hơn số lượng bạn đang muốn thuế !!!");
//                                return;
//                            }
//                        }
//                    }
//                    System.out.println("Không tìm thấy Sách ID !!!");
//                    return;
//                } else {
//                    System.out.println("Người dùng ID phải trên 16 tuổi để có thể thuê sách !!!");
//                }
//            }
//        }
//        System.out.println("Không tìm thấy người dùng ID !!!");
    }

    //    public void backBook(String personID, String bookID, int quantity, String dayHire) {
    public void backBook(String personID, int sttBook, int quantity) {
        // Tìm người dùng ID
        Persons personCurrent = findPersonById(personID);

        if (personCurrent == null) {
            System.out.println("Không tìm thấy người dùng ID !!!");
            return;
        }

        // Tìm sách đã thuê bằng index
        HireBook hireBookCurrent = null;
        try {
            // trừ 1 để trả về đúng index được chọn
            hireBookCurrent = personCurrent.getHireBooks().get(sttBook - 1);
            if (hireBookCurrent != null) {
                // Tìm Sách ID trong thư viện
                Books bookCurrent = findBookById(hireBookCurrent.getBookId());

                if(quantity > hireBookCurrent.getQuantityHire()) {
                    System.err.println("* Số lượng sách nhập vào không được lớn hơn số lượng sách đã thuê !!!");
                } else if (quantity == hireBookCurrent.getQuantityHire()) {
                    // Nếu Số lượng trả bằng số lượng thuê thì xóa luôn quyển sách đã thuê đó.
                    personCurrent.getHireBooks().remove(hireBookCurrent);
                } else {
                    // Cập nhật lại số lượng sách đã thuê bằng cách trừ đi số lượng thuê
                    hireBookCurrent.setQuantityHire(hireBookCurrent.getQuantityHire() - quantity);
                }
                // Cập nhật lại số lượng sách trong thư viện bằng cách cộng với số lượng hiện tại
                bookCurrent.setQuantity(bookCurrent.getQuantity() + quantity);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index sách không tồn tại !!!");
        }
    }

    public Persons findPersonById(String personID) {
        for (Persons person : persons) {
            if (person.getPersonId().equals(personID)) {
                return person;
            }
        }
        return null;
    }

    public Books findBookById(String bookID) {
        for (Books book : books) {
            if (book.getBookId().equals(bookID)) {
                return book;
            }
        }
        return null;
    }
}
