package com.exercies.chapter04;

import com.exercies.data.entity.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class DishFilter {

    public static List<String> beforeStreamJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();

        // filter
        for (Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }

        List<String> lowCaloricDishesName = new ArrayList<>();

        // 이름기준 sorting
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() { // 익명 클래스 사용
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }

        return lowCaloricDishesName;
    }

    public static List<String> afterStreamJava7(List<Dish> dishes) {
        return dishes.stream() // parallelStream() 시 병렬로 실행 가능
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}
