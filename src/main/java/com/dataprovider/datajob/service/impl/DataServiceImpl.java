package com.dataprovider.datajob.service.impl;

import com.dataprovider.datajob.model.ScoreDataEntity;
import com.dataprovider.datajob.model.dto.ScoreDataDto;
import com.dataprovider.datajob.model.dto.SensitiveDataDto;
import com.dataprovider.datajob.model.dto.TraceDataDto;
import com.dataprovider.datajob.publisher.ScoreDataPublisher;
import com.dataprovider.datajob.publisher.SensitiveDataPublisher;
import com.dataprovider.datajob.publisher.TraceDataPublisher;
import com.dataprovider.datajob.repository.ScoreDataRepository;
import com.dataprovider.datajob.service.DataService;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

  private final ScoreDataPublisher scoreDataPublisher;
  private final TraceDataPublisher traceDataPublisher;
  private final SensitiveDataPublisher sensitiveDataPublisher;

  //  private final SensitiveDataRepository sensitiveDataRepository;
//  private final TraceDataRepository traceDataRepository;
  private final ScoreDataRepository scoreDataRepository;

  @Override
  public void processAndSendSensitiveData(SensitiveDataDto dto) {
    sensitiveDataPublisher.send(null);
  }

  @Override
  public void processAndSendTraceData(TraceDataDto dto) {
    traceDataPublisher.send(null);
  }

  @Override
  public void processAndSendScoreData(ScoreDataDto dto) {
    log.info("M=ProcessAndSendScoreData, dto={}", dto);
    LocalDateTime updateAt = LocalDateTime.parse(dto.getUpdateAt());
    Optional<ScoreDataEntity> scoreDataEntity = scoreDataRepository.findByCpf(dto.getCpf());

    scoreDataEntity.ifPresentOrElse(
        scoreData -> {
          if (hasUpdate(updateAt, scoreData.getUpdateAt())) {
            log.info("M=ProcessAndSendScoreData, cpf={} hasUpdate, updatedAt={}", dto.getCpf(), updateAt);
            scoreDataPublisher.send(dto);
            scoreData.setUpdateAt(updateAt);
            scoreDataRepository.saveAndFlush(scoreData);
          }
          log.info("M=ProcessAndSendScoreData, cpf={} updated", dto.getCpf());
        }, () -> {
          log.info("M=ProcessAndSendScoreData, cpf was not registered, registeredAt={}", updateAt);
          scoreDataPublisher.send(dto);
          scoreDataRepository.save(
              ScoreDataEntity.builder()
                  .cpf(dto.getCpf())
                  .updateAt(updateAt)
                  .build()
          );
        });
  }

  public ScoreDataEntity getData(String cpf) {
    return scoreDataRepository.findByCpf(cpf).get();
  }

  private boolean hasUpdate(LocalDateTime dtoUpdate, LocalDateTime entityUpdate) {
    return dtoUpdate.isAfter(entityUpdate);
  }
}

