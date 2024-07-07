package org.pl.mscalculate.dto.mapper;

import org.modelmapper.ModelMapper;
import org.pl.mscalculate.dto.CalculateResponseDto;
import org.pl.mscalculate.entities.Calculate;

public class CalculateMapper {

    public static Calculate toCustomer(CalculateResponseDto calculate) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(calculate, Calculate.class);
    }


}
