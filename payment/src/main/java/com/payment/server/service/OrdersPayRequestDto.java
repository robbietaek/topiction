package com.payment.server.service;

import com.payment.domain.order.Orders;
import com.payment.domain.order.OrdersType;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class OrdersPayRequestDto {

  private Long orderId;
  private Long fictionId;
  private Long userId;
  private OrdersType orderType;
  private Long price;

  @Builder
  public OrdersPayRequestDto(Long orderId, Long fictionId, Long userId, OrdersType orderType,
      Long price) {
    this.orderId = orderId;
    this.fictionId = fictionId;
    this.userId = userId;
    this.orderType = orderType;
    this.price = price;
  }

  public Orders toEntity() {
    return Orders.builder().fictionId(fictionId).userId(userId).orderType(orderType)
        .price(price).orderDate(LocalDateTime.now()).build();
  }

}
