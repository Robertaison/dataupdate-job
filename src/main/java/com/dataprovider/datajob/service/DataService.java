package com.dataprovider.datajob.service;

import com.dataprovider.datajob.model.dto.scoredata.ScoreDataDto;
import com.dataprovider.datajob.model.dto.sensitivedata.SensitiveDataDto;
import com.dataprovider.datajob.model.dto.tracedata.TraceDataDto;
import java.util.List;

public interface DataService {

  void processAndSendSensitiveData(List<SensitiveDataDto> dto);
  void processAndSendTraceData(List<TraceDataDto> dto);
  void processAndSendScoreData(List<ScoreDataDto> dto);
}
