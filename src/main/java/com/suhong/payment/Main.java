package com.suhong.payment;

public class Main {
    public static void main(String[] args){
        int amount = 150000;

        // 신용카드 결제
        PaymentMethod paymentMethod = new CardPayment();
        paymentMethod.pay(amount);

        // 카카오페이 결제
        PaymentMethod paymentMethod = new KakaoPayPayment();
        paymentMethod.pay(amount);

        // 계좌이체 결제
        PaymentMethod paymentMethod = new BankTransferPayment();
        paymentMethod.pay(amount);
    }
}
