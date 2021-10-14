package com.dataprovider.datajob.model.dto.scoredata;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoreDataDto {

  private String cpf;
  private String customerAge;
  private String address;
  private String sourceOfIncome;
  private Set<PropertyDto> properties;
  private String updatedAt;
}

