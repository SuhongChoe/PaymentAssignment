package com.suhong.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
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
        FakePaymentMethod fakePaymentMethod = new FakePaymentMethod();
        OrderService orderService = new OrderService(fakePaymentMethod);

        // when
        orderService.checkout(15000);

        // then
        assertTrue(fakePaymentMethod.isPaid());
        assertEquals(15000, fakePaymentMethod.getPaidAmount());
    }

    @Test
    void 금액이_0원이면_결제가_실행되지_않는다() {
        // given
        FakePaymentMethod fakePaymentMethod = new FakePaymentMethod();
        OrderService orderService = new OrderService(fakePaymentMethod);

        // when
        orderService.checkout(0);

        // then
        assertFalse(fakePaymentMethod.isPaid());
    }

    @Test
    void 금액이_음수이면_결제가_실행되지_않는다() {
        // given
        FakePaymentMethod fakePaymentMethod = new FakePaymentMethod();
        OrderService orderService = new OrderService(fakePaymentMethod);

        // when
        orderService.checkout(-100);

        // then
        assertFalse(fakePaymentMethod.isPaid());
    }
}