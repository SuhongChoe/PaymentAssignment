package com.suhong.payment;

public class KakaoPayPayment {
    @Override
    public String getName(){
        return "카카오페이";
    }
    @Override
    void pay(int amount){
        System.out.println(getName() + "로 " + amount + "원을 결제했습니다.");
    }
}
