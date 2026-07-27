package com.suhong.payment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int amount = 15000;

        List<PaymentMethod> paymentMethods = List.of(
                new CardPayment(),
                new KakaoPayPayment(),
                new BankTransferPayment(),
                new PointPayment()
        );

        for (PaymentMethod paymentMethod : paymentMethods) {
            OrderService orderService = new OrderService(paymentMethod);
            orderService.checkout(amount);
        }
    }
}
