/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author macdo
 */
public class GachNgoi extends SanPham{
    private String LoaiGach;
    private String LoaiNgoi;
    private String CachAm;
    private String TrangTri;
    private String NoiThat;

    public GachNgoi(String LoaiGach, String LoaiNgoi, String CachAm, String TrangTri, String NoiThat, String maSP, String tenSP, int soLuong, double gia, String xuatXu, int trangThai, String phanloai) {
        super(maSP, tenSP, soLuong, gia, xuatXu, trangThai, phanloai);
        this.LoaiGach = LoaiGach;
        this.LoaiNgoi = LoaiNgoi;
        this.CachAm = CachAm;
        this.TrangTri = TrangTri;
        this.NoiThat = NoiThat;
    }

    public String getLoaiGach() {
        return LoaiGach;
    }

    public void setLoaiGach(String LoaiGach) {
        this.LoaiGach = LoaiGach;
    }

    public String getLoaiNgoi() {
        return LoaiNgoi;
    }

    public void setLoaiNgoi(String LoaiNgoi) {
        this.LoaiNgoi = LoaiNgoi;
    }

    public String getCachAm() {
        return CachAm;
    }

    public void setCachAm(String CachAm) {
        this.CachAm = CachAm;
    }

    public String getTrangTri() {
        return TrangTri;
    }

    public void setTrangTri(String TrangTri) {
        this.TrangTri = TrangTri;
    }

    public String getNoiThat() {
        return NoiThat;
    }

    public void setNoiThat(String NoiThat) {
        this.NoiThat = NoiThat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.LoaiGach);
        hash = 89 * hash + Objects.hashCode(this.LoaiNgoi);
        hash = 89 * hash + Objects.hashCode(this.CachAm);
        hash = 89 * hash + Objects.hashCode(this.TrangTri);
        hash = 89 * hash + Objects.hashCode(this.NoiThat);
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
        final GachNgoi other = (GachNgoi) obj;
        if (!Objects.equals(this.LoaiGach, other.LoaiGach)) {
            return false;
        }
        if (!Objects.equals(this.LoaiNgoi, other.LoaiNgoi)) {
            return false;
        }
        if (!Objects.equals(this.CachAm, other.CachAm)) {
            return false;
        }
        if (!Objects.equals(this.TrangTri, other.TrangTri)) {
            return false;
        }
        return Objects.equals(this.NoiThat, other.NoiThat);
    }

    @Override
    public String toString() {
        return "GachNgoi{" + "LoaiGach=" + LoaiGach + ", LoaiNgoi=" + LoaiNgoi + ", CachAm=" + CachAm + ", TrangTri=" + TrangTri + ", NoiThat=" + NoiThat + '}';
    }
}
