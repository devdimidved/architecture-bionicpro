package com.example.reportsapi.service;

import com.example.reportsapi.dto.ReportDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ReportService {

    private final Random random = new Random();
    private final String[] categories = {"Категория A", "Категория B", "Категория C", "Категория D"};
    private final String[] names = {"Протез руки", "Протез ноги", "Протез колена", "Ортопедическая стелька", 
                                   "Протез стопы", "Экзоскелет", "Бионическая рука", "Коленный модуль"};

    public ReportDto generateReport() {
        ReportDto report = new ReportDto();
        report.setReportId(UUID.randomUUID().toString());
        report.setGeneratedAt(LocalDateTime.now());
        report.setTitle("Отчет по использованию протезов");
        report.setDescription("Сводный отчет по использованию протезных изделий за последний месяц");

        int itemsCount = 5 + random.nextInt(10); // От 5 до 14 позиций

        List<ReportDto.ReportItemDto> items = IntStream.range(0, itemsCount)
                .mapToObj(i -> createRandomReportItem())
                .collect(Collectors.toList());

        report.setItems(items);

        return report;
    }

    private ReportDto.ReportItemDto createRandomReportItem() {
        ReportDto.ReportItemDto item = new ReportDto.ReportItemDto();
        item.setId(UUID.randomUUID().toString().substring(0, 8));
        item.setName(names[random.nextInt(names.length)]);
        item.setValue(50 + random.nextDouble() * 950); // От 50 до 1000
        item.setCategory(categories[random.nextInt(categories.length)]);
        return item;
    }
}
