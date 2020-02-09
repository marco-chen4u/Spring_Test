package com.marco.brewery.web.mapper;

import com.marco.brewery.domain.Beer;
import com.marco.brewery.web.model.BeerDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
