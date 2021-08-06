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
public class OrderBookDTO implements Serializable{
    private int orderId;
    private int userId;
    private Date createDate;
    private float totalPrice;
    private int discountId;

    public OrderBookDTO() {
    }

    public OrderBookDTO(int orderId, int userId, Date createDate, float totalPrice, int discountId) {
        this.orderId = orderId;
        this.userId = userId;
        this.createDate = createDate;
        this.totalPrice = totalPrice;
        this.discountId = discountId;
    }

    public OrderBookDTO(int userId, float totalPrice) {
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    public OrderBookDTO(int userId, float totalPrice, int discountId) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.discountId = discountId;
    }
    
    

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    
}
