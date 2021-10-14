package com.dataprovider.datajob.publisher;

import com.dataprovider.datajob.config.RabbitConfig;
import com.dataprovider.datajob.model.dto.scoredata.ScoreDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScoreDataPublisher {

  private final RabbitTemplate rabbitTemplate;

  public void send(ScoreDataDto scoreData) {
    log.info("M=ScoreDataPublisher.send, I=Publicando mensagem na fila, notificação={}",
        scoreData);
    rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.SCORE_DATA, scoreData);
  }
}
