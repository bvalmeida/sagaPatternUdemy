package com.saga.sale.application.ports.out;

import com.saga.sale.application.core.domain.Sale;
import com.saga.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutPutPort {

    void send(Sale sale, SaleEvent event);
}
