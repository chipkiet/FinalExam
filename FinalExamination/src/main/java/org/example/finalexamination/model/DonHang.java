package org.example.finalexamination.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "donhang")
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maDonHang;

    @Column(name = "ngay_mua", nullable = false)
    private LocalDate ngayMua;

    @Column(name = "so_luong" , nullable = false)
    private Long soLuong;

    @ManyToOne
    @JoinColumn(name = "ma_sp")
    private SanPham sanPham;

    public Long getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(Long maDonHang) {
        this.maDonHang = maDonHang;
    }

    public LocalDate getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(LocalDate ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
