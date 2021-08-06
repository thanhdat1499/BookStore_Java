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
public class OrderDetailDTO implements Serializable{
    private int orderDetailId;
    private int orderId;
    private int bookId;
    private String bookName;
    private int bookPrice;
    private int boughtQuantity;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderDetailId, int orderId, int bookId, String bookName, int bookPrice, int boughtQuantity) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.boughtQuantity = boughtQuantity;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public int getBoughtQuantity() {
        return boughtQuantity;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBoughtQuantity(int boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }

    

    
    
}
