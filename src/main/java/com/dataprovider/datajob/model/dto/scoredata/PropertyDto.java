package com.dataprovider.datajob.model.dto.scoredata;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyDto {

  private String propertyName;
  private String propertyDocument;
  private String propertyEvaluatedPrice;
}
