package demo3;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;
    private int borrowedBy;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.borrowedBy = -1;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getBorrowedBy() {
        return borrowedBy;
    }

    public void borrowBook(int memberId) {
        if (!available) {
            throw new IllegalStateException("Book is already borrowed.");
        }

        available = false;
        borrowedBy = memberId;
    }

    public void returnBook() {
        if (available) {
            throw new IllegalStateException("Book is already available.");
        }

        available = true;
        borrowedBy = -1;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | Status: " + (available ? "Available" : "Borrowed");
    }
}