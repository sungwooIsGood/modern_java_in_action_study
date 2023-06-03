package com.exercies.data.strategy;

import com.exercies.data.entity.Apple;

public class AppleWeightPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
