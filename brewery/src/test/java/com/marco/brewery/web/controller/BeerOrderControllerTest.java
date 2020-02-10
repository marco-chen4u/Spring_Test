package com.marco.brewery.web.controller;

import com.marco.brewery.services.BeerOrderService;
import com.marco.brewery.utils.Utils;
import com.marco.brewery.web.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(BeerOrderController.class)
class BeerOrderControllerTest {

    @MockBean
    BeerOrderService beerOrderService;

    @Autowired
    MockMvc mockMvc;

    BeerDto validBeer;
    BeerOrderDto beerOrder;
    BeerOrderPagedList beerOrderPagedList;

    @BeforeEach
    void setUp() {
        validBeer = BeerDto.builder().id(UUID.randomUUID())
                .version(1)
                .beerName("Beer1")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("10.29"))
                .quantityOnHand(4)
                .upc(Utils.getRandomValue())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .build();

        beerOrder = BeerOrderDto.builder()
                .id(UUID.randomUUID())
                .customerRef("1234")
                .beerOrderLines(List.of(BeerOrderLineDto
                                        .builder()
                                        .beerId(validBeer.getId())
                                        .build()))
                .build();

        beerOrderPagedList = new BeerOrderPagedList(List.of(beerOrder), PageRequest.of(1, 1), 1);
    }

    @AfterEach
    public void tearDown() {
        reset(beerOrderService);
    }

    @Test
    void listOrders() throws Exception {
        given(beerOrderService.listOrders(any(), any())).willReturn(beerOrderPagedList);

        mockMvc.perform(get("/api/v1/customers/85d4506-e7dd-446e-a092-5f30b98e7b26/orders"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getOrder() throws Exception {
        given(beerOrderService.getOrderById(any(), any())).willReturn(beerOrder);

        mockMvc.perform(get("/api/v1/customers/85d4506-e7dd-446e-a092-5f30b98e7b26/orders/f25767d9-342a-48ac-a788-0a7a38ae6fb3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
