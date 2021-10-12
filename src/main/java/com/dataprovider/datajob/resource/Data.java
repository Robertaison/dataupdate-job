package com.dataprovider.datajob.resource;

import com.dataprovider.datajob.model.ScoreDataEntity;
import com.dataprovider.datajob.model.SensitiveDataEntity;
import com.dataprovider.datajob.model.dto.ScoreDataDto;
import com.dataprovider.datajob.publisher.SensitiveDataPublisher;
import com.dataprovider.datajob.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Data {

  @Autowired
  private SensitiveDataPublisher sensitiveDataPublisher;

  @Autowired
  private DataService dataService;

  @PostMapping( "/save")
  public ResponseEntity<ScoreDataDto> processProduct(@RequestBody ScoreDataDto dto) {
    log.info("Receivied={}", dto);
//    SensitiveDataEntity sensitiveData = SensitiveDataEntity.builder()
//        .cpf("425.36.457.96")
//        .name("Oswaldo")
//        .address("Rua Lá")
//        .debts("Varios")
//        .build();

//    sensitiveDataPublisher.send(sensitiveData);
    dataService.processAndSendScoreData(dto);
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/get")
  public ScoreDataEntity get(@RequestParam String cpf) {
    return dataService.getData(cpf);
  }
}

