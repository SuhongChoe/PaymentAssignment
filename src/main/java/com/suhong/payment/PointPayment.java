package com.suhong.payment;

public class PointPayment implements PaymentMethod {
    @Override
    public void pay(int amount){
        System.out.println(getName() + "로 " + amount + "원을 결제했습니다.");
    }

    @Override
    public String getName() {
        return "포인트";
    }
}
