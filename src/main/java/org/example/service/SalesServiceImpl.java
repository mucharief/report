package org.example.service;

import org.example.dto.EmployeeSalesDTO;
import org.example.dto.ProductSalesDTO;
import org.example.dto.SalesDTO;
import org.example.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    @Autowired
    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public List<ProductSalesDTO> reportProduct() {
        return salesRepository.findBestSellerProductPerMonth();
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
