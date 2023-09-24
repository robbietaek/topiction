package com.payment.server.controller;

import com.payment.server.dto.OrdersService;
import com.payment.server.service.OrdersPayRequestDto;
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
public class OrdersController {

  private final OrdersService ordersService;

  @PostMapping("{id}")
  public Long order(@RequestBody OrdersPayRequestDto ordersPayRequestDto) {
    return ordersService.save(ordersPayRequestDto);
  }

  @PutMapping("{id}")
  public Long modifyOrder(@RequestBody OrdersPayRequestDto ordersPayRequestDto) {
    return ordersService.update(ordersPayRequestDto);
  }

  @PostMapping("/payment/{id}")
  public Long pay(@RequestBody OrdersPayRequestDto ordersPayRequestDto) {
    return ordersService.save(ordersPayRequestDto);
  }

  @PutMapping("/payment/{id}")
  public Long modifyPay(@RequestBody OrdersPayRequestDto ordersPayRequestDto) {
    return ordersService.update(ordersPayRequestDto);
  }

}
