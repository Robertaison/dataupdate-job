package com.dataprovider.datajob.service;

import com.dataprovider.datajob.model.ScoreDataEntity;
import com.dataprovider.datajob.model.dto.ScoreDataDto;
import com.dataprovider.datajob.model.dto.SensitiveDataDto;
import com.dataprovider.datajob.model.dto.TraceDataDto;

public interface DataService {

  void processAndSendSensitiveData(SensitiveDataDto dto);
  void processAndSendTraceData(TraceDataDto dto);
  void processAndSendScoreData(ScoreDataDto dto);

  ScoreDataEntity getData(String cpf);
}
