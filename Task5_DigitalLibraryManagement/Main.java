import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LibraryService library =
                new LibraryService();

        while(true) {

            System.out.println("\n===== DIGITAL LIBRARY =====");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Add User");
            System.out.println("7. View Users");
            System.out.println("8. Delete User");
            System.out.println("9. Issue Book");
            System.out.println("10. Return Book");
            System.out.println("11. View Issued Books");
            System.out.println("12. Exit");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    library.addBook(
                            new Book(id,title,
                                    author,category));

                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String search =
                            sc.nextLine();

                    library.searchBook(search);

                    break;

                case 4:

    System.out.print("Book ID: ");
    int updateId = sc.nextInt();
    sc.nextLine();

    System.out.print("New Title: ");
    String newTitle = sc.nextLine();

    System.out.print("New Author: ");
    String newAuthor = sc.nextLine();

    System.out.print("New Category: ");
    String newCategory = sc.nextLine();

    library.updateBook(updateId, newTitle, newAuthor, newCategory);

    break;

case 5:

    System.out.print("Enter Book ID: ");
    int deleteBookId = sc.nextInt();

    library.deleteBook(deleteBookId);

    break;

case 6:

    System.out.print("User ID: ");
    int userId = sc.nextInt();
    sc.nextLine();

    System.out.print("Name: ");
    String name = sc.nextLine();

    System.out.print("Email: ");
    String email = sc.nextLine();

    library.addUser(new User(userId, name, email));

    break;

case 7:

    library.viewUsers();

    break;

case 8:

    System.out.print("Enter User ID: ");
    int deleteUserId = sc.nextInt();

    library.deleteUser(deleteUserId);

    break;

case 9:

    System.out.print("User ID: ");
    int issueUserId = sc.nextInt();

    System.out.print("Book ID: ");
    int issueBookId = sc.nextInt();

    library.issueBook(issueUserId, issueBookId);

    break;

case 10:

    System.out.print("Issue ID: ");
    int issueId = sc.nextInt();

    library.returnBook(issueId);

    break;

case 11:

    library.viewIssuedBooks();

    break;

case 12:

    System.exit(0);

              break;
            }
        }
    }
}