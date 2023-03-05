package com.saga.sale.adapters.in.controller.mapper;

import com.saga.sale.adapters.in.controller.request.SaleRequest;
import com.saga.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
}
