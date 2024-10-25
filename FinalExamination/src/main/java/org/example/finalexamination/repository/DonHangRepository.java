package org.example.finalexamination.repository;

import org.example.finalexamination.model.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Long> {
    List<DonHang> findByNgayMuaBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Lấy top đơn hàng theo số lượng
    @Query(value = "SELECT d FROM DonHang d ORDER BY d.soLuong DESC")
    List<DonHang> findTopDonHang(@Param("limit") int limit);
}
