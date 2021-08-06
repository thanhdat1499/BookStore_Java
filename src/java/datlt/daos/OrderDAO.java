/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.daos;

import datlt.conn.MyConnection;
import datlt.dtos.CartDTO;

import datlt.dtos.OrderBookDTO;
import datlt.dtos.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class OrderDAO {
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public OrderDAO() {
    }

    
    
    private void closeConnection(){
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
    
    public int addOrderReturnId(OrderBookDTO order) throws Exception {
        try {
            String sql = "INSERT INTO [dbo].[OrderBook]\n"
                    + "           ([UserId]\n"
                    + "           ,[TotalPrice]\n"
                    + "           ,[discountId])\n"
                    + "     VALUES(?,?,?)\n";
                    
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preStm.setInt(1, order.getUserId());
            preStm.setFloat(2, order.getTotalPrice());
            preStm.setInt(3, order.getDiscountId());


            if (preStm.executeUpdate() != 0) {
                rs = preStm.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return 0;
    }
    
    public int addOrderDetailReturnId(ArrayList<CartDTO> listCart, int orderId) throws Exception {
        try {
            String sql = "INSERT INTO OrderDetail \n"
                    + "           ([OrderId]\n"
                    + "           ,[BookId]\n"
                    + "           ,[BookName]\n"
                    + "           ,[BookPrice]\n"
                    + "           ,[BoughtQuantity])\n"
                    + "     VALUES(?,?,?,?,?)\n";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);

            int[] arr = {};
            for (CartDTO cart : listCart) {
                preStm.setInt(1, orderId);
                preStm.setInt(2, cart.getBookId());
                preStm.setString(3, cart.getBookName());
                preStm.setInt(4, cart.getPrice());
                preStm.setInt(5, cart.getBuyingQuantity());
                preStm.addBatch();
            }

            arr = preStm.executeBatch();
            return arr.length;

        }catch (Exception e) {
            e.printStackTrace();
        }  
        finally {
            closeConnection();
        }
        return 0;
    }
    
    public ArrayList<OrderBookDTO> getAllOrdersOfAccount(int userId) throws Exception {
        try {
            String sql = "SELECT [OrderId] \n"
                    + "      ,[UserId] \n"
                    + "      ,[CreateDate] \n"
                    + "      ,[TotalPrice] \n"
                    + "      ,[discountId] \n"
                    + "  FROM [dbo].[OrderBook] \n"
                    + "  WHERE [UserId] = ? ";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, userId);
            rs = preStm.executeQuery();

            ArrayList<OrderBookDTO> listOrder = new ArrayList<>();
            while (rs.next()) {
                OrderBookDTO order = new OrderBookDTO(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getFloat(4), rs.getInt(5));
                listOrder.add(order);
            }
            return listOrder;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    
    
    
    public ArrayList<OrderDetailDTO> getDetailByOrderId(int orderId) throws Exception {
        try {
            String sql = "SELECT [OrderDetailId] \n"
                    + "      ,[OrderId] \n"
                    + "      ,[BookId] \n"
                    + "      ,[BookName] \n"
                    + "      ,[BookPrice] \n"
                    + "      ,[BoughtQuantity] \n"
                    + "  FROM [dbo].[OrderDetail] \n"
                    + "  WHERE [OrderId] = ? ";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, orderId);
            rs = preStm.executeQuery();

            ArrayList<OrderDetailDTO> listDetail = new ArrayList<>();
            while (rs.next()) {
                OrderDetailDTO detail = new OrderDetailDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                listDetail.add(detail);
            }
            return listDetail;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
}
