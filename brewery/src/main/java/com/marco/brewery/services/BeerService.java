package com.marco.brewery.services;

import com.marco.brewery.web.model.BeerDto;
import com.marco.brewery.web.model.BeerPagedList;
import com.marco.brewery.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

    BeerDto findBeerById(UUID beerId);
}
