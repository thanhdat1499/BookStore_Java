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
public class DiscountCodeDTO implements Serializable{
    private int disId;
    private String disName;
    private int disPercent;
    private Date disDate;

    public DiscountCodeDTO() {
    }

    public DiscountCodeDTO(int disId, String disName, int disPercent, Date disDate) {
        this.disId = disId;
        this.disName = disName;
        this.disPercent = disPercent;
        this.disDate = disDate;
    }

    public DiscountCodeDTO(int disId, String disName, int disPercent) {
        this.disId = disId;
        this.disName = disName;
        this.disPercent = disPercent;
    }
    
    

    public int getDisId() {
        return disId;
    }

    public String getDisName() {
        return disName;
    }

    public int getDisPercent() {
        return disPercent;
    }

    public Date getDisDate() {
        return disDate;
    }

    public void setDisId(int disId) {
        this.disId = disId;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public void setDisPercent(int disPercent) {
        this.disPercent = disPercent;
    }

    public void setDisDate(Date disDate) {
        this.disDate = disDate;
    }

    
}
