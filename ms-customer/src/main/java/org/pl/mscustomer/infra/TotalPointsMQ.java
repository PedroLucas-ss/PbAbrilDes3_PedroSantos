package org.pl.mscustomer.infra;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.pl.mscustomer.entities.CalculateResponseDto;
import org.pl.mscustomer.entities.Customer;
import org.pl.mscustomer.repository.CustomerRepository;
import org.pl.mscustomer.service.CustomerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequiredArgsConstructor
public class TotalPointsMQ {

    private final CustomerService customerService;

    @RabbitListener(queues = "${mq.queues.TotalPoins}")
    public void totalPoints (@Payload String payload){
        try {

            var mapper = new ObjectMapper();
            CalculateResponseDto points = mapper.readValue(payload, CalculateResponseDto.class);

           Customer customer = customerService.findById(points.getCustomerId());
           customer.setPoints(customer.getPoints() + points.getTotal());
            customerService.update(customer);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
