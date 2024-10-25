package org.example.finalexamination.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sanpham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maSp;

    @Column(name = "ten_sp", nullable = false)
    private String tenSp;

    @Column(name = "gia_sp", nullable = false)
    private Double giaSp;

    @Column(name = "tinh_trang_sp", nullable = false)
    private String tinhTrangSp;

    @ManyToOne
    @JoinColumn(name = "loai_san_pham_id")
    private LoaiSanPham loaiSanPham;

    public Long getMaSp() {
        return maSp;
    }

    public void setMaSp(Long maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public Double getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(Double giaSp) {
        this.giaSp = giaSp;
    }

    public String getTinhTrangSp() {
        return tinhTrangSp;
    }

    public void setTinhTrangSp(String tinhTrangSp) {
        this.tinhTrangSp = tinhTrangSp;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
}
