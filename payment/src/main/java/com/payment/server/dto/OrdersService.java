package com.payment.server.dto;

import com.payment.domain.order.Orders;
import com.payment.domain.order.OrdersRepository;
import com.payment.server.service.OrdersPayRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrdersService {

  private final OrdersRepository ordersRepository;

  @Transactional
  public Long save(OrdersPayRequestDto ordersPayRequestDto) {
    return ordersRepository.save(ordersPayRequestDto.toEntity()).getOrderId();
  }

  @Transactional
  public Long update(OrdersPayRequestDto ordersPayRequestDto) {
    Orders order = ordersRepository.findById(ordersPayRequestDto.getOrderId())
        .orElseThrow(() -> new IllegalArgumentException(
            "해당 주문번호가 없습니다. orderId=" + ordersPayRequestDto.getOrderId()));
    order.update(ordersPayRequestDto.getOrderType());
    return order.getOrderId();
  }

}
