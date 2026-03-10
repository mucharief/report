package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeSalesDTO {
    private String empName;
    private String productName;
    private String month;
    private BigDecimal total;
}
