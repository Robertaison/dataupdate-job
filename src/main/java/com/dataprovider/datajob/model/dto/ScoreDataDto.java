package com.dataprovider.datajob.model.dto;

import com.dataprovider.datajob.model.ScoreDataEntity;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ScoreDataDto {

  private String cpf;
  private String updateAt;

  public static ScoreDataDto newInstance(ScoreDataEntity scoreData) {
    return null;
  }
}
