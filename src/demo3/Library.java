package demo3;


import java.util.*;

public class Library {

    private Map<Integer, Book> books;
    private Map<Integer, Member> members;

    public Library() {
        books = new LinkedHashMap<>();
        members = new LinkedHashMap<>();

        loadSampleData();
    }

    private void loadSampleData() {
        addBook(new Book(101, "Clean Code", "Robert C. Martin"));
        addBook(new Book(102, "Effective Java", "Joshua Bloch"));
        addBook(new Book(103, "The Alchemist", "Paulo Coelho"));
        addBook(new Book(104, "Atomic Habits", "James Clear"));
        addBook(new Book(105, "Java Programming", "Herbert Schildt"));

        addMember(new Member(1, "Rohan", "rohan@example.com"));
        addMember(new Member(2, "Rahul", "rahul@example.com"));
        addMember(new Member(3, "Ananya", "ananya@example.com"));
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    public void displayBooks() {
        System.out.println("\n========== BOOK COLLECTION ==========");

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void displayMembers() {
        System.out.println("\n========== REGISTERED MEMBERS ==========");

        for (Member member : members.values()) {
            System.out.println(member);
        }
    }

    public void searchBook(String keyword) {
        boolean found = false;

        System.out.println("\nSearch Results:");

        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    public void borrowBook(int bookId, int memberId)
            throws LibraryException {

        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null) {
            throw new LibraryException("Book not found.");
        }

        if (member == null) {
            throw new LibraryException("Member not found.");
        }

        if (!book.isAvailable()) {
            throw new LibraryException("This book is already borrowed.");
        }

        book.borrowBook(memberId);
        member.addBook(bookId);

        System.out.println("Book borrowed successfully!");
    }

    public void returnBook(int bookId, int memberId)
            throws LibraryException {

        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            throw new LibraryException("Invalid book or member ID.");
        }

        if (book.isAvailable()) {
            throw new LibraryException("This book is not currently borrowed.");
        }

        if (book.getBorrowedBy() != memberId) {
            throw new LibraryException("This book belongs to another member's borrowing record.");
        }

        book.returnBook();
        member.removeBook(bookId);

        System.out.println("Book returned successfully!");
    }

    public void displayMemberBooks(int memberId)
            throws LibraryException {

        Member member = members.get(memberId);

        if (member == null) {
            throw new LibraryException("Member not found.");
        }

        System.out.println("\nBooks borrowed by " + member.getName() + ":");

        if (member.getBorrowedBooks().isEmpty()) {
            System.out.println("No books currently borrowed.");
            return;
        }

        for (int bookId : member.getBorrowedBooks()) {
            System.out.println(books.get(bookId));
        }
    }

    public void displayStatistics() {
        int totalBooks = books.size();
        int borrowedBooks = 0;

        for (Book book : books.values()) {
            if (!book.isAvailable()) {
                borrowedBooks++;
            }
        }

        System.out.println("\n========== LIBRARY STATISTICS ==========");
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Available Books: " + (totalBooks - borrowedBooks));
        System.out.println("Borrowed Books: " + borrowedBooks);
        System.out.println("Registered Members: " + members.size());
    }
}