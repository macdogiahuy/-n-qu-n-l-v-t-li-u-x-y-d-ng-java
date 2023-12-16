/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;

public class SanPhamDAO implements DAOInterface<SanPham> {

    public static SanPhamDAO getInstance() {
        return new SanPhamDAO();
    }

    @Override
    public int insert(SanPham t) {
       int ketqua=0;
       try {
           Connection con = JDBCUtil.getConnection();
           String sql = "INSERT sanpham (maSP,tenSP,soLuong,gia,phanLoai,xuatXu,trangThai) VALUES (?,?,?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,t.getMaSP());
           pst.setString(2,t.getTenSP());
           pst.setInt(3,t.getSoLuong());
           pst.setDouble(4, t.getGia());
           pst.setString(5, t.getPhanLoai());
           pst.setString(6, t.getXuatXu());
           pst.setInt(7, t.getTrangThai());
           ketqua = pst.executeUpdate();
           pst.close();
           con.close();
       } catch (Exception e) {
            e.printStackTrace();
       }
       return ketqua;
       
    }

    @Override
    public int update(SanPham t) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sanpham SET tenSP = ?,soLuong=?,gia=?,xuatXu=?,trangThai=? WHERE maSP=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenSP());
            pst.setInt(2, t.getSoLuong());
            pst.setDouble(3, t.getGia());
            pst.setString(4, t.getXuatXu());
            pst.setInt(5, t.getTrangThai());
            pst.setString(6, t.getMaSP());
            ketqua = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }

    @Override
    public int delete(SanPham t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM MayTinh WHERE maSP=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaSP());
            ketQua = pst.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maSP,tenSP,soLuong,gia,phanLoai,xuatXu,trangThai FROM SanPham";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia"); 
                String phanLoai = rs.getString("phanLoai");
                String xuatXu = rs.getString("xuatXu");                     
                int trangThai = rs.getInt("trangThai");
                SanPham sp = new SanPham(maSP, tenSP, soLuong, gia, phanLoai, xuatXu, trangThai);
                ketQua.add(sp);
            }
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public SanPham selectById(String t) {
        SanPham ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maSP,tenSP,soLuong,gia,phanLoai,xuatXu,trangThai FROM SanPham WHERE maSP = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String phanLoai = rs.getString("phanLoai");
                String xuatXu = rs.getString("xuatXu");
                int trangThai = rs.getInt("trangThai");
                ketQua = new SanPham(maSP, tenSP, soLuong, gia, phanLoai, xuatXu, trangThai);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public int updateSoLuong(String maSP, int soluong) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            //String sql = "INSERT INTO MayTinh (maMay, tenMay, soLuong, tenCpu, ram, cardManHinh, gia, dungLuongPin, dungLuongPin, dungLuongPin, loaiMay, rom) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql = "UPDATE sanpham SET soLuong=? WHERE maSP=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, soluong);
            pst.setString(2, maSP);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public int deleteTrangThai(String maSP){
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            //String sql = "INSERT INTO MayTinh (maMay, tenMay, soLuong, tenCpu, ram, cardManHinh, gia, dungLuongPin, dungLuongPin, dungLuongPin, loaiMay, rom) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql = "UPDATE sanpham SET trangThai=0 WHERE maSP=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maSP);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<SanPham> selectAllE() {
        ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
        ArrayList<SanPham> ketQuaTonKho = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maSP,tenSP,soLuong,gia,phanLoai,xuatXu,trangThai FROM SanPham";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String phanLoai = rs.getString("phanLoai");
                String xuatXu = rs.getString("xuatXu");
                int trangThai = rs.getInt("trangThai");
                SanPham sp = new SanPham(maSP, tenSP, soLuong, gia, phanLoai, xuatXu, trangThai);
                ketQua.add(sp);
            }
            for (SanPham sanpham : ketQua) {
                if (sanpham.getSoLuong() > 0) {
                    ketQuaTonKho.add(sanpham);
                }
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQuaTonKho;
    }
    
        public ArrayList<SanPham> selectAllExist() {
        ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maSP,tenSP,soLuong,gia,phanLoai,xuatXu,trangThai FROM SanPham WHERE trangThai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String phanLoai = rs.getString("phanLoai");
                String xuatXu = rs.getString("xuatXu");
                int trangThai = rs.getInt("trangThai");
                 SanPham sp = new SanPham(maSP, tenSP, soLuong, gia, phanLoai, xuatXu, trangThai);
                ketQua.add(sp);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
        
    public int getSl() {
        int soluong = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham WHERE trangThai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                soluong++;
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return soluong;
    }
}