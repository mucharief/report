package org.example.service;

import org.example.dto.EmployeeSalesDTO;
import org.example.dto.ProductSalesDTO;
import org.example.dto.SalesDTO;

import java.util.List;

public interface SalesService {

    List<SalesDTO> reportProductSales();

    List<EmployeeSalesDTO> reportEmployeeSales();

    List<ProductSalesDTO> reportProduct();

}
