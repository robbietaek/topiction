package com.payment.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderType {

  ORDER("ORDER", "주문완료"),
  PAY("PAY", "결제완료"),
  ORDER_CANCEL("ORDER_CANCEL", "주문취소"),
  PAY_CANCEL("PAY_CANCEL", "결제취소");

  private final String key;
  private final String status;

}
