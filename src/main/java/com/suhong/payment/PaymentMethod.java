package com.suhong.payment;

public interface PaymentMethod {
    void pay(int amount); //결제를 수행
    String getName(); //결제 수단의 이름을 반환
}
