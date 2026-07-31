package com.suhong.payment;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        int amount = 15000;
        List<PaymentType> paymentTypes = List.of(
                PaymentType.CARD,
                PaymentType.KAKAO_PAY,
                PaymentType.BANK_TRANSFER,
                PaymentType.POINT
        );

        for (PaymentType paymentType : paymentTypes) {
            PaymentMethod paymentMethod = PaymentMethodFactory.create(paymentType);
            OrderService orderService = new OrderService(paymentMethod);
            PaymentResult result = orderService.checkout(amount);

            // 결과 출력
            System.out.println(
                    result.paymentMethodName() + ": " result.amount() + "원"
            );
        }
    }
}
