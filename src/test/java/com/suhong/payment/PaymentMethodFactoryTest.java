package com.suhong.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class PaymentMethodFactoryTest {
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
    void POINT는_PointPayment를_생성한다() {
        // given

        // when
        PaymentMethod paymentMethod = PaymentMethodFactory.create(PaymentType.POINT);

        // then
        assertInstanceOf(PointPayment.class, paymentMethod);
    }
}
