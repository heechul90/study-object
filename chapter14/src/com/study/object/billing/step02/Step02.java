package com.study.object.billing.step02;

import com.study.object.billing.step02.fee.*;
import com.study.object.meney.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class Step02 {
    public static void main(String[] args) {
        LocalDateTime from = LocalDateTime.of(2023, 01, 01, 0, 0, 0, 000_000_000);
        LocalDateTime to = LocalDateTime.of(2023, 12, 31, 23, 59, 59, 999_999_999);

        Call call1 = new Call(
                LocalDateTime.of(2023, 01, 01, 10, 0, 0),
                LocalDateTime.of(2023, 01, 03, 16, 0, 0));
        Call call2 = new Call(
                LocalDateTime.of(2023, 10, 01, 10, 0, 0),
                LocalDateTime.of(2023, 10, 01, 11, 0, 0));

        Call call3 = new Call(
                LocalDateTime.of(2022, 10, 01, 10, 0, 0),
                LocalDateTime.of(2022, 10, 01, 11, 0, 0));

        FeeCondition feeCondition = new FixedFeeCondition();

        FeePerDuration feePerDuration = new FeePerDuration(Money.wons(2000), Duration.between(from, to));


        FeeRule feeRule = new FeeRule(feeCondition, feePerDuration);
        RatePolicy ratePolicy = new BasicRatePolicy(feeRule);

        Phone phone = new Phone(ratePolicy);
        phone.call(call1);
        phone.call(call2);
        phone.call(call3);

        System.out.println("phone.calculateFee() = " + phone.calculateFee().toSring());
    }
}
