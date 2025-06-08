package com.example.reportsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private String reportId;
    private LocalDateTime generatedAt;
    private String title;
    private String description;
    private List<ReportItemDto> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReportItemDto {
        private String id;
        private String name;
        private double value;
        private String category;
    }
}
