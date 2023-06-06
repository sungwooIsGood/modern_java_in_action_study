package chapter04;

import com.exercies.chapter04.DishFilter;
import com.exercies.data.entity.Dish;
import com.exercies.data.enums.Type;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Chapter04Test {

    final static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 400, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH)
    );

    @Test
    void beforeStream(){
        DishFilter.beforeStreamJava7(menu);
    }

    @Test
    void afterStream(){
        DishFilter.afterStreamJava7(menu);
    }

}
