package com.saga.sale.adapters.in.controller;

import com.saga.sale.adapters.in.controller.mapper.SaleRequestMapper;
import com.saga.sale.adapters.in.controller.request.SaleRequest;
import com.saga.sale.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    private final CreateSaleInputPort createSaleInputPort;

    private final SaleRequestMapper saleRequestMapper;

    public SaleController(CreateSaleInputPort createSaleInputPort, SaleRequestMapper saleRequestMapper) {
        this.createSaleInputPort = createSaleInputPort;
        this.saleRequestMapper = saleRequestMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@Valid @RequestBody SaleRequest saleRequest){
        log.info("Criando a venda...");
        createSaleInputPort.create(saleRequestMapper.toSale(saleRequest));
        log.info("Venda criada com sucesso.");
    }
}
