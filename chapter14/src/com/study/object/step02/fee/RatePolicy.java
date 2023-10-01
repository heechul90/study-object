package com.study.object.step02.fee;

import com.study.object.step02.meney.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
