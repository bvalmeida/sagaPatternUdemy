package com.saga.sale.adapters.out;

import com.saga.sale.adapters.out.repository.SaleRepository;
import com.saga.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.saga.sale.application.core.domain.Sale;
import com.saga.sale.application.ports.out.SaveSaleOutPutPort;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleAdapter implements SaveSaleOutPutPort {

    private final SaleRepository saleRepository;

    private final SaleEntityMapper saleEntityMapper;

    public SaveSaleAdapter(SaleRepository saleRepository, SaleEntityMapper saleEntityMapper) {
        this.saleRepository = saleRepository;
        this.saleEntityMapper = saleEntityMapper;
    }

    @Override
    public Sale save(Sale sale) {
        var saleEntity = saleEntityMapper.toSaleEntity(sale);
        var saleEntityResponse = this.saleRepository.save(saleEntity);
        return saleEntityMapper.toSale(saleEntityResponse);
    }
}
