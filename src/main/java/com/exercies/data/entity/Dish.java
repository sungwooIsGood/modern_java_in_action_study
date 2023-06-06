package com.exercies.data.entity;

import com.exercies.data.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

}
