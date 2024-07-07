package org.pl.mspayment.infra;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.pl.mspayment.entities.CalculateResponseDto;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TotalPointPublisher {

    private final RabbitTemplate  rabbitTemplate;

    private final Queue queueCalcPoints;

    public void getPoins(CalculateResponseDto total) throws JsonProcessingException {
        var json = convertetIntoJson(total);
        rabbitTemplate.convertAndSend(queueCalcPoints.getName(), json);
    }

    private String convertetIntoJson(CalculateResponseDto total) throws JsonProcessingException{

        ObjectMapper mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(total);
        return json;
    }

}
