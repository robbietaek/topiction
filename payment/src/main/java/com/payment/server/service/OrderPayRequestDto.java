package com.payment.server.service;

import com.payment.domain.payment.Order;
import com.payment.domain.payment.OrderType;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class OrderPayRequestDto {

  private Long orderId;
  private Long fictionId;
  private Long userId;
  private OrderType orderType;
  private Long price;

  @Builder
  public OrderPayRequestDto(Long orderId, Long fictionId, Long userId, OrderType orderType,
      Long price) {
    this.orderId = orderId;
    this.fictionId = fictionId;
    this.userId = userId;
    this.orderType = orderType;
    this.price = price;
  }

  public Order toEntity() {
    return Order.builder().orderId(orderId).fictionId(fictionId).userId(userId).orderType(orderType)
        .price(price).buyingDate(java.sql.Date.valueOf(LocalDate.now())).build();
  }

}
