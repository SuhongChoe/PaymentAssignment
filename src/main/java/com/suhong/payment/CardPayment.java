package com.suhong.payment;

public class CardPayment implements PaymentMethod {
    @Override
    public String getName() {
        return "신용카드";
    }
    @Override
    void pay(int amount){
        System.out.println(getName() + "로 " + amount + "원을 결제했습니다.");
    }
}

