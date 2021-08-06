/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BookDTO implements Serializable{
    private int bookId;
    private int categoryId;
    private String bookName, description, author, image;
    private int quantityBuying;
    private int quantity;
    private int price;
    private Date createDate;
    private int status;

    public BookDTO() {
    }

    public BookDTO(int bookId, String bookName, int quantity, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.price = price;
    }
    

    public BookDTO(int categoryId, String bookName, String description, String author, String image, int quantity, int price, int status) {
        this.categoryId = categoryId;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }
    
    

    public BookDTO(int bookId, int categoryId, String bookName, String description, String author, String image, int quantity, int price, Date createDate, int status) {
        this.bookId = bookId;
        this.categoryId = categoryId;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.createDate = createDate;
        this.status = status;
    }

    public BookDTO(int bookId, int categoryId, String bookName, String description, String author, String image, int quantity, int price) {
        this.bookId = bookId;
        this.categoryId = categoryId;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }

    public BookDTO(int bookId, String bookName, int quantityBuying, int quantity, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantityBuying = quantityBuying;
        this.quantity = quantity;
        this.price = price;
    }

    public BookDTO(int bookId, String bookName, String description, String author, String image, int quantity, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }

    
    
    

    public BookDTO(int bookId, int categoryId, String bookName, String description, String author, String image, int quantityBuying, int quantity, int price, Date createDate, int status) {
        this.bookId = bookId;
        this.categoryId = categoryId;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.image = image;
        this.quantityBuying = quantityBuying;
        this.quantity = quantity;
        this.price = price;
        this.createDate = createDate;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getImage() {
        return image;
    }

    public int getQuantityBuying() {
        return quantityBuying;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setQuantityBuying(int quantityBuying) {
        this.quantityBuying = quantityBuying;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "bookId=" + bookId + ", categoryId=" + categoryId + ", bookName=" + bookName + ", description=" + description + ", author=" + author + ", image=" + image + ", quantityBuying=" + quantityBuying + ", quantity=" + quantity + ", price=" + price + ", createDate=" + createDate + ", status=" + status + '}';
    }

    
    
    
}
