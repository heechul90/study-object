package com.study.object.step02.fee;

import com.study.object.step02.time.DateTimeInterval;

import java.util.List;

public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
