package com.dataprovider.datajob.scheduler;

import com.dataprovider.datajob.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataJobScheduler {

  @Autowired
  private DataService dataService;

  @Scheduled(cron = "0 0 0/1 1/1 * ? *")
  public void sensitiveDataScheduler() {
    //TODO consulta base externa
    dataService.processAndSendSensitiveData(null);
  }

  @Scheduled(cron = "0 15 10 15 * ?")
  public void traceDataScheduler() {
    //TODO consulta base externa
    dataService.processAndSendTraceData(null);
  }

  @Scheduled(cron = "0 0/10 * 1/1 * ? *")
  public void scoreDataScheduler() {
    //TODO consulta base externa
    dataService.processAndSendScoreData(null);
  }
}
