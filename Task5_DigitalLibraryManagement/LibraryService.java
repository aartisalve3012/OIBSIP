import java.sql.*;

public class LibraryService {

    // ADD BOOK
    public void addBook(Book book) {

        try {
            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO books VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getCategory());

            ps.executeUpdate();

            System.out.println("Book Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW BOOKS
    public void viewBooks() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM books");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("title") + " " +
                        rs.getString("author") + " " +
                        rs.getString("category"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH BOOK
    public void searchBook(String title) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM books WHERE title=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, title);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("title") + " " +
                        rs.getString("author") + " " +
                        rs.getString("category"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE BOOK
    public void updateBook(int id, String title,
                           String author, String category) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE books SET title=?, author=?, category=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, category);
            ps.setInt(4, id);

            int rows =
                    ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book Updated Successfully!");
            else
                System.out.println("Book Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE BOOK
    public void deleteBook(int id) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "DELETE FROM books WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book Deleted Successfully!");
            else
                System.out.println("Book Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ISSUE BOOK
    public void issueBook(int userId, int bookId) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO issued_books(userId,bookId,issueDate) VALUES(?,?,CURDATE())";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);
            ps.setInt(2, bookId);

            int rows =
                    ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book Issued Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // RETURN BOOK
    public void returnBook(int issueId) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE issued_books SET returnDate=CURDATE() WHERE issueId=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, issueId);

            int rows =
                    ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book Returned Successfully!");
            else
                System.out.println("Issue ID Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW ISSUED BOOKS
    public void viewIssuedBooks() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM issued_books");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("issueId") + " " +
                        rs.getInt("userId") + " " +
                        rs.getInt("bookId") + " " +
                        rs.getDate("issueDate") + " " +
                        rs.getDate("returnDate"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }  

// ADD USER
public void addUser(User user) {

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "INSERT INTO users VALUES(?,?,?)";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, user.getUserId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getEmail());

        ps.executeUpdate();

        System.out.println("User Added Successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}





    // VIEW USERS
    public void viewUsers() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM users");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("userId") + " " +
                        rs.getString("name") + " " +
                        rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE USER
    public void deleteUser(int userId) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "DELETE FROM users WHERE userId=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);

            int rows =
                    ps.executeUpdate();

            if (rows > 0)
                System.out.println("User Deleted Successfully!");
            else
                System.out.println("User Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}