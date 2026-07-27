package com.suhong.payment;

public class BankTransferPayment {
    @Override
    public String getName(){
        return "계좌이체";
    }
    @Override
    void pay(int amount){
        System.out.println(getName() + "로 " + amount + "원을 결제했습니다.");
    }
}
