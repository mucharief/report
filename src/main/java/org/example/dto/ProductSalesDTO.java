package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductSalesDTO {
    private String month;
    private String productName;
    private BigDecimal monthlyTotal;
}
