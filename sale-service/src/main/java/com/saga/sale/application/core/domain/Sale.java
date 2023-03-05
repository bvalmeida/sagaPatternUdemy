package com.saga.sale.application.core.domain;

import com.saga.sale.application.core.domain.enums.SaleStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Sale {

    private Integer id;

    private Integer productId;

    private Integer userId;

    private BigDecimal value;

    private SaleStatus status;

    private Integer quantity;

    public Sale(){

    }

    public Sale(Integer id, Integer productId, Integer userId, BigDecimal value, SaleStatus status, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.value = value;
        this.status = status;
        this.quantity = quantity;
    }
}
