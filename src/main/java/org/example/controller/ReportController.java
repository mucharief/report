package org.example.controller;

import org.example.dto.EmployeeSalesDTO;
import org.example.dto.ProductSalesDTO;
import org.example.dto.SalesDTO;
import org.example.repository.SalesRepository;
import org.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    private final SalesServiceImpl salesService;

    @Autowired
    public ReportController(SalesServiceImpl salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/report-total-sales")
    public List<SalesDTO> getReportProductSales() {
        return salesService.reportProductSales();
    }

    @GetMapping("/report-employee-sales")
    public List<EmployeeSalesDTO> getReportEmployeeSales() {
        return salesService.reportEmployeeSales();
    }

    @GetMapping("/report-product")
    public List<ProductSalesDTO> getReportProduct() {
        return salesService.reportProduct();
    }

}
