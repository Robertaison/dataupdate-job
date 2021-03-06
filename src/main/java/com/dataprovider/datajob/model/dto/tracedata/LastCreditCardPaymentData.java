package com.dataprovider.datajob.model.dto.tracedata;

import lombok.Data;

@Data
public class LastCreditCardPaymentData {
  private String companyName;
  private String amount;
  private String card;
  private String issuerBank;
  private String dateTime;
}
