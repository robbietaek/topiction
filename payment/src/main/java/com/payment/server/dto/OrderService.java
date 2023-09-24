package com.payment.server.dto;

import com.payment.domain.payment.Order;
import com.payment.domain.payment.OrderRepository;
import com.payment.server.service.OrderPayRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public Long save(OrderPayRequestDto orderPayRequestDto) {
    return orderRepository.save(orderPayRequestDto.toEntity()).getOrderId();
  }

  public Long update(OrderPayRequestDto orderPayRequestDto) {
    Order order = orderRepository.findById(orderPayRequestDto.getOrderId())
        .orElseThrow(() -> new IllegalArgumentException(
            "해당 주문번호가 없습니다. orderId=" + orderPayRequestDto.getOrderId()));
    order.update(orderPayRequestDto.getOrderType());
    return order.getOrderId();
  }

}
