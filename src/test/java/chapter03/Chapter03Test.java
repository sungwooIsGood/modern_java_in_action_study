package chapter03;

import com.exercies.data.entity.Apple;
import com.exercies.data.enums.Color;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Chapter03Test {

    @Test
    void doLamdas(){
        // 람다로 거름
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        // sorting
        Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();

        // [Apple{color=GREEN, weight=80}, Apple{color=RED, weight=120}, Apple{color=GREEN, weight=155}]
        inventory.sort(c);
        System.out.println(inventory);
    }


}
