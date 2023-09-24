package com.payment.server.controller;

import com.payment.server.dto.OrderService;
import com.payment.server.service.OrderPayRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/order")
public class OrderController {

  private final OrderService orderService;

  @PostMapping("{id}")
  public Long order(@RequestBody OrderPayRequestDto orderPayRequestDto) {
    return orderService.save(orderPayRequestDto);
  }

  @PutMapping("{id}")
  public Long modifyOrder(@RequestBody OrderPayRequestDto orderPayRequestDto) {
    return orderService.update(orderPayRequestDto);
  }

  @PostMapping("/payment/{id}")
  public Long pay(@RequestBody OrderPayRequestDto orderPayRequestDto) {
    return orderService.save(orderPayRequestDto);
  }

  @PutMapping("/payment/{id}")
  public Long modifyPay(@RequestBody OrderPayRequestDto orderPayRequestDto) {
    return orderService.update(orderPayRequestDto);
  }

}
