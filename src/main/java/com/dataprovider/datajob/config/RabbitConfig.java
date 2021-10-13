package com.dataprovider.datajob.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  public static final String EXCHANGE = "data-exchange";

  public static final String SENSITIVE_DATA = "sensitive-data";
  public static final String SENSITIVE_DATA_QUEUE = "sensitive-data-queue";

  public static final String SCORE_DATA = "score-data";
  public static final String SCORE_DATA_QUEUE = "score-data-queue";

  public static final String TRACE_DATA = "trace-data";
  public static final String TRACE_DATA_QUEUE = "trace-data-queue";


  @Bean
  public TopicExchange exchange() {
    return ExchangeBuilder.topicExchange(EXCHANGE).durable(true).build();
  }

  @Bean
  Queue sensitiveDataQueue() {
    return QueueBuilder.durable(SENSITIVE_DATA_QUEUE).build();
  }

  @Bean
  Queue scoreDataQueue() {
    return QueueBuilder.durable(SCORE_DATA_QUEUE).build();
  }

  @Bean
  Queue traceDataQueue() {
    return QueueBuilder.durable(TRACE_DATA_QUEUE).build();
  }

  @Bean
  Binding sensitiveDataBinder() {
    return BindingBuilder.bind(sensitiveDataQueue()).to(exchange()).with(SENSITIVE_DATA);
  }

  @Bean
  Binding scoreDataBinder() {
    return BindingBuilder.bind(scoreDataQueue()).to(exchange()).with(SCORE_DATA);
  }

  @Bean
  Binding traceDataBinder() {
    return BindingBuilder.bind(traceDataQueue()).to(exchange()).with(TRACE_DATA);
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
