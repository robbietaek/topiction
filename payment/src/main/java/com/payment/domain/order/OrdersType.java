package com.payment.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrdersType {

  ORDER("ORDER", "주문완료"),
  ORDER_CANCEL("ORDER_CANCEL", "주문취소");

  private final String key;
  private final String status;

}
