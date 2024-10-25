package org.example.finalexamination.service;

import org.example.finalexamination.model.DonHang;
import org.example.finalexamination.model.SanPham;
import org.example.finalexamination.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.finalexamination.repository.DonHangRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonHangService {
    @Autowired
    private DonHangRepository donHangRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<DonHang> getAllDonHang() {
        return donHangRepository.findAll();
    }
    public DonHang getDonHangById(Long id) {
        return donHangRepository.findById(id).orElse(null);
    }
    public DonHang saveDonHang(DonHang donHang) {

        return donHangRepository.save(donHang);
    }
    public void deleteDonHang(Long id) {
        donHangRepository.deleteById(id);
    }
    public List<DonHang> getDonHangByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return donHangRepository.findByNgayMuaBetween(startDate, endDate);
    }

    public List<DonHang> getTopDonHang(int limit) {
        return donHangRepository.findTopDonHang(limit);
    }
}
