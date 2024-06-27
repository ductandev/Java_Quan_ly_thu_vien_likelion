package vn.edu.likelion;

import vn.edu.likelion.model.Books;
import vn.edu.likelion.model.HireBook;
import vn.edu.likelion.model.Persons;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int userInputInt() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("* Error: Vui lòng chỉ nhập số nguyên !!!");
                scanner.nextLine(); // Clear invalid input
                System.out.print("Nhập lại: ");
            }
        }
        return choice;
    }

    public static String userInputString() {
        String choise = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                choise = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.err.println("* Error: Vui lòng chỉ nhập ký tự !!!");
                scanner.close();
            }
        }
        return choise;
    }

    public static void showDisplayFunction() {
        System.out.println("=============================================");
        System.out.println("+          ĐỀ 1: QUẢN LÝ THƯ VIỆN           +");
        System.out.println("=============================================");
        System.out.println("|1. Xem tẩt cả sách có trong thư viện.      |");
        System.out.println("|2. Thêm sách.                              |");
        System.out.println("|3. Sửa sách.                               |");
        System.out.println("|4. Xóa sách.                               |");
        System.out.println("|5. Xem danh sách khách hàng.               |");
        System.out.println("|6. Thêm khách hàng.                        |");
        System.out.println("|7. Sửa thông tin khách hàng.               |");
        System.out.println("|8. Xem chi tiết khách hàng.                |");
        System.out.println("|9. Thuê sách.                              |");
        System.out.println("|10. Trả sách.                              |");
        System.out.println("|0. Exit                                    |");
        System.out.println("=============================================");
        System.out.print("Chọn mục tương ứng: ");
    }

    // Case 1
    public static void getAllBooks(Library library) {
        library.showAllBooks();
    }

    public static void addBook(Library library) {
        // Show allBook
        library.showAllBooks();

        System.out.print("Nhập vào Sách ID: ");
        String bookId = userInputString();
        System.out.print("Nhập vào Tên sách: ");
        String bookName = userInputString();
        System.out.print("Nhập vào tác giả: ");
        String author = userInputString();
        System.out.print("Nhập vào số luợng sách: ");
        int quantity = userInputInt();
        library.addBook(new Books(bookId, bookName, author, quantity));

        // Show allBook
        library.showAllBooks();
    }

    public static void editBook(Library library) {
        // Show allBook
        library.showAllBooks();

        System.out.print("Nhập vào Sách ID: ");
        String bookId = userInputString();

        System.err.println("* Lưu ý, nếu không muốn thay đổi giá trị nào, hãy nhập '0'!!!");
        System.out.println("");

        System.out.print("Nhập vào Tên sách: ");
        String bookName = userInputString();
        System.out.print("Nhập vào tác giả: ");
        String author = userInputString();
        System.out.print("Nhập vào số luợng sách: ");
        int quantity = userInputInt();

        Books books = new Books(bookId, bookName, author, quantity);
        library.editBook(books);

        // Show allBook
        library.showAllBooks();
    }

    public static void deleteBook(Library library) {
        // Show allBook
        library.showAllBooks();

        System.out.print("Nhập vào Sách ID: ");
        String bookId = userInputString();
        library.deleteBook(bookId);

        // Show allBook
        library.showAllBooks();
    }

    // Case 2
    public static void getAllPerson(Library library){
        library.showAllPerson();
    }

    public static void addPerson(Library library) {
        // Show allPerson
        library.showAllPerson();

        System.out.print("Nhập vào ID khách hàng: ");
        String personID = userInputString();
        System.out.print("Nhập vào tên khách hàng: ");
        String personName = userInputString();
        System.out.print("Nhập vào tuổi khách hàng: ");
        int age = userInputInt();
        library.addPerson(new Persons(personID, personName, age, new ArrayList<HireBook>()));

        System.out.println("Thêm khách hàng mới thành công !!!");
        // Show allPerson
        library.showAllPerson();
    }

    public static void editPerson(Library library) {
        // Show allPerson
        library.showAllPerson();

        System.out.print("Nhập vào ID khách hàng: ");
        String personID = userInputString();
        System.out.print("Nhập vào tên khách hàng: ");
        String personName = userInputString();
        System.out.print("Nhập vào tuổi khách hàng: ");
        int age = userInputInt();
        Persons persons = new Persons(personID, personName, age, new ArrayList<HireBook>());
        library.editPerson(persons);

        //Show allPerson
        library.showAllPerson();
    }

    public static void personDetail(Library library) {
        //Show allPerson
        library.showAllPerson();

        System.out.print("Nhập vào ID khách hàng: ");
        String personID = userInputString();
        library.personDetailById(personID);
    }

    public static void hireBookByUserID(Library library) {
        library.showAllBooks();
        library.showAllPerson();

        System.out.print("Nhập vào ID khách hàng: ");
        String personID = userInputString();
        System.out.print("Nhập vào Sách ID: ");
        String bookID = userInputString();
        System.out.print("Nhập vào số lượng muốn thuê: ");
        int quantity = userInputInt();
        LocalDate dayHire = LocalDate.now();
        System.out.print("Nhập vào số ngày muốn thuê: ");
        int number = userInputInt();
        LocalDate dayBack = dayHire.plusDays(number);

        library.addHireBook(personID, bookID, quantity, dayHire, dayBack);
        // Show detail book rent by id
        library .personDetailById(personID);
    }

    public static void backBookByUserID(Library library){
        library.showAllPerson();

        System.out.print("Nhập vào ID khách hàng muốn trả sách: ");
        String personID = userInputString();
        // In ra chi tiết người dùng đã thuê
        library.personDetailById(personID);

        System.out.print("Nhập vào số thứ tự Sách muốn trả: ");
        int indexBook = userInputInt();
        System.out.print("Nhập vào số lượng sách muốn trả: ");
        int quantity = userInputInt();

        library.backBook(personID, indexBook, quantity);

        // In ra chi tiết người dùng đã thuê
        library.personDetailById(personID);
    }



    public static void main(String[] args) {
        // Rạo dữ liệu cứng
        Library library = new Library();
        library.addBook(new Books("B01", "Đắc nhân tâm", "Dale Carnegie", 100));
        library.addBook(new Books("B02", "Quẳng gánh lo đi mà vui sống", "Dale Carnegie", 100));
        library.addBook(new Books("B03", "Nhà giả kim", "Paulo Coelho", 100));
        library.addBook(new Books("B04", "Luật hấp dẫn bí mật tối cao", "Jack Canfield", 100));

        LocalDate dayHire = LocalDate.now();
        LocalDate dayBack = dayHire.plusDays(30);
        HireBook hireBook = new HireBook("B03", 5, dayHire, dayBack);
        HireBook hireBook2 = new HireBook("B01", 5, dayHire, dayBack);
        HireBook hireBook3 = new HireBook("B02", 5, dayHire, dayBack);

        ArrayList<HireBook> hireBooks = new ArrayList<>();
        hireBooks.add(hireBook);
        hireBooks.add(hireBook2);
        hireBooks.add(hireBook3);

        library.addPerson(new Persons( "P01","Nguyễn Đức Tấn", 26, hireBooks));

        while (true) {
            showDisplayFunction();
            int choice = userInputInt();
            switch (choice) {
                case 1:
                    getAllBooks(library);
                    break;
                case 2:
                    addBook(library);
                    break;
                case 3:
                    editBook(library);
                    break;
                case 4:
                    deleteBook(library);
                    break;
                case 5:
                    getAllPerson(library);
                    break;
                case 6:
                    addPerson(library);
                    break;
                case 7:
                    editPerson(library);
                    break;
                case 8:
                    personDetail(library);
                    break;
                case 9:
                    hireBookByUserID(library);
                    break;
                case 10:
                    backBookByUserID(library);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}