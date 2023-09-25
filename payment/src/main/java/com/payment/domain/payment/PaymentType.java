package com.payment.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentType {
  POINT("POINT", "포인트"),
  CARD("CARD", "카드"),
  REMITTANCE("REMITTANCE", "무통장입금"),
  ACCOUNT_TRANSFER("ACCOUNT_TRANSFER", "계좌이체"),
  NAVER("NAVER", "네이버페이"),
  KAKAO("KAKAO", "카카오페이"),
  TOSS("TOSS", "토스"),
  PAYCO("PAYCO", "페이코");

  private final String key;
  private final String detail;

}
