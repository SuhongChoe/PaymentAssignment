package com.suhong.payment;

public class OrderService {
    private final PaymentMethod paymentMethod;

    // 생성자 작성
    private void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    };

    public void checkout(int amount) {
        // 결제 수단 이름 출력
        System.out.println("결제 수단: " + paymentMethod.getName());
        // 실제 결제 실행
        paymentMethod.pay(amount);
        System.out.println("결제가 완료되었습니다.");
    }
}
