package com.exercies.data.strategy;

import com.exercies.data.entity.Apple;

public interface ApplePredicate {

    boolean test(Apple a);

}
