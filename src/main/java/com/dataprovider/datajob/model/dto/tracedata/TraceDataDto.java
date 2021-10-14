package com.dataprovider.datajob.model.dto.tracedata;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TraceDataDto {

  private String cpf;
  private BureauOfCreditQuery lastQueryAtBureauOfCredit;
  private List<FinancialMovement> financialMovementList;
  private LastCreditCardPaymentData lastCreditCardPaymentData;
  private String updatedAt;
}
