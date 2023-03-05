package com.saga.sale.application.ports.in;

import com.saga.sale.application.core.domain.Sale;
import org.springframework.stereotype.Component;

public interface CreateSaleInputPort {

    void create(Sale sale);
}
