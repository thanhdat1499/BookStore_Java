/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.dtos;

import java.io.Serializable;


/**
 *
 * @author Admin
 */
public class CartDTO implements Serializable{
    private int bookId;
    private String bookName;
    private int price;
    private int buyingQuantity;
    private int quantity;
    private double totalPrice;

    public CartDTO() {
    }

    public CartDTO(int bookId, String bookName, int price, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.quantity = quantity;
    }

    public CartDTO(int bookId, String bookName, int price, int buyingQuantity, int quantity, double totalPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.buyingQuantity = buyingQuantity;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public CartDTO(int bookId, String bookName, int price, int buyingQuantity, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.buyingQuantity = buyingQuantity;
        this.quantity = quantity;
    }

    
    
    

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPrice() {
        return price;
    }

    public int getBuyingQuantity() {
        return buyingQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBuyingQuantity(int buyingQuantity) {
        this.buyingQuantity = buyingQuantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    
    
    
}
