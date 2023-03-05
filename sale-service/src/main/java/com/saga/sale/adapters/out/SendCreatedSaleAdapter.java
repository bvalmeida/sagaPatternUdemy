package com.saga.sale.adapters.out;

import com.saga.sale.adapters.out.message.SaleMessage;
import com.saga.sale.application.core.domain.Sale;
import com.saga.sale.application.core.domain.enums.SaleEvent;
import com.saga.sale.application.ports.out.SendCreatedSaleOutPutPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCreatedSaleAdapter implements SendCreatedSaleOutPutPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    public SendCreatedSaleAdapter(KafkaTemplate<String, SaleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        this.kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
