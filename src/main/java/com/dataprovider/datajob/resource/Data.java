package com.dataprovider.datajob.resource;

import com.dataprovider.datajob.model.ScoreDataEntity;
import com.dataprovider.datajob.model.SensitiveDataEntity;
import com.dataprovider.datajob.model.dto.ScoreDataDto;
import com.dataprovider.datajob.model.dto.SensitiveDataDto;
import com.dataprovider.datajob.model.dto.TraceDataDto;
import com.dataprovider.datajob.publisher.SensitiveDataPublisher;
import com.dataprovider.datajob.service.DataService;
import java.util.List;
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

  @PostMapping( "/score")
  public ResponseEntity<List<ScoreDataDto>> processProduct(@RequestBody List<ScoreDataDto> dto) {
    log.info("Receivied={}", dto.toString());
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

  @PostMapping( "/sensitive")
  public ResponseEntity<List<SensitiveDataDto>> sensitive(@RequestBody List<SensitiveDataDto> dto) {
    log.info("Receivied={}", dto.toString());
//    SensitiveDataEntity sensitiveData = SensitiveDataEntity.builder()
//        .cpf("425.36.457.96")
//        .name("Oswaldo")
//        .address("Rua Lá")
//        .debts("Varios")
//        .build();

//    sensitiveDataPublisher.send(sensitiveData);
    dataService.processAndSendSensitiveData(dto);
    return ResponseEntity.ok(dto);
  }

  @PostMapping( "/trace")
  public ResponseEntity<List<TraceDataDto>> trace(@RequestBody List<TraceDataDto> dto) {
    log.info("Receivied={}", dto.toString());
//    SensitiveDataEntity sensitiveData = SensitiveDataEntity.builder()
//        .cpf("425.36.457.96")
//        .name("Oswaldo")
//        .address("Rua Lá")
//        .debts("Varios")
//        .build();

//    sensitiveDataPublisher.send(sensitiveData);
    dataService.processAndSendTraceData(dto);
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/get")
  public ScoreDataEntity get(@RequestParam String cpf) {
    return dataService.getData(cpf);
  }
}

