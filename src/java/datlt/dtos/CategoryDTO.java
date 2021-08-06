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
public class CategoryDTO implements Serializable{
    private int categoryId;
    private String categoryName;
    private int status;

    public CategoryDTO() {
    }

    public CategoryDTO(int categoryId, String categoryName, int status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getStatus() {
        return status;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
}
