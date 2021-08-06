/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.daos;

import datlt.conn.MyConnection;
import datlt.dtos.DiscountCodeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DiscountDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public DiscountDAO() {
    }

    private void closeConnection(){
        try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public DiscountCodeDTO findDiscountByDisName(String discountName) throws Exception {
        
        DiscountCodeDTO discount = null;
        try {
            String sql = "SELECT DisId \n"
                    + "      , DisPercent \n"
                    + "  FROM DiscountCode \n"
                    + "  WHERE [DisName] LIKE ? ";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, discountName);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                int disId = rs.getInt("DisId");                
                int percent = rs.getInt("DisPercent");
                discount = new DiscountCodeDTO(disId, discountName, percent);
                
            }
        }  finally {
            closeConnection();
        }
        return discount;
    }
    
    public boolean checkDiscount(int discounId, int userId) throws Exception {
        
        boolean used = false;
        try {
            String sql = "SELECT [Id] \n"
                    + "  FROM [dbo].[DiscountUsed] \n"
                    + "  WHERE [UserId] = ? AND [discountId] = ? ";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, discounId);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                used = true;
                
            }
        }  finally {
            closeConnection();
        }
        return used;
    }
    
    public boolean insertIntoDiscountUsed(int userId, int discountId) throws  Exception{
        boolean check = false;
        try{
            String sql = "Insert Into DiscountUsed(UserId, discountId) "
                    + "values(?,?)";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, discountId);
            
            check = ps.executeUpdate() > 0 ;
        }finally{
            closeConnection();
        }
        return check;
    }
}
