package com.saga.sale.application.ports.out;

import com.saga.sale.application.core.domain.Sale;

public interface SaveSaleOutPutPort {

    Sale save(Sale sale);
}
