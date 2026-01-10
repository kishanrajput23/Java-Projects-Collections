package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.javatpoint.beans.AccountantBean;
import com.javatpoint.beans.StudentBean;

public class AccountantDao {

    public static int save(AccountantBean bean) {
        try (Connection con = DB.getCon();
             PreparedStatement ps = con.prepareStatement("INSERT INTO fee_accountant (name, email, password, address, contact) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getEmail());
            ps.setString(3, bean.getPassword());
            ps.setString(4, bean.getAddress());
            ps.setString(5, bean.getContact());
            return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static boolean validate(String email, String password) {
        try (Connection con = DB.getCon();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM fee_accountant WHERE email=? AND password=?")) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static int update(AccountantBean bean) {
        try (Connection con = DB.getCon();
             PreparedStatement ps = con.prepareStatement("UPDATE fee_accountant SET name=?, email=?, password=?, address=?, contact=? WHERE id=?")) {
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getEmail());
            ps.setString(3, bean.getPassword());
            ps.setString(4, bean.getAddress());
            ps.setString(5, bean.getContact());
            ps.setInt(6, bean.getId());
            return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static int delete(int id) {
        try (Connection con = DB.getCon();
             PreparedStatement ps = con.prepareStatement("DELETE FROM fee_accountant WHERE id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static List<AccountantBean> getAllRecords() {
        List<AccountantBean> list = new ArrayList<>();
        try (Connection con = DB.getCon();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM fee_accountant");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AccountantBean bean = new AccountantBean();
                bean.setId(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setPassword(rs.getString(4));
                bean.setAddress(rs.getString(5));
                bean.setContact(rs.getString(6));
                list.add(bean);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static AccountantBean getRecordById(int id) {
        try (Connection con = DB.getCon();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM fee_accountant WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    AccountantBean bean = new AccountantBean();
                    bean.setId(rs.getInt(1));
                    bean.setName(rs.getString(2));
                    bean.setEmail(rs.getString(3));
                    bean.setPassword(rs.getString(4));
                    bean.setAddress(rs.getString(5));
                    bean.setContact(rs.getString(6));
                    return bean;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
