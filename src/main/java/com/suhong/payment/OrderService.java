package com.suhong.payment;

public class OrderService {
    private final PaymentMethod paymentMethod;

    // 생성자 작성

    // 1차 작성물 -> 생성자가 아니라 일반 메서드임
//    private void setPaymentMethod(PaymentMethod paymentMethod){
//        this.paymentMethod = paymentMethod;
//    };

    public OrderService(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void checkout(int amount) {
        if(amount <= 0){
            System.out.println("유효하지 않은 값입니다.");
            return;
        }
        // 결제 수단 이름 출력
        System.out.println("결제 수단: " + paymentMethod.getName());
        // 실제 결제 실행
        paymentMethod.pay(amount);
        System.out.println("결제가 완료되었습니다.");
    }
}
