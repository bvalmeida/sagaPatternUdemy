package com.saga.sale.adapters.out.repository.mapper;

import com.saga.sale.adapters.out.repository.entity.SaleEntity;
import com.saga.sale.application.core.domain.Sale;
import com.saga.sale.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SaleEntityMapper {

    @Mapping(source = "status", target = "statusId", qualifiedByName = "setStatusId")
    SaleEntity toSaleEntity(Sale sale);

    @Named("setStatusId")
    default Integer setStatusId(SaleStatus saleStatus){
        return saleStatus.getStatusId();
    }

    @Mapping(source = "statusId", target = "status", qualifiedByName = "setStatus")
    Sale toSale(SaleEntity saleEntity);

    @Named("setStatus")
    default SaleStatus setStatus(Integer saleStatusId){
        return SaleStatus.toEnum(saleStatusId);
    }
}
