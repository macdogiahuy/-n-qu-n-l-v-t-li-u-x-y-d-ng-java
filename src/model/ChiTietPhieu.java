/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

public class ChiTietPhieu {

    private String maPhieu;
    private String maSP;
    private int soLuong;
    private double donGia;

    public ChiTietPhieu(String maPhieu, String maSP, int soLuong, double donGia) {
        this.maPhieu = maPhieu;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.maPhieu);
        hash = 17 * hash + Objects.hashCode(this.maSP);
        hash = 17 * hash + this.soLuong;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.donGia) ^ (Double.doubleToLongBits(this.donGia) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChiTietPhieu other = (ChiTietPhieu) obj;
        if (this.soLuong != other.soLuong) {
            return false;
        }
        if (Double.doubleToLongBits(this.donGia) != Double.doubleToLongBits(other.donGia)) {
            return false;
        }
        if (!Objects.equals(this.maPhieu, other.maPhieu)) {
            return false;
        }
        return Objects.equals(this.maSP, other.maSP);
    }

    @Override
    public String toString() {
        return "ChiTietPhieu{" + "maPhieu=" + maPhieu + ", maSP=" + maSP + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
}
