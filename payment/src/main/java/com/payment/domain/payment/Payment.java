package com.payment.domain.payment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor
@Entity
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paymentId;

  @Column(nullable = false)
  private Long orderId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PaymentType paymentType;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PaymentStatusType paymentStatusType;

  @CreatedDate
  private LocalDateTime paymentDate;

  @Builder
  public Payment(Long orderId, PaymentType paymentType, PaymentStatusType paymentStatusType,
      LocalDateTime paymentDate) {
    this.orderId = orderId;
    this.paymentType = paymentType;
    this.paymentStatusType = paymentStatusType;
    this.paymentDate = paymentDate;
  }

  public void update(PaymentStatusType paymentStatusType) {
    this.paymentStatusType = paymentStatusType;
  }

}
