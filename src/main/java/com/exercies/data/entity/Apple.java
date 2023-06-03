package com.exercies.data.entity;

import com.exercies.data.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Apple {

    private int weight = 0;
    private Color color;

}