package com.dataprovider.datajob.model.dto.tracedata;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class FinancialMovement {

  private String amount;
  private String type;
  private String dateTime;
}
