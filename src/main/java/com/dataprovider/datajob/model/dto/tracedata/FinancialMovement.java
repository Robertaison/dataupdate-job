package com.dataprovider.datajob.model.dto.tracedata;

import lombok.Data;

@Data
public class FinancialMovement {

  private String amount;
  private String type;
  private String dateTime;
}
