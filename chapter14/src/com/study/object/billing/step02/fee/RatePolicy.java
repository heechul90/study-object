package com.study.object.billing.step02.fee;

import com.study.object.meney.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
