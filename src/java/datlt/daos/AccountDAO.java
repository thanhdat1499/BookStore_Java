/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.daos;

import datlt.conn.MyConnection;
import datlt.dtos.AccountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public AccountDAO() {
    }

    private void closeConnection() {
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

    public AccountDTO login(String username, String password) throws Exception {

        AccountDTO account = null;
        try {
            String sql = "SELECT [UserID]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Password]\n"
                    + "      ,[FullName]\n"
                    + "      ,[Address]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Role]\n"
                    + "  FROM [dbo].[Account]\n"
                    + "  WHERE [UserName] LIKE ? AND [Password] LIKE ? AND Status = 1";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {

                int userId = rs.getInt("UserId");
                String fullname = rs.getString("FullName");
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                int role = rs.getInt("Role");
                account = new AccountDTO(userId, username, password, fullname, address, phone, role);

            }
        } finally {
            closeConnection();
        }
        return account;
    }

    public boolean insertAccount(AccountDTO account) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO [dbo].[Account]\n"
                    + "           ([UserName]\n"
                    + "           ,[Password]\n"
                    + "           ,[FullName]\n"
                    + "           ,[Address]\n"
                    + "           ,[Phone]\n"
                    + "           ,[Role]\n"
                    + "           ,[Status])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?)";

            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUserName());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getFullName());
            ps.setString(4, account.getAddress());
            ps.setString(5, account.getPhone());
            ps.setInt(6, account.getRole());
            ps.setInt(7, account.getStatus());
            

            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
