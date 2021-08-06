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
public class AccountDTO implements Serializable{
    private int userId;
    private String userName;
    private String password;
    private String fullName;
    private String address;
    private String phone;
    private int role;
    private int status;
    private Date createDate;

    public AccountDTO() {
    }

    public AccountDTO(int userId, String userName, String password, String fullName, String address, String phone, int role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public AccountDTO(String userName, String password, String fullName, String address, String phone, int role, int status) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }

    public AccountDTO(String userName, String password, String fullName, String address, String phone) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }
    
    

    public AccountDTO(int userId, String userName, String password, String fullName, String address, String phone, int role, int status, Date createDate) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.status = status;
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getRole() {
        return role;
    }

    public int getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
}
