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
public class DiscountUsedDTO implements Serializable{
    private int id;
    private int discountId;
    private int userId;

    public DiscountUsedDTO() {
    }

    public DiscountUsedDTO(int id, int discountId, int userId) {
        this.id = id;
        this.discountId = discountId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getDiscountId() {
        return discountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
