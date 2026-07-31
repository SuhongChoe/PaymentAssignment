package com.suhong.payment;

public class PaymentMethodFactory {
    public static PaymentMethod create(PaymentType paymentType) {
        // paymentType에 맞는 PaymentMethod 반환
        return switch (paymentType) {
            case CARD -> new CardPayment(); // CardPayment 반환
            case KAKAO_PAY -> new KakaoPayPayment(); // KakaoPayPayment 반환
            case BANK_TRANSFER -> new BankTransferPayment(); // BankTransferPayment 반환
            case POINT -> new PointPayment(); // PointPayment 반환
        };
    }
}
