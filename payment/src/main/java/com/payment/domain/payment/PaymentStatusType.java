package com.payment.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatusType {

  PROCEED("PROCEED", "결제중"),
  COMPLETE("COMPLETE", "결제완료"),
  FAIL("FAIL", "결제취소");

  private final String key;
  private final String status;

}
