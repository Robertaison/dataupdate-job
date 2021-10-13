package com.dataprovider.datajob.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize
@JsonSerialize
public class SensitiveDataDto {

  private String cpf;
  private String name;
  private String address;
  private String debts;
  private String updatedAt;
}
