package org.example.finalexamination.controller;

import org.example.finalexamination.model.DonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.finalexamination.service.DonHangService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/don-hang")
public class DonHangController {

    @Autowired
    private DonHangService donHangService;

    @GetMapping("")
    public String showDonHangList(Model model) {
        List<DonHang> donHangList = donHangService.getAllDonHang();
        model.addAttribute("donHangList", donHangList);
        return "donhang";
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<DonHang> filterDonHang(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return donHangService.getDonHangByDateRange(startDate.atStartOfDay(), endDate.atStartOfDay().plusDays(1));
    }

    @GetMapping("/top")
    @ResponseBody
    public List<DonHang> getTopDonHang(@RequestParam(defaultValue = "5") int limit) {
        return donHangService.getTopDonHang(limit);
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        DonHang donHang = donHangService.getDonHangById(id);
        if (donHang == null) {
            return "redirect:/don-hang";
        }
        model.addAttribute("donHang", donHang);
        return "donhang-edit";
    }

    @PostMapping("/update")
    public String updateDonHang(@ModelAttribute DonHang donHang) {
        donHangService.saveDonHang(donHang);
        return "redirect:/don-hang";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteDonHang(@PathVariable Long id) {
        try {
            donHangService.deleteDonHang(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Không thể xóa đơn hàng");
        }
    }
}