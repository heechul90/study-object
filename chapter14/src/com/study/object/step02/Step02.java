package com.study.object.step02;

import com.study.object.step02.fee.*;
import com.study.object.step02.meney.Money;

import java.time.LocalDateTime;

public class Step02 {
    public static void main(String[] args) {
        Call call = new Call(LocalDateTime.of(2023, 01, 01, 10, 0, 0), LocalDateTime.of(2023, 01, 03, 16, 0, 0));

        FixedFeeCondition fixedFeeCondition = new FixedFeeCondition();
        FeePerDuration feePerDuration = new FeePerDuration(Money.wons(2000), call.getDuration());
        FeeRule feeRule = new FeeRule(fixedFeeCondition, feePerDuration);
        BasicRatePolicy basicRatePolicy = new BasicRatePolicy(feeRule);

        Phone phone = new Phone(basicRatePolicy);
        phone.call(call);

        System.out.println("phone.calculateFee() = " + phone.calculateFee().toSring());
    }
}
