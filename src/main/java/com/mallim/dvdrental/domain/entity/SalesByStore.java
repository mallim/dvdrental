package com.mallim.dvdrental.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class SalesByStore implements Serializable {

    private String store;

    private String manager;

    private BigDecimal totalSales;
}
