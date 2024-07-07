package org.pl.mscalculate.service;

import lombok.RequiredArgsConstructor;
import org.pl.mscalculate.dto.CalculateResponseDto;
import org.pl.mscalculate.dto.CalculateTotalDto;
import org.pl.mscalculate.entities.Calculate;
import org.pl.mscalculate.repository.CalculateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateService {

    private final CalculateRepository repository;

    public Calculate create(Calculate calculate) {
        return repository.save(calculate);
    }

    public Calculate findById(Long id) {return repository.findById(id).get();}

    public List<Calculate> findAll() {return repository.findAll();}

    public Calculate update(Calculate calculate) {

         repository.updateCategoryAndParityById(calculate.getCategory(), calculate.getParity(), calculate.getId());
         return calculate;
    }

    public void delete(Calculate calculate) {repository.delete(calculate);
    }

    public CalculateResponseDto calculate(CalculateTotalDto calculate) {
        Calculate rule = findById(calculate.getCategoryId());
        Integer total = rule.getParity() * calculate.getValue();

        CalculateResponseDto calculateResponseDto = new CalculateResponseDto();
        calculateResponseDto.setTotal(total);
        return calculateResponseDto;
    }

}
