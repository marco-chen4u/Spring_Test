package com.marco.brewery.web.controller;

import com.marco.brewery.domain.Customer;
import com.marco.brewery.repositories.BeerOrderRepository;
import com.marco.brewery.repositories.CustomerRepository;
import com.marco.brewery.web.model.BeerOrderPagedList;
import com.marco.brewery.web.model.BeerPagedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeerOrderControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = customerRepository.findAll().get(0);
    }

    @Test
    void testListBeerOrders() {
        String url = "/api/v1/customers/"+ customer.getId().toString() + "/orders";

        BeerOrderPagedList beerPagedList = testRestTemplate.getForObject(url, BeerOrderPagedList.class);

        assertThat(beerPagedList.getContent()).hasSize(1);
    }
}
