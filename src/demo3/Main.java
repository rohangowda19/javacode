
package demo3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice = -1;

        System.out.println("======================================");
        System.out.println("       LIBRARY MANAGEMENT SYSTEM      ");
        System.out.println("======================================");

        do {

            System.out.println("\n-------------- MAIN MENU -------------");
            System.out.println("1. Display All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Members");
            System.out.println("6. View Member's Books");
            System.out.println("7. Library Statistics");
            System.out.println("0. Exit");
            System.out.println("--------------------------------------");

            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:
                        library.displayBooks();
                        break;

                    case 2:
                        System.out.print("Enter book title or author: ");
                        String keyword = scanner.nextLine();
                        library.searchBook(keyword);
                        break;

                    case 3:
                        System.out.print("Enter Book ID: ");
                        int borrowId = scanner.nextInt();

                        System.out.print("Enter Member ID: ");
                        int borrowMember = scanner.nextInt();

                        library.borrowBook(borrowId, borrowMember);
                        break;

                    case 4:
                        System.out.print("Enter Book ID: ");
                        int returnId = scanner.nextInt();

                        System.out.print("Enter Member ID: ");
                        int returnMember = scanner.nextInt();

                        library.returnBook(returnId, returnMember);
                        break;

                    case 5:
                        library.displayMembers();
                        break;

                    case 6:
                        System.out.print("Enter Member ID: ");
                        int memberId = scanner.nextInt();

                        library.displayMemberBooks(memberId);
                        break;

                    case 7:
                        library.displayStatistics();
                        break;

                    case 0:
                        System.out.println(
                            "Thank you for using the Library System!"
                        );
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (LibraryException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {

                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }

        } while (choice != 0);

        scanner.close();
    }
}
