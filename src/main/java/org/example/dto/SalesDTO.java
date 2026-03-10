package org.example.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SalesDTO {
    private String productName;
    private String month;
    private BigDecimal total;
}
