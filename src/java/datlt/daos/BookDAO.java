/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.daos;

import datlt.conn.MyConnection;
import datlt.dtos.BookDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BookDAO {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public BookDAO() {
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumberPage() {
        int countPage = 0;
        try {
            String sql = "Select count(*) From Book Where BookStatus = 1 AND Quantity > 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);

                countPage = total / 4;
                if (total % 4 != 0) {
                    countPage++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return countPage;
    }

    public List<BookDTO> getPaging(int index) {
        List<BookDTO> result = null;

        String bookName, description, author, image;
        int bookId, categoryId, price, quantity;

        BookDTO dto = null;

        try {
            String sql = "Select BookId, categoryId, BookName, BookDescription, Author, Images, Quantity ,Price "
                    + " From Book\n"
                    + " Where BookStatus = 1 AND Quantity > 0\n"
                    + " order by BookId\n"
                    + " OFFSET ? ROWS \n"
                    + " FETCH FIRST 4 ROWS ONLY;";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, (index - 1) * 4);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                bookId = rs.getInt("BookId");
                categoryId = rs.getInt("categoryId");
                bookName = rs.getString("BookName");
                description = rs.getString("BookDescription");
                author = rs.getString("Author");
                image = rs.getString("Images");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");

                dto = new BookDTO(bookId, categoryId, bookName, description, author, image, quantity, price);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();

        }
        return result;
    }

    public BookDTO findByPrimaryKey(int id) throws Exception {
        BookDTO dto = null;
        try {
            String sql = "Select BookName, Quantity, Price, Author, BookDescription, Images  From Book Where BookId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String bookName = rs.getString("BookName");
                int quantity = rs.getInt("Quantity");
                int price = rs.getInt("Price");
                String author = rs.getString("Author");
                String description = rs.getString("BookDescription");
                String images = rs.getString("Images");

                dto = new BookDTO(id, bookName, description, author, images, quantity, price);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateQuantity(int bookId, int newQuantity) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Book SET Quantity = ? WHERE BookId = ? ";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, newQuantity);
            preStm.setInt(2, bookId);

            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public ArrayList<BookDTO> searchBookByName(String name) {
        ArrayList<BookDTO> result = null;

        String bookName, description, author, image;
        int bookId, categoryId, price, quantity;

        BookDTO dto = null;

        try {
            String sql = "Select BookId, categoryId, BookName, BookDescription, Author, Images, Quantity ,Price "
                    + " From Book \n"
                    + " Where BookStatus = 1 AND Quantity > 0 AND BookName LIKE ? \n";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                bookId = rs.getInt("BookId");
                categoryId = rs.getInt("categoryId");
                bookName = rs.getString("BookName");
                description = rs.getString("BookDescription");
                author = rs.getString("Author");
                image = rs.getString("Images");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");

                dto = new BookDTO(bookId, categoryId, bookName, description, author, image, quantity, price);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();

        }
        return result;
    }

    public boolean updateBookStatus(int bookId) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Book SET BookStatus = 0 WHERE BookId = ? ";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, bookId);

            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateBookByAdmin(BookDTO book) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE Book SET BookName = ?"
                    + " , BookDescription = ? "
                    + " , Author = ? "
                    + " , Images = ? "
                    + " , Quantity = ? "
                    + " , Price = ? "
                    + "  WHERE BookId = ? ";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, book.getBookName());
            preStm.setString(2, book.getDescription());
            preStm.setString(3, book.getAuthor());
            preStm.setString(4, book.getImage());
            preStm.setInt(5, book.getQuantity());
            preStm.setInt(6, book.getPrice());
            preStm.setInt(7, book.getBookId());

            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertBookByAdmin(BookDTO book) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO [dbo].[Book]\n"
                    + "           ([BookName]\n"
                    + "           ,[BookDescription]\n"
                    + "           ,[Author]\n"
                    + "           ,[Images]\n"
                    + "           ,[Quantity]\n"
                    + "           ,[Price]\n"
                    + "           ,[BookStatus]\n"
                    + "           ,[categoryId])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?)";

            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, book.getBookName());
            preStm.setString(2, book.getDescription());
            preStm.setString(3, book.getAuthor());
            preStm.setString(4, book.getImage());
            preStm.setInt(5, book.getQuantity());
            preStm.setInt(6, book.getPrice());
            preStm.setInt(7, book.getStatus());
            preStm.setInt(8, book.getCategoryId());

            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
