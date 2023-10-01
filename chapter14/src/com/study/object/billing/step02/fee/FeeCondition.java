package com.study.object.billing.step02.fee;

import com.study.object.time.DateTimeInterval;

import java.util.List;

public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
