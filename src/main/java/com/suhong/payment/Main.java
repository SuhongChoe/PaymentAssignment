package com.suhong.payment;

public class Main {
    public static void main(String[] args){
        int amount = 15000;

        // 1차 작성 코드 -> 단순히 같은 변수에 다른 객체를 넣으려는 목적
//        // 신용카드 결제
//        PaymentMethod paymentMethod = new CardPayment();
//        paymentMethod.pay(amount);
//
//        // 카카오페이 결제
//        paymentMethod = new KakaoPayPayment();
//        paymentMethod.pay(amount);
//
//        // 계좌이체 결제
//        paymentMethod = new BankTransferPayment();
//        paymentMethod.pay(amount);

        // OrderService를 사용하여 결제 수단별로 서비스를 생성

        // 신용카드 결제
        PaymentMethod cardPayment = new CardPayment();
        OrderService cardOrderService = new OrderService(cardPayment);
        cardOrderService.checkout(amount);

        // 카카오페이 결제
        PaymentMethod kakaoPayPayment = new KakaoPayPayment();
        OrderService kakaoOrderService = new OrderService(kakaoPayPayment);
        kakaoOrderService.checkout(amount);

        // 계좌이체 결제
        PaymentMethod bankTransferPayment = new BankTransferPayment();
        OrderService bankTransferOrderService = new OrderService(bankTransferPayment);
        bankTransferOrderService.checkout(amount);
    }
}
