package com.saga.sale.config.usecase;

import com.saga.sale.adapters.out.SaveSaleAdapter;
import com.saga.sale.adapters.out.SendCreatedSaleAdapter;
import com.saga.sale.application.core.usecase.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(SaveSaleAdapter saveSaleAdapter, SendCreatedSaleAdapter sendCreatedSaleAdapter){
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }
}
