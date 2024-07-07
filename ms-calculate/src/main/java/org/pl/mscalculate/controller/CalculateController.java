package org.pl.mscalculate.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pl.mscalculate.dto.CalculateResponseDto;
import org.pl.mscalculate.dto.CalculateTotalDto;
import org.pl.mscalculate.dto.mapper.CalculateMapper;
import org.pl.mscalculate.entities.Calculate;
import org.pl.mscalculate.repository.CalculateRepository;
import org.pl.mscalculate.service.CalculateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class CalculateController {


    private final CalculateService calculateService;

    private final CalculateRepository calculateRepository;


    @PostMapping("/rule")
    public ResponseEntity<Calculate> registerRule(@Valid @RequestBody Calculate rule) {

        return ResponseEntity.ok().body(calculateService.create(rule));
    }

    @GetMapping("/rule")
    public ResponseEntity<List<Calculate>> getRuleById() {

        return ResponseEntity.ok().body(calculateService.findAll());
    }

    @PutMapping("/rule/{id}")
    public ResponseEntity<Calculate> updateRule(@PathVariable Long id, @RequestBody Calculate rule) {

        calculateRepository.updateCategoryAndParityById(rule.getCategory(), rule.getParity(), id);
        Calculate ruleModify =  calculateService.findById(id);
        return ResponseEntity.ok().body(ruleModify);
    }

    @DeleteMapping("/rule/{id}")
    public String deleteRule(@PathVariable Long id){

        Calculate rule =  calculateService.findById(id);
        calculateService.delete(rule);
        return "Rule deleted";
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculateResponseDto> calculate(@RequestBody CalculateTotalDto calculate){


        log.info("CalculateTotalDto: {}", calculateService.calculate(calculate));
        return ResponseEntity.ok().body(calculateService.calculate(calculate));


    }


}
