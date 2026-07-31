package com.suhong.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    private FakePaymentMethod fakePaymentMethod;
    private OrderService orderService;

    @BeforeEach
    void setup() {
        fakePaymentMethod = new FakePaymentMethod();
        orderService = new OrderService(fakePaymentMethod);
    }

    // 테스트 전용 구현체 만들기
    static class FakePaymentMethod implements PaymentMethod {
        private boolean paid = false;
        private int paidAmount = 0;

        @Override
        public void pay(int amount) {
            paid = true;
            paidAmount = amount;
        }

        @Override
        public String getName() {
            return "테스트 결제";
        }

        public boolean isPaid() {
            return paid;
        }

        public int getPaidAmount() {
            return paidAmount;
        }
    }

    @Test
    void 정상_금액이면_결제가_실행된다() {
        // given

        // when
        PaymentResult result = orderService.checkout(15000);

        // then
        assertTrue(fakePaymentMethod.isPaid());
        assertEquals(15000, fakePaymentMethod.getPaidAmount());

        // PaymentResult 내용 검증
        assertEquals("테스트 결제", result.paymentMethodName());
        assertEquals(15000, result.amount());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    void 유효하지_않은_금액이면_결제가_실행되지_않는다(int amount) {
        // given

        // when, then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> orderService.checkout(amount)
        );

        assertEquals(
                "결제 금액은 0원보다 커야 합니다.",
                exception.getMessage()
        );
        assertFalse(fakePaymentMethod.isPaid());
    }

    @Test
    void 결제_수단이_null이면_객체를_생성할_수_없다() {
        // given

        // when, then
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new OrderService(null)
        );

        assertEquals(
                "결제 수단은 필수입니다.",
                exception.getMessage()
        );
    }

    @Test
    void CARD는_CardPayment를_생성한다() {
        // given

        // when
        PaymentMethod paymentMethod = PaymentMethodFactory.create(PaymentType.CARD);

        // then
        assertInstanceOf(CardPayment.class, paymentMethod);
    }

    @Test
    void KAKAO_PAY는_KakaoPayPayment를_생성한다() {
        // given

        // when
        PaymentMethod paymentMethod = PaymentMethodFactory.create(PaymentType.KAKAO_PAY);

        // then
        assertInstanceOf(KakaoPayPayment.class, paymentMethod);
    }

    @Test
    void BANK_TRANSFER는_BankTransferPayment를_생성한다() {
        // given

        // when
        PaymentMethod paymentMethod = PaymentMethodFactory.create(PaymentType.BANK_TRANSFER);

        // then
        assertInstanceOf(BankTransferPayment.class, paymentMethod);
    }

    @Test
    void Point는_PointPayment를_생성한다() {
        // given

        // when
        PaymentMethod paymentMethod = PaymentMethodFactory.create(PaymentType.POINT);

        // then
        assertInstanceOf(PointPayment.class, paymentMethod);
    }
}