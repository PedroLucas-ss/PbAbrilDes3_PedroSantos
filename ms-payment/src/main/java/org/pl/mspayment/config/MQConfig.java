package org.pl.mspayment.config;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
public class MQConfig {

    @Value("${mq.queues.TotalPoins}")
    private String queuePoints;

    @Bean
    public Queue queueCalcPoints(){
        return new Queue(queuePoints, true);
    }
}
