package org.example.service;

import org.example.dto.EmployeeSalesDTO;
import org.example.dto.ProductDTO;
import org.example.dto.SalesDTO;
import org.example.entity.Employee;
import org.example.entity.Product;
import org.example.entity.Sales;
import org.example.repository.EmployeeRepository;
import org.example.repository.ProductRepository;
import org.example.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    @Autowired
    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public List<ProductDTO> reportProduct() {
        return salesRepository.findSoldProductPerMonth();
    }

    @Override
    public List<EmployeeSalesDTO> reportEmployeeSales() {
        return salesRepository.findEmployeeeSalesPerMostProductPerMonth();
    }

    @Override
    public List<SalesDTO> reportProductSales() {
        return salesRepository.findTotalSalesPerProductPerMonth();
    }

}
