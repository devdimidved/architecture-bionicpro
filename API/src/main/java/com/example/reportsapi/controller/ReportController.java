package com.example.reportsapi.controller;

import com.example.reportsapi.dto.ReportDto;
import com.example.reportsapi.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reports")
    @PreAuthorize("hasRole('prothetic_user')")
    public ResponseEntity<ReportDto> getReport() {
        return ResponseEntity.ok(reportService.generateReport());
    }
}
