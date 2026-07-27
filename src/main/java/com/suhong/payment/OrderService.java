package com.suhong.payment;

public class OrderService {
    private final PaymentMethod paymentMethod;

    // 생성자 작성
    public OrderService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "결제 금액은 0원보다 커야 합니다."
            );
        }
        // 결제 수단 이름 출력
        System.out.println("결제 수단: " + paymentMethod.getName());
        // 실제 결제 실행
        paymentMethod.pay(amount);
        System.out.println("결제가 완료되었습니다.");
    }
}
