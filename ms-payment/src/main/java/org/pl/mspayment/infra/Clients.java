package org.pl.mspayment.infra;


import org.pl.mspayment.entities.CalculateResponseDto;
import org.pl.mspayment.entities.CalculateTotalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8081", name = "ms-calculate", path = "/v1")
public interface Clients {

    @PostMapping("/calculate")
     ResponseEntity<CalculateResponseDto> calculate(@RequestBody CalculateTotalDto calculate);


}
