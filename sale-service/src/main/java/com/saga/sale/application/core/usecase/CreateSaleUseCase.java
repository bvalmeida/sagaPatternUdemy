package com.saga.sale.application.core.usecase;

import com.saga.sale.application.core.domain.Sale;
import com.saga.sale.application.core.domain.enums.SaleEvent;
import com.saga.sale.application.core.domain.enums.SaleStatus;
import com.saga.sale.application.ports.in.CreateSaleInputPort;
import com.saga.sale.application.ports.out.SaveSaleOutPutPort;
import com.saga.sale.application.ports.out.SendCreatedSaleOutPutPort;

public class CreateSaleUseCase implements CreateSaleInputPort {

    private final SaveSaleOutPutPort saveSaleOutPutPort;

    private final SendCreatedSaleOutPutPort sendCreatedSaleOutPutPort;

    public CreateSaleUseCase(SaveSaleOutPutPort saveSaleOutPutPort, SendCreatedSaleOutPutPort sendCreatedSaleOutPutPort) {
        this.saveSaleOutPutPort = saveSaleOutPutPort;
        this.sendCreatedSaleOutPutPort = sendCreatedSaleOutPutPort;
    }

    @Override
    public void create(Sale sale){
        sale.setStatus(SaleStatus.PENDING);
        var saleResponse = saveSaleOutPutPort.save(sale);
        sendCreatedSaleOutPutPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
