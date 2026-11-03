package demo3;



import java.util.ArrayList;
import java.util.List;

public class Member {
    private int id;
    private String name;
    private String email;
    private List<Integer> borrowedBooks;

    public Member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBook(int bookId) {
        borrowedBooks.add(bookId);
    }

    public void removeBook(int bookId) {
        borrowedBooks.remove(Integer.valueOf(bookId));
    }

    @Override
    public String toString() {
        return "Member ID: " + id +
                " | Name: " + name +
                " | Email: " + email +
                " | Books Borrowed: " + borrowedBooks.size();
    }
}