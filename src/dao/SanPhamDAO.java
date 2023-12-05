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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            pst.setString(6, t.getXuatXu());
            pst.setInt(9, t.getTrangThai());
            pst.setString(10, t.getMaSP());
            ketqua = pst.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
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
            String sql = "DELETE FROM sanpham WHERE maSP=? ";
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
            String sql = "SELECT maSP,tenSP,soLuong,gia,xuatXu,trangThai FROM sanpham";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maMay = rs.getString("maMay");
                String tenMay = rs.getString("tenMay");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String tenCpu = rs.getString("tenCpu");
                String ram = rs.getString("ram");
                String xuatXu = rs.getString("xuatXu");
                String cardManHinh = rs.getString("cardManHinh");
                String rom = rs.getString("rom");
                int trangThai = rs.getInt("trangThai");
                MayTinh mt = new MayTinh(maMay, tenMay, soLuong, gia, tenCpu, ram, xuatXu, cardManHinh, rom, trangThai);
                ketQua.add(mt);
            }
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public MayTinh selectById(String t) {
        MayTinh ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maMay,tenMay,soLuong,gia,tenCpu,ram,xuatXu,cardManHinh,rom,trangThai FROM MayTinh WHERE maMay = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maMay = rs.getString("maMay");
                String tenMay = rs.getString("tenMay");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String tenCpu = rs.getString("tenCpu");
                String ram = rs.getString("ram");
                String xuatXu = rs.getString("xuatXu");
                String cardManHinh = rs.getString("cardManHinh");
                String rom = rs.getString("rom");
                int trangThai = rs.getInt("trangThai");
                ketQua = new MayTinh(maMay, tenMay, soLuong, gia, tenCpu, ram, xuatXu, cardManHinh, rom, trangThai);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public int updateSoLuong(String maMay, int soluong) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            //String sql = "INSERT INTO MayTinh (maMay, tenMay, soLuong, tenCpu, ram, cardManHinh, gia, dungLuongPin, dungLuongPin, dungLuongPin, loaiMay, rom) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql = "UPDATE MayTinh SET soLuong=? WHERE maMay=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, soluong);
            pst.setString(2, maMay);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public int deleteTrangThai(String maMay){
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            //String sql = "INSERT INTO MayTinh (maMay, tenMay, soLuong, tenCpu, ram, cardManHinh, gia, dungLuongPin, dungLuongPin, dungLuongPin, loaiMay, rom) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql = "UPDATE MayTinh SET trangThai=0 WHERE maMay=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maMay);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<MayTinh> selectAllE() {
        ArrayList<MayTinh> ketQua = new ArrayList<MayTinh>();
        ArrayList<MayTinh> ketQuaTonKho = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maMay,tenMay,soLuong,gia,tenCpu,ram,xuatXu,cardManHinh,rom,trangThai FROM MayTinh";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maMay = rs.getString("maMay");
                String tenMay = rs.getString("tenMay");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String tenCpu = rs.getString("tenCpu");
                String ram = rs.getString("ram");
                String xuatXu = rs.getString("xuatXu");
                String cardManHinh = rs.getString("cardManHinh");
                String rom = rs.getString("rom");
                int trangThai = rs.getInt("trangThai");
                MayTinh mt = new MayTinh(maMay, tenMay, soLuong, gia, tenCpu, ram, xuatXu, cardManHinh, rom, trangThai);
                ketQua.add(mt);
            }
            for (MayTinh mayTinh : ketQua) {
                if (mayTinh.getSoLuong() > 0) {
                    ketQuaTonKho.add(mayTinh);
                }
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQuaTonKho;
    }
    
        public ArrayList<MayTinh> selectAllExist() {
        ArrayList<MayTinh> ketQua = new ArrayList<MayTinh>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maMay,tenMay,soLuong,gia,tenCpu,ram,xuatXu,cardManHinh,rom,trangThai FROM MayTinh WHERE trangThai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maMay = rs.getString("maMay");
                String tenMay = rs.getString("tenMay");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String tenCpu = rs.getString("tenCpu");
                String ram = rs.getString("ram");
                String xuatXu = rs.getString("xuatXu");
                String cardManHinh = rs.getString("cardManHinh");
                String rom = rs.getString("rom");
                int trangThai = rs.getInt("trangThai");
                MayTinh mt = new MayTinh(maMay, tenMay, soLuong, gia, tenCpu, ram, xuatXu, cardManHinh, rom, trangThai);
                ketQua.add(mt);
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
            String sql = "SELECT * FROM MayTinh WHERE trangThai = 1";
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
