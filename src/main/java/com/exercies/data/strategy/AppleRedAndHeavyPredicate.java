package com.exercies.data.strategy;

import com.exercies.data.entity.Apple;
import com.exercies.data.enums.Color;

public class AppleRedAndHeavyPredicate  implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor() == Color.RED && apple.getWeight() > 150;
    }
}
